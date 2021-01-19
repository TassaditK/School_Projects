import java.util.List;

public class ChessBot extends Player {
    private static final int SEARCH_DEPTH=5;

    public ChessBot(ChessColor color) {
        super(color);
    }


   private int minimax(GameUI gameUI, int depth, int alpha, int beta){
        Player currentPlayer = gameUI.getCurrentPlayer();
        Player opponentPlayer = gameUI.getOpponent(currentPlayer);
        if(depth <= 0)
            return currentPlayer.getScore() - opponentPlayer.getScore();
        else if (gameUI.isCheckMate(this))
            return Integer.MIN_VALUE;
        else if (gameUI.isCheckMate(opponentPlayer))
            return Integer.MAX_VALUE;

       List<Move> moves;
       int score;
        // maximizing player
       if(currentPlayer== this){
           moves = this.getAllMoves(gameUI.getBoard());
           int  maxValue = Integer.MIN_VALUE;

           for(Move move: moves){
               if(!gameUI.isMovePlayable(move))
                   continue;
               gameUI.applyMove(move);
               score=minimax(gameUI,depth-1,maxValue,beta);
               maxValue=Math.max(maxValue,score);
               gameUI.undo();
               if(maxValue > beta)
                   break;
           }
           return maxValue;
       }
       else{    // minimizing player
           moves = opponentPlayer.getAllMoves(gameUI.getBoard());
           int minValue = Integer.MAX_VALUE;
           for(Move move: moves){
               if(!gameUI.isMovePlayable(move))
                   continue;
               gameUI.applyMove(move);
               score = minimax(gameUI,depth-1,alpha,minValue);
               minValue = Math.min(minValue,score);
               gameUI.undo();
               if(minValue <= alpha)
                   break;
           }
           return minValue;
       }

   }



        @Override
    public FromTo getFromTo(GameUI gameUI) {
        List<Move> moves = getAllMoves(gameUI.getBoard());
        Move bestMove = null;
        int bestScore = Integer.MIN_VALUE;
        for(Move move: moves){
            if(!gameUI.isMovePlayable(move))
                continue;
            gameUI.applyMove(move);
            int score = minimax(gameUI,SEARCH_DEPTH,Integer.MIN_VALUE,Integer.MAX_VALUE);
            if(score > bestScore){
                bestMove = move;
                bestScore= score;
            }
            gameUI.undo();
        }
        if(bestMove == null){
            // return the first possible move if any problem occurred
            for(Move move: moves){
                if(gameUI.isMovePlayable(move))
                    return move.fromTo();
            }
        }
        return bestMove.fromTo();
    }



}



