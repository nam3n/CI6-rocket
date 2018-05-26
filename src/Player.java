import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player {

    Random random = new Random();

    public BufferedImage image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityX;
    public int velocityY;

    public Player(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void moveLeft() {
        this.velocityX -= 20;
    }

    public void moveRight() {
        this.velocityX += 20;
    }

    public void moveUp() {
        this.velocityY -= 20;
    }

    public void moveDown() {
        this.velocityY += 20;
    }

    public void run() {
        this.x += this.velocityX;
        this.y += this.velocityY;
        this.velocityX = 0;
        this.velocityY = 0;
        if (this.x >= 1024) {
            this.x = 1;
            this.y = random.nextInt(600);
        } else if (this.x <= -this.width) {
            this.x = 1024 - this.width;
            this.y = random.nextInt(600);
        } else if (this.y >= 600) {
            this.y = 1;
            this.x = random.nextInt(1024);
        } else if (this.y <= -this.height) {
            this.y = 600 - this.height;
            this.x = random.nextInt(1024);
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);
    }
}