package com.codebakery.Eduino.Application.GUI.Block.BlockThread;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockGroup.BlockGroup;
import javafx.scene.layout.VBox;

/**
 * Created by codertimo on 15. 5. 25..
 */
public class CollisionCheck {
    public double x;
    public double y;
    public double width;
    public double height;

    public CollisionCheck(Block rootBlock, VBox movingObject)
    {
        x = rootBlock.getLayoutX();
        height = rootBlock.getHeight() + movingObject.getHeight();
        if(rootBlock.getWidth() > movingObject.getWidth())
            width = rootBlock.getWidth();
        else
            width = movingObject.getWidth();
    }

    public Range check(Range range)
    {
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
