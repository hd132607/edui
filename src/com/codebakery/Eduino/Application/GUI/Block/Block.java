package com.codebakery.Eduino.Application.GUI.Block;

import com.codebakery.Eduino.Application.GUI.Block.BlockFunction.BlockEvent;
import com.codebakery.Eduino.Application.GUI.Block.BlockList.BlockListItem;
import com.codebakery.Eduino.Application.GUI.Block.BlockType.ValueBlock.ValueBlock;
import com.codebakery.Eduino.Application.GUI.Block.BlockType.ValueBlock.ValueBlockItem;
import com.codebakery.Eduino.Application.Main.Main;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import jfxtras.labs.util.event.MouseControlUtil;

import java.util.ArrayList;


/**
 * Created by codertimo on 15. 5. 23..
 */
public class Block extends VBox {
    public BlockListItem id;
    public ArrayList<ValueBlockItem> valueBlockItems = new ArrayList<>();

    public Block()
    {
        Main.controlCenter.newBlock(this);
        MouseControlUtil.makeDraggable(this, null, BlockEvent.clickedEvent);
        this.setOnMouseReleased(BlockEvent.releaseEvent);
    }
    public Block(int id)
    {
        switch (id)
        {
            case 0:
                this.getChildren().add(new ImageView(new Image("file:/Users/codertimo/Desktop/block/b4.png")));
                break;
            case 1:
                this.getChildren().add(new ImageView(new Image("file:/Users/codertimo/Desktop/block/b3.png")));
                break;
            case 2:
                this.getChildren().add(new ImageView(new Image("file:/Users/codertimo/Desktop/block/b2.png")));
                break;
            case 3:
                this.getChildren().add(new ImageView(new Image("file:/Users/codertimo/Desktop/block/b1.png")));
                break;
            case 4:
                this.getChildren().add(new ImageView(new Image("file:/Users/codertimo/Desktop/block/b0.png")));
                break;
        }

        Main.controlCenter.newBlock(this);
        MouseControlUtil.makeDraggable(this, null, BlockEvent.clickedEvent);
        this.setOnMouseReleased(BlockEvent.releaseEvent);

    }

    public void makeUI()
    {
        //1. StackPane
        StackPane stackPane = new StackPane();

        //2. Backgroud
        HBox background = new HBox();
        background.getChildren().add(new ImageView(new Image("file:")));  //Image Connect
        background.getChildren().add(new ImageView(new Image("file:")));  //Image Context
        stackPane.getChildren().add(background);

        //3. Context
        HBox context = new HBox();
        context.setPadding(new Insets(30, 30, 30, 30));  //top right buttom left
        context.setSpacing(30);

        //4. Add Image And Node
        VBox valueInput = new VBox();
        ImageView icon = new ImageView(new Image("file://Icon"));
        Text text = new Text("아날로그 입력");
        context.getChildren().addAll(icon, valueInput, text);

        //5. Add All
        stackPane.getChildren().add(context);

        //6. Setting the ValueInput VBox
        valueBlockItems.add(new ValueBlockItem(valueInput));

        //7. Finally Add StackPane
        this.getChildren().add(stackPane);
    }

    public void setId(BlockListItem id)
    {
        this.id = id;
    }

}
