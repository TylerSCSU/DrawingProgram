import java.awt.*;
import java.text.*;
public class PolygonCommand extends Command{
    private Polygon poly;
    private int pointCount;
    int [] x = {};
    int [] y = {};
    public PolygonCommand() {
        this(null, null, null, null);
        pointCount = 0;
    }
    public PolygonCommand(Point point) {
        this(point, null, null, null);
        pointCount = 1;
    }
    public PolygonCommand(Point point1, Point point2){
        this(point1, point2, null, null);
        pointCount = 2;
    }
    public PolygonCommand(Point point1, Point point2, Point point3){
        poly = new Polygon(point1, point2, point3, null);
        pointCount = 3;
    }
    public PolygonCommand(Point point1, Point point2, Point point3, Point point4){
        poly = new Polygon(point1, point2, point3, point4);
        pointCount = 4;
    }
    public void setLinePoint(Point point){
        if(++pointCount == 1){
            poly.setPoint1(point);
        } else if (pointCount == 2){
            poly.setPoint2(point);
        } else if (pointCount == 3){
            poly.setPoint3(point);
        } else if (pointCount == 4){
            poly.setPoint4(point);
        }
    }

    public void execute() {
        model.addItem(poly);
    }
    public boolean undo() {
        model.removeItem(poly);
        return true;
    }
    public boolean redo() {
        execute();
        return true;
    }
    public boolean end() {
        if (poly.getPoint1() == null) {
          undo();
          return false;
        }
        if (poly.getPoint2() == null) {
           poly.setPoint2(poly.getPoint1());
        }
        if (poly.getPoint3() == null) {
            poly.setPoint3(poly.getPoint2());
        }
        if (poly.getPoint4() == null) {
            poly.setPoint4(poly.getPoint3());
        }
        return true;
    }


}
