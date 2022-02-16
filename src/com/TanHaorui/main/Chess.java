package com.TanHaorui.main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Chess {

    //定义一个常量，只能卓定义时或代码块中修改值，其他不允许修改
    private static final int SIZE=30; //棋子大小

    private static final int MARGIN=20; //棋子中心与界面

    private static final int SPACE=40; //棋子与棋子之间的间距

    private String name;//棋子名称

    //set方法
    public void setName(String name){
        this.name=name;
    }

    private String suffix =".png";//棋子图片后缀

    private int player;//0 红 1 黑

    public void setPlayer(int player){
        this.player=player;
    }

    public int getPlayer(){
        return player;
    }

    //棋子绘制时的坐标位置
    private int x,y;

    //棋子的网格坐标 官方提供
    private Point p;

    //棋子的网格坐标，初始位置，不可改变
    private Point initP;

    //保存每个棋子的索引位置
    private int index;
    public void setP(Point p) {
        this.p = (Point) p.clone();
        if (initP == null){
            initP = this.p;
        }
        calXY();
    }

    public Point getP(){
        return p;
    }

    //判断棋子是否可以被移动到指定位置
    public boolean isAbleMove(Point tp){
        if("boss".equals(name)){
            //判断是否出格
            if(tp.x <4 || tp.x >6){
                return false;
            }
            //红黑方y轴
            if (initP.y<6){
                //红
                if(tp.y>3 || tp.y <1){
                    return false;
                }
            }else if(initP.y>5){
                //黑
                if(tp.y>10 || tp.y <8){
                    return false;
                }
            }

            //判断是否走直线且只能走一步
            //x轴直线还是y轴直线
            if(p.y==tp.y){
                //x
                if(Math.abs(p.x - tp.x)==1){
                    //走一步
                    return true;
                }
            }else if(p.x == tp.x){
                //y
                if(Math.abs(p.y - tp.y)==1){
                    //走一步
                    return true;
                }
            }

            return false;


        }else if("shi".equals(name)){

        }
        else if("xiang".equals(name)){

        }
        else if("ma".equals(name)){

        }
        else if("che".equals(name)){

        }
        else if("pao".equals(name)){

        }
        else if("bing".equals(name)){

        }
        return false;
    }


    //棋子的绘制方法
    public void draw(Graphics g, JPanel panel){
        String path = "pic" + File.separator + name + player + suffix;
        Image img = Toolkit.getDefaultToolkit().getImage(path);
        g.drawImage(img,x,y,SIZE,SIZE, panel);
    }

    //绘制棋子边框
    public void drawRect(Graphics g){
        g.drawRect(x,y,SIZE,SIZE);
    }


    //计算xy的绘制坐标
    public void calXY(){
        x=MARGIN - SIZE / 2 + SPACE * (p.x-1);
        y=MARGIN - SIZE / 2 + SPACE * (p.y-1);
    }

    //通过xy坐标计算网格坐标对象
    public static Point getPointFromXY(int x,int y) {
        Point p = new Point();
        p.x = (x - MARGIN + SIZE / 2) / SPACE + 1;
        p.y = (y - MARGIN + SIZE / 2) / SPACE + 1;
        if(p.x < 1 || p.x > 9 || p.y < 1 || p.y > 10){
            return null;
        }
        return  p;
    }

    //反转网格坐标
    public void reserve(){
        p.x = 10 -p.x;
        p.y = 11 -p.y;
        initP =p;//不需要加条件，因为只运行一次
        calXY();
    }



}
