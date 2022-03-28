package com.TanHaorui.main;

import java.awt.*;

public class Guards extends Chess{
    public Guards(int player, Point p) {
        super("shi", player, p);
    }

    public Guards(int player, int px) {
        this(player, new Point(px,1));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        return line(tp)==1 && isHome(tp) && getStep(tp) ==1;
    }
}