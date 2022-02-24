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

    private int index; // 保存每个棋子的索引位置

    public void setIndex(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

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

    /*
    判断棋子初始上/下，1上2下
     */
    public int isUpOrDown(){

        if (initP.y<6){
            //up

         return 1;
        }else if(initP.y>5){
            //down

         return 2;
        }
        return 0;
    }

    /*
    判断是否在王宫
     */
    public boolean isHome(Point tp){
        if(tp.x <4 || tp.x >6){
            return false;
        }
        int upOrDown = isUpOrDown();
        if(upOrDown == 1){
            //up
            if(tp.y>3 || tp.y <1){
                return false;
            }
        }else if(upOrDown == 2){
            //down
            if(tp.y>10 || tp.y <8){
                return false;
            }
        }
        return true;
    }
    /*
    判断直线/斜线
    3：x轴直线 2：y轴直线 1：正斜线  -2：都不是 0 x轴日子 -1：y轴日子
     */
    public int line(Point tp){
        if(p.y==tp.y){
            //x
            return 3;
        }else if(p.x == tp.x){
            //y
            return 2;
            }else if(Math.abs(p.x-tp.x) == Math.abs(p.y-tp.y)){
           //正斜线
            return 1;
        }else{
            //日子
            if(Math.abs(p.x-tp.x) ==2 && Math.abs(p.y-tp.y) == 1){
                //x
                return 0;
            }else if(Math.abs(p.x-tp.x) ==1 && Math.abs(p.y-tp.y) == 2){
                //y
                return -1;
            }
        }
        return -2;
        }

    /*
    计算起点到目标点的步数
     */
    public int getStep(Point tp){
        int line = line(tp);
        if(line==3){
            //x
            return Math.abs(p.x-tp.x);
        }else if(line==2){
            //y
            return Math.abs(p.y-tp.y);
        }else if(line==1){
            //正斜线（随意，都相等）
            return Math.abs(p.y-tp.y);
        }
        return 0;
    }

    /*
    判断目标点是否过河
     */
    public boolean isOverRiver(Point tp){
        int upOrDown = isUpOrDown();
        if(upOrDown == 1){
            //up
           if(tp.y>5){
               return false;
           }
        }else if (upOrDown == 2){
            //down
            if(tp.y<6){
                return false;
            }
        }
        return true;
    }

    /*
    判断象 马 是否蹩脚
     */
    public boolean isLame(Point tp,GamePanel gamePanel){
        Point center = new Point();//center point
        if("xiang".equals(name)){
            center.x = (p.x + tp.x)/2;
            center.y = (p.y + tp.y)/2;
            return gamePanel.getChessByp(center) != null;
        }else if("ma".equals(name)){
            int line = line(tp);
            if(line==0){
                //x
                center.x = (p.x + tp.x)/2;
                center.y = p.y;
            }else if(line==-1){
                center.x = p.x;
                center.y = (p.y + tp.y)/2;
            }
            return gamePanel.getChessByp(center) != null;
        }
        return true;
    }

    //计算起点到目标点之间的棋子数量，不计算起点和目标的上的位置
    public int getCount(Point tp,GamePanel gamePanel){
        int start = 0;
        int end = 0;
        int count = 0;//count the num of chesses
        int line = line (tp);
        Point np = new Point();
        if(line == 2){
            //y
            np.x = tp.x;
            if(tp.y > p.y){
                //up to down
                start = p.y + 1;
                end = tp.y;
            }else {
                //down to up
                start = tp.y + 1;
                end = p.y;
            }
            System.out.println("start" + start);
            System.out.println("end" + end);
            for(int i = start;i < end;i++){
                np.y = i;
                if(gamePanel.getChessByp(np) != null){
                    count++;
                }
            }
        }else if(line == 3){
            //x
            np.y = tp.y;
            if(tp.x > p.x){
                //left to right
                start = p.x + 1;
                end = tp.x;
            }else {
                //right to left
                start = tp.x + 1;
                end = p.x;
            }
            System.out.println("start" + start);
            System.out.println("end" + end);
            for(int i = start;i < end;i++){
                np.x = i;
                if(gamePanel.getChessByp(np) != null){
                    count++;
                }
            }
        }
        System.out.println("The num of the chess is " + count);
        return count;
    }


    //判断棋子是否可以被移动到指定位置
    public boolean isAbleMove(Point tp,GamePanel gamePanel){
        if("boss".equals(name)){
           return line(tp)>1 && isHome(tp) && getStep(tp) ==1;
        }else if("shi".equals(name)){
            return line(tp)==1 && isHome(tp) && getStep(tp) ==1;
        }
        else if("xiang".equals(name)){
            return line(tp)==1 && getStep(tp)==2 && !isLame(tp,gamePanel) && isOverRiver(tp);
        }
        else if("ma".equals(name)){
            return (line(tp) == 0 || line(tp) == -1) && !isLame(tp,gamePanel);
        }
        else if("che".equals(name)){
            return line(tp) > 1 && getCount(tp,gamePanel) == 0;
        }
        else if("pao".equals(name)){
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
        }
        else if("bing".equals(name)){
            return true;
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
