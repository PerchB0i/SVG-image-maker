
public class Main {

    public static void main(String[] args) {
        Style style = new Style("lime", "red" ,2.0);
        //System.out.println(style.toSVG());

        Point point1 = new Point(100, 0);
        Point point2 = new Point(50, 100);
        Point point3 = new Point(150, 100);

        Polygon polygon = new Polygon(3, style);
        polygon.setPoint(0, point1);
        polygon.setPoint(1, point2);
        polygon.setPoint(2, point3);

        SvgScene scene = new SvgScene();
        //scene.addPolygon(polygon);
        Polygon square = Polygon.square(new Segment(new Point(20.0,10.0), new Point(40.0, 50.0)), style);
        scene.addPolygon(square);

        Segment seg = new Segment(new Point(20.0,10.0), new Point(40.0, 10.0));
        System.out.println(seg.toSVG());
        System.out.println(Segment.perpendicular(seg, new Point((seg.getP1().x + seg.getP2().x) / 2 , (seg.getP1().y + seg.getP2().y) / 2))[0].toSVG());
        System.out.println(Segment.perpendicular(seg, new Point((seg.getP1().x + seg.getP2().x) / 2 , (seg.getP1().y + seg.getP2().y) / 2))[1].toSVG());
        scene.saveHTML("file.html");

    }

}