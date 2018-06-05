import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PolygonRenderer implements Renderer{
    private List<Vecter2D> verties;
    private Polygon polygon;
    private Color color;
    public Vecter2D velocity;
    private float width;
    private float height;

    public PolygonRenderer(Color color, float width, float height) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.polygon = new Polygon();
        this.velocity = new Vecter2D();
    }

    private void updateVerties(Vecter2D position) {
        // Triangle ABC, G is triangle center, I is BC center
        float k = (float) ((2.0 / 3.0) * (height / velocity.length()));
        Vecter2D GA = velocity.multiply(k);
        Vecter2D OA = position.add(GA);
        Vecter2D OI = position.subtract(GA.multiply((float) (1.0 / 2.0)));
        k = (float) ((width / 2.0) / velocity.length());
        Vecter2D OB = velocity.rotate(90).multiply(k).add(OI);
        Vecter2D OC = velocity.rotate(270).multiply(k).add(OI);
        this.verties = Arrays.asList(OA, OB, OC);
    }

    public void render(Vecter2D position, Graphics graphics) {
        graphics.setColor(this.color);
        this.polygon.reset();
        this.updateVerties(position);
        this.verties.forEach(vecter2D -> polygon.addPoint((int) vecter2D.x, (int) vecter2D.y));
        graphics.fillPolygon(this.polygon);
    }
}
