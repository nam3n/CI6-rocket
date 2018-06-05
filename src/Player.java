import java.awt.*;

public class Player extends GameObject {

    public boolean shooting = false;
    public PlayerMove playerMove;

    private PlayerShoot playerShoot;

    public Player() {
        this.position = new Vecter2D(300,300);
        this.renderer = new PolygonRenderer(java.awt.Color.CYAN, 20, 25);
        this.playerShoot = new PlayerShoot();
        this.playerMove = new PlayerMove();
    }
    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        ((PolygonRenderer) this.renderer).velocity.set(this.playerMove.velocity);
        if (shooting) this.playerShoot.run(this);
        this.playerShoot.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.run());
    }
    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        this.playerShoot.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
}