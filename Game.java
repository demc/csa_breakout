import processing.core.PApplet;
import processing.event.MouseEvent;
/**
 * Game app class. Maintains the state of the game.
 *
 * @author McMillen
 * @version 5
 */

//
// STAGE 1: Setup PApplet and launcher
//
public class Game extends PApplet
{
    //
    // Stage 2: Make the ball 
    //
    private Ball myBall;
    
    //
    // Stage 3: Launch the ball
    //
    private boolean hasGameStarted = false;
    
    //
    // Stage 4: Add bricks to store
    //
    private BrickStore brickStore;
    
    public void settings() {
        size(480, 480);
    }
    
    public void setup() {
        //
        // Stage 2: Make the ball
        //
        int radius = 8;
        myBall = new Ball(width / 2, height - radius - 20, radius, color(30, 144, 255));
        
        //
        // Stage 5: Add bricks to store
        //
        brickStore = new BrickStore(this);
        
        for (int i = 0; i < 10; i++) {
            Brick redBrick = new Brick(i * 44 + i * 4, 0, 44, 20, color(255, 0, 0));
            brickStore.addBrick(redBrick);
        }
    }
    
    public void draw() {
        //
        // Stage 2: Make the ball
        //
        background(255); // good mistake example
        
        noStroke();
        fill(myBall.getColor());
        int diameter = myBall.getRadius() * 2;
        ellipse(myBall.getX(), myBall.getY(), diameter, diameter); // explain javadoc for `ellipse()`
        
        //
        // Stage 6: Check for collisions
        //
        Brick brickThatWasHit = brickStore.getCollision(myBall);
        if (brickThatWasHit != null) {
            brickStore.removeBrick(brickThatWasHit);
            myBall.setVelocityY(myBall.getVelocityY() * -1);
        }
        
        //
        // Stage 4: Hit the sides
        //
        if (myBall.getX() + myBall.getRadius() >= width) {
            // Colliding with right wall
            myBall.setVelocityX(myBall.getVelocityX() * -1);
        }
        
        if (myBall.getY() - myBall.getRadius() <= 0) {
            // Colliding with top wall
            myBall.setVelocityY(myBall.getVelocityY() * -1);
        }
        
        if (myBall.getX() - myBall.getRadius() <= 0) {
            // Colliding with left wall
            myBall.setVelocityX(myBall.getVelocityX() * -1);
        }
        
        if (myBall.getY() + myBall.getRadius() >= height) {
            // Went through the goal - reset the game
            myBall.setPosition(width / 2, height - 20 - myBall.getRadius());
            myBall.setVelocityX(0);
            myBall.setVelocityY(0);
            hasGameStarted = false;
        }
        
        //
        // Stage 3: Launch the ball
        //
        int newXPos = myBall.getX() + myBall.getVelocityX(); // explain that 0 is the default value
        myBall.setX(newXPos);
        int newYPos = myBall.getY() + myBall.getVelocityY();
        myBall.setY(newYPos);
    }
    
    //
    // Stage 2: Make the ball
    //
    public void mouseMoved(MouseEvent event) {
        //
        // Stage 3: Launch the ball
        //
        if (!hasGameStarted) {        
            int x = event.getX();
            int y = event.getY();
            
            // myBall.setPosition(x, y); // good mistake example
            myBall.setX(x);
        }
    }
    
    //
    // Stage 3: Launch the ball
    //
    public void mouseReleased(MouseEvent event) {
        if (!hasGameStarted) {
            myBall.setVelocityX(5);
            myBall.setVelocityY(-5);
            hasGameStarted = true;
        }
    }
}
