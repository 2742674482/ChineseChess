package com.TanHaorui.main;

import java.awt.*;

public class Horses extends Chess{

    public Horses(int player, Point p) {
        super("ma", player, p);
    }

    public Horses(int player, int px) {
        this(player, new Point(px,1));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        return (line(tp) == 0 || line(tp) == -1) && !isLame(tp,gamePanel);
    }
}
