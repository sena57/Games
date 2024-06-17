package at.sena.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectGames extends BasicGame {
    private List<Rectangle> rectangles;
    private List<Oval> ovals;
    private List<Circle> circles;

    public ObjectGames(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.rectangles = new ArrayList<>();
        this.ovals = new ArrayList<>();
        this.circles = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(600), 50);
            rectangles.add(rectangle);
        }

        for (int i = 0; i < 10; i++) {
            Oval oval = new Oval(random.nextInt(600), random.nextInt(600), random.nextInt(50));
            ovals.add(oval);
        }

        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle(random.nextInt(600), random.nextInt(600), random.nextInt(50));
            circles.add(circle);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Rectangle rectangle:this.rectangles) {
            rectangle.update(delta);
        }

        for (Oval oval:this.ovals) {
            oval.update((delta));
        }

        for (Circle circle :this.circles) {
            circle.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Rectangle rectangle:this.rectangles) {
            rectangle.render(graphics);
        }

        for (Oval oval:this.ovals) {
            oval.render(graphics);
        }

        for (Circle circle:this.circles) {
            circle.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectGames("ObjectGames"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
