package at.sena.games.firstgame;


import org.newdawn.slick.Graphics;

public class Rectangle {
    private enum DIRECTION{RIGHT, DOWN, UP, LEFT};
    private int x;
    private int y;
    private float speed;

    public Rectangle(int x, int y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void render(Graphics graphics){
        graphics.drawRect(this.x,this.y,10,10);
    }

    public void update(int delta){
        this.x += (float)delta/this.speed;
        if (this.x>800){
            this.x = 0;
        }
    }
}