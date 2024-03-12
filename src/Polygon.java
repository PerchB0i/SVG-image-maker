import java.util.Locale;

public class Polygon {
    private Point[] arr;
    private Style style;

    public Polygon(int count, Style style) {
        arr = new Point[count];
        this.style = style;
    }

    public void setPoint(int index, Point point) {
        arr[index] = point;
    }

    public void setPoints(Point[] points){
        arr = points;
    }

    public String toSvg() {
        String pointsString = "";
        for(Point point : arr)
            pointsString += point.x + "," + point.y + " ";

        return String.format(Locale.ENGLISH,"" +
                "<polygon points=\"%s\" %s/>", pointsString, style.toSVG());
    }

    public static Polygon square(Segment diagonal, Style style) {
        Point diagMidPoint = new Point((diagonal.getP1().x + diagonal.getP2().x) / 2, (diagonal.getP1().y + diagonal.getP2().y) / 2);
        Segment[] segs = Segment.perpendicular(diagonal, diagMidPoint);
        Segment diag2 = new Segment(new Point(segs[0].getP2().x, segs[0].getP2().y), new Point(segs[1].getP2().x, segs[1].getP2().y));
        Polygon square = new Polygon(4, style);
        Point[] squarePoints = {
                diag2.getP2(),
                diagonal.getP2(),
                diag2.getP1(),
                diagonal.getP1()
        };
        square.setPoints(squarePoints);

        return square;
    }

}
