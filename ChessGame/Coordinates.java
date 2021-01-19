public class Coordinates{
    private int x;
    private int y;
    
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
	return this.x;
    }
    public int getY(){
	return this.y;
    }

    @Override
    public String toString(){
        return "("+getX()+" , "+getY()+")";

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinates ) )return false;
        return (x == ((Coordinates) o).x && y == ((Coordinates) o).y);
    }
}
