/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.utils;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Michael
 */
public interface Entity {

    public void move();

    public Point getLocation();

    public Velocity getVelocity();

    public Rectangle getHitbox();
    
    public void collision(Entity entity);
    
    public void draw(Graphics g);
}
