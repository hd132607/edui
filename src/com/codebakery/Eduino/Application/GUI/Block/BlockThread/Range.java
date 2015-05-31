package com.codebakery.Eduino.Application.GUI.Block.BlockThread;

import com.codebakery.Eduino.Application.GUI.Block.Block;

/**
 * Created by codertimo on 15. 5. 25..
 */
public class Range {
    public double x;
    public double y;
    public double width;
    public double height;
    public Block block;
    public boolean isUp;
    public boolean isBig;

    public Range(double x, double y, Block block, boolean isUp, boolean isBig)
    {
        this.x = x;
        this.y = y;
        this.block = block;
        this.isUp = isUp;
        this.isBig = isBig;
        if(isBig)
        {
            this.width = block.getWidth();
            this.height = 100;
        }
        else
        {
            this.width = block.getWidth();
            this.height = 10;
        }
    }




}
