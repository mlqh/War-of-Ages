/**
 * Hitbox.java
 * Hitbox for entities
 * Matthew Hao
 * Jan 20, 2020
 */

import java.awt.Point;
import java.awt.Rectangle;

public class Hitbox {
    
    private Point position;
    private int height, width;
    private Rectangle boundingBox; // rectangle that is used for collision detection
    
    public Hitbox(Point position, int w, int h) {
        this.position = position;
        this.width = w;
        this.height = h;
        this.boundingBox = new Rectangle(position.x, position.y, width, height);
    }
    
    public boolean checkCollide(Hitbox other) {
        if(this.boundingBox.intersects(other.getBoundingBox())) {
            return true;
        } else {
            return false;
        }
    }
    
    public void update(Point point) {
        this.position = point;
        this.boundingBox.setLocation(position);
    }
    
    //-----------------------------------------
    public Point getPosition() {
        return position;
    }
    
    public void setPosition(Point position) {
        this.position = position;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public Rectangle getBoundingBox() {
        return boundingBox;
    }
    //-----------------------------------------
    
}
