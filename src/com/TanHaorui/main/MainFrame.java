package com.TanHaorui.main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFrame extends JFrame implements ActionListener {

    private GamePanel gp = null;

    public MainFrame(){
        //设置窗口大小
        setSize(650,500);
        //设置窗口居中
        setLocationRelativeTo(null);
        //设置点击关闭按钮同时结束虚拟机
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置布局管理员
        setLayout(new BorderLayout());

        setTitle("Chinese Chess");
        //将游戏面板添加到窗口中
        gp = new GamePanel();
        add(gp, BorderLayout.CENTER);
        //添加按钮面板
        JPanel btnPanel = new JPanel(new GridLayout(4,1));
        add(btnPanel,BorderLayout.EAST);
        JLabel hintLabel = new JLabel("    RED GO");
        btnPanel.add(hintLabel);
        gp.setHintLabel(hintLabel);
        JButton btnRegret = new JButton("Regret");
        btnRegret.setActionCommand("Regret");
        btnRegret.addActionListener(this);
        btnPanel.add(btnRegret);
        JButton btnSave = new JButton("Save");
        btnSave.setActionCommand("Save");
        btnSave.addActionListener(this);
        btnPanel.add(btnSave);
        JButton btnImport = new JButton("Import");
        btnImport.setActionCommand("Import");
        btnImport.addActionListener(this);
        btnPanel.add(btnImport);
        JButton btnSfP = new JButton("Sue for Peace");
        btnSfP.setActionCommand("Sue for Peace");
        btnSfP.addActionListener(this);
        btnPanel.add(btnSfP);
        JButton btnResign  = new JButton("Resign");
        btnResign.setActionCommand("Resign");
        btnResign.addActionListener(this);
        btnPanel.add(btnResign);
        //设置窗口可见
        setVisible(true);
    }

    public static void main(String[] args) {
        //创建一个JFrame 的实例 frm
        //JFrame frm = new JFrame();
        new MainFrame();



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button is clicked");
        String cmd = e.getActionCommand();
        switch (cmd){
            case "Regret":
                System.out.println("Regret");
                gp.regret();
                break;
            case "Save":
                System.out.println("Save");
                save();
                break;
            case "Import":
                System.out.println("Import");
                Import();
                break;
            case "Sue for Peace":
                System.out.println("Sue for Peace");
                break;
            case "Resign":
                System.out.println("Resign");
                break;
        }
    }


    //import chess manual
    private void  Import(){
        JFileChooser chooser = new JFileChooser();
        //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result=chooser.showOpenDialog(null);
        File parent = chooser.getSelectedFile();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(parent);
            ois = new ObjectInputStream(fis);
            Chess[] chesses =(Chess[]) ois.readObject();
            gp.setChesses(chesses);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    //save chess manual
    private void save(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result=chooser.showOpenDialog(null);
        File parent = chooser.getSelectedFile();
        System.out.println("fname--->"+parent);

        Date date = new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HHmmdd");
        String name=format.format(date)+".txt";


        //创建文件
        String path = parent.getAbsolutePath() + File.separator + name;
        File file = new File(path);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            //创建文件输出流对象
            fos = new FileOutputStream(file);
            //创建文件对象输出流
            oos = new ObjectOutputStream(fos);
            oos.writeObject(gp.getChesses());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

}
