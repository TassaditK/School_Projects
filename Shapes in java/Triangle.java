import tp2.lib.Painter;

import java.awt.*;
import java.util.Random;

import static tp2.lib.Tools.sleep;

/**
 * Created by Arnaud Labourel on 15/10/2018.
 */

public class Triangle implements Shape {
    private final Point[] vertices;

    public Triangle(Point p1, Point p2, Point p3) {
        vertices = new Point[]{p1, p2, p3};
        vertices[0]=p1;
        vertices[1]=p2;
        vertices[2]=p3;
    }

    private Triangle(Point[] vertices){
        this.vertices = vertices;
    }

    @Override
    public double getPerimeter() {
         Point p1=getPoint(0);
         Point p2=getPoint(1);
         Point p3=getPoint(2);
         //ici A,B,C représentes les trois côtés du triangle
        double A = Math.sqrt(Math.pow(p2.x-p1.x,2) + Math.pow(p2.y -p1.y,2));
        double B = Math.sqrt(Math.pow(p3.x-p1.x,2) + Math.pow(p3.y -p1.y,2));
        double C = Math.sqrt(Math.pow(p3.x-p2.x,2) + Math.pow(p3.y -p2.y,2));
        return A+B+C;
    }

    @Override
    public void draw(Painter painter, Color color) {
        Point p1=getPoint(0);
        painter.addPoint(p1.x,p1.y,color);
        Point p2=getPoint(1);
        painter.addPoint(p2.x,p2.y,color);
        painter.addLine(p1.x,p1.y,p2.x,p2.y,color);


        Point p3=getPoint(2);
        painter.addPoint(p3.x,p3.y,color);
        painter.addLine(p1.x,p1.y,p3.x,p3.y,color);
        painter.addLine(p2.x,p2.y,p3.x,p3.y,color);
    }

    @Override
    public Shape translate(int dx, int  dy) {
        Point p1=getPoint(0);
        Point p2=getPoint(1);
        Point p3=getPoint(2);
        return new Triangle(p1.translate(dx,dy),p2.translate(dx,dy),p3.translate(dx,dy));
    }

    @Override
    public double getArea() {
        Point p1=getPoint(0);
        Point p2=getPoint(1);
        Point p3=getPoint(2);

         return  (1/2)*(p1.x *(p2.y-p3.y) + p2.x *(p3.y-p1.y) + p3.x * (p1.y -p2.y) );

    }

    // Cette méthode permet d'obtenir un point de vertices
    public Point getPoint(int i){
        if (i >=0 && i<3 ) {
            return this.vertices[i];
        }
        else return null;
    }

    public static void test_Triangle(Painter painter){
        Point p1 = new Point(100,100);
        Point p2 = new Point(200,200);
        Point p3 = new Point(10,200);
        Random random= new Random();

        Shape t = new Triangle(p1,p2,p3);
        for(int i =30; i<600; i+=30) {
            Shape t2 = t.translate(i, i);
            sleep(100);
            t2.draw(painter, new Color(random.nextFloat(),
                    random.nextFloat(), random.nextFloat()));

        }
    }
}


