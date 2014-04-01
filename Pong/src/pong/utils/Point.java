/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.utils;

/**
 *
 * @author Austin Wheeler
 */
public class Point {

    public int x, y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isInBounds(BoundingBox bounds) {
        return x >= bounds.point1.x && y >= bounds.point1.y
                && x < bounds.point2.x && y < bounds.point2.y;
    }

    @Override
    public Point clone() {
        return new Point(x, y);
    }
}
