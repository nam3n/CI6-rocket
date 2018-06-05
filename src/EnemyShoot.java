import java.util.ArrayList;
import java.util.List;

public class EnemyShoot extends GameObject{
    public List<BulletEnemy> bulletEnemies;
    private FrameCounter frameCounter = new FrameCounter(50);

    public EnemyShoot() {
        this.bulletEnemies = new ArrayList<>();
    }

    public void run(Vecter2D position) {
        if (this.frameCounter.run()) {
            this.frameCounter.reset();
            Vecter2D bulletVelocity = new Vecter2D(3, 0);
            for (int i = 0; i < 16; i++) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(position);
                bulletEnemy.velocity.set(bulletVelocity);
                bulletVelocity = bulletVelocity.rotate(22.5);
                this.bulletEnemies.add(bulletEnemy);
            }
        }
    }
}
