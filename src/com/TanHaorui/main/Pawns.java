package com.TanHaorui.main;

import java.awt.*;

public class Pawns extends Chess{
    public Pawns(int player, Point p) {
        super("bing", player, p);
    }

    public Pawns(int player, int px) {
        this(player, new Point(px,4));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        if(line(tp) < 2 || getStep(tp) > 1){
            return false;
        }
        if(isOverRiver(p)){
            return !isBack(tp);
        }else {
            return isForward(tp);
        }

    }
}