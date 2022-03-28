package com.TanHaorui.main;

import java.awt.*;

public class Rooks extends Chess{

    public Rooks(int player, Point p) {
        super("che", player, p);
    }

    public Rooks(int player, int px) {
        this(player, new Point(px,1));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        return line(tp) > 1 && getCount(tp,gamePanel) == 0;
    }
}
