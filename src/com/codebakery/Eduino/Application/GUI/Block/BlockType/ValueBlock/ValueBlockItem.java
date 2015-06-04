package com.codebakery.Eduino.Application.GUI.Block.BlockType.ValueBlock;

import com.codebakery.Eduino.Application.GUI.Block.BlockThread.ValueRange;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by codertimo on 15. 6. 4..
 */
public class ValueBlockItem {
    public ValueBlock valueBlock;
    public ValueRange range;
    public VBox parentPane;

    public ValueBlockItem(VBox inputValue) {
        this.parentPane = inputValue;
    }

    public boolean isNull()
    {
        if(this.valueBlock == null)
            return true;
        else
            return false;
    }
}
