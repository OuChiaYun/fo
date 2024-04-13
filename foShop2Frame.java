
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
// import java.awt.Image;
import java.io.InterruptedIOException;
import java.lang.Thread;
import java.sql.Time;
import java.text.AttributedCharacterIterator;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
// import java.awt.event.WindowFocusListener;
// import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

public class foShop2Frame extends JFrame {

    String[] songs = { "fo", "fo2" };
    int songnumber = 0;

    Boolean colorflag = false;
    JSlider slider = new JSlider(0, 100);

    // fomusic music = new fomusic();
    int Opa;

    JLabel eggshowsum = new JLabel("egg : 0");
    int f1 = 0;
    int f2 = 0;
    int f3 = 0;
    int f4 = 0;
    int f5 = 0;

    JButton jbtnrandomcolor = new JButton(" show ");

    JScrollBar scrR = new JScrollBar(JScrollBar.VERTICAL);
    JScrollBar scrG = new JScrollBar(JScrollBar.VERTICAL);
    JScrollBar scrB = new JScrollBar(JScrollBar.VERTICAL);

    JDesktopPane jdp = new JDesktopPane();
    JTabbedPane jtp = new JTabbedPane();

    // music
    fomusic music;
    Boolean flag = true;
    // music

    JInternalFrame jif1 = new JInternalFrame("fish shop", false, false, false, false);
    JInternalFrame jif2 = new JInternalFrame("sell shop", false, false, false, false);
    JInternalFrame jif3 = new JInternalFrame("decorate & voice ", false, false, false, false);

    public foShop2Frame(fomusic newmusic) {

        music = newmusic;

        init();
        init2();
        init3();
    }

    int money = 2000;
    private int fishSum = 0;
    private int petSum = 0;
    JLabel monjl = new JLabel("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
            + "          pet : " + String.valueOf(petSum));
    JLabel monjl2 = new JLabel("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
            + "          pet : " + String.valueOf(petSum));

    int egg1sum = 0;
    JTextField eggsell = new JTextField("0");

    private void init() {

        this.setContentPane(jtp);
        jtp.addTab("fish shop", jif1);

        jif1.setVisible(true);
        jif2.setVisible(true);
        jif3.setVisible(true);

        this.setBounds(600, 100, 400, 300);
        this.setBackground(Color.WHITE);
        // this.setVisible(true);
        this.setResizable(false);
        // this.setLayout(null);

        JButton jbtnf = new JButton("100");
        JButton jbtnf2 = new JButton("50");
        JButton jbtnf3 = new JButton("200");
        JButton jbtnf4 = new JButton("600");
        JButton jbtnf5 = new JButton("500");

        JLabel jicon = new JLabel(">-i=i-<");
        JLabel jicon2 = new JLabel("><D");
        JLabel jicon3 = new JLabel("><SHARKD");
        JLabel jicon4 = new JLabel("_Q_Y");
        JLabel jicon5 = new JLabel("-:(X):O");

        JPanel jp = new JPanel();

        jp.setLayout(null);
        jp.setBackground(new Color(200, 180, 100));

        jbtnf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (money - 100 >= 0) {
                    money = money - 100;
                    petSum = petSum + 1;
                    fo.f1++;
                    monjl.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));
                    monjl2.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));
                } else {
                    JOptionPane.showMessageDialog(foShop2Frame.this, "Poor you, you don't have enough money.",
                            "wait ! ", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        jbtnf2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (money - 50 >= 0) {
                    money = money - 50;
                    fishSum = fishSum + 1;
                    fo.f2++;
                    monjl.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));
                    monjl2.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));
                } else {
                    JOptionPane.showMessageDialog(foShop2Frame.this, "Poor you, you don't have enough money.",
                            "wait ! ", JOptionPane.ERROR_MESSAGE);

                }

            }
        });

        jbtnf3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (money - 200 >= 0) {
                    money = money - 200;
                    fishSum = fishSum + 1;
                    fo.f3++;
                    monjl.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));
                    monjl2.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));

                } else {
                    JOptionPane.showMessageDialog(foShop2Frame.this, "Poor you, you don't have enough money.",
                            "wait ! ", JOptionPane.ERROR_MESSAGE);

                }

            }
        });

        jbtnf4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (money - 600 >= 0) {
                    money = money - 600;
                    petSum = petSum + 1;
                    fo.f4++;
                    monjl.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));
                    monjl2.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));

                } else {
                    JOptionPane.showMessageDialog(foShop2Frame.this, "Poor you, you don't have enough money.",
                            "wait ! ", JOptionPane.ERROR_MESSAGE);

                }

            }
        });

        jbtnf5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (money - 500 >= 0) {
                    money = money - 500;
                    petSum = petSum + 1;
                    fo.f5++;
                    monjl.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));
                    monjl2.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));

                } else {
                    JOptionPane.showMessageDialog(foShop2Frame.this, "Poor you, you don't have enough money.",
                            "wait ! ", JOptionPane.ERROR_MESSAGE);

                }

            }
        });

        jbtnf.setBounds(30, 60, 65, 35);
        jbtnf.setBackground(Color.GRAY);
        jbtnf.setForeground(Color.WHITE);

        jbtnf2.setBounds(110, 60, 65, 35);
        jbtnf2.setBackground(Color.GRAY);
        jbtnf2.setForeground(Color.WHITE);

        jbtnf3.setBounds(190, 60, 65, 35);
        jbtnf3.setBackground(Color.GRAY);
        jbtnf3.setForeground(Color.WHITE);

        jbtnf4.setBounds(270, 60, 65, 35);
        jbtnf4.setBackground(Color.GRAY);
        jbtnf4.setForeground(Color.WHITE);

        jbtnf5.setBounds(30, 140, 65, 35);
        jbtnf5.setBackground(Color.GRAY);
        jbtnf5.setForeground(Color.WHITE);

        // fish icon

        jicon.setBounds(30, 30, 65, 35);
        jicon.setHorizontalAlignment(JLabel.CENTER);

        jicon2.setBounds(110, 30, 65, 35);
        jicon2.setHorizontalAlignment(JLabel.CENTER);

        jicon3.setBounds(188, 30, 70, 35);
        jicon3.setHorizontalAlignment(JLabel.CENTER);

        jicon4.setBounds(270, 30, 65, 35);
        jicon4.setHorizontalAlignment(JLabel.CENTER);

        jicon5.setBounds(30, 110, 65, 35);
        jicon5.setHorizontalAlignment(JLabel.CENTER);

        monjl.setBounds(0, 0, 400, 35);
        monjl.setHorizontalAlignment(JLabel.CENTER);
        // monjl.setVisible(true);

        //

        jp.add(monjl);
        jp.add(jbtnf);
        jp.add(jbtnf2);
        jp.add(jbtnf3);
        jp.add(jbtnf4);

        jp.add(jicon);
        jp.add(jicon2);
        jp.add(jicon3);
        jp.add(jicon4);
        jp.add(jicon5);
        jp.add(jbtnf5);

        jif1.setContentPane(jp);

    }

    private void init2() {

        jtp.addTab("sell shop", jif2);
        this.setBackground(Color.WHITE);

        JButton jbtnsell = new JButton("sell");

        JButton jbtnf = new JButton("5");
        TitledBorder zone = new TitledBorder(null, "Normal egg ", TitledBorder.TOP, TitledBorder.CENTER);
        JPanel jpzone = new JPanel();
        // monjl = new JLabel("money : " +String.valueOf(money) + " fish : " +
        // String.valueOf(fishSum) + " pet : " + String.valueOf(petSum));
        JLabel jicon = new JLabel("O");
        JPanel jp = new JPanel();
        JTextField maybeget = new JTextField("0");
        JPanel jpfishsell = new JPanel();
        TitledBorder sellzone = new TitledBorder(null, "sell fish zone ", TitledBorder.TOP, TitledBorder.CENTER);

        JLabel bjicon = new JLabel(">-i=i-<");
        JLabel bjicon2 = new JLabel("><D");
        JLabel bjicon3 = new JLabel("><SHARKD ");
        JLabel bjicon4 = new JLabel("_Q_Y");
        JLabel bjicon5 = new JLabel("-:(X):O");

        JTextField jt1 = new JTextField("0");
        JTextField jt2 = new JTextField("0");
        JTextField jt3 = new JTextField("0");
        JTextField jt4 = new JTextField("0");
        JTextField jt5 = new JTextField("0");

        JLabel jfish1sell = new JLabel("50");
        JLabel jfish2sell = new JLabel("25");
        JLabel jfish3sell = new JLabel("150");
        JLabel jfish4sell = new JLabel("300");
        JLabel jfish5sell = new JLabel("250");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();

        JButton jbtnfishsell = new JButton("sell");
        JButton jbtnallsell = new JButton("all sell");
        JButton jbtnrandoms = new JButton("random");
        JPanel selljbtnjp = new JPanel();

        final JButton b = new TriangleButton();
        final JButton d = new TriangleButton2();

        jfish1sell.setHorizontalAlignment(JLabel.CENTER);
        jfish2sell.setHorizontalAlignment(JLabel.CENTER);
        jfish3sell.setHorizontalAlignment(JLabel.CENTER);
        jfish4sell.setHorizontalAlignment(JLabel.CENTER);
        jfish5sell.setHorizontalAlignment(JLabel.CENTER);

        p1.setLayout(new GridLayout(1, 2, 2, 2));
        p1.setOpaque(false);
        p2.setLayout(new GridLayout(1, 2, 2, 2));
        p2.setOpaque(false);
        p3.setLayout(new GridLayout(1, 2, 2, 2));
        p3.setOpaque(false);
        p4.setLayout(new GridLayout(1, 2, 2, 2));
        p4.setOpaque(false);
        p5.setLayout(new GridLayout(1, 2, 2, 2));
        p5.setOpaque(false);

        selljbtnjp.setLayout(new GridLayout(1, 2, 3, 5));
        selljbtnjp.setOpaque(false);

        selljbtnjp.add(jbtnfishsell);
        selljbtnjp.add(jbtnallsell);

        jpfishsell.setLayout(new GridLayout(4, 3, 3, 5));

        jbtnfishsell.setMargin(new Insets(0, 0, 0, 0));
        jbtnfishsell.setFont(new Font(null, Font.PLAIN, 8));
        jbtnfishsell.setBackground(Color.GRAY);
        jbtnfishsell.setForeground(Color.WHITE);

        jbtnallsell.setMargin(new Insets(0, 0, 0, 0));
        jbtnallsell.setBackground(Color.GRAY);
        jbtnallsell.setForeground(Color.WHITE);
        jbtnallsell.setFont(new Font(null, Font.PLAIN, 8));

        jbtnrandoms.setMargin(new Insets(0, 0, 0, 0));
        jbtnrandoms.setBackground(Color.GRAY);
        jbtnrandoms.setForeground(Color.WHITE);
        jbtnrandoms.setFont(new Font(null, Font.PLAIN, 8));

        bjicon.setBounds(230, 30, 65, 35);
        bjicon.setHorizontalAlignment(JLabel.CENTER);

        bjicon2.setBounds(230, 65, 65, 35);
        bjicon2.setHorizontalAlignment(JLabel.CENTER);

        bjicon3.setBounds(230, 100, 70, 35);
        bjicon3.setHorizontalAlignment(JLabel.CENTER);

        bjicon4.setBounds(230, 135, 65, 35);
        bjicon4.setHorizontalAlignment(JLabel.CENTER);

        bjicon5.setBounds(230, 170, 65, 35);
        bjicon5.setHorizontalAlignment(JLabel.CENTER);

        monjl.setBounds(0, 0, 400, 35);
        monjl.setHorizontalAlignment(JLabel.CENTER);

        jt1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        jt1.setOpaque(false);
        jt1.setHorizontalAlignment(JTextField.CENTER);
        jt2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        jt2.setOpaque(false);
        jt2.setHorizontalAlignment(JTextField.CENTER);
        jt3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        jt3.setOpaque(false);
        jt3.setHorizontalAlignment(JTextField.CENTER);
        jt4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        jt4.setOpaque(false);
        jt4.setHorizontalAlignment(JTextField.CENTER);
        jt5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        jt5.setOpaque(false);
        jt5.setHorizontalAlignment(JTextField.CENTER);

        // jp.add(bjbtnf);
        // jp.add(bjbtnf2);
        // jp.add(bjbtnf3);
        // jp.add(bjbtnf4);
        sellzone.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        jpfishsell.setBorder(sellzone);
        sellzone.setTitleColor(Color.WHITE);

        p1.add(jt1);
        p1.add(jfish1sell);
        p2.add(jt2);
        p2.add(jfish2sell);
        p3.add(jt3);
        p3.add(jfish3sell);
        p4.add(jt4);
        p4.add(jfish4sell);
        p5.add(jt5);
        p5.add(jfish5sell);

        jpfishsell.add(bjicon);
        jpfishsell.add(bjicon2);
        jpfishsell.add(bjicon3);
        jpfishsell.add(p1);
        jpfishsell.add(p2);
        jpfishsell.add(p3);
        jpfishsell.add(bjicon4);
        jpfishsell.add(bjicon5);
        jpfishsell.add(selljbtnjp);
        jpfishsell.add(p4);
        jpfishsell.add(p5);
        jpfishsell.setBounds(138, 28, 225, 140);
        jpfishsell.setOpaque(false);
        jp.add(jpfishsell);
        jpfishsell.add(jbtnrandoms);
        // jp.add(bjbtnf5);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                int tmpsell = Integer.valueOf(eggsell.getText());

                if (tmpsell + 1 <= egg1sum) {
                    eggsell.setText((tmpsell + 1) + "");
                    tmpsell++;
                    // int curget = Integer.valueOf(maybeget.getText());
                    maybeget.setText(tmpsell * 5 + "");
                } else {
                    eggsell.setText(egg1sum + "");
                }

            }
        });

        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int tmpsell = Integer.valueOf(eggsell.getText());

                if (tmpsell - 1 > 0) {
                    eggsell.setText((tmpsell - 1) + "");
                    tmpsell++;
                    // int curget = Integer.valueOf(maybeget.getText());
                    maybeget.setText(tmpsell * 5 + "");
                } else {
                    eggsell.setText("0");
                    maybeget.setText("0");
                }
            }
        });

        jbtnsell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int tmpsell = Integer.valueOf(eggsell.getText());

                if (tmpsell <= egg1sum) {
                    money = money + tmpsell * 5;
                    eggsell.setText("egg : " + egg1sum);
                    egg1sum = egg1sum - tmpsell;
                    monjl.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));
                    monjl2.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));
                    eggsell.setText("0");
                    maybeget.setText("0");

                } else {

                    tmpsell++;
                    eggsell.setText(egg1sum + "");
                    maybeget.setText(egg1sum * 5 + "");

                }

            }
        });

        jbtnfishsell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int tmpsell1 = Integer.valueOf(jt1.getText());
                int tmpsell2 = Integer.valueOf(jt2.getText());
                int tmpsell3 = Integer.valueOf(jt3.getText());
                int tmpsell4 = Integer.valueOf(jt4.getText());
                int tmpsell5 = Integer.valueOf(jt5.getText());

                if ((tmpsell1 <= fo.f1) && (tmpsell2 <= fo.f2) && (tmpsell3 <= fo.f3) && (tmpsell4 <= fo.f4)
                        && (tmpsell5 <= fo.f5)) {
                    fo.f1 = fo.f1 - tmpsell1;
                    fo.f2 = fo.f2 - tmpsell2;
                    fo.f3 = fo.f3 - tmpsell3;
                    fo.f4 = fo.f4 - tmpsell4;
                    fo.f5 = fo.f5 - tmpsell5;

                    petSum = fo.f1 + fo.f4 + fo.f5;
                    fishSum = fo.f2 + fo.f3;

                    money = money + tmpsell1 * 50 + tmpsell2 * 25 + tmpsell3 * 150 + tmpsell4 * 300 + tmpsell5 * 250;

                    monjl.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));
                    monjl2.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                            + "          pet : " + String.valueOf(petSum));
                    eggsell.setText("0");
                    maybeget.setText("0");

                    jt1.setText("0");
                    jt2.setText("0");
                    jt3.setText("0");
                    jt4.setText("0");
                    jt5.setText("0");

                } else {
                    if (tmpsell1 > fo.f1) {
                        jt1.setText(fo.f1 + "");
                    }
                    ;
                    if (tmpsell2 > fo.f2) {
                        jt2.setText(fo.f2 + "");
                    }
                    ;
                    if (tmpsell3 > fo.f3) {
                        jt3.setText(fo.f3 + "");
                    }
                    ;
                    if (tmpsell4 > fo.f4) {
                        jt4.setText(fo.f4 + "");
                    }
                    ;
                    if (tmpsell5 > fo.f5) {
                        jt5.setText(fo.f5 + "");
                    }
                    ;
                }

            }
        });

        jbtnallsell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jt1.setText(fo.f1 + "");
                jt2.setText(fo.f2 + "");
                jt3.setText(fo.f3 + "");
                jt4.setText(fo.f4 + "");
                jt5.setText(fo.f5 + "");

            }
        });

        jbtnrandoms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Random r1 = new Random();
                Random r2 = new Random();
                Random r3 = new Random();
                Random r4 = new Random();
                Random r5 = new Random();

                if (fo.f1 > 0) {
                    jt1.setText(r1.nextInt(fo.f1) + "");
                } else {
                    jt1.setText("0");
                }

                if (fo.f2 > 0) {
                    jt2.setText(r2.nextInt(fo.f2) + "");
                } else {
                    jt2.setText("0");
                }
                if (fo.f3 > 0) {
                    jt3.setText(r3.nextInt(fo.f3) + "");

                } else {
                    jt3.setText("0");
                }
                if (fo.f4 > 0) {
                    jt4.setText(r4.nextInt(fo.f4) + "");
                } else {
                    jt4.setText("0");
                }
                if (fo.f5 > 0) {
                    jt5.setText(r5.nextInt(fo.f5) + "");
                } else {
                    jt5.setText("0");
                }
                // System.out.println(fo.f1 + " " + fo.f2 + " " + fo.f3 + " " + fo.f4 + " " +
                // fo.f5);

            }
        });

        eggshowsum.setBounds(44, 15, 100, 20);

        monjl2.setBounds(0, 0, 400, 35);
        monjl2.setHorizontalAlignment(JLabel.CENTER);

        eggsell.setBounds(44, 60, 40, 20);
        eggsell.setHorizontalAlignment(JTextField.CENTER);
        eggsell.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        eggsell.setOpaque(false);

        jp.setLayout(null);
        jp.setBackground(new Color(200, 180, 100));

        b.setSize(200, 100);
        b.setOpaque(false);
        d.setSize(200, 100);
        d.setOpaque(false);

        jbtnf.setBounds(30, 60, 65, 35);

        jbtnf.setBackground(Color.GRAY);
        jbtnf.setForeground(Color.WHITE);

        jbtnsell.setBounds(44, 110, 40, 20);
        jbtnsell.setBackground(Color.GRAY);
        jbtnsell.setForeground(Color.WHITE);
        jbtnsell.setMargin(new Insets(0, 0, 0, 0));
        //
        //

        zone.setTitleColor(Color.WHITE);
        zone.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

        jpzone.setBackground(new Color(200, 180, 100));

        jpzone.setBorder(zone);

        jpzone.setBounds(10, 28, 125, 140);
        jpzone.setLayout(null);
        jp.add(jpzone);

        // fish icon

        jicon.setBounds(30, 30, 65, 35);
        jicon.setHorizontalAlignment(JLabel.CENTER);
        jicon.setForeground(Color.WHITE);

        maybeget.setBounds(44, 85, 40, 20);
        maybeget.setHorizontalAlignment(JLabel.CENTER);
        maybeget.setEditable(false);

        maybeget.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        maybeget.setOpaque(false);

        jpzone.add(jbtnsell);
        jpzone.add(eggshowsum);
        jpzone.add(maybeget);
        jpzone.add(d);
        jpzone.add(b);
        jpzone.add(eggsell);
        jp.add(monjl2);
        // jp.add(jbtnf);
        jpzone.add(jicon);

        jif2.setContentPane(jp);

    }

    public void egg1sumfun(int newegg1) {
        egg1sum = egg1sum + newegg1;
        eggshowsum.setText("egg : " + egg1sum);

    }

    public void setmoney(int newmoney, int newfish, int newpet, int newegg) {
        money = newmoney;
        petSum = newpet;
        fishSum = newfish;
        egg1sum = newegg;
        monjl.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                + "          pet : " + String.valueOf(petSum));
        monjl2.setText("money : " + String.valueOf(money) + "          fish : " + String.valueOf(fishSum)
                + "          pet : " + String.valueOf(petSum));

    }

    // public int getf1(){

    // return f1;

    // };
    // public int getf2(){
    // return f2;
    // };

    // public int getf3(){
    // return f3;
    // };
    // public int getf4(){
    // return f4;
    // };

    // public int getf5(){
    // return f5;
    // };

    private void init3() {

        JPanel jp3 = new JPanel();
        jp3.setLayout(null);

        // select color
        scrR.setBounds(30, 20, 10, 170);
        scrG.setBounds(60, 20, 10, 170);
        scrB.setBounds(90, 20, 10, 170);

        scrR.setMaximum(255);
        scrG.setMaximum(255);
        scrB.setMaximum(255);

        jp3.add(scrR);
        jp3.add(scrG);
        jp3.add(scrB);

        jtp.addTab("decorate", jif3);
        this.setBackground(Color.WHITE);
        jp3.setBackground(new Color(200, 180, 100));
        jif3.setContentPane(jp3);

        //

        JButton musicjbtn = new JButton("change song"); // now function is change;
        JButton starjbtn = new JButton("start"); // now function is change;
        JButton stopjbtn = new JButton("stop"); // now function is change;
        // JButton musicstopjbtn = new JButton("Stop");
        // JButton musicstarjbtn = new JButton("Star");
        // JButton musicchangejbtn = new JButton("Change");

        musicjbtn.setBounds(200, 120, 100, 30);
        jp3.add(musicjbtn);
        musicjbtn.setMargin(new Insets(0, 0, 0, 0));
        musicjbtn.setBackground(Color.GRAY);
        musicjbtn.setForeground(Color.WHITE);

        starjbtn.setBounds(160, 120, 35, 30);
        jp3.add(starjbtn);
        starjbtn.setMargin(new Insets(0, 0, 0, 0));
        starjbtn.setBackground(Color.GRAY);
        starjbtn.setForeground(Color.WHITE);

        stopjbtn.setBounds(305, 120, 35, 30);
        jp3.add(stopjbtn);
        stopjbtn.setMargin(new Insets(0, 0, 0, 0));
        stopjbtn.setBackground(Color.GRAY);
        stopjbtn.setForeground(Color.WHITE);

        slider.setBounds(150, 100, 200, 20);
        slider.setEnabled(false);
        slider.setOpaque(false);
        jif3.add(slider);

        jbtnrandomcolor.setBounds(110, 20, 50, 30);
        jp3.add(jbtnrandomcolor);
        jbtnrandomcolor.setMargin(new Insets(0, 0, 0, 0));
        jbtnrandomcolor.setBackground(new Color(200, 180, 100));
        jbtnrandomcolor.setBorder(BorderFactory.createLineBorder(new Color(128, 228, 228), 5, true));
        jbtnrandomcolor.setForeground(new Color(128, 228, 228));
        jbtnrandomcolor.setOpaque(false);
        starjbtn.setEnabled(false);

        jbtnrandomcolor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (!colorflag) {
                    colorflag = true;
                } else {
                    colorflag = false; // to control the cp's color
                }

            }
        });

        starjbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                music.clip.loop(Clip.LOOP_CONTINUOUSLY);
                starjbtn.setEnabled(false);
                stopjbtn.setEnabled(true);

            }
        });

        musicjbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                starjbtn.setEnabled(false);
                songnumber++;
                songnumber = songnumber % 2;
                music.clip.stop();
                music.interrupt();
                music = new fomusic();
                music.file = new File(songs[songnumber] + ".wav"); // change path
                System.out.print(songs[songnumber]);
                music.start();
                flag = false;
                stopjbtn.setEnabled(true);

            }
        });

        stopjbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                music.clip.stop();
                stopjbtn.setEnabled(false);
                starjbtn.setEnabled(true);
            }
        });

    }

}

class TriangleButton extends JButton {
    private Shape triangle = createTriangle();

    public void paintBorder(Graphics g) {
        ((Graphics2D) g).draw(triangle);
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(204, 0, 0));
        ((Graphics2D) g).fill(triangle);
    }

    public Dimension getPreferredSize() {
        return new Dimension(20, 10);
    }

    public boolean contains(int x, int y) {
        return triangle.contains(x, y);
    }

    private Shape createTriangle() {
        Polygon p = new Polygon();
        p.addPoint(90, 75); // left
        p.addPoint(95, 64); // top
        p.addPoint(100, 75); // right
        return p;
    }
}

class TriangleButton2 extends JButton {
    private Shape triangle = createTriangle();

    public void paintBorder(Graphics g) {
        ((Graphics2D) g).draw(triangle);
    }

    public void paintComponent(Graphics g) {
        // g.setColor(new Color(204,0,0));
        ((Graphics2D) g).fill(triangle);
    }

    public Dimension getPreferredSize() {
        return new Dimension(20, 10);
    }

    public boolean contains(int x, int y) {
        return triangle.contains(x, y);
    }

    private Shape createTriangle() {
        Polygon p = new Polygon();
        p.addPoint(28, 64); // left
        p.addPoint(33, 75); // top
        p.addPoint(38, 64); // right
        return p;
    }

}
