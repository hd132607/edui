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
                Main.controlCenter.highLight(result);
            }
            else
            {
                Main.controlCenter.highlight();
            }
            try {
                Thread.sleep(100);
            }
            catch (Exception e) {
                System.out.print(e);
            }

        }

    }

    public BlockThread(Block block)
    {
        this.movingObject = block;
        //set Root Block

        setUpRange();
        //setting up Range from controlCenter's Block Lists

        collisionCheck = new CollisionCheck(movingObject);
        //collision Check Object Create

        this.start();
    }


    private void setUpRange()
    {
        for(BlockListItem blockListItem : Main.controlCenter.getBlockList()) {
            Block block = blockListItem.block;

            if((movingObject.id.blockGroup!=null && !movingObject.id.blockGroup.contains(block))||(movingObject!=block)) {
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
    }

    private Range checkCollision()
    {
        ArrayList<Block> notMoving = new ArrayList<>();
        notMoving.add(movingObject);
        for(int i=1;i<movingObject.getChildren().size();i++)
        {
            notMoving.add((Block)movingObject.getChildren().get(i));
        }

        for(Range range : ranges) {
            ArrayList<Range> results = new ArrayList<>();
            if(!notMoving.contains(range.block)){
                Range result = collisionCheck.check(range);
                if(result!=null) {
                    results.add(result);
                }
            }
            //System.out.println("[Results] "+results);
            if(results.size() != 0)
            {
                if(results.size()>1)
                {
                    Range result = null;
                    double value =1000;
                    for(Range r :results)
                    {
                        double temp = Math.abs(movingObject.getLayoutX() - r.x)+Math.abs(movingObject.getLayoutY()-r.y);
                        if(value>temp)
                        {
                            result = r;
                            value = temp;
                        }
                    }
                    return result;
                }
                else
                {
                    return results.get(0);
                }
            }
        }
        return null;
    }
    public void threadStop()
    {
        this.run_flag = false;
    }
    public Range getResult(){ return this.result; }
}

