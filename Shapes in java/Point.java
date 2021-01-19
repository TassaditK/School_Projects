/**
 * Created by Arnaud Labourel on 20/09/2018.
 */
import tp2.lib.Painter;

import java.awt.*;


public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
	this.x=x;
	this.y=y;
    }

    void draw(Painter painter, Color color){
        painter.addPoint(this.x,this.y,color);
    }

    void drawLine(Point p, Painter painter, Color color){
        double  x1=this.x;
        double x2 = p.x;
        double y1=this.y;
        double y2=p.y;
        painter.addLine(x1,y1,x2,y2,color);

    }
    Point translate(double dx,double dy){
      return new Point(x+dx,y+dy);

    }
    Point rotate(double angle){
        double ALPHA=(Math.PI*angle)/180;
        return new Point(this.x*Math.cos(ALPHA)-this.y*Math.sin(ALPHA),this.x*Math.sin(ALPHA)+this.y*Math.cos(ALPHA));

    }
    Point rotateAround(Point Center ,double angle){
        double alpha =(Math.PI*angle)/180;
        double Xpoint = Center.x+(this.x-Center.x)*Math.cos(alpha)-(this.y-Center.y)*Math.sin(alpha);
        double Ypoint = Center.y+(this.x-Center.x)*Math.sin(alpha)+(this.y-Center.y)*Math.cos(alpha);
        return new Point(Xpoint,Ypoint);

    }


/*
    public static void main(String[] args) {
        Painter painter = new Painter(500,900);
       test2_Point(painter);
    }

 */






    public static void test1_Point(Painter painter){
        Point p1 = new Point(100,100);
        Point p2 = new Point(300,100);
        Point p3 = new Point(300,300);
        Point p4 = new Point(100,300);
        p1.drawLine(p2, painter, Color.black);
        p2.drawLine(p3, painter, Color.black);
        p3.drawLine(p4, painter, Color.black);
        p4.drawLine(p1, painter, Color.black);
        p1.draw(painter, Color.red);
        p2.draw(painter, Color.red);
        p3.draw(painter, Color.red);
        p4.draw(painter, Color.red);
}


public static void test2_Point(Painter painter){
    Point p1 = new Point(100,100);
    Point p2 = p1.translate(200, 0);
    Point p3 = p2.translate(0, 200);
    Point p4 = p3.translate(200,0);
    p1.drawLine(p2, painter, Color.black);
    p2.drawLine(p3, painter, Color.black);
    p3.drawLine(p4, painter, Color.black);
    p4.drawLine(p1, painter, Color.black);
    p1.draw(painter, Color.red);
    p2.draw(painter, Color.red);
    p3.draw(painter, Color.red);
    p4.draw(painter, Color.red);
}



}


