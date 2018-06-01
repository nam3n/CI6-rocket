import java.awt.*;

public class Background {
    public Vecter2D position;
    private RectangleRenderer renderer;

    public Background(int x, int y, int width, int height, Color color) {
        this.position = new Vecter2D();
        this.position.x = x;
        this.position.y = y;
        this.renderer = new RectangleRenderer(width, height, position, color);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics);
    }
}
