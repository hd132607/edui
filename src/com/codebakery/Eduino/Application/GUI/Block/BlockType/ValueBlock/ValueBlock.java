package com.codebakery.Eduino.Application.GUI.Block.BlockType.ValueBlock;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import jfxtras.labs.util.event.MouseControlUtil;

/**
 * Created by codertimo on 15. 6. 4..
 */
public class ValueBlock extends VBox{

    public ValueBlock()
    {
        //Make UI On Here//



        //---------------//

        MouseControlUtil.makeDraggable(this,null,ValueBlockEvent.clickEvent);
        this.setOnMouseReleased(ValueBlockEvent.releaseEvent);
    }

}
