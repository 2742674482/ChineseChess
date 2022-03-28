package com.TanHaorui.main;

import java.awt.*;

public class Record {
    //操作的棋子类
    private Chess chess;
    //起始坐标
    private Point start;
    //结束坐标
    private Point end;
    //被吃掉的棋子
    private Chess eatedChess;

    public  Record(){

    }

    public Record(Chess chess,Point start,Point end,Chess eatedChess){
        this.chess=chess;
        this.start=start;
        this.end=end;
        this.eatedChess=eatedChess;
    }

    public Chess getChess() {
        return chess;
    }

    public void setChess(Chess chess) {
        this.chess = chess;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Chess getEatedChess() {
        return eatedChess;
    }

    public void setEatedChess(Chess eatedChess) {
        this.eatedChess = eatedChess;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Record{");
        sb.append("chess=").append(chess);
        sb.append(", start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", eatedChess=").append(eatedChess);
        sb.append('}');
        return sb.toString();
    }
}
