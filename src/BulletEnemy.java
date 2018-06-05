public class BulletEnemy extends GameObject {

    public int width;
    public int height;
    public Vecter2D velocity;

    public BulletEnemy() {
        this.position = new Vecter2D();
        this.width = 10;
        this.height = 10;
        this.velocity = new Vecter2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", width, height);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
}
