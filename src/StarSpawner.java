import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StarSpawner extends GameObject {
    private FrameCounter frameCounter;
    private Random random;
    public List<Star> stars;

    public StarSpawner() {
        this.frameCounter = new FrameCounter(1);
        this.stars = new ArrayList<>();
        this.random = new Random();
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Star star = new Star(
                    1024,
                    this.random.nextInt(600) * 1,
                    this.random.nextInt(3) + 1,
                    -(this.random.nextInt(3) + 1) * 1,
                    0
            );
            this.stars.add(star);
            this.frameCounter.reset();
        }
        this.stars.forEach(enemy -> enemy.run());
    }
}
