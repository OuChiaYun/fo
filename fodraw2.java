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

public class fodraw2 extends JFrame {

    Container cp;
    foChatServer chatServerm;
    ImageIcon tmpicon;
    JLabel tmpJLabel;
    JPanel jp = new JPanel();
    JButton Znbig = new JButton("Big");
    JButton Znbsml = new JButton("Small");
    JButton imgxx = new JButton("X");
    BufferedImage bufferedImage;
    File tmpfile;
    String tmpfilename;
    int tmpw;
    int tmph;
    int nowH;
    int nowW;
    Image tmpimage;

    JTextArea tmptextarea = new JTextArea();
    JScrollPane tmpjsp = new JScrollPane(tmptextarea);

    public fodraw2() {
        init();
    }

    private void init() {
        this.setTitle("Chat Room 1 ");

        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.setBackground(new Color(200, 200, 200));
        this.setResizable(false);
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(900, 400, 400, 400);

        tmpJLabel = new JLabel("");

        jp.setLayout(new GridLayout(1, 3, 3, 3));

        Znbig.setBackground(Color.GRAY);
        Znbig.setForeground(Color.WHITE);

        Znbsml.setBackground(Color.GRAY);
        Znbsml.setForeground(Color.WHITE);

        imgxx.setBackground(Color.GRAY);
        imgxx.setForeground(Color.WHITE);

        Znbig.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO Auto-generated method stub

                try {
                    orimg();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        imgxx.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO Auto-generated method stub

                fodraw2.this.dispose();

            }
        });

        Znbsml.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO Auto-generated method stub

                try {
                    showtmpimg();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    public void getimgvalue(File newtmpfile, String newtmpfilename, int newtmpw, int newtmph) {
        jp.add(Znbig);
        jp.add(imgxx);
        jp.add(Znbsml);

        cp.add(jp, BorderLayout.NORTH);
        cp.add(tmpJLabel);

        tmpfile = newtmpfile;
        tmpfilename = newtmpfilename;
        tmpw = newtmpw;
        tmph = newtmph;

        nowW = tmpw;
        nowH = tmph;

        if (tmpw >= 500 && tmph >= 500) {
            nowW = tmpw / 3;
            nowH = tmph / 3;
        } else if (tmpw <= 100 && tmph <= 100) {
            nowW = tmpw * 2;
            nowH = tmph * 2;
        } else {
            Znbsml.setEnabled(false);
            Znbig.setEnabled(false);
            nowW = tmpw;
            nowH = tmph;
        }

    }

    public void showtmpimg() throws IOException {
        fodraw2.this.setTitle(tmpfile.getName() + " : thumbnail");
        bufferedImage = ImageIO.read(tmpfile);
        tmpimage = bufferedImage.getScaledInstance(nowW, nowH, Image.SCALE_DEFAULT);
        fodraw2.this.setBounds(700, 200, nowW, nowH);
        tmpicon = new ImageIcon(tmpimage);
        tmpJLabel.setIcon(tmpicon);
        fodraw2.this.setVisible(true);
        tmpJLabel.setBounds(0, 0, nowW, nowH);
    }

    public void orimg() throws IOException {
        fodraw2.this.setTitle(tmpfile.getName() + " : ( " + tmpw + " x " + tmph + " )");
        fodraw2.this.setBounds(0, 0, tmpw, tmph);
        tmpicon = new ImageIcon(tmpfilename);
        tmpJLabel.setIcon(tmpicon);
        fodraw2.this.setVisible(true);
        tmpJLabel.setBounds(0, 0, tmpw, tmph);
        tmpJLabel.setOpaque(true);

    }

    public void showtext(File newtmpfile) {

        try {
            fodraw2.this.setTitle(newtmpfile.getName());
            fodraw2.this.setBounds(900, 350, 300, 400);
            File tmpfile = newtmpfile;
            FileReader fr;
            fr = new FileReader(tmpfile);
            char data[] = new char[1024];
            int num = fr.read(data);
            String str = new String(data, 0, num);
            tmptextarea.append(str);
            cp.add(tmpjsp);
            fr.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
