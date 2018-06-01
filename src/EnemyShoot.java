import java.util.ArrayList;
import java.util.List;

public class EnemyShoot {
    public List<BulletEnemy> bulletEnemies;
    private int countBullet = 0;

    public EnemyShoot() {
        this.bulletEnemies = new ArrayList<>();
    }

    public void run(Vecter2D position) {
        if (countBullet == 50) {
            countBullet = 0;
            Vecter2D bulletVelocity = new Vecter2D(3, 0);
            for (int i = 0; i < 16; i++) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(position);
                bulletEnemy.velocity.set(bulletVelocity);
                bulletVelocity = bulletVelocity.rotate(22.5);
                this.bulletEnemies.add(bulletEnemy);
            }
        } else {
            countBullet++;
        }
    }
}
