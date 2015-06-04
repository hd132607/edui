package com.codebakery.Eduino.Application.GUI.Block.BlockThread;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockType.ValueBlock.ValueBlock;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by codertimo on 15. 5. 25..
 */
public class Range {
    public double x;
    public double y;
    public double width;
    public double height;
    public Block block;
    public boolean isUp;
    public boolean isBig;

    public Range(double x, double y, Block block, boolean isUp, boolean isBig)
    {
        this.x = x;
        this.y = y;
        this.block = block;
        this.isUp = isUp;
        this.isBig = isBig;
        if(isBig)
        {
            this.width = block.getWidth();
            this.height = 100;
            if(isUp)
                this.y = this.y - this.height;
            else
                this.y = this.y + block.getHeight();
        }
        else
        {
            this.width = block.getWidth();
            this.height = 50;

            if(isUp)
                this.y = this.y - this.height;
            else
                this.y = this.y + block.getHeight();
        }
    }

}
