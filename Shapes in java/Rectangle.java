import tp2.lib.Painter;

import java.awt.*;
import java.util.Random;
import static tp2.lib.Tools.sleep;

/**
 * Created by Arnaud Labourel on 17/10/2018.
 */

public class Rectangle implements Shape{

    Point p1, p2;

    public Rectangle(Point p1, Point p2){
        this.p1 =p1;
        this.p2 =p2;
    }

    private int height(){
        double L = Math.sqrt(Math.pow((p2.x-p1.x),2)+ Math.pow((p2.y-p1.y),2));
        return (int) Math.sqrt((Math.pow(L,2) - Math.pow(width(),2)));
    }

    private int width(){
        return (int) (p2.y - p1.y);
    }



    public static void test_rectangle(Painter painter){
        Point p1 = new Point(100,100);
        Point p2 = new Point(200,100);
        Point p3 = new Point(100,300);
        Random random= new Random();

        Shape r = new Rectangle(p2, p3);
        r.draw(painter, Color.black);

        for(int i =30; i<400; i+=30) {
            Shape t2 = r.translate(i, i);
            sleep(100);
            t2.draw(painter, new Color(random.nextFloat(),
                    random.nextFloat(), random.nextFloat()));
        }

    }

    @Override
    public double getPerimeter() {
        return (height() + width())/2;
    }

    @Override
    public void draw(Painter painter, Color color) {
        painter.addPoint(p1.x,p1.y,color);
        painter.addPoint(p2.x,p2.y,color);
        Point p3 = p1.translate(0,(p2.y - p1.y));
        Point p4 = p1.translate((p2.x-p3.x),0);
        painter.addPoint(p3.x,p3.y,color);
        painter.addPoint(p4.x,p4.y,color);
        painter.addLine(p1.x,p1.y,p3.x,p3.y,color);
        painter.addLine(p1.x,p1.y,p4.x,p4.y,color);
        painter.addLine(p2.x,p2.y,p3.x,p3.y,color);
        painter.addLine(p2.x,p2.y,p4.x,p4.y,color);

    }


    @Override
    public Shape translate(int dx, int dy) {
        return new Rectangle(this.p1.translate(dx,dy),this.p2.translate(dx,dy));
    }

    @Override
    public double getArea() {
        return height()*width();
    }
}
