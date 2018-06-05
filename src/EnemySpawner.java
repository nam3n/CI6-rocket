import java.util.ArrayList;
import java.util.List;

public class EnemySpawner extends GameObject {

    private FrameCounter frameCounter;
    public List<Enemy> enemies;
    public Vecter2D playerPosition;

    public EnemySpawner() {
        this.frameCounter = new FrameCounter(200);
        this.enemies = new ArrayList<>();
        this.playerPosition = new Vecter2D();
    }
    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Enemy enemy = new Enemy();
            this.enemies.add(enemy);
            this.frameCounter.reset();
        }
        this.enemies.forEach(enemy -> enemy.moveForward(playerPosition));
    }
}
