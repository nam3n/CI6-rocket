import java.awt.*;

public class BulletPlayer {
    public Vecter2D position;
    public Vecter2D velocity;
    public float height = 15;
    public float width = 5;

    private PolygonRenderer renderer;

    public BulletPlayer() {
        this.position = new Vecter2D();
        this.velocity = new Vecter2D();
        this.renderer = new PolygonRenderer(Color.red);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position, this.velocity, this.width, this.height);
    }
}