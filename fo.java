import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread;
import java.awt.Color;
import java.awt.Component;
import java.io.*;
import java.net.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;

class Tchat extends Thread {

    // foWinChat foWin = new foWinChat();

    String name;

    public Tchat(String newname) {
        name = newname;
    }

    public void run() {
        foWinChat f = new foWinChat();
        f.setVisible(true);
        f.setTitle(name);
    }

}

public class fo implements Runnable {

    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int e = 0;

    static int f1 = 0; // fish sum
    static int f2 = 0;
    static int f3 = 0;
    static int f4 = 0;
    static int f5 = 0;


    // foWinChat f = new foWinChat();
    //foShop2Frame sh2frm = new foShop2Frame();
    foFrame mfrm ;
    String infomation;
    fomusic fom = new fomusic();
    public fo(String newdata,fomusic music) {
        // f.setVisible(true);
        infomation = newdata;
        mfrm = new foFrame(music);
        fom  =music;
        mfrm.setVisible(true);
        start();
    }

    private void start() {
        Thread t = new Thread(this);
        t.start();
    }

    // }
    @Override
    public void run() {

        Long updatetime = System.nanoTime();

        // long time = System.nanoTime();

        // System.out.println(infomation);

        // System.out.println(a + " " + f1 + " " + b + " " + f2 + " " + c  + " " + f3 + " " + d + " " + f4 + " " + e + " " + f5);

        String[] totmpif = infomation.split("%");
        String[] tmpinfo = totmpif[1].split("#");
        String usName = tmpinfo[0];
        f1 = Integer.valueOf(tmpinfo[1]);
        f2 = Integer.valueOf(tmpinfo[2]);
        f3 = Integer.valueOf(tmpinfo[3]);
        f4 = Integer.valueOf(tmpinfo[4]);
        f5 = Integer.valueOf(tmpinfo[5]);
        // System.out.println(a + " " + f1 + " " + b + " " + f2 + " " + c  + " " + f3 + " " + d + " " + f4 + " " + e + " " + f5);

        mfrm.sh2frm.setmoney(Integer.valueOf(tmpinfo[6]), f2 + f3, f1 + f4 + f5, Integer.valueOf(tmpinfo[7]));
        mfrm.setTitle(usName + " 's Aquarium");

        int egg1 = 0;
        Boolean trasflagR = true,trasflagG = true,trasflagB = true;
        // foShopFrame shfrm = new foShopFrame();
        //
        mfrm.sh2frm.scrR.setValue(128);
        mfrm.sh2frm.scrG.setValue(228);
        mfrm.sh2frm.scrB.setValue(228);
        // System.out.println(rc+" " + gc +" " + bc );

        while (true) {

            fom = mfrm.sh2frm.music;

            if(fom.clip != null &&fom.clip.isRunning()){
                mfrm.sh2frm.slider.setValue((int)(((float)fom.clip.getMicrosecondPosition()/fom.clip.getMicrosecondLength())*100));
                if(fom.clip.getMicrosecondPosition() >= fom.clip.getMicrosecondLength()){
                    fom.clip.setMicrosecondPosition(0);
                }
            }

            // fom.clip.isRunning();

            // mfrm.sh2frm.slider.setValue((int) ((float)fom.time/fom.am.getFrameLength()*100));
            // System.out.println((float)fom.time + "  " + fom.am.getFrameLength() *100);
            mfrm.cp.setBackground(new Color( mfrm.sh2frm.scrR.getValue() ,mfrm.sh2frm.scrG.getValue(),mfrm.sh2frm.scrB.getValue()));
            mfrm.sh2frm.jbtnrandomcolor.setForeground(new Color( mfrm.sh2frm.scrR.getValue() ,mfrm.sh2frm.scrG.getValue(),mfrm.sh2frm.scrB.getValue()));
            mfrm.sh2frm.jbtnrandomcolor.setBorder(BorderFactory.createLineBorder(new Color( mfrm.sh2frm.scrR.getValue() ,mfrm.sh2frm.scrG.getValue(),mfrm.sh2frm.scrB.getValue()), 5, true));

            if(mfrm.sh2frm.colorflag){

                if(trasflagR){
                    mfrm.sh2frm.scrR.setValue((int)(mfrm.sh2frm.scrR.getValue()+1)%246 );
                }else{
                    mfrm.sh2frm.scrR.setValue((int)(mfrm.sh2frm.scrR.getValue()-1)%246 );      
                }
                
                if(trasflagG){
                    mfrm.sh2frm.scrG.setValue((int)(mfrm.sh2frm.scrG.getValue()+1)%246 );                    
                }else{
                    mfrm.sh2frm.scrG.setValue((int)(mfrm.sh2frm.scrG.getValue()-1)%246 );   
                }
                
                if(trasflagB){
                    mfrm.sh2frm.scrB.setValue((int)(mfrm.sh2frm.scrB.getValue()+1)%246 );         
                }else{
                    mfrm.sh2frm.scrB.setValue((int)(mfrm.sh2frm.scrB.getValue()-1)%246 );   
                }

                if(mfrm.sh2frm.scrR.getValue() >= 245){
                    trasflagR = false;
                }else if(mfrm.sh2frm.scrR.getValue() == 0){
                    trasflagR = true;
                }

                if(mfrm.sh2frm.scrG.getValue() >= 245){
                    trasflagG = false;
                }else if(mfrm.sh2frm.scrG.getValue() == 0){
                    trasflagG = true;
                }
                
                if(mfrm.sh2frm.scrB.getValue() >= 245){
                    trasflagB = false;
                }else if(mfrm.sh2frm.scrB.getValue() == 0){
                    trasflagB = true;
                }

                // System.out.println(mfrm.sh2frm.scrR.getValue() +" "+ mfrm.sh2frm.scrG.getValue() + " " +mfrm.sh2frm.scrB.getValue());

            }


            // long nowtime = System.nanoTime();
            // if (nowtime - time >= 33000000) {

            mfrm.cp.revalidate();
            mfrm.cp.repaint();

            if (mfrm.fooddug == 1) {

                mfrm.fooodCheckCount();

                if (mfrm.count == 0) {
                    mfrm.setCursor(3);
                } else {
                    mfrm.setCursor(1);
                }
            }

            // menu function (chat feed collect shopF shop sell)

            if (mfrm.chatRoomOp) {
                Tchat chat = new Tchat(usName);
                chat.start();
                mfrm.chatRoomOp = false;
            }

            if (mfrm.shop) {

                mfrm.sh2frm.setVisible(true);
                mfrm.shop = false;

            }

            // fish move


            if (f1 > 0) {
                if (a < f1) {
                    mfrm.fishow(a);
                    a++;

                }
                if (a > f1) {
                    mfrm.remove(mfrm.jf1.get(a - 1).jlabel);
                    mfrm.jf1.remove(a - 1);
                    mfrm.cp.revalidate();
                    mfrm.repaint();
                    mfrm.wow.setText("food : "+mfrm.count+" fish : "+(f2+f3)+" pet : "+(f1+f4+f5));
                    a--;
                }

                if (a > 0) {
                    for (int i = 0; i <= a - 1; i++) {
                        mfrm.jLabelForward(i);
                    }

                }
            } else if (a > f1 && f1 == 0) {
                mfrm.remove(mfrm.jf1.get(a - 1).jlabel);
                mfrm.jf1.remove(a - 1);
                mfrm.cp.revalidate();
                mfrm.repaint();
                mfrm.wow.setText("food : "+mfrm.count+" fish : "+(f2+f3)+" pet : "+(f1+f4+f5));
                a--;
            }

            if (f2 > 0) {
                if (b < f2) {
                    Random fe = new Random();
                    mfrm.fishow2(b);
                    mfrm.jf2.get(b).timeegg = fe.nextInt(450);
                    b++;
                }

                if (b > f2) {
                    mfrm.remove(mfrm.jf2.get(b - 1).jlabel);
                    mfrm.jf2.remove(b - 1);
                    mfrm.cp.revalidate();
                    mfrm.repaint();
                    mfrm.wow.setText("food : "+mfrm.count+" fish : "+(f2+f3)+" pet : "+(f1+f4+f5));
                    b--;
                }
                if (b > 0) {
                    for (int i = 0; i <= b - 1; i++) {
                        mfrm.jLabel2Forward(i);
                        mfrm.jf2.get(i).timeegg = mfrm.jf2.get(i).timeegg+1;
                        
                    }
                    for (int i = 0; i < b; i++) {
                        mfrm.tryeggborn(mfrm.jf2.get(i).timeegg,i);
                        mfrm.jf2.get(i).timeegg = mfrm.jf2.get(i).timeegg%(int)mfrm.jf2.get(i).eggtimelimit;
                    }
                }

            }else if (b > f2 && f2 == 0) {
                mfrm.remove(mfrm.jf2.get(b - 1).jlabel);
                mfrm.jf2.remove(b - 1);
                mfrm.cp.revalidate();
                mfrm.repaint();
                mfrm.wow.setText("food : "+mfrm.count+" fish : "+(f2+f3)+" pet : "+(f1+f4+f5));
                b--;
            }


            for (int i = 0; i < mfrm.egg2.size(); i++) {

                if (i < mfrm.egg2.size() && i < mfrm.eggRe2.size() && mfrm.egg2.get(i) != null
                        && mfrm.eggRe2.get(i) != null) {
                    mfrm.egg2.get(i).setLocation(mfrm.egg2.get(i).getX(), mfrm.egg2.get(i).getY() + 1);
                    mfrm.eggRe2.get(i).setLocation(mfrm.egg2.get(i).getX(), mfrm.egg2.get(i).getY() + 1);
                }

            }

            if (f3 > 0) {

                if (c < f3) {
                    mfrm.fishow3(c);
                    c++;
                }
                if (c > f3) {
                    mfrm.remove(mfrm.jf3.get(c - 1).jlabel);
                    mfrm.jf3.remove(c - 1);
                    mfrm.cp.revalidate();
                    mfrm.repaint();
                    mfrm.wow.setText("food : "+mfrm.count+" fish : "+(f2+f3)+" pet : "+(f1+f4+f5));
                    c--;
                }
                if (c > 0) {
                    for (int i = 0; i <= c - 1; i++) {
                        mfrm.jLabel3Forward(i);
                        
                    }

                }

            } else if (c > f3 && f3 == 0) {
                mfrm.remove(mfrm.jf3.get(c - 1).jlabel);
                mfrm.jf3.remove(c - 1);
                mfrm.cp.revalidate();
                mfrm.repaint();
                mfrm.wow.setText("food : "+mfrm.count+" fish : "+(f2+f3)+" pet : "+(f1+f4+f5));
                c--;
            }


            if (f4 > 0) {

                if (d < f4) {
                    mfrm.fishow4(d);
                    d++;
                }
                if (d > f4) {
                    mfrm.remove(mfrm.jf4.get(d - 1).jlabel);
                    mfrm.jf4.remove(d - 1);
                    mfrm.cp.revalidate();
                    mfrm.repaint();
                    mfrm.wow.setText("food : "+mfrm.count+" fish : "+(f2+f3)+" pet : "+(f1+f4+f5));
                    d--;
                }
                if (d > 0) {
                    for (int i = 0; i < d; i++) {
                        mfrm.jLabel4Forward(i);
                    }
                }

            } else if (d > f4 && f4 == 0) {
                mfrm.remove(mfrm.jf4.get(d - 1).jlabel);
                mfrm.jf4.remove(d - 1);
                mfrm.cp.revalidate();
                mfrm.repaint();
                mfrm.wow.setText("food : "+mfrm.count+" fish : "+(f2+f3)+" pet : "+(f1+f4+f5));
                d--;
            }


            if (f5 > 0) {

                if (e < f5) {
                    mfrm.fishow5(e);
                    e++;
                }
                if (e > f5) {
                    mfrm.remove(mfrm.jf5.get(e - 1).jlabel);
                    mfrm.jf5.remove(e - 1);
                    mfrm.cp.revalidate();
                    mfrm.repaint();
                    mfrm.wow.setText("food : "+mfrm.count+" fish : "+(f2+f3)+" pet : "+(f1+f4+f5));
                    e--;
                }
                if (e > 0) {
                    for (int i = 0; i <= e - 1; i++) {
                        mfrm.jLabel5Forward(i);
                    }
                }

            } else if (e > f5 && f5 == 0) {
                mfrm.remove(mfrm.jf5.get(e - 1).jlabel);
                mfrm.jf5.remove(e - 1);
                mfrm.cp.revalidate();
                mfrm.repaint();
                mfrm.wow.setText("food : "+mfrm.count+" fish : "+(f2+f3)+" pet : "+(f1+f4+f5));
                e--;
            }


            for (int i = 0; i < 5; i++) {
                if (foFrame.foodcanuse[i] == 0) {
                    mfrm.foodForward(i);
                }
            }

            // mfrm.cp.repaint();
            egg1 = mfrm.egg1infoFrame;
            mfrm.sh2frm.egg1sumfun(egg1);
            egg1 = 0;
            mfrm.egg1infoFrame = 0;

            try {
                Long nowtime = System.nanoTime();

                if (nowtime - updatetime >= 3000000) {
                    updatetime = nowtime;
                    foReadData foread = new foReadData();
                    String tmpdata = "#" + f1 + "#" + f2 + "#" + f3 + "#" + f4 + "#" + f5 + "#" + mfrm.sh2frm.money
                            + "#"+mfrm.sh2frm.egg1sum;
                    foread.updateData(usName, tmpdata);
                    // System.out.println(a + " " + f1 + " " + b + " " + f2 + " " + c  + " " + f3 + " " + d + " " + f4 + " " + e + " " + f5);

                }
                mfrm.fish_s = f2+f3;
                mfrm.pet_s = f1+f4+f5;
                mfrm.cp.revalidate();
                mfrm.repaint();
                Thread.sleep(29);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
