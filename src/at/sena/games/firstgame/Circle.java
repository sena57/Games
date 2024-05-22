package at.sena.games.firstgame;

import org.newdawn.slick.Graphics;

public class Circle {
    private enum DIRECTION{RIGHT, DOWN, UP, LEFT};
    private int x;
    private int y;
    private float speed;

    public Circle(int x, int y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void render(Graphics graphics){
        graphics.drawOval(50,this.y,20,20);
    }

    public void update(int delta) {
        this.x += (float) delta / this.speed;
        if (this.x > 600) {
            this.x = 0;
        }
    }
}
