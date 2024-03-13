import java.util.Locale;

public class Elipse extends Shape{
    private Point elipseMidPoint;
    private double radius1Length, radius2Length;
    private Style style;

    public Elipse(Style style, Point elipseMidPoint,
                  double radius1Length, double radius2Length) {
        super(style);
        this.elipseMidPoint = elipseMidPoint;
        this.radius1Length = radius1Length;
        this.radius2Length = radius2Length;
        this.style = style;
    }

    public Point getElipseMidPoint() {
        return elipseMidPoint;
    }

    public double getRadius1Length() {
        return radius1Length;
    }

    public double getRadius2Length() {
        return radius2Length;
    }

    public Style getStyle() {
        return style;
    }

    @Override
    public String toSVG() {
        return String.format(Locale.ENGLISH,"" +
                "<ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\" %s/>",
                radius1Length, radius2Length,
                elipseMidPoint.x, elipseMidPoint.y, style.toSVG());
    }
}
