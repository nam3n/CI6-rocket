import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BulletEnemy {

    public BufferedImage image;
    public Vecter2D position;
    public int width;
    public int height;
    public Vecter2D velocity;
    private ImageRenderer renderer;

    public BulletEnemy() {
        this.position = new Vecter2D();
        this.width = 10;
        this.height = 10;
        this.velocity = new Vecter2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", width, height);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
