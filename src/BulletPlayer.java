import java.awt.*;

public class BulletPlayer extends GameObject{
    public Vecter2D velocity;

    public BulletPlayer() {
        this.position = new Vecter2D();
        this.velocity = new Vecter2D();
        this.renderer = new PolygonRenderer(Color.red, 5, 15);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        ((PolygonRenderer) this.renderer).velocity.set(this.velocity);
    }
}