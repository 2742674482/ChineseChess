//
//package com.TanHaorui.main;
//
///*
//swing编程中面板值jpanel这类，在jframe中自带一个面板，但其又bug
// */
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.File;
//
//public class GamePanel_备份2 extends JPanel {
//    //定义一个保存所有棋子的成员变量，类型是数组
//    private Chess[] chesses = new Chess[32];//保存所有的棋子
//
//    //当前选中的棋子
//    private Chess selectedChess;
//
//    //记住当前阵营
//    private int curPlayer = 0;
//
//    //无参构造方法：权限修饰符 类名（）{}
//    //构造方法，可以让自定义创建对象，做一些必要的操作
//    public GamePanel_备份2(){
//        createChesses();
//        System.out.println("1");
//        /*如何操作棋子
//            1 点击棋盘
//            2 如何获取棋子对象（如何判断点击的地方是否有棋子）
//            3 如何区分第一选择 重新选择 移动 吃子
//
//         */
//
//        //添加棋子的点击事件
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("The coordinates of the clicked chessboard position is：x=" + e.getX() + ".y="+e.getY());
//                Point p = Chess.getPointFromXY(e.getX(),e.getY());
//                System.out.println("The coordinates of the grid position of the clicked board is：p="+p);
//                //Chess c = getChessByp(p);
//                if(selectedChess == null){
//                    //第一次选择
//                    selectedChess=getChessByp(p);
//                    if (selectedChess != null && selectedChess.getPlayer() != curPlayer){
//                        selectedChess = null;
//                    }
//                }else {
//                    //重新选择 移动 吃子
//                    Chess c = getChessByp(p);
//                    if (c!=null){
//                        //第n此点击时有棋子
//                        //重新选择 吃子
//                        if(c.getPlayer()==selectedChess.getPlayer()){
//                            //重新选择
//                            System.out.println("reselect");
//                            selectedChess=c;
//
//                        }else {
//                            //吃子
//                            System.out.println("Capture");
//                            if(selectedChess.isAbleMove(p, GamePanel_备份2.this)){
//                                /*  从数组中删除被吃掉的棋子
//                                    修改该要移动棋子的坐标
//                                 */
//                                chesses[c.getIndex()] = null;//从数组中删除被吃掉的棋子
//                                selectedChess.setP(p);
//                                overMyTurn();
//                            }
//                        }
//                    }else{
//                        //第n此点击时无棋子，及点的是空白地方
//                        //移动
//                        System.out.println("move");
//                        if(selectedChess.isAbleMove(p, GamePanel_备份2.this)){
//                            selectedChess.setP(p);
//                            overMyTurn();
//                        }
//                    }
//                }
//                System.out.println("The coordinates of the clicked pawn is：c="+selectedChess);
//                //刷新棋盘，即重新执行paint方法
//                repaint();
//            }
//        });
//    }
//
//    //结束当前回合
//    private void overMyTurn(){
//        curPlayer = curPlayer == 0 ? 1 : 0;
//        selectedChess = null;
//    }
//
//    //根据网格坐标p对象查找棋子对象
//    public Chess getChessByp(Point p){
//        for(Chess item : chesses){
//            //System.out.println(item.getP());
//            if (item != null && item.getP().equals(p)){
//                return item;
//            }
//         }
//        return null;
//    }
//
//    //创建所有棋子
//    private void createChesses(){
//        String[] names = {"che", "ma", "xiang", "shi", "boss", "shi",
//                "xiang", "ma", "che", "pao", "pao", "bing", "bing",
//                "bing", "bing", "bing"};
//
//        Point[] ps ={new Point(1,1),new Point(2,1),new Point(3,1),new Point(4,1),
//                new Point(5,1),new Point(6,1),new Point(7,1),new Point(8,1)
//                ,new Point(9,1), new Point(2,3),new Point(8,3), new Point(1,4),
//                new Point(3,4), new Point(5,4),new Point(7,4),new Point(9,4),};
//
//        for(int i = 0;i< names.length;i++){
//            Chess c = new Chess();//创建棋子对象
//            c.setName(names[i]);//指定棋子名称
//            c.setP(ps[i]);//指定棋子的网络坐标
//            c.setPlayer(0);
//            c.setIndex(i);
//            chesses[i] =c;//将棋子保存到数组中
//        }
//        for(int i = 0;i< names.length;i++){
//            Chess c = new Chess(names[i], 1,ps[i]);//创建棋子对象
////            c.setName(names[i]);//指定棋子名称
////            c.setP(ps[i]);//指定棋子的网络坐标
////            c.setPlayer(1);
//            c.reserve();
//            c.setIndex(i+16);
//            chesses[c.getIndex()] =c;//将棋子保存到数组中
//        }
//    }
//
//
//
//    //绘制所有棋子
//    private void drawChesses(Graphics g){
//        for(Chess item: chesses){
//            if(item != null)
//            item.draw(g,this);
//        }
//    }
//
//    @Override
//    //有一个问题，又是创建，又是绘制，优势保存到数组中，paint正常来说应该只做气质绘制这一个事情
//    public void paint(Graphics g) {
//        super.paint(g);//清除原来的痕迹
//        System.out.println("2");
//        /*
//        paint方法是JPanel的绘制面板内容的方法
//        Graphics：绘制类
//            常用方法：
//            g.drawImage 图片
//            g.drawChars 文字
//            g.drawLine 直线
//            g.drawOval 圆 椭圆
//
//            如何在jpanel上画一张图：
//                1 准备图片路径
//                    File.separator：路劲分隔符
//                        windows：\ 反斜杠
//                        linux macos：/ 斜杠
//                2 通过路劲获得对象
//                3 使用g.drawImage将图片绘制到面板上
//
//         */
//        //画背景
//        //1、准备图片路劲
//        String bgPath = "pic" + File.separator + "qipan.jpg";
//        //2 通过路劲获得对象
//        /*
//        Toolkit.getDefaultToolkit():获取toolkit的实例
//            Toolkit.getDefaultToolkit().getImage()   获取图片
//            Toolkit.getDefaultToolkit().createImage()创建图片
//         */
//        Image bgImg = Toolkit.getDefaultToolkit().getImage(bgPath);
//        // 3 使用g.drawImage将图片绘制到面板上
//        g.drawImage(bgImg, 0, 0, this);
//
//        drawChesses(g);
//
//        if(selectedChess != null){
//            selectedChess.drawRect(g);
//        }
//
//
//    }
//
//
//}
//*/