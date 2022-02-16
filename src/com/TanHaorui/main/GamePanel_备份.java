package com.TanHaorui.main;

/*
swing编程中面板值jpanel这类，在jframe中自带一个面板，但其又bug
 */

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;

public class GamePanel_备份 extends JPanel {
    //定义一个保存所有棋子的成员变量，类型是数组
    private Chess[] chesses = new Chess[32];//保存所有的棋子

    //创建所有棋子
    private void createChesses(){

    }

    //绘制所有棋子
    private void drawChesses(Graphics g){

    }

    @Override
    //有一个问题，优势创建，优势绘制，优势保存到数组中，paint正常来说应该只做气质绘制这一个事情
    public void paint(Graphics g) {
//        super.paint(g);
        /*
        paint方法是JPanel的绘制面板内容的方法
        Graphics：绘制类
            常用方法：
            g.drawImage 图片
            g.drawChars 文字
            g.drawLine 直线
            g.drawOval 圆 椭圆

            如何在jpanel上画一张图：
                1 准备图片路径
                    File.separator：路劲分隔符
                        windows：\ 反斜杠
                        linux macos：/ 斜杠
                2 通过路劲获得对象
                3 使用g.drawImage将图片绘制到面板上

         */
        //画背景
        //1、准备图片路劲
        String bgPath = "pic" + File.separator + "qipan.jpg";
        //2 通过路劲获得对象
        /*
        Toolkit.getDefaultToolkit():获取toolkit的实例
            Toolkit.getDefaultToolkit().getImage()   获取图片
            Toolkit.getDefaultToolkit().createImage()创建图片
         */
        Image bgImg = Toolkit.getDefaultToolkit().getImage(bgPath);
        // 3 使用g.drawImage将图片绘制到面板上
        g.drawImage(bgImg, 0, 0, this);
        //画棋子
        /*过于复杂
        String che0Path = "pic" + File.separator +"che0.png";
        Image che0Img = Toolkit.getDefaultToolkit().getImage(che0Path);
        g.drawImage(che0Img,5,5,30,30,this);

        String ma0Path = "pic" + File.separator +"ma0.png";
        Image ma0Img = Toolkit.getDefaultToolkit().getImage(ma0Path);
        g.drawImage(ma0Img,45,5,30,30,this);
        */
        //定义string变量 ，名为path，且赋值为
        /*String path = "pic" + File.separator +"che0.png";
        Image img = Toolkit.getDefaultToolkit().getImage(path);
        g.drawImage(img,5,5,30,30,this);

        path = "pic" + File.separator+"ma0.png";
        img = Toolkit.getDefaultToolkit().getImage(path);
        g.drawImage(img,45,5,30,30,this);

        path = "pic" + File.separator+"xiang0.png";
        img = Toolkit.getDefaultToolkit().getImage(path);
        g.drawImage(img,85,5,30,30,this);
        */
        /*
        使用数组与虚幻优化代码
            变量局限性：只能保存一个数据
            如何保存多个数据
                使用数组和集合

         数组的基本使用
            1 定义
                静态 ：必须一行，定义赋值必须在一行
                    格式：数据类型[] 数组名 = new 数据类型[]{值1，，，，};
                         简写：数据类型[] 数组名 = {值1，，，，};
                动态 ：可以先定义后赋值
                    格式：1 数据类型[] 数组名 = new 数据类型[]{长度};
                         2 先定义 数据类型[] 数组名 [=null];
                           后附值 数组名 = new 数据类型[]{长度};
            2 长度 length属性
            3 索引 [0,length-1]
                若超出范围，抛出 数组索引越界异常(java.lang.ArrayIndexOutOfBoundsException)
            4 元素的使用和赋值
                格式：数组名【索引值】= 值；
                注意 数组在使用前必须初始化：赋值，否则报空指针异常(java.lang.NullPointerException)
            5 异常
            6 遍历，使用循环
         */
        //String[] names = new String[]{"che0.png","ma0.png","xiang0.png"};
//        String[] names = {"che","ma","xiang","shi","boss","shi",
//                    "xiang","ma","che","pao","pao","bing","bing",
//                    "bing","bing","bing"};
//        int player = 0;//棋子阵营
//        String suffix = ".png";//图片后缀
//       int[] xs = {5,45,85,125,165,205,245,285,325,45,285,5,85,165,245,325};
//       int[] ys = {5,5,5,5,5,5,5,5,5,85,85,125,125,125,125,125};
//        int[] xs = {1,2,3,4,5,6,7,8,9,2,8,1,3,5,7,9};
//        int[] ys = {1,1,1,1,1,1,1,1,1,3,3,4,4,4,4,4};
//        int size = 30; //棋子大小
//        int margin = 20; //棋子中心与界面
//        int space = 40;//棋子与棋子之间的间距
        //String[] names = new String[3];
        //names[0]="che0.png";
        //int[] a1 = null;//只是定义一个名为a1的数组，并没初始化

//        for(int i = 0;i< names.length;i++){
//            String path = "pic" + File.separator + names[i] + player + suffix;
//            Image img = Toolkit.getDefaultToolkit().getImage(path);
//            g.drawImage(img,margin-size/2+space*(xs[i]-1),
//                    margin-size/2+space*(ys[i]-1),size,size,
//                    this);
//        }

//        player=1;
//        for(int i = 0;i< names.length;i++){
//            String path = "pic" + File.separator + names[i] + player + suffix;
//            Image img = Toolkit.getDefaultToolkit().getImage(path);
//            g.drawImage(img,margin-size/2+space*(reserveX(xs[i])-1),
//                    margin-size/2+space*(reserveY(ys[i])-1),size,size,
//                    this);}
        String[] names = {"che", "ma", "xiang", "shi", "boss", "shi",
                "xiang", "ma", "che", "pao", "pao", "bing", "bing",
                "bing", "bing", "bing"};

        Point[] ps ={new Point(1,1),new Point(2,1),new Point(3,1),new Point(4,1),
                new Point(5,1),new Point(6,1),new Point(7,1),new Point(8,1)
                ,new Point(9,1), new Point(2,3),new Point(8,3), new Point(1,4),
                new Point(3,4), new Point(5,4),new Point(7,4),new Point(9,4),};

        for(int i = 0;i< names.length;i++){
            Chess c = new Chess();//创建棋子对象
            c.setName(names[i]);//指定棋子名称
            c.setP(ps[i]);//指定棋子的网络坐标
            c.setPlayer(0);
            c.draw(g,this);//绘制棋子
            chesses[i] =c;//将棋子保存到数组中
        }
        for(int i = 0;i< names.length;i++){
            Chess c = new Chess();//创建棋子对象
            c.setName(names[i]);//指定棋子名称
            c.setP(ps[i]);//指定棋子的网络坐标
            c.setPlayer(1);
            c.reserve();
            c.draw(g,this);//绘制棋子
            chesses[i+16] =c;//将棋子保存到数组中
        }

        System.out.println(Arrays.toString(chesses));

    }


}
