import tp2.lib.Painter;
import static tp2.lib.Tools.sleep;

import javax.swing.*;
import java.awt.*;

import static tp2.lib.Tools.sleep;


public class Turtle {
    Color penColor;
    double angleDirection;
    Point  position;
    boolean penDown;
    tp2.lib.Painter painter;

    public Turtle(int width, int height){
     this.penColor=null;
     this.angleDirection=90;
     this.painter=new Painter(width,height);
     this.penDown=false;
     this.position= new Point(width/2,height/2);
    }
    public void moveForward(double distance ){
        double oldX=position.x;
        double oldY=position.y;
      if(penDown=true){
          sleep(1);
        position.x+=distance*Math.cos(Math.toRadians(angleDirection));
        position.y+=distance*Math.sin(Math.toRadians(angleDirection));
        painter.addLine(oldX,oldY,position.x,position.y,Color.MAGENTA);
      }
    }
   public void setColor(Color color){
        penColor = new Color(color.getRGB());
   }
   public void turnLeft(double angle){
        angleDirection+=angle;
   }
   public void turnRight(double angle){
       angleDirection-=angle;
   }
   public void setPenDown(){
        penDown=true;
   }
   public void setPenUp(){
        penDown=false;
   }

   public  void drawString(String sequence, double length, double angle) {
       for (int i = 0; i < sequence.length(); i++) {

           if (sequence.charAt(i) == 'A') {
                 moveForward(length);
            }
            if (sequence.charAt(i) == '+') {
                turnRight(angle);
            }
            if (sequence.charAt(i) == '-') {
                turnLeft(angle);
            }
   }
   }
   public static void test_Turtle(Painter painter){
        Turtle turtle = new Turtle(800,600);
        turtle.drawString("A+A+A+A",100,90);
   }


}
