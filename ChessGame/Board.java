import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;


public class Board{
	private Piece[][] array;

	public Board(String fileName, Player white, Player black){
		int pieceType;
		int col;
		int row;
		String nextWord;
		Player owner;

		this.array = new Piece[8][8];
		try {
			File file = new File(fileName);
			if(file.exists()==false) {
				System.err.println("Error: Cannot find file "+ fileName);
				System.exit(1);
			}

			Scanner in = new Scanner(file);
			while(in.hasNext()) {
				if ((nextWord = in.nextLine()).length()>2) {
					pieceType = nextWord.charAt(0);
					col = nextWord.charAt(1)-'0';
					row = nextWord.charAt(2)-'0';
					owner = black;
					if (pieceType >= 'a' && pieceType <= 'z')
						owner = white;
					switch(pieceType) {
						case 'K' : case 'k' :
						{ this.addPiece(new King(col, row, owner));break;}
						case 'P' : case 'p' :
							this.addPiece(new Pawn(col, row, owner));
							break;
						case 'N' : case 'n' :
							this.addPiece(new Knight(col, row, owner));
							break;
						case 'Q' : case 'q' :
							this.addPiece(new Queen(col, row, owner));
							break;
						case 'R' : case 'r' :
							this.addPiece(new Rook(col, row, owner));
							break;
						case 'B' : case 'b' :
							this.addPiece(new Bishop(col, row, owner));
							break;
					}
				}

			}

			in.close();

		}
		catch(FileNotFoundException e) {
			System.err.println("Error file not found : "+e);
			System.exit(1);
		}
	}

	public List<Coordinates> getAllCoordinates(){
		List<Coordinates> coordinates = new ArrayList<>();
		for (Piece piece : getPieces()){
			coordinates.add(piece.position);
		}
		return coordinates;

	}

	public List<Piece> getPieces(Player player) {
		List<Piece> pieces = new ArrayList<>();
		for( Piece piece :getPieces()){
			if(piece.getOwner().equals(player)){
				pieces.add(piece);
			}
		}
		return pieces;
	}



	public List<Piece> getPieces() {
		ArrayList<Piece> pieces = new ArrayList<>();
		for(int x = 0; x < 8; x++)
			for(int y = 0; y< 8; y++)
				if(array[x][y] != null)
					pieces.add(array[x][y]);
		return pieces;

	}
	public List<Piece> getPieces(ChessColor color) {
		ArrayList<Piece> list = new ArrayList<Piece>();
		for(int x = 0; x < 8; x++)
			for(int y = 0; y < 8; y++){
				Piece piece = array[x][y];
				if((piece != null) && (piece.getColor() == color))
					list.add(array[x][y]);
			}
		return list;

	}


	public void addPiece(Piece piece){ array[piece.getY()][piece.getX()] = piece;}
	public Piece getPiece(Coordinates coordinates){ return array[coordinates.getY()][coordinates.getX()]; }
	public Piece getPiece(int x, int y){ return array[y][x]; }
	public void emptyCell(Coordinates coordinates){
		array[coordinates.getY()][coordinates.getX()] = null;
	}

	public boolean isEmptyCell(Coordinates coordinates){return getPiece(coordinates) == null; }
	public boolean isEmptyCell(int x, int y){
		return array[y][x]== null;
	}

	public boolean sameColumnNothingBetween(Coordinates origin, Coordinates destination){
		if(origin.getY() != destination.getY())	return false;
		int begin = Math.min(origin.getY(),destination.getY());
		int end = Math.max(origin.getY(),destination.getY());
		for (int i = begin +1; i <end ; i++) {
			if(!isEmptyCell(origin.getX(),i)) return false;
		}
		return true;
	}

	public boolean sameLineNothingBetween(Coordinates origin, Coordinates destination){
		if(origin.getX()!=destination.getX())return false;
		int Begin = Math.min(origin.getY(),destination.getY());
		int end = Math.max(origin.getY(),destination.getY());
		for(int y=Begin+1;y<end;y++)
			if(!isEmptyCell(origin.getX(),y)) return false;
		return true;

	}

	public boolean sameDiagonalNothingBetween(Coordinates origin, Coordinates destination){
		int diagonalLength = Math.abs(destination.getX() - origin.getX());
		if (diagonalLength != Math.abs(destination.getY() - origin.getY())) return false;
		int directionX = Integer.signum(destination.getX() - origin.getX());
		int directionY = Integer.signum(destination.getY() - origin.getY());
		for (int i = 1; i <diagonalLength ; i++) {
			if( !isEmptyCell(origin.getX()+ i*directionX,origin.getY()+ i*directionY)) return false;
		}
		return true;
	}

	public boolean contains(Coordinates cords) {
		return cords.getX() >= 0 && cords.getY() >= 0 && cords.getX() < 8  && cords.getY() < 8;
	}

}
