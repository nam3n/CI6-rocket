import java.util.ArrayList;
import java.util.List;

public class PlayerShoot {
    public List<BulletPlayer> bulletPlayers;

    public PlayerShoot() {
        this.bulletPlayers = new ArrayList<>();
    }

    public void run(Player player) {
        BulletPlayer bulletPlayer = new BulletPlayer();
        bulletPlayer.position.set(player.position);
        bulletPlayer.velocity.set(player.velocity.multiply(2));
        this.bulletPlayers.add(bulletPlayer);
    }
}
