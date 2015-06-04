package com.codebakery.Eduino.Application.Main;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockControlCenter.BlockControlCenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by codertimo on 15. 5. 23..
 */
public class Main extends Application {
    public static BlockControlCenter controlCenter = new BlockControlCenter();
    public static Pane root = new Pane();
    @Override
    public void start(Stage primaryStage) throws Exception{

        Block block1 = new Block(0);
        Block block2 = new Block(1);
        Block block3 = new Block(2);
        Block block4 = new Block(3);
        Block block5 = new Block(4);

        block1.setLayoutY(300);
        block2.setLayoutY(600);
        block4.setLayoutX(600);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
