/**
 * Created by Arnaud Labourel on 20/09/2018.
 */

import tp2.lib.Painter;

import java.awt.Color;
import java.util.Random;

import static tp2.lib.Tools.sleep;

public class Main {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;


    public static void main(String[] args) {

        Random random = new Random();
        Painter painter = new Painter(WIDTH, HEIGHT);


        /*
        Painter painter = new Painter(400, 400);
        painter.addLine(100, 100, 300, 100, Color.black);
        painter.addLine(300, 100, 300, 300, Color.black);
        painter.addLine(300, 300, 100, 300, Color.black);
        painter.addLine(100, 300, 100, 100, Color.black);
        painter.addPoint(100, 100, Color.red);
        painter.addPoint(300, 100, Color.red);
        painter.addPoint(100, 300, Color.red);
        painter.addPoint(300, 300, Color.red);

         */

       // dessin_roue();
        //Rectangle.test_rectangle(painter);
         Triangle.test_Triangle(painter);
       // test_turtle();
        //Turtle.test_Turtle(painter);

        //drawFractale();

    }

    public static void drawSquare(Turtle turtle, int size) {
        for (int i = 0; i < 4; i++) {
            sleep(100);
            turtle.moveForward(size);
            turtle.turnLeft(90);
        }
    }

    public static void test_turtle() {
        Turtle turtle = new Turtle(800, 600);
        turtle.setColor(Color.black);
        turtle.setPenDown();
        int n = 20;
        for (int i = 0; i < n; i++) {
            turtle.turnRight(360.0 / n);
            drawSquare(turtle, 100);
        }
    }



        private static void drawFractale(){
            int width = 590, height = 580, nbIterations = 4;
            Turtle turtle = new Turtle(width, height);

            // Déplacement de la tortue en bas à gauche.
            turtle.setPenUp();
            turtle.turnLeft(90); turtle.moveForward(width/2-10);
            turtle.turnLeft(90); turtle.moveForward(height/2-10);
            turtle.turnLeft(180);
            turtle.setPenDown();

            // Définition des règles
            Rule[] rules = { new Rule('X', "XAYAX+A+YAXAY-A-XAYAX"),
                    new Rule('Y', "YAXAY-A-XAYAX+A+YAXAY") };
            SetOfRules setOfRules = new SetOfRules(rules);

            // Application des règles nbIterations fois
            String sequence = "X";
            for (int i = 0; i < nbIterations; i++)
                sequence = setOfRules.apply(sequence);

            // Dessin de la séquence par la tortue
            turtle.drawString(sequence, 7, 90);
        }

    public static void dessin_roue() {
        Painter painter = new Painter(700, 500);
        Point centre = new Point(700 / 2, 500 / 2);
        Point p0 = centre.translate(200, 0);

        Point[] arrayPoint = new Point[11];
        arrayPoint[0] = p0;
        double angle = 36;
        for (int i = 1; i < arrayPoint.length; i++) {
            arrayPoint[i] = p0.rotateAround(centre, angle);
            arrayPoint[i].draw(painter, Color.red);
            angle += 36;
        }

        for (int i = 0; i < arrayPoint.length - 1; i++) {
            arrayPoint[i].drawLine(arrayPoint[i + 1], painter, Color.black);
        }

        for (int i = 0; i < arrayPoint.length / 2; i++) {
            arrayPoint[i].drawLine(arrayPoint[i + 5], painter, Color.blue);
        }
    }

}

