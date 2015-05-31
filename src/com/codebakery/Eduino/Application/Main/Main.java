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

        Block block = new Block();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
