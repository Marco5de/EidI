import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Turtle extends Application {

    double angle = 90;
    double oldX = 0;
    double oldY = 300;
    double x = 0;
    double y = 300;

    GraphicsContext gc;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Init UI
        primaryStage.setTitle("Schildkroeten und Fraktale <3");
        Group root = new Group();
        Canvas canvas = new Canvas(700, 600);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        // Koch-Kurven
        koch(300, 4);
        forward(100);
        kochSchneeflocke(300, 4);
    }

    public void kochSchneeflocke(double len, int deep) {
        koch(len, deep);
        turn(120);
        koch(len, deep);
        turn(120);
        koch(len, deep);
    }

    public void koch(double len, int deep) {
        if (deep > 0) {
            koch(len / 3, deep - 1);
            turn(-60);
            koch(len / 3, deep - 1);
            turn(120);
            koch(len / 3, deep - 1);
            turn(-60);
            koch(len / 3, deep - 1);
        } else {
            forward(len);
        }
    }

    public void turn(double degree) {
        if ((angle += degree) > 360)
            angle %= 360;
    }

    public void forward(double step) {
        oldX = x;
        oldY = y;

        x += step * Math.sin(Math.toRadians(angle));
        y -= step * Math.cos(Math.toRadians(angle));

        gc.strokeLine((int) x, (int) y, (int) oldX, (int) oldY);
    }

}