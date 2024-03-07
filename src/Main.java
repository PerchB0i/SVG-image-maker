
public class Main {

    /*
    public static Segment getSegment (Segment segment, Point point) {
        double a = (segment.getP2().y - segment.getP1().y) / (segment.getP2().x - segment.getP1().x);

        Segment newSegment;
        double aPrim = -1/a;
        double b1 = point.y - (point.x * aPrim);

        double x1 = point.x -Math.abs(segment.getP1().x - segment.getP2().x);
        //double x2 = Math.abs(segment.getP1().x - segment.getP2().x) + point.x;

        double y1 = aPrim * x1 + b1;
        //double y2 = aPrim*x2 + b1;

        newSegment = new Segment(point, new Point(x1, y1));

        return newSegment;
    }
*/

    public static void main(String[] args) {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(100, 100);

        Segment segment = new Segment(p1, p2);
        //System.out.println(segment.toSVG());
        System.out.println(segment.getDistance());
        Point point = new Point(30, 20);

        // System.out.println(getSegment(segment, point).getP2().x);
        // System.out.println(getSegment(segment, point).getP2().y);
    }

}