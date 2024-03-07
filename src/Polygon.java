import java.util.Locale;

/*
public class Polygon {
    private Point[] arr;

    public Polygon(Point[] arr) {
        this.arr = arr;
    }

    public String toSVG() {
        String pointsStr = "";
        for (Point i:
             this.arr) {
            String string = String.format(Locale.ENGLISH,"%f,%f ", i.x, i.y);
            pointsStr = points.concat(string);
        }
        return String.format("<polygon points=\"%s\" " +
                "style=\"stroke:red:stroke-width:2\" />", pointsStr);
    }
}
*/
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


}
