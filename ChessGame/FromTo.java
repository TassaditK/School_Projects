public class FromTo {
    private final Coordinates from;
    private final Coordinates to;
    
    public FromTo(int ox, int oy, int dx, int dy) {
	    from = new Coordinates(ox,oy) ;
	    to = new Coordinates(dx,dy);
    }
    public FromTo(Coordinates origin, Coordinates destination) {
        from = origin;
        to = destination;
    }


    public Coordinates getFrom() {
        return from;
    }

    public Coordinates getTo() {return  to; }
}
