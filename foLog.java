import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;
import java.net.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;

import java.awt.Image;

public class foLog extends JFrame{
    
    public foLog(){
        init();
    }

    fomusic music = new fomusic();

    Container cp;
    JLabel jlb = new JLabel("><D");
    JPanel logzone = new JPanel();
    TitledBorder tp = new TitledBorder(" Log in ");

    
    JLabel jlbId = new JLabel("               ID :  _____________");
    JLabel jlbPassword = new JLabel("  Password :  _____________");
    JPasswordField jField = new JPasswordField();
    JTextField jIDField = new JTextField();
    JLabel jboo1 = new JLabel(".");

    JLabel jboo2 = new JLabel(".");

    JButton jbtnsign = new JButton("Sign in");
    JButton jbtnlogin = new JButton("Log in");

    JPanel jbtnpn = new JPanel();
    foReadData foR = new foReadData(); 

    JLabel jwaring = new JLabel("This ID is not exist ! ");

    private void init(){

        this.setTitle("Welcome !");

        cp = this.getContentPane();
        cp.setBackground(new Color(255,200,160));
        cp.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(425, 200, 400, 400);
        this.setContentPane(cp);

        tp.setTitleFont(new Font(null,Font.PLAIN,20));
        tp.setTitleColor(Color.WHITE);
        tp.setBorder(BorderFactory.createLineBorder(Color.WHITE , 5,true));
        music.start(); // tp = JPanel , music.start() start a muti-Thread
        

        logzone.setBorder(tp);
        logzone.setLayout(new GridLayout(2,1,3,3));
        logzone.setBounds(45, 70, 295, 200);
        logzone.setOpaque(false);
        logzone.add(jlbId);
        logzone.add(jlbPassword);

        jlbId.setForeground(Color.WHITE);
        jlbPassword.setForeground(Color.WHITE);

        jlbId.setFont(new Font(null,Font.PLAIN,20));
        jlbPassword.setFont(new Font(null,Font.PLAIN,20));
        jField.setBounds(170, 207, 150, 22);
        jField.setOpaque(false);
        jField.setBorder(null);
        jField.setForeground(Color.WHITE);
        jField.setFont(new Font(null,Font.PLAIN,18)); 


        // jIDField.setFont(new Font(null,Font.PLAIN,10));
        jIDField.setFont(new Font(null,Font.PLAIN,20));
        jIDField.setBounds(173, 125, 150, 22);
        jIDField.setOpaque(false);
        jIDField.setBorder(null);
        jIDField.setForeground(Color.WHITE);
        //TitledBorder.TOP,TitledBorder.CENTER

        jbtnpn.setLayout(new GridLayout(1,2,10,3));
        jbtnpn.setBounds(45, 290, 295, 55);
        jbtnpn.setOpaque(false);

        jbtnsign.setOpaque(false);
        jbtnsign.setBackground(new Color(255,200,160));
        jbtnsign.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
        jbtnsign.setForeground(Color.WHITE);
        jbtnsign.setFont(new Font(null,Font.PLAIN,20));

        jbtnlogin.setOpaque(false);
        jbtnlogin.setBackground(new Color(255,200,160));
        jbtnlogin.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
        jbtnlogin.setForeground(Color.WHITE);
        jbtnlogin.setFont(new Font(null,Font.PLAIN,20));

        jlb.setBounds(-30,30,40,20);

        jboo1.setBounds(-40,30,30,18);
        jboo1.setFont(new Font(null,Font.PLAIN,20));

        jboo2.setBounds(-50,30,30,18);
        jboo2.setFont(new Font(null,Font.PLAIN,20));

        jwaring.setBounds(110,165, 170, 30);
        jwaring.setOpaque(false);
        jwaring.setHorizontalAlignment(JLabel.CENTER);
        jwaring.setForeground(Color.WHITE);
        jwaring.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true));
        jwaring.setVisible(false);

        jbtnlogin.addActionListener(new ActionListener(){
            // @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO Auto-generated method stub

                String now1 = jIDField.getText();
                String now2 = jField.getText();

                if(now1.contains(" ")||now2.contains(" ")|| now1.contains("#") || now2.contains("#")||now1.contains("%")||now2.contains("%") ){
                    jwaring.setText("Include wrong char ! ");
                    jwaring.setVisible(true);
                }

                else if(now1 != null && !now1.equals("")&& now2 != null && !now2.equals("")&& !now1.contains(" ")&& !now2.contains(" ")){

                    String flag = foR.check(jIDField.getText(), jField.getText());
                    // System.out.println(flag);

                    if(flag.equals("1")){
                        jwaring.setText("The password is incorrect ! ");
                        jwaring.setVisible(true);
                    }
    
                    if(flag.equals("2")){
                        jwaring.setText("This ID is not exist ! ");
                        jwaring.setVisible(true);
                    }
    
                    if(flag.charAt(0) == '3'){
                        foLog.this.dispose();
                        fo fou = new fo(flag,music);
                    }
                }
                
                
            }
        });

        
        jbtnsign.addActionListener(new ActionListener(){
            // @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO Auto-generated method stub

                
                String now1 = jIDField.getText();
                String now2 = jField.getText();
                
                if(now1 != null && !now1.equals("")&& now2 != null && !now2.equals("")){


                    String flag = foR.check(jIDField.getText(), jField.getText());
                    System.out.println(flag);

                    if(flag.equals("1") || flag.charAt(0) == '3'){
                        jwaring.setText("The ID is exist ! ");
                        jwaring.setVisible(true);
                    }
    
                    if(flag.equals("2")){
                        String tmpnamestr = (String) JOptionPane.showInputDialog(null, "Input your User name \n", "wait",
                        JOptionPane.PLAIN_MESSAGE);
                        if(tmpnamestr!= null && !tmpnamestr.equals("")){
                            foR.signin(jIDField.getText(),  jField.getText(),tmpnamestr);
                            jwaring.setText("Sign in is Correct ! ");
                            jwaring.setVisible(true);

                        }else{
                            jwaring.setText("Username can't be null ! ");
                            jwaring.setVisible(true);
                        }

    
                    }

                }
                
            }
        });


        jbtnpn.add(jbtnsign);
        jbtnpn.add(jbtnlogin);
        cp.add(jbtnpn);

        cp.add(jwaring);

        cp.add(jlb);
        cp.add(jboo1);
        cp.add(jboo2);

        cp.add(logzone);

        cp.add(jField);
        cp.add(jIDField);


    }

    public void ani(){

        
        

        while(true){

            double bcos = Math.toRadians(jlb.getX() + 1);
            double boo1cos = Math.toRadians(jboo1.getX() + 1);
            double boo2cos = Math.toRadians(jboo2.getX() + 1);

            jlb.setLocation(jlb.getX()+1,(int) (jlb.getY() + (float) Math.cos(7 * bcos) + 0.49999999999999289121));
            jboo1.setLocation(jboo1.getX()+1,(int) (jboo1.getY() + (float) Math.cos(7 * boo1cos) + 0.49999999999999289121));
            jboo2.setLocation(jboo2.getX()+1,(int) (jboo2.getY() + (float) Math.cos(7 * boo2cos) + 0.49999999999999289121));

            if( (jlb.getX() > 460) && (jboo1.getX()>460) && (jboo2.getX()>460)){
                jlb.setLocation(-30, 30);
                jboo1.setLocation(-40,30);
                jboo2.setLocation(-50,30);
            }
            try {
                Thread.sleep(13);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    
        
}

