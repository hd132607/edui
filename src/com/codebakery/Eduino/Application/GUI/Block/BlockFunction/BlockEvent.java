package com.codebakery.Eduino.Application.GUI.Block.BlockFunction;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockGroup.BlockGroup;
import com.codebakery.Eduino.Application.GUI.Block.BlockList.BlockListItem;
import com.codebakery.Eduino.Application.GUI.Block.BlockThread.BlockThread;
import com.codebakery.Eduino.Application.GUI.Block.BlockThread.Range;
import com.codebakery.Eduino.Application.Main.Main;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by codertimo on 15. 5. 23..
 */
public class BlockEvent {
    public static EventHandler<MouseEvent> clickedEvent =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Block block = (Block)event.getSource();
                    //0. get Event Block

                    SplitBlock splitBlock =null;
                    if(block.id.blockGroup!=null) {
                        splitBlock = new SplitBlock(block);
                    }
                    //1. Split Clicked Block group


                    if(splitBlock!=null) {
                        for (Block b : splitBlock.getNextBlockGroup()) {
                            if (b != block)
                                block.getChildren().add(b);
                        }
                    }
                    //2. Add blocks to Clicked block

                    for(BlockListItem item :Main.controlCenter.getBlockList())
                    {
                        System.out.println("["+item.block+"]: "+item.blockGroup);
                    }

                    Main.controlCenter.setBlockThread(new BlockThread(block));
                    //3. Start Thread
                }
            };

    public static EventHandler<MouseEvent> releaseEvent =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Block block = (Block)event.getSource();
                    //0. get Event Block

                    Main.controlCenter.getBlockThread().threadStop();
                    //1. Stop Thread

                    Range result = Main.controlCenter.getBlockThread().getResult();
                    //2. get Result block

                    if(result != null)
                    {
                        BlockBuilder blockBuilder = new BlockBuilder(result,block);
                        System.out.println("[Result] isBig:"+result.isBig+" isUp:"+result.isUp);
                        //3-0. AddBlock and Replace UI <- Result Ex
                    }
                    else {
                        BlockBuilder blockBuilder = new BlockBuilder(block);
                        //3-1. Replace UI <- No Result
                    }
                    for(BlockListItem item :Main.controlCenter.getBlockList())
                    {
                        System.out.println("["+item.block+"]: "+item.blockGroup);
                    }
                    // UI Update
                    Main.controlCenter.highlight();
                }
            };
}
