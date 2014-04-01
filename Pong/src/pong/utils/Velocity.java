package pong.utils;

/**
 *
 * @author Michael
 */
public class Velocity {

    private int xVelocity = 0;
    private int yVelocity = 0;
    private int xmin, ymin, xmax, ymax;
    private boolean useBounderies = false;

    public Velocity() {
    }

    public Velocity(int xVelocity, int yVelocity) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public Velocity(int xVelocity, int yVelocity, int xmin, int ymin, int xmax, int ymax) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.xmin = xmin;
        this.ymin = ymin;
        this.xmax = xmax;
        this.ymax = ymax;
        useBounderies = true;
    }

    public void reverseXVelocity() {
        xVelocity = -xVelocity;
    }

    public void reverseYVelocity() {
        yVelocity = -yVelocity;
    }

    public void setXVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setYVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public Point calculateNewPoint(Point point) {
        point.x += xVelocity;
        point.y += yVelocity;
        if (useBounderies) {
            if (point.x > xmax) {
                point.x = xmax;
            } else if (point.x < xmin) {
                point.x = xmin;
            }

            if (point.y > ymax) {
                point.y = ymax;
            } else if (point.y < ymin) {
                point.y = ymin;
            }
        }
        return point;
    }

    public Point calculateNewBouncyPoint(Point point) {
        point.x += xVelocity;
        point.y += yVelocity;
        if (useBounderies) {
            if (point.x > xmax) {
                point.x = xmax;
            } else if (point.x < xmin) {
                point.x = xmin;
            }

            if (point.y > ymax) {
                point.y = ymax;
                reverseYVelocity();
            } else if (point.y < ymin) {
                point.y = ymin;
                reverseYVelocity();
            }
        }
        return point;
    }
}
