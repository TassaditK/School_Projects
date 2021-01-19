public class Move{
    final Coordinates origin;
    final Coordinates destination;
    final Piece pieceAtOrigin;
    final Piece pieceAtDestination;
    
    public Move(Board board, Coordinates origin, Coordinates destination){
		this.origin = origin;
		this.destination = destination;
		this.pieceAtOrigin = board.getPiece(origin);
		this.pieceAtDestination = board.getPiece(destination);
    }
    
    public Move(Coordinates origin, Coordinates destination, Piece pieceAtOrigin, Piece pieceAtDestination){
		this.origin = origin;
		this.destination = destination;
		this.pieceAtOrigin = pieceAtOrigin;
		this.pieceAtDestination = pieceAtDestination;
    }
    
    public Move(Board board, FromTo ft){
	this.origin = ft.getFrom();
	this.destination = ft.getTo();
	this.pieceAtOrigin = board.getPiece(origin);
	this.pieceAtDestination = board.getPiece(destination);
    }

	public Coordinates getOrigin() {
		return origin;
	}

	public Coordinates getDestination() {
		return destination;
	}

	public Piece getPieceAtDestination() {
		return pieceAtDestination;
	}

	public Piece getPieceAtOrigin() {
		return pieceAtOrigin;
	}
	public FromTo fromTo(){
    	return new FromTo(origin,destination);
	}
}
    
