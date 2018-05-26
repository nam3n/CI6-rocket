import javafx.scene.paint.Color;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {

    public Vecter2D position;
    public Vecter2D velocity;

    private Random random;
    private List<Vecter2D> verties;
    private Polygon polygon;
    private Vecter2D vertex;

    public Player(int x, int y) {
        this.position = new Vecter2D(x, y);
        this.velocity = new Vecter2D(5, 0);
        this.random = new Random();
        this.updateVerties();
        this.polygon = new Polygon();
    }

    public void run() {
        this.position.addUp(this.velocity);
        this.backToScreen();
        this.updateVerties();
    }

    private void updateVerties() {
        this.verties = Arrays.asList(
                new Vecter2D(this.position.x - 6, this.position.y - 8),
                new Vecter2D(this.position.x - 6, this.position.y + 8),
                new Vecter2D(this.position.x + 12, this.position.y)
        );
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