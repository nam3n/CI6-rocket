import java.awt.*;

public class Star extends GameObject{

    public Vecter2D velocity;

    public Star(int x, int y, int width, int velocityX, int velocityY) {
        this.position = new Vecter2D(x, y);
        this.velocity = new Vecter2D(velocityX, velocityY);
        this.renderer = new ImageRenderer("resources/images/star.png", width, width);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
}