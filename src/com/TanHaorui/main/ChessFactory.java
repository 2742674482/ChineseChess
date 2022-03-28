package com.TanHaorui.main;

public class ChessFactory {
    private ChessFactory(){


    }

    public static Chess create(String name ,int player, int px){
        if("boss".equals(name)){
            return new King(player,px);
        }else if("shi".equals(name)){
            return new Guards(player,px);
        }
        else if("xiang".equals(name)){
            return new Ministers(player,px);
        }
        else if("ma".equals(name)){
            return new Horses(player,px);
        }
        else if("che".equals(name)){
            return new Rooks(player,px);
        }
        else if("pao".equals(name)){
            return new Cannons(player,px);
        }
        else if("bing".equals(name)){
            return new Pawns(player,px);
        }
        return null;
    }
}
