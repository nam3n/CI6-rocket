import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRenderer implements Renderer{
    public BufferedImage image;
    public int width;
    public int height;

    public ImageRenderer(String path, int width, int height) {
        this.width = width;
        this.height = height;
        this.image = this.loadImage(path);
    }

    public void render(Vecter2D position, Graphics graphics) {
        graphics.drawImage(
                this.image,
                (int) position.x,
                (int) position.y,
                this.width,
                this.height,
                null
        );
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
