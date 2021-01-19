import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class GameUI {
    public Board board;
    private Player white;
    private Player black;
    private Player currentPlayer;
    private ChessUI ui;
    private Stack<Move> history;

    public GameUI(ChessUI ui, String boardConfigFileName, Player white, Player black) {
        this.board = new Board(boardConfigFileName, white, black);
        this.white = white;
        this.black = black;
        this.currentPlayer = white;
        this.ui = ui;
        this.history = new Stack<Move>();

        for (Piece p : board.getPieces()) this.ui.placePiece(p.getType(), p.getColor(), p.getPosition());


    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public boolean undo() {
        if (this.history.empty()) return false;
        Move move = this.history.pop();
        board.emptyCell(move.destination);
        ui.removePiece(move.destination);
        if (move.pieceAtDestination != null) {
            move.pieceAtDestination.setPosition(move.destination);
            board.addPiece(move.pieceAtDestination);
            ui.placePiece(move.pieceAtDestination.getType(), move.pieceAtDestination.getColor(), move.pieceAtDestination.getPosition());
        }
        board.emptyCell(move.origin);
        ui.removePiece(move.origin);
        move.pieceAtOrigin.setPosition(move.origin);
        board.addPiece(move.pieceAtOrigin);
        ui.placePiece(move.pieceAtOrigin.getType(), move.pieceAtOrigin.getColor(), move.pieceAtOrigin.getPosition());

        currentPlayer = move.pieceAtOrigin.getOwner();
        if (move.pieceAtDestination != null)
            currentPlayer.removeFromScore(move.pieceAtDestination.getValue());
        return true;

    }

    public boolean isMovePlayable(Move gameMove) {
        Piece piece = getBoard().getPiece(gameMove.getOrigin());
        Piece pieceInDanger = board.getPiece(gameMove.destination);
        if (piece == null || currentPlayer.getColor() != piece.getColor())
            return false;
        if (gameMove.getPieceAtDestination() != null && gameMove.getPieceAtDestination().sameColor(gameMove.getPieceAtOrigin()))
            return false;
        if(pieceInDanger != null && pieceInDanger.getType() == Piece.Type.KING) return false;
        return piece.isMoveAuthorized(getBoard(), gameMove.getDestination());

    }

    public void applyMove(Move move) {
        Piece piece = board.getPiece(move.getOrigin());
        history.push(move);
        board.emptyCell(piece.getPosition());
        piece.setPosition(move.getDestination());
        board.addPiece(piece);
        currentPlayer.addToScore(move.pieceAtOrigin.getValue());
        switchPlayers();
    }

    public void switchPlayers() {
        currentPlayer = getOpponent(currentPlayer);
    }

    public Player getOpponent(Player player) {
        if (player == black) return white;
        else return black;
    }

    public boolean isPrey(Piece prey) {
        if (prey == null) return false;
        List<Move> opponentMoves = getOpponent(prey.getOwner()).getAllMoves(getBoard());
        for (Move move : opponentMoves)
            if (prey.getPosition().equals(move.getPieceAtDestination().getPosition()))
                return true;
        return false;
    }

    public boolean isCheck(Player player) {
        return isPrey(player.getKing());
    }


    public boolean isCheckMate(Player player){
        // check whether the king is in check
        for(Move move : player.getKing().getAllMoves(getBoard())){
            // try all the possible movements of the king if we could find one that could save him
            boolean isCheck;
            applyMove(move);
            isCheck = isCheck(player);  // check whether the player is in check with this move
            undo();     // undo the movement
            if(!isCheck)    return false;
        }
        // if the king couldn't save himself we check if one of the ally pieces can save him
        List<Piece> allies = getBoard().getPieces(player);
        allies.remove(player.getKing());    // remove the king from the allies since he couldn't save himself
        for(Piece ally : allies){
            // check all the possible moves of each ally if he can get the king out of check
            for(Move move : ally.getAllMoves(getBoard())){
                boolean isCheck;
                applyMove(move);
                isCheck = isCheck(player);
                undo();
                if (!isCheck)   return false;
            }
        }
        //all pieces have been examined and none can make the player get out of check
        return true;
    }


    public void determineWinner() {

        if (isCheckMate(black) || isCheckMate(white)) {
            System.out.println(getOpponent(currentPlayer).color.toString() + " is the winner!");
        }
        if (black.getScore() == white.getScore()) {
            System.out.println("There is an equality!");
        }
        if (white.getScore() > black.getScore()) {
            System.out.println(white.toString() + " is the winner!");
        }
        if (white.getScore() < black.getScore()) {
            System.out.println(black.toString() + " is the winner!");
        }

    }


    public void play() {

        int numberOfHits = 0;
        while (numberOfHits < 50) {
            System.out.println("It's " + currentPlayer + "'s turn");
            Move move;
            move = new Move(board, currentPlayer.getFromTo(this));
            if (isMovePlayable(move)) {
                applyMove(move);
                ui.placePiece(board.getPiece(move.fromTo().getTo()).getType(), board.getPiece(move.fromTo().getTo()).getOwner().getColor(), move.fromTo().getTo());
                ui.removePiece(move.fromTo().getFrom());
                numberOfHits++;
            }
            if (!isMovePlayable(move)) {
                continue;
            }
            else break;
        }
        determineWinner();
    }


}


