package com.codebakery.Eduino.Application.GUI.Block.BlockFunction;

import com.codebakery.Eduino.Application.GUI.Block.Block;
import com.codebakery.Eduino.Application.GUI.Block.BlockGroup.BlockGroup;
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
                    //get Event Block

                    Main.controlCenter.setPointerBlock(block.id);
                    // set Pointer about block

                    BlockGroup moveBlockGroup  = new BlockGroup();
                    BlockGroup splitedBlock = new BlockGroup();
                    if(block.id.blockGroup != null) // Making Moving Block
                    {
                        boolean isMoveSect = false;
                        for(Block forblock :block.id.blockGroup)
                        {
                            if(forblock == block)
                                isMoveSect = true;
                            if(isMoveSect)
                                moveBlockGroup.add(forblock);
                            else
                                splitedBlock.add(forblock);
                        }
                    }

                    // Update BlockList
                    Main.controlCenter.updateBlockList(moveBlockGroup);
                    Main.controlCenter.updateBlockList(splitedBlock);

                    //Update UI
                    for(Block b:moveBlockGroup)
                    {
                        if(b!=block)
                            block.getChildren().add(b);
                    }

                    //Starting BlockThread
                    Main.controlCenter.setBlockThread(new BlockThread(block));
                }
            };

    public static EventHandler<MouseEvent> releaseEvent =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Block block = (Block)event.getSource();
                    //get Event Block

                    Main.controlCenter.getBlockThread().threadStop();
                    //Stop Thread

                    Range result = Main.controlCenter.getBlockThread().getResult();
                    //get Event Block

                    if(result != null)
                    {
                        BlockBuilder blockBuilder = new BlockBuilder(result,block);
                    }
                    else
                    {
                        if(block.id.blockGroup == null)
                        {
                            //Nothing do
                        }
                        else
                        {
                            for(int i=0;i<block.id.blockGroup.size();i++)
                            {
                                Block this_block = block.id.blockGroup.get(i);

                                this_block.setLayoutX(block.id.blockGroup.get(i-1).getLayoutX());
                                this_block.setLayoutY(block.id.blockGroup.get(i-1).getLayoutY()+
                                                        this_block.id.blockGroup.get(i-1).getHeight());

                            }
                        }
                    }

                }
            };
}
