import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SvgScene {
    private Polygon[] polygons = new Polygon[0];

    public void addPolygon(Polygon newPolygon) {
        polygons = Arrays.copyOf(polygons, polygons.length + 1);
        polygons[polygons.length - 1] = newPolygon;
    }

    public void saveHTML(String path) {
        String img = "<svg height=\"200\" width=\"300\" >\n";
        for (Polygon poly:
             polygons) {
            img += poly.toSvg() + "\n";
        }
        img += "</svg>";

        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(img);
            fileWriter.close();
        } catch (IOException e) {
        }
/*
        String test = "t";
        String test2 = "t";
        if(test.equals(test2))
        {
            System.out.println("don't use '==' /w Strings or any other objects");
        }
 */
    }
}
