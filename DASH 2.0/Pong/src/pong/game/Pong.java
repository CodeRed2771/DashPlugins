package pong.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import pong.entities.Ball;
import pong.entities.Paddle;
import pong.logic.EntityLogic;
import pong.utils.Point;

public class Pong extends JFrame {

    EntityLogic entityLogic;
    public Paddle left, right;
    Ball ball;

    public Pong() {
        setUndecorated(true);
        this.setSize(1024, 400);
        this.setLocation(0, 0);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBackground(Color.WHITE);
        setTitle("Pong");
        addKeyListener(new Pong.KeyListener(this));

        left = new Paddle(new Point(13, (getScreenHeight() - 80) / 2), this);
        right = new Paddle(new Point(getScreenWidth() - 23, (getScreenHeight() - 80) / 2), this);
        entityLogic = new EntityLogic();
        entityLogic.addEntity(left);
        entityLogic.addEntity(right);
        this.setVisible(true);
        requestFocus();
    }

    public void resetBall() {
        entityLogic.removeEntity(ball);
        ball = new Ball(this);
        entityLogic.addEntity(ball);
    }

    @Override
    public void paint(Graphics g) {
        Image dbImg = createImage(getWidth(), getHeight());
        Graphics dbg = dbImg.getGraphics();
        draw(dbg);
        g.drawImage(dbImg, 0, 0, this);
    }

    public void draw(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 50));
        FontMetrics metrics = g.getFontMetrics();
        g.setColor(Color.white);
        g.drawRect(0, 0, getScreenWidth(), getScreenHeight());
        g.setColor(Color.black);
        g.fillRect(5, 5, getScreenWidth() - 10, getScreenHeight() - 10);
        g.setColor(Color.white);
        g.fillRect((getScreenWidth() - 5) / 2, 0, 5, getScreenHeight());
        g.drawString(String.valueOf(left.score), getScreenWidth() / 2 - (20 + metrics.stringWidth(String.valueOf(left.score))), 50);
        g.drawString(String.valueOf(right.score), getScreenWidth() / 2 + 20, 50);
        for (int i = 0; i < entityLogic.getEntities().size(); i++) {
            entityLogic.getEntities().get(i).draw(g);
        }
        repaint();
    }

    private static Image loadImage(String fileName) {
        ImageIcon icon = new ImageIcon(fileName);
        return icon.getImage();
    }

    public int getScreenWidth() {
        return this.getWidth();
    }

    public int getScreenHeight() {
        return this.getHeight();
    }

    private class KeyListener extends KeyAdapter {

        Pong game;

        public KeyListener(Pong game) {
            this.game = game;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    left.getVelocity().setYVelocity(-3);
                    break;
                case KeyEvent.VK_S:
                    left.getVelocity().setYVelocity(3);
                    break;
                case KeyEvent.VK_UP:
                    right.getVelocity().setYVelocity(-3);
                    break;
                case KeyEvent.VK_DOWN:
                    right.getVelocity().setYVelocity(3);
                    break;
                case KeyEvent.VK_Z:
                    entityLogic.shouldRun = false;
                    break;
                case KeyEvent.VK_X:
                    if (!entityLogic.shouldRun) {
                        left.score = 0;
                        right.score = 0;
                        left.getLocation().y = (getScreenHeight() - 80) / 2;
                        right.getLocation().y = (getScreenHeight() - 80) / 2;
                        entityLogic.shouldRun = true;
                        entityLogic.start();
                        resetBall();
                    }
                    break;
                case KeyEvent.VK_ESCAPE:
                    game.setVisible(false);
                    game = null;
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    if (left.getVelocity().getyVelocity() == -3) {
                        left.getVelocity().setYVelocity(0);
                    }
                    break;
                case KeyEvent.VK_S:
                    if (left.getVelocity().getyVelocity() == 3) {
                        left.getVelocity().setYVelocity(0);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (right.getVelocity().getyVelocity() == -3) {
                        right.getVelocity().setYVelocity(0);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (right.getVelocity().getyVelocity() == 3) {
                        right.getVelocity().setYVelocity(0);
                    }
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            switch (e.getKeyCode()) {
            }
        }
    }
}
