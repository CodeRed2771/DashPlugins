package pong.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import pong.game.Pong;
import pong.utils.Entity;
import pong.utils.Point;
import pong.utils.Velocity;

/**
 *
 * @author Michael
 */
public class Ball implements Entity {

    Point location;
    Velocity velocity;
    Pong pong;

    public Ball(Pong pong) {
        location = new Point((pong.getScreenWidth() - 10) / 2,
                (pong.getScreenHeight() - 10) / 2);
        velocity = new Velocity(2 * (new Random().nextBoolean() ? 1 : -1),
                2 * (new Random().nextBoolean() ? 1 : -1), -11, 5,
                pong.getScreenWidth() - 3, pong.getScreenHeight() - 15);
        this.pong = pong;
    }

    @Override
    public void move() {
        location = velocity.calculateNewBouncyPoint(location);
        if (location.x < -10) {
            pong.resetBall();
            pong.right.score++;
        } else if (location.x > pong.getScreenWidth() - 4){
            pong.resetBall();
            pong.left.score++;
        }
    }

    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public Velocity getVelocity() {
        return velocity;
    }

    @Override
    public Rectangle getHitbox() {
        return new Rectangle(location.x, location.y, 10, 10);
    }

    @Override
    public void collision(Entity entity) {
        if (entity instanceof Paddle) {
            velocity.reverseXVelocity();
            move();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(location.x, location.y, 10, 10);
    }
}
