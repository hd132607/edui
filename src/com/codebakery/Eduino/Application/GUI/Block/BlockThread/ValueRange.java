package com.codebakery.Eduino.Application.GUI.Block.BlockThread;

import javafx.scene.layout.Pane;

/**
 * Created by codertimo on 15. 6. 4..
 */
public class ValueRange {
    public double x;
    public double y;
    public double height;
    public double width;
    public Pane parent;

    public ValueRange(Pane pane)
    {
        this.parent = pane;
        this.x = pane.getLayoutX();
        this.y = pane.getLayoutY();
        this.height = pane.getHeight();
        this.width = pane.getWidth();
    }
}
