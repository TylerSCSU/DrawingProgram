import java.awt.*;
public class Polygon extends Item{
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;
    int [] x = {};
    int [] y = {};
    public Polygon(Point point1, Point point2, Point point3, Point point4){
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public Polygon(Point point1, Point point2, Point point3){
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        point4 = null;
    }
    public Polygon(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        point3 = null;
        point4 = null;
    }
    public Polygon(Point point1) {
        this.point1 = point1;
        point2 = null;
        point3 = null;
        point4 = null;
    }
    public Polygon(){
        point1 = null;
        point2 = null;
        point3 = null;
        point4 = null;
    }

    public boolean includes(Point point) {
        return ((distance(point, point1 ) < 10.0) || (distance(point, point2)< 10.0));
    }

    public void render() {

        uiContext.drawPolygon(point1, point2, point3, point4);
        //uiContext.drawLine(point1, point3);
        //uiContext.drawLine(point2, point3);
        
    }
    public void setPoint1(Point point) {
        point1 = point;
    }
    public void setPoint2(Point point) {
        point2 = point;
    }
    public void setPoint3(Point point) {
        point3 = point;
    }
    public void setPoint4(Point point) {
        point4 = point;
    }
    public Point getPoint1() {
        return point1;
    }
    public Point getPoint2() {
        return point2;
    }
    public Point getPoint3() {
        return point3;
    }
    public Point getPoint4() {
        return point4;
    }
    public String toString() {
        return "Line  from " + point1 + " to " + point2 + " to " + point3;
    }
}
