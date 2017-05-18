
/**
 * Write a description of class Brick here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//
// Stage 4: Create Brick and BrickStore
//
public class Brick
{
    private int x;
    private int y;
    private int width;
    private int height;
    private int color;
    
    public Brick(int x, int y, int width, int height, int color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getColor() {
        return color;
    }
}
