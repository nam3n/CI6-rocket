import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {

    private Random random = new Random();

    public BufferedImage image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityX;
    public int velocityY;

    public Enemy(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }



    public void moveForward(int x, int y) {
        if (Math.abs(this.x - x) < this.velocityX) {
            this.x = x;
        } else {
            if (this.x > x) {
                this.x -= this.velocityX;
            } else {
                this.x += this.velocityX;
            }
        }

        if (Math.abs(this.y - y) < this.velocityY) {
            this.y = y;
        } else {
            if (this.y > y) {
                this.y -= this.velocityY;
            } else {
                this.y += this.velocityY;
            }
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);
    }
}