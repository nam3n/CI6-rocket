import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public Vecter2D position;
    public Vecter2D velocity;

    private ImageRenderer renderer;

    public Star(int x, int y, int width, int velocityX, int velocityY) {
        this.position = new Vecter2D(x, y);
        this.velocity = new Vecter2D(velocityX, velocityY);
        this.renderer = new ImageRenderer("resources/images/star.png", width, width);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}