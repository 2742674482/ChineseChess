package com.TanHaorui.main;

import java.awt.*;

public class Cannons extends Chess{
    public Cannons(int player, Point p) {
        super("pao", player, p);
    }

    public Cannons(int player, int px) {
        this(player, new Point(px,3));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        Chess c = gamePanel.getChessByp(tp);
        if(c!=null){
            if(c.getPlayer() != this.player){
                //Capture
                return line(tp) > 1 && getCount(tp,gamePanel) == 1;
            }
        }else {
            //move
            return line(tp) > 1 && getCount(tp,gamePanel) == 0;
        }
        return false;
    }
}