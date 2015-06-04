package com.codebakery.Eduino.Application.GUI.Block.BlockThread;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockGroup.BlockGroup;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codertimo on 15. 5. 25..
 */
public class CollisionCheck {
    public double x;
    public double y;
    public double width;
    public double height;
    public Block movingObject;

    public CollisionCheck(Block movingObject)
    {
        this.movingObject = movingObject;
        for(int i=1;i<movingObject.getChildren().size();i++)
            height+=((Block)movingObject.getChildren().get(i)).getHeight();
        height+=movingObject.getHeight();
        System.out.println("[Height]:" + height);
        width = movingObject.getWidth();
    }

    public Range check(Range range)
    {

        this.x = movingObject.getLayoutX();
        this.y = movingObject.getLayoutY();

        if(this.x < range.x+range.width &&
                this.x + this.width>range.x &&
                this.y < range.y + range.height &&
                this.y + this.height > range.y)
        {
            return range;
        }
        else
            return null;
    }
}

//if (rect1.x < rect2.x + rect2.width &&
//        rect1.x + rect1.width > rect2.x &&
//        rect1.y < rect2.y + rect2.height &&
//        rect1.height + rect1.y > rect2.y) {
//        // collision detected!
//        }
