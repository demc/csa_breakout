import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Contains all of the brick objects.
 * Performs collision detection.
 *
 * @author demc
 * @version 5/17/17
 */
public class BrickStore
{
    private PApplet app;
    private ArrayList<Brick> bricks;
    private int rowHeight;
    
    public BrickStore(PApplet app) {
        this.app = app;
        bricks = new ArrayList();

        app.registerMethod("draw", this);
    }
    
    public void addBrick(Brick brick) {
        bricks.add(brick);
    }
    
    public void removeBrick(Brick brick) {
        bricks.remove(brick);
    }
    
    public void setRowHeight(int rowHeight) {
        this.rowHeight = rowHeight;
    }
    
    public void draw() {

        for (Brick brick : bricks) {
            app.noStroke();
            app.fill(brick.getColor());
            app.rect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
        }
        
    }
    
    public Brick getCollision(Ball ball) {

        for (Brick brick : bricks) {
            int midpointX = brick.getX() + brick.getWidth() / 2;
            int midpointY = brick.getY() + brick.getHeight() / 2;
            int cornerX = brick.getX() + brick.getWidth();
            int cornerY = brick.getY() + brick.getHeight();
            float distance = PApplet.dist(midpointX, midpointY, ball.getX(), ball.getY());
            float threshold = PApplet.dist(midpointX, midpointY, cornerX, cornerY);
            
            if (distance <= threshold) {
                return brick;
            }
        }
    
        return null;
    }
}
