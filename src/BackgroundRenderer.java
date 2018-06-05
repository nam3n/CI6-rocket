import java.awt.*;

public class BackgroundRenderer implements Renderer{
    public int width;
    public int height;
    public Color color;

    public BackgroundRenderer(Color color) {
        this.width = 1024;
        this.height = 600;
        this.color = color;
    }
    @Override
    public void render(Vecter2D position, Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect((int)position.x, (int)position.y, width, height);
    }
}
