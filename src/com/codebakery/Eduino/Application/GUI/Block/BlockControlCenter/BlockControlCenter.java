package com.codebakery.Eduino.Application.GUI.Block.BlockControlCenter;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockGroup.BlockGroup;
import com.codebakery.Eduino.Application.GUI.Block.BlockList.BlockList;
import com.codebakery.Eduino.Application.GUI.Block.BlockList.BlockListItem;
import com.codebakery.Eduino.Application.GUI.Block.BlockThread.BlockThread;

import javax.naming.ldap.Control;
import java.util.ArrayList;

/**
 * Created by codertimo on 15. 5. 23..
 */
public class BlockControlCenter {
    private ArrayList<BlockListItem> blockList;
    private BlockListItem pointerBlock;
    private BlockThread blockThread;

    public BlockControlCenter(){}
    public void newBlock(Block block)
    {
        BlockListItem id = new BlockListItem(block);
        block.setId(id);
        this.blockList.add(id);
    }
    public void newBlockGroup()
    {

    }

    public BlockListItem getPointerBlock() {
        return pointerBlock;
    }

    public void setPointerBlock(BlockListItem pointerBlock) {
        this.pointerBlock = pointerBlock;
    }
    public void updateBlockList(BlockGroup blockGroup)
    {
        if(blockGroup.size() !=1) {
            for (Block block : blockGroup) {
                block.id.blockGroup = blockGroup;
                //block 객체의 blockGroup을 현재 blockGroup으로 설정

                blockList.get(blockList.indexOf(block.id)).blockGroup = blockGroup;
                ///BlockList.indexof(block.id) -> 현재 가리키고 있는 블럭의 id값에 대한 index를 얻어옴
                ///blockList.get(index).blockGroup -> 인덱스 값의 blockGroup을 선택함
            }
        }
        else
            for (Block block : blockGroup) {
                block.id.blockGroup = null;
                //Block의 Blockgroup을 null로 설정함.

                blockList.get(blockList.indexOf(block.id)).blockGroup = null;
                //BlockList 의 Block객체들의 blockgroup 을 null로 설정함

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
