public class Main {
    public static void main(String[] args) {
        Point point1 = new Point(0, 100);
        Point point2 = new Point(100, 102);
        Point point3 = new Point(50, 50);

        Polygon polygon = new Polygon(
                3,
                new Style(null, null, null)
        );
        polygon.setPoint(0, point1);
        polygon.setPoint(1, point2);
        polygon.setPoint(2, point3);

        Shape filledPolygon = new SolidFilledShapeDecorator(polygon, "blue");

        Shape transformedPolygon = new TransformationDecorator
                .Builder()
                .setShape(filledPolygon)
                .setTranslateVector(point3)
                .setTranslateVector(point3)
                .build();

        SvgScene svgScene = new SvgScene();
        svgScene.addShape(transformedPolygon);
        svgScene.saveHtml("./test.html");
    }
}