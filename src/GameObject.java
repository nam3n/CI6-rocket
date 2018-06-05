import java.awt.*;

public class GameObject {
    public Vecter2D position;
    public Renderer renderer;

    public void run() {
    }

    public void render(Graphics graphics) {
        if (this.renderer == null) return;
        this.renderer.render(this.position, graphics);
    }
}
