package com.codebakery.Eduino.Application.GUI.Block.BlockFunction;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockControlCenter.BlockControlCenter;
import com.codebakery.Eduino.Application.GUI.Block.BlockGroup.BlockGroup;
import com.codebakery.Eduino.Application.Main.Main;

/**
 * Created by codertimo on 15. 5. 23..
 */
public class SplitBlock {
    private BlockGroup orizinal;
    private BlockGroup previous;
    private BlockGroup next;

    public SplitBlock(){}
    public SplitBlock(Block block)
    {
        orizinal = block.id.blockGroup;
        previous = new BlockGroup();
        next = new BlockGroup();

        boolean before = true;
        for(Block blocks : orizinal)
        {
            if(blocks == block)
            {
                before = false;
            }
            if(before)
                previous.add(blocks);

            else
                next.add(blocks);
        }
        updateBlockList();

    }
    private void updateBlockList()
    {
        Main.controlCenter.updateBlockList(previous);
        Main.controlCenter.updateBlockList(next);
    }
    public BlockGroup getNextBlockGroup()
    {
        return this.next;
    }
}
