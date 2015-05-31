package com.codebakery.Eduino.Application.GUI.Block;

import com.codebakery.Eduino.Application.GUI.Block.BlockList.BlockListItem;
import com.codebakery.Eduino.Application.Main.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/**
 * Created by codertimo on 15. 5. 23..
 */
public class Block extends VBox {
    public BlockListItem id;
    public Block()
    {
        this.getChildren().add(new ImageView(new Image("file:/Users/codertimo/Desktop/block1.png")));
        Main.controlCenter.newBlock(this);
    }
    public void setId(BlockListItem id)
    {
        this.id = id;
    }

}
