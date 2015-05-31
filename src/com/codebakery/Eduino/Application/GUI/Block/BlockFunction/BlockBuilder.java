package com.codebakery.Eduino.Application.GUI.Block.BlockFunction;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockGroup.BlockGroup;
import com.codebakery.Eduino.Application.GUI.Block.BlockThread.Range;
import com.codebakery.Eduino.Application.Main.Main;

/**
 * Created by codertimo on 15. 5. 29..
 */
public class BlockBuilder {
    public BlockBuilder(Range result,Block block){
        BlockGroup dstBlockGroup = new BlockGroup();
        if(result.isUp)
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

        updateUI(result,block);
    }
    private void updateUI(Range result,Block block)
    {
        Block standard  = result.block;

        for(int i=standard.id.blockGroup.indexOf(standard)+1;i<standard.id.blockGroup.size();i++)
        {
            Block temp = standard.id.blockGroup.get(i);

            temp.setLayoutX(standard.getLayoutX());
            temp.setLayoutY(standard.id.blockGroup.get(i-1).getLayoutY()+  //이전 블럭의 Y값을 가져옴
                            standard.id.blockGroup.get(i-1).getHeight());  //이전 블럭의 Height값을 더함
        }

            ///Start From Here about UI

    }
}
