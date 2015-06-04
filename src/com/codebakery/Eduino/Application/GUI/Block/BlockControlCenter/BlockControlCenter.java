package com.codebakery.Eduino.Application.GUI.Block.BlockControlCenter;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockGroup.BlockGroup;
import com.codebakery.Eduino.Application.GUI.Block.BlockList.BlockList;
import com.codebakery.Eduino.Application.GUI.Block.BlockList.BlockListItem;
import com.codebakery.Eduino.Application.GUI.Block.BlockThread.BlockThread;
import com.codebakery.Eduino.Application.GUI.Block.BlockThread.Range;
import com.codebakery.Eduino.Application.Main.Main;
import javafx.application.Platform;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import javax.naming.ldap.Control;
import java.util.ArrayList;

/**
 * Created by codertimo on 15. 5. 23..
 */
public class BlockControlCenter {
    private ArrayList<BlockListItem> blockList = new ArrayList<>();
    private Rectangle highlight = new Rectangle();
    private BlockThread blockThread;

    public BlockControlCenter(){}
    public void newBlock(Block block)
    {
        BlockListItem id = new BlockListItem(block);
        block.setId(id);
        this.blockList.add(id);

        Main.root.getChildren().add(block);
    }
    public void highLight(Range range)
    {
                Platform.runLater(()-> {
                    if(!Main.root.getChildren().contains(highlight))
                        Main.root.getChildren().add(highlight);
                    highlight.setLayoutX(range.x);
                    highlight.setLayoutY(range.y);
                    highlight.setHeight(range.height);
                    highlight.setWidth(range.width);
                });
    }
    public void highlight()
    {
        Platform.runLater(()-> {
            if(Main.root.getChildren().contains(highlight))
                Main.root.getChildren().remove(highlight);
        });
    }

    public void updateBlockList(BlockGroup blockGroup)
    {
       if(blockGroup!=null) {
           if (blockGroup.size() > 1)
           {
               for (Block block : blockGroup) {
                   block.id.blockGroup = blockGroup;
                   //block 객체의 blockGroup을 현재 blockGroup으로 설정
               }
           }
           else
           {
               for (Block block : blockGroup) {
                   block.id.blockGroup = null;
                   //Block의 Blockgroup을 null로 설정함.
               }
           }
       }
       else
       {
            System.out.print("[BlockControlCenter]BlockGroup is null");
            //Print ERROR
       }
    }

    public void setBlockThread(BlockThread blockThread) {
        this.blockThread = blockThread;
    }
    public ArrayList<BlockListItem> getBlockList()
    {
        return this.blockList;
    }
    public BlockThread getBlockThread() { return this.blockThread; }
}
