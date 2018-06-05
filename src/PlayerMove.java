import java.util.Random;

public class PlayerMove {

    public Vecter2D velocity;
    public double angleChangeVelocity = 0;
    private Random random;

    public PlayerMove() {
        this.random = new Random();
        this.velocity = new Vecter2D(5, 0);
    }

    public void run(Player player) {
        this.velocity.set(this.velocity.rotate(this.angleChangeVelocity));
        player.position.addUp(this.velocity);
        this.backToScreen(player);
    }

    public void backToScreen(Player player) {
        if (player.position.x >= 1024) {
            player.position.set(1, random.nextInt(600));
        } else if (player.position.x <= 0) {
            player.position.set(1024, random.nextInt(600));
        } else if (player.position.y >= 600) {
            player.position.set(random.nextInt(1024), 1);
        } else if (player.position.y <= 0) {
            player.position.set(random.nextInt(1024), 600);
        }
    }
}
