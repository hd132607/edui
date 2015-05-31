package com.codebakery.Eduino.Application.GUI.Block.BlockThread;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockGroup.BlockGroup;
import com.codebakery.Eduino.Application.GUI.Block.BlockList.BlockListItem;
import com.codebakery.Eduino.Application.Main.Main;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * Created by codertimo on 15. 5. 25..
 */
public class BlockThread extends Thread {
    private Block movingObject;
    private ArrayList<Range> ranges = new ArrayList<>();
    private CollisionCheck collisionCheck;
    private Range result;

    boolean run_flag = true;
    public void run(){

        while(run_flag) {  //repeat until run_flag Stop

            result = checkCollision();
            if (result != null){
                //Make Highlight
            }
        }

    }
    public BlockThread(Block block)
    {
        this.movingObject = block;
        //set Root Block

        setUpRange();
        //setting up Range from controlCenter's Block Lists

        collisionCheck = new CollisionCheck(block,movingObject);
        //collision Check Object Create

        this.run();
    }


    private void setUpRange()
    {
        ArrayList<BlockListItem> tempBlockList = Main.controlCenter.getBlockList();
        for(BlockListItem blockListItem : tempBlockList) {
            Block block = blockListItem.block;
            if (blockListItem.blockGroup == null) {   //블럭 혼자일때
                ranges.add(new Range(block.getLayoutX(), block.getLayoutY(), block, true, true));
                ranges.add(new Range(block.getLayoutX(), block.getLayoutY(), block, false, true));
            } else if (blockListItem.blockGroup.get(0) == block) {  //첫번쨰 블럭
                ranges.add(new Range(block.getLayoutX(), block.getLayoutY(), block, true, true));
                ranges.add(new Range(block.getLayoutX(), block.getLayoutY(), block, false, false));
            } else if (blockListItem.blockGroup.get(blockListItem.blockGroup.size() - 1) == block) {  //마지막 블럭
                ranges.add(new Range(block.getLayoutX(), block.getLayoutY(), block, false, true));
            } else {  //어중간한 블럭
                ranges.add(new Range(block.getLayoutX(), block.getLayoutY(), block, false, false));
            }
        }
    }

    private Range checkCollision()
    {
        for(Range range : ranges) {
            Range result = collisionCheck.check(range);
            if(result!=null)
                return result;
        }
        return null;
    }
    public void threadStop()
    {
        this.run_flag = false;
    }
    public Range getResult(){ return this.result; }
}

