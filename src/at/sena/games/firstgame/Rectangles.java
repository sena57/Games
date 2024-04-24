package at.sena.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;

public class Rectangles extends BasicGame {
    private float x;
    private float y;
    private int directionX;
    private int directionY;
    private float speed;
    private float circleY;
    // Richtung, in die sich der Kreis bewegt (-1 für nach oben, 1 für nach unten)
    private int circleDirection;

    private float ovalX;
    // Richtung, in die sich das Oval bewegt (-1 für nach links, 1 für nach rechts)
    private int ovalDirection;

    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.x = 200;
        this.y = 200;
        this.directionX = 1;
        this.directionY = 0;
        this.speed = 5.0f;
        this.circleY = 100;
        this.circleDirection = 1;
        this.ovalX = 0;
        this.ovalDirection = 1;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        // Bewegung von links nach rechts
        if (this.directionX == 1) {
            this.x += delta / this.speed;
            if (this.x >= 500) {
                this.directionX = 0;
                this.directionY = 1; // Ändern der Richtung zu unten
            }
        }
        // Bewegung von oben nach unten
        else if (this.directionY == 1) {
            this.y -= delta / this.speed;
            if (this.y <= 200) {
                this.directionX = -1; // Ändern der Richtung zu links
                this.directionY = 0;
            }
        }
        // Bewegung von rechts nach links
        else if (this.directionX == -1) {
            this.x -= delta / this.speed;
            if (this.x <= 200) {
                this.directionX = 0;
                this.directionY = -1; // Ändern der Richtung nach oben
            }
        }
        // Bewegung von unten nach oben
        else if (this.directionY == -1) {
            this.y += delta / this.speed;
            if (this.y >= 400) {
                this.directionX = 1; // Ändern der Richtung zu rechts
                this.directionY = 0;
            }
        }


        // Update für den Kreis (vertikal)
        this.circleY += this.circleDirection * (delta / this.speed);

        // Ändern der Richtung, wenn der Kreis den oberen oder unteren Rand erreicht
        if (this.circleY <= 0 || this.circleY >= gameContainer.getHeight() - 100) {
            this.circleDirection *= -1;
        }

        // Update für das Oval (horizontal)
        this.ovalX += this.ovalDirection * (delta / this.speed);

        // Ändern der Richtung, wenn das Oval den linken oder rechten Rand erreicht
        if (this.ovalX <= 0 || this.ovalX >= gameContainer.getWidth() - 100) {
            this.ovalDirection *= -1; }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.x,this.y,100,100);
        graphics.drawOval(50, this.circleY, 50, 50);
        graphics.drawOval(this.ovalX, 50, 50, 25);
        graphics.drawString("Hellooo",50,50);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
