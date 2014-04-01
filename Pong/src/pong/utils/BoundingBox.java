/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.utils;

/**
 *
 * @author Austin Wheeler
 */
public class BoundingBox {

    public Point point1, point2;

    public BoundingBox() {
    }

    public BoundingBox(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public boolean isInBounds(Point p) {
        return p.isInBounds(this);
    }

    public int calculateWidth() {
        return point2.x - point1.x;
    }

    public int calculateHeight() {
        return point2.y - point1.y;
    }

    public BoundingBox clone() {
        return new BoundingBox(point1.clone(), point2.clone());
    }
}
