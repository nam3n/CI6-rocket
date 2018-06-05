import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;
    boolean speedUp = false;

    public GameWindow() {
        this.setSize(1024, 600); // set size window

        this.setupGameCanvas();
        this.event();

        this.setVisible(true);
    }

    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void event() {
        this.keyboardEvent();
        this.windowEvent();
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.playerMove.angleChangeVelocity = 355;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.player.playerMove.angleChangeVelocity = 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (speedUp == false) {
                        gameCanvas.player.playerMove.velocity.multiplyUp(2);
                        speedUp = true;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    gameCanvas.player.shooting = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.playerMove.angleChangeVelocity = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.player.playerMove.angleChangeVelocity = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (speedUp) {
                        speedUp = false;
                        gameCanvas.player.playerMove.velocity.multiplyUp(0.5f);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    gameCanvas.player.shooting = false;
                }
            }
        });
    }

    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }

}