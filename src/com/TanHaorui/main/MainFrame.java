package com.TanHaorui.main;


import javax.swing.*;

public class MainFrame {

    public static void main(String[] args) {
        //创建一个JFrame 的实例 frm
        JFrame frm = new JFrame();
        //设置窗口大小
        frm.setSize(400,500);
        //设置窗口居中
        frm.setLocationRelativeTo(null);
        //设置点击关闭按钮同时结束虚拟机
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //将游戏面板添加到窗口中
        frm.add(new GamePanel());
        //设置窗口可见
        frm.setVisible(true);


    }
}
