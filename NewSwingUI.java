import java.awt.Graphics;
import java.awt.*;
public class NewSwingUI implements UIContext {
  private Graphics graphics;
  private static NewSwingUI swingUI;
  private NewSwingUI() {
  }
  public static NewSwingUI getInstance() {
    if (swingUI == null) {
      swingUI = new NewSwingUI();
    }
    return swingUI;
  }
  public  void setGraphics(Graphics graphics) {
    this.graphics = graphics;
  }
  public void drawLabel(String s, Point p) {
    if (p != null) {
      if (s != null) {
        graphics.drawString(s, (int) p.getX(), (int) p.getY());
      }
    }
    int length = graphics.getFontMetrics().stringWidth(s);
    graphics.drawString("_", (int)p.getX() + length, (int)p.getY());
  }
  public void drawLine(Point point1,  Point point2) {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    if (point1 != null) {
      i1 = Math.round((float) (point1.getX()));
      i2 = Math.round((float) (point1.getY()));
      if (point2 != null) {
        i3 = Math.round((float) (point2.getX()));
        i4 = Math.round((float) (point2.getY()));
      } else {
        i3 = i1;
        i4 = i2;
      }
      graphics.drawLine(i1, i2, i3, i4);
    }
  }
  public void drawPolygon(Point p1, Point p2, Point p3, Point p4){
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    //int [] x = {};
    //int [] y = {};
    if (p1 != null) {
      i1 = Math.round((float) (p1.getX()));
      i2 = Math.round((float) (p1.getY()));
      if (p2 != null) {
        i3 = Math.round((float) (p2.getX()));
        i4 = Math.round((float) (p2.getY()));
        if (p3 != null) {
          i5 = Math.round((float) (p3.getX()));
          i6 = Math.round((float) (p3.getY()));
          if (p4 != null) {
            i7 = Math.round((float) (p4.getX()));
            i8 = Math.round((float) (p4.getY()));
          }
        } else {
          //i5 = i1;
          //i6 = i2;
        } 
        
      } else {
        //i3 = i1;
        //i4 = i2;
      } 
      
      int [] x = {i1, i3, i5, i7};
      int [] y = {i2, i4, i6, i8};
      graphics.drawPolygon(x, y, 4);
      // graphics.drawLine(i1, i2, i3, i4);
      // graphics.drawLine(i1,i2,i5,i6);
      // graphics.drawLine(i3,i4,i5,i6);
    }
  }
 
}
