import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public BufferedImage image;
    public Vecter2D position;
    public int width;
    public int height;
    public Vecter2D velocity;

    public Star(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.position = new Vecter2D(x, y);
        this.width = width;
        this.height = height;
        this.velocity = new Vecter2D(velocityX, velocityY);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, this.width, this.height, null);
    }
}