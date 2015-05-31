package com.codebakery.Eduino.Application.GUI.Block.BlockList;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockGroup.BlockGroup;

/**
 * Created by codertimo on 15. 5. 23..
 */
public class BlockListItem {
    public Block block;
    public BlockGroup blockGroup;

    public BlockListItem(Block block)
    {
        this.block = block;
        this.blockGroup = null;
    }
    public void setBlockGroup(BlockGroup blockGroup)
    {
        this.blockGroup = blockGroup;
    }
}
