
/**
 * Ball class.
 *
 * @author McMillen
 * @version 5/17/17
 */

//
// Stage 2: Make the ball 
//
public class Ball
{
    private int x;
    private int y;
    private int radius;
    private int color;
    
    //
    // Stage 3: Launch the ball
    //
    private int velocityX;
    private int velocityY;
    
    public Ball(int x, int y, int radius, int color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public int getColor() {
        return color;
    }
    
    //
    // Stage 3: Launch the ball
    //
    public int getVelocityX() {
        return velocityX;
    }
    
    //
    // Stage 3: Launch the ball
    //
    public int getVelocityY() {
        return velocityY;
    }
    
    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }
    
    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }
   
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
