package rect;

import sourceAnnotations.ToString;

@ToString
public class Rectangle {
    private final Point topLeft;
    private final int width;
    private final int height;
    
    public Rectangle(Point topLeft, int width, int height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }
    
    @ToString(includeName = false)
    public Point getTopLeft() {
        return topLeft;
    }
    
    @ToString
    public int getWidth() {
        return width;
    }
    
    @ToString
    public int getHeight() {
        return height;
    }
}
