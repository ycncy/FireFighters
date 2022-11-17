import View.Grid;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class App extends Application {

    boolean isInPause = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        Group root = new Group();
        Button restart = new Button("Restart");
        VBox buttons = new VBox();
        HBox total = new HBox();
        Grid grid = new Grid(650,650,20,20);

        root.getChildren().add(total);
        total.getChildren().add(buttons);
        total.getChildren().add(grid);
        buttons.getChildren().add(restart);
        restart.setOnMouseClicked(grid::restart);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        grid.repaint();

        ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        threadPoolExecutor.scheduleAtFixedRate(() -> {
            if(!isInPause) {
                grid.getModel().activation();
                grid.repaint();
            }
        }, 0, 50 , TimeUnit.MILLISECONDS);


        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        sleep(50);
                        grid.getModel().activation();
                        grid.repaint();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();*/
    }
}

