package pong.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import pong.game.Pong;
import pong.utils.Entity;
import pong.utils.Point;
import pong.utils.Velocity;

/**
 *
 * @author Michael
 */
public class Paddle implements Entity {

    Point location;
    Velocity velocity;
    
    public int score = 0;

    public Paddle(Point location, Pong pong) {
        this.location = location;
        velocity = new Velocity(0, 0, location.x - 1, 5, location.x + 1, pong.getScreenHeight() - 85);
    }

    @Override
    public void move() {
        location = velocity.calculateNewPoint(location);
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
        return new Rectangle(location.x, location.y, 10, 80);
    }

    @Override
    public void collision(Entity entity) {
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(location.x, location.y, 10, 80);
    }
}
