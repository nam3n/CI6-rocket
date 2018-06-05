import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;
    Background background = new Background(0,0, Color.BLACK);

    Player player;
    Enemy specialEnemy;

    private EnemySpawner enemySpawner;
    private StarSpawner starSpawner;

    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.setupCharacter();
        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.player = new Player();
        this.specialEnemy = new Enemy();
        this.starSpawner = new StarSpawner();
        this.enemySpawner = new EnemySpawner();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // lat backbuffered
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(graphics);

        this.player.render(graphics);
        this.specialEnemy.render(graphics);
        this.enemySpawner.enemies.forEach(enemy -> enemy.render(graphics));
        this.starSpawner.stars.forEach(star -> star.render(graphics));

        this.repaint();
    }

    public void runAll() {
        this.player.run();
        this.specialEnemy.shootAround();
        this.enemySpawner.playerPosition.set(this.player.position);
        this.enemySpawner.run();
        this.starSpawner.run();
    }
}