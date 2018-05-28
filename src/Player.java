import javafx.scene.paint.Color;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {

    public Vecter2D position;
    public Vecter2D velocity;
    public float height = 18;
    public float width = 16;
    public double angleChangeVelocity = 0;

    private Random random;
    private List<Vecter2D> verties;
    private Polygon polygon;

    public Player(int x, int y) {
        this.position = new Vecter2D(x, y);
        this.velocity = new Vecter2D(5, 0);
        this.random = new Random();
        this.updateVerties();
        this.polygon = new Polygon();
    }

    public void run() {
        this.velocity.set(this.velocity.rotate(this.angleChangeVelocity));
        this.position.addUp(this.velocity);
        this.backToScreen();
        this.updateVerties();
    }

    private void updateVerties() {
        // Triangle ABC, G is triangle center, I is BC center
        float k = (float) ((2.0 / 3.0) * (this.height / this.velocity.length()));
        Vecter2D GA = this.velocity.multiply(k);
        Vecter2D OA = this.position.add(GA);
        Vecter2D OI = this.position.subtract(GA.multiply((float) (1.0 / 2.0)));
        k = (float) ((this.width / 2.0) / this.velocity.length());
        Vecter2D OB = this.velocity.rotate(90).multiply(k).add(OI);
        Vecter2D OC = this.velocity.rotate(270).multiply(k).add(OI);
        this.verties = Arrays.asList(OA, OB, OC);
    }

    public void backToScreen() {
        if (this.position.x >= 1024) {
            this.position.set(1, random.nextInt(600));
        } else if (this.position.x <= 0) {
            this.position.set(1024, random.nextInt(600));
        } else if (this.position.y >= 600) {
            this.position.set(random.nextInt(1024), 1);
        } else if (this.position.y <= 0) {
            this.position.set(random.nextInt(1024), 600);
        }
    }

    public void render(Graphics graphics) {
        graphics.setColor(java.awt.Color.RED);
        this.polygon.reset();
        this.verties.forEach(vecter2D -> polygon.addPoint((int) vecter2D.x, (int) vecter2D.y));
        graphics.fillPolygon(this.polygon);
    }
}