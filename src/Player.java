import javafx.scene.paint.Color;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {

    public Vecter2D position;
    public Vecter2D velocity;
    public float height = 25;
    public float width = 20;
    public double angleChangeVelocity = 0;
    public boolean shooting = false;

    private Random random;
    private List<Vecter2D> verties;
    private PolygonRenderer renderer;
    private PlayerShoot playerShoot;

    public Player() {
        this.position = new Vecter2D(300,300);
        this.velocity = new Vecter2D(5, 0);
        this.random = new Random();
        this.renderer = new PolygonRenderer(java.awt.Color.CYAN);
        this.playerShoot = new PlayerShoot();
    }

    public void run() {
        this.velocity.set(this.velocity.rotate(this.angleChangeVelocity));
        this.position.addUp(this.velocity);
        this.backToScreen();
        if (shooting) this.playerShoot.run(this);
        this.playerShoot.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.run());
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
        this.renderer.render(graphics, this.position, this.velocity, this.width, this.height);
        this.playerShoot.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
}