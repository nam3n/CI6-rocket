import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject {

    private Random random = new Random();

    public Vecter2D velocity;
    public int speed;
    public EnemyShoot enemyShoot;

    public Enemy() {
        this.position = new Vecter2D(random.nextInt(1000), random.nextInt(580));
        this.speed = random.nextInt(4) + 1;
        this.velocity = new Vecter2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.enemyShoot = new EnemyShoot();
    }

    public void moveForward(Vecter2D positionPlayer) {
        this.updateVelocity(positionPlayer);
        this.run();
    }

    public void shootAround() {
        this.enemyShoot.run(this.position);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }

    public void updateVelocity(Vecter2D positionPlayer) {
        this.velocity.set(positionPlayer.subtract(this.position).normalize()).multiplyUp(this.speed);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}