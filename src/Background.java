import java.awt.*;

public class Background extends GameObject {
    public Vecter2D position;

    public Background(int x, int y, Color color) {
        this.position = new Vecter2D(x, y);
        this.renderer = new BackgroundRenderer(color);
    }
}
