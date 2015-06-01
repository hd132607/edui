package com.codebakery.Eduino.Application.GUI.Block.BlockFunction;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockGroup.BlockGroup;
import com.codebakery.Eduino.Application.GUI.Block.BlockThread.Range;
import com.codebakery.Eduino.Application.Main.Main;

/**
 * Created by codertimo on 15. 5. 29..
 */
public class BlockBuilder {
    public BlockBuilder (Block block)
    {
        if(block.id.blockGroup!=null)
            updateUI(block);

        //else blockgroup is null
        //No Reason to Update UI
    }
    public BlockBuilder(Range result,Block block){

        BlockGroup dstBlockGroup = new BlockGroup();
        if(result.isUp)  //Result is UP
        {
            if(block.id.blockGroup!=null)
                dstBlockGroup.addAll(block.id.blockGroup);
            else
                dstBlockGroup.add(block);

            if(result.block.id.blockGroup!=null)
                dstBlockGroup.addAll(result.block.id.blockGroup);
            else
                dstBlockGroup.add(result.block);

        }
        else  //result is Down
        {
            if(result.block.id.blockGroup!=null)
                dstBlockGroup.addAll(result.block.id.blockGroup);
            else
                dstBlockGroup.add(result.block);

            if(block.id.blockGroup!=null)
                dstBlockGroup.addAll(block.id.blockGroup);
            else
                dstBlockGroup.add(block);
        }

        Main.controlCenter.updateBlockList(dstBlockGroup);
        //Updtae BlockList

        updateUI(result, block);
    }
    private void updateUI(Block block)  // No Result
    {
        double height_sum =0;
        for(int i=1;i<block.id.blockGroup.size();i++)
            height_sum+=block.id.blockGroup.get(i).getHeight();
        //Get total sum

        double block_height = block.getHeight();
        for(int i=1;i<block.id.blockGroup.size();i++)
        {
            Block thisblock = block.id.blockGroup.get(i);

            Main.root.getChildren().add(thisblock);  //1. Main root에 Node를 추가
            thisblock.setLayoutX(block.getLayoutX());
            thisblock.setLayoutY(block.getLayoutY()+(block_height-height_sum));  //2. X,Y좌표값을 설정

            height_sum -= thisblock.getHeight();
        }
        //setPosition of Block
    }

    private void updateUI(Range result,Block block)  //Exist Result
    {
        Block standard  = result.block;
        //Result 내의 Block 가져옴 <- 클릭한 블럭 위 또는 아래 블럭

        double height_sum = 0;
        for(int i=block.id.blockGroup.indexOf(block)+1;i<block.id.blockGroup.size();i++)
        {
            Block temp = block.id.blockGroup.get(i);
            height_sum+=temp.getHeight();
        }
        //Click 한 블럭의 VBox Height를 가져옴

        block.setLayoutX(standard.getLayoutX());
        block.setLayoutY(standard.getLayoutY()+standard.getHeight());
        //Vbox 전체를 result로 이동시킴

        double block_height = block.getHeight();
        for(int i=standard.id.blockGroup.indexOf(standard)+1;i<standard.id.blockGroup.size();i++)  //
        {
            Block thisBlock = standard.id.blockGroup.get(i);

            Main.root.getChildren().add(thisBlock);

            thisBlock.setLayoutX(block.getLayoutX());
            thisBlock.setLayoutY(block.getLayoutY()+(block_height-height_sum));

            height_sum-=thisBlock.getHeight();
        }
        ///Start From Here about UI

    }
}
