import java.awt.*;

public class RectangleRenderer {
    public int width;
    public int height;
    public Vecter2D position;
    public Color color;

    public RectangleRenderer(int width, int height, Vecter2D position, Color color) {
        this.width = width;
        this.height = height;
        this.position = position;
        this.color = color;
    }

    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect((int)position.x, (int)position.y, width, height);
    }
}
