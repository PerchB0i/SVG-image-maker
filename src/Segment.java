import java.util.Locale;

public class Segment {
    private Point p1, p2;

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getDistance(){
        // return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        return Math.hypot(p1.x - p2.x, p1.y - p2.y);
    }

    public String toSVG() {
        return String.format(Locale.ENGLISH,"<line x1=\"%f\" y1=\"%f\" " +
                "x2=\"%f\" y2=\"%f\" " +
                "style=\"stroke:red:stroke-width:2\" />", p1.x, p1.y, p2.x, p2.y);
    }

    public static Segment[] getLines (Segment segment, Point point) {
        double a = (segment.getP2().y - segment.getP1().y) / (segment.getP2().x - segment.getP1().x);
        double b = segment.getP1().y - (segment.getP1().x * a);
        double aPrim = -1/a;
        double b1 = point.y - (point.x * aPrim);

        double x1 = point.x -Math.abs(segment.getP1().x - segment.getP2().x);
        double x2 = Math.abs(segment.getP1().x - segment.getP2().x) + point.x;

        double y1 = aPrim*x1 + b1;
        double y2 = aPrim*x2 + b1;

        Segment newSegment1 = new Segment(point, new Point(x1, y1));
        Segment newSegment2 = new Segment(point, new Point(x2, y2));

        return new Segment[]{newSegment1, newSegment2};
    }
}
