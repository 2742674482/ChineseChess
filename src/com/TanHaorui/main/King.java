package com.TanHaorui.main;

import java.awt.*;

public class King extends Chess{
    public King(int player, Point p) {
        super("boss", player, p);
    }

    public King(int player, int px) {
        this(player, new Point(px,1));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        return line(tp)>1 && isHome(tp) && getStep(tp) ==1;
    }
}