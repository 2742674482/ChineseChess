package com.TanHaorui.main;

import java.awt.*;

public class Ministers extends Chess{
    public Ministers(int player, Point p) {
        super("xiang", player, p);
    }

    public Ministers(int player, int px) {
        this(player, new Point(px,1));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        return line(tp)==1 && getStep(tp)==2 && !isLame(tp,gamePanel) && !isOverRiver(tp);
    }
}