
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import java.awt.Graphics;

import javax.swing.event.MouseInputAdapter;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

public class foFrame extends JFrame {

    int R = 128;
    int G = 228;
    int b = 228; 

    Boolean shop = false;
    Boolean chatRoomOp = false;
    Boolean feed = false;

    foShop2Frame sh2frm ;
    Container cp = this.getContentPane();

    // feeding
    int change = -1;

    JLabel foodnowJLabel = new JLabel("feeding");

    JLabel foods[] = new JLabel[5];
    int fooddug = 0;

    static int foodcanuse[] = { 1, 1, 1, 1, 1 };
    Rectangle recfood[] = new Rectangle[5];

    // produce food time

    // touch to stop fish
    int refood = 0;
    int foodnum = 5;

    // show info

    JLabel wow = new JLabel("food : 5 fish : 0 pet : 0");
    int fish_s = 0, pet_s = 0;
    int count = 5;
    // fish

    ArrayList<jfish1> jf1 = new ArrayList<jfish1>();
    ArrayList<jfish2> jf2 = new ArrayList<jfish2>();
    ArrayList<jfish3> jf3 = new ArrayList<jfish3>();
    ArrayList<jfish4> jf4 = new ArrayList<jfish4>();
    ArrayList<jfish5> jf5 = new ArrayList<jfish5>();

    // menu
    JMenuBar menubar;
    JMenu menu, subMenu;
    JMenuItem itemFeed, itemCol, itemChat, itemShop;
    int egg1infoFrame = 0;
    // egg

    int eq2 = 0;
    ArrayList<JLabel> egg2 = new ArrayList<JLabel>();
    // ArrayList<JLabel> egg3 = new ArrayList<JLabel>();

    int whichfish = 0;
    ArrayList<Rectangle> eggRe2 = new ArrayList<Rectangle>();
    // String egg3Img[] = { "Egg", "is...", "Yummy", "!!!" };
    // collect
    boolean eggpick = false;
    JLabel eggpicknowJLabel = new JLabel("collecting");
    JPanel jpsc = new JPanel();

    public foFrame(fomusic music) {

        init();
        menu();
        sh2frm = new foShop2Frame(music);
    }

    public void init() {

        this.setBounds(100, 100, 400, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp.setBackground(new Color(128, 228, 228));
        cp.setLayout(null);
        this.setBackground(Color.WHITE);

        // jpsc.setBackground(new Color(255,255,255,0));
        // jpsc.setBounds(0, 0, 400, 300);
        // jpsc.setOpaque(true);
        this.setResizable(false);
        // cp.add(jpsc);

        wow.setBounds(230, 0, 155, 40);
        cp.add(wow);

        foodnowJLabel.setBounds(5, 7, 50, 25);
        foodnowJLabel.setBackground(Color.PINK);
        foodnowJLabel.setOpaque(true);
        foodnowJLabel.setHorizontalAlignment(JTextField.CENTER);
        cp.add(foodnowJLabel);
        foodnowJLabel.setVisible(false);

        eggpicknowJLabel.setBounds(5, 38, 60, 25);
        eggpicknowJLabel.setBackground(new Color(240, 230, 25));
        eggpicknowJLabel.setOpaque(true);
        eggpicknowJLabel.setHorizontalAlignment(JTextField.CENTER);
        cp.add(eggpicknowJLabel);
        eggpicknowJLabel.setVisible(false);

        for (int i = 0; i < 5; i++) {
            foods[i] = new JLabel(",");
        }

        foods[0].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                // pickfood to recycle food
                if (fooddug == 1) {
                    JLabel tmpJLabel = (JLabel) e.getSource();

                    cp.remove(tmpJLabel);
                    int tmpnum = 0;

                    for (int y = 0; y < 5; y++) {
                        if (tmpJLabel == foods[y]) {
                            tmpnum = y;
                        }
                    }

                    foodtime ff[] = new foodtime[5];
                    recfood[tmpnum] = remove(recfood);
                    cp.revalidate();
                    cp.repaint();
                    // cp.repaint();
                    ff[tmpnum] = new foodtime(tmpnum);
                    ff[tmpnum].start();
                }

            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        foods[1].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                // pickfood to recycle food
                if (fooddug == 1) {

                    JLabel tmpJLabel = (JLabel) e.getSource();

                    cp.remove(tmpJLabel);

                    int tmpnum = 0;

                    for (int y = 0; y < 5; y++) {
                        if (tmpJLabel == foods[y]) {
                            tmpnum = y;
                        }
                    }

                    foodtime ff[] = new foodtime[5];
                    recfood[tmpnum] = remove(recfood);
                    cp.revalidate();
                    cp.repaint();
                    // cp.repaint();
                    ff[tmpnum] = new foodtime(tmpnum);
                    ff[tmpnum].start();
                }

            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

        foods[2].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                // pickfood to recycle food
                if (fooddug == 1) {

                    JLabel tmpJLabel = (JLabel) e.getSource();

                    cp.remove(tmpJLabel);
                    int tmpnum = 0;

                    for (int y = 0; y < 5; y++) {
                        if (tmpJLabel == foods[y]) {
                            tmpnum = y;
                        }
                    }

                    foodtime ff[] = new foodtime[5];
                    recfood[tmpnum] = remove(recfood);
                    // cp.repaint();
                    ff[tmpnum] = new foodtime(tmpnum);
                    ff[tmpnum].start();
                    cp.revalidate();
                    cp.repaint();
                }

            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

        foods[3].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                // pickfood to recycle food

                if (fooddug == 1) {
                    JLabel tmpJLabel = (JLabel) e.getSource();

                    cp.remove(tmpJLabel);
                    int tmpnum = 0;

                    for (int y = 0; y < 5; y++) {
                        if (tmpJLabel == foods[y]) {
                            tmpnum = y;
                        }
                    }

                    foodtime ff[] = new foodtime[5];
                    recfood[tmpnum] = remove(recfood);
                    cp.revalidate();
                    cp.repaint();
                    // cp.repaint();
                    ff[tmpnum] = new foodtime(tmpnum);
                    ff[tmpnum].start();
                }

            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

        foods[4].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                // pickfood to recycle food

                if (fooddug == 1) {

                    JLabel tmpJLabel = (JLabel) e.getSource();

                    cp.remove(tmpJLabel);
                    cp.revalidate();
                    cp.repaint();
                    int tmpnum = 0;

                    for (int y = 0; y < 5; y++) {
                        if (tmpJLabel == foods[y]) {
                            tmpnum = y;
                        }
                    }

                    foodtime ff[] = new foodtime[5];
                    recfood[tmpnum] = remove(recfood);
                    // cp.repaint();
                    ff[tmpnum] = new foodtime(tmpnum);
                    ff[tmpnum].start();
                }

            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });



    }

    public void menu() {

        menubar = new JMenuBar();
        menu = new JMenu("MENU");

        subMenu = new JMenu("Shop");
        itemChat = new JMenuItem("Chat");
        itemFeed = new JMenuItem("Feed");
        itemCol = new JMenuItem("Collect");
        itemShop = new JMenuItem("Shop");

        // itemFeed.setAccelerator(KeyStroke.getKeyStroke('A'));
        // itemCol.setAccelerator(KeyStroke.getKeyStroke('D'));
        // itemChat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
        // InputEvent.CTRL_MASK));

        menu.add(itemChat);
        menu.add(itemFeed);
        menu.add(itemCol);
        menu.addSeparator();
        menu.add(itemShop);

        JMenuItem itemfish = new JMenuItem("fish");
        JMenuItem itemsell = new JMenuItem("sell");
        subMenu.add(itemfish);
        subMenu.add(itemsell);
        menubar.add(menu);
        setJMenuBar(menubar);

        itemChat.setBackground(new Color(179, 237, 251));
        itemFeed.setBackground(Color.PINK);
        itemCol.setBackground(new Color(240, 230, 25));

        subMenu.setBackground(Color.WHITE);
        subMenu.setOpaque(true);

        menu.setBackground(Color.WHITE);
        menu.setOpaque(true);

        menubar.setBackground(Color.WHITE);
        menubar.setOpaque(true);

        // itemfish.setBackground(new Color(240,220,240));
        // itemsell.setBackground(new Color(197,202,241));

        itemfish.setBackground(Color.WHITE);
        itemsell.setBackground(Color.WHITE);

        itemChat.addMouseListener((MouseListener) new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                chatRoomOp = true;
            }
        });

        itemShop.addMouseListener((MouseListener) new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);

                shop = true;
            }
        });

        itemFeed.addMouseListener((MouseListener) new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);

                fooddug++;
                if (fooddug % 2 == 1) {
                    foFrame.this.setCursor(CROSSHAIR_CURSOR);
                    foodnowJLabel.setVisible(true);
                    // eggpicknowJLabel.setLocation(5,38);
                    eggpicknowJLabel.setVisible(false);
                    eggpick = false;
                    // change = findfood();

                    if (count == 0) {
                        JOptionPane.showMessageDialog(cp, "You don't have food ... QQ ", " wait ! ",
                                JOptionPane.ERROR_MESSAGE);
                        foFrame.this.setCursor(WAIT_CURSOR);
                    }

                } else {
                    foFrame.this.setCursor(0);
                    foodnowJLabel.setVisible(false);
                    eggpicknowJLabel.setLocation(5, 7);
                }

                fooddug = fooddug % 2;

            }
        });

        itemCol.addMouseListener((MouseListener) new MouseInputAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);

                if (eggpick == false) {
                    foFrame.this.setCursor(HAND_CURSOR);
                    eggpick = true;
                    eggpicknowJLabel.setLocation(5, 7);
                    eggpicknowJLabel.setVisible(true);
                    fooddug = 0;
                    foodnowJLabel.setVisible(false);
                } else {
                    foFrame.this.setCursor(0); // the cursor is orignal one
                    eggpick = false;
                    eggpicknowJLabel.setVisible(false);

                }

            }
        });

        cp.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {

                foodnum = findfood();

                // TODO Auto-generated method stub
                if (e.getButton() == e.BUTTON3 && fooddug % 2 == 1 && foodnum >= 0) {

                    foods[foodnum].setBounds(e.getX() - 15, e.getY() - 15, 25, 25);
                    foods[foodnum].setFont(new Font(null, Font.PLAIN, 30));
                    foods[foodnum].setHorizontalAlignment(JLabel.CENTER);

                    foods[foodnum].setForeground(new Color(170,100,30));
                    // foods[foodnum].setOpaque(true);;

                    recfood[foodnum] = new Rectangle(e.getX(), e.getY(), 3, 3);

                    cp.add(foods[foodnum]);
                    // foods[foodnum].repaint();

                    foodcanuse[foodnum] = 0;

                    count = fooodCheckCount();

                    wow.setText("food : " + (count) + " fish : " + (fish_s) + " pet : " + (pet_s));
                    // add food mouseListner
                    foods[foodnum].addMouseListener(new MouseListener() {

                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent e) {
                            // TODO Auto-generated method stub
                            // pickfood to recycle food

                            JLabel tmpJLabel = (JLabel) e.getSource();

                            cp.remove(tmpJLabel);
                            int tmpnum = 0;

                            for (int y = 0; y < 5; y++) {
                                if (tmpJLabel == foods[y]) {
                                    tmpnum = y;
                                }
                            }

                            foodtime ff[] = new foodtime[5];
                            recfood[tmpnum] = remove(recfood);
                            // cp.repaint();
                            ff[tmpnum] = new foodtime(tmpnum);
                            ff[tmpnum].start();

                        }

                        @Override
                        public void mousePressed(java.awt.event.MouseEvent e) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void mouseReleased(java.awt.event.MouseEvent e) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void mouseEntered(java.awt.event.MouseEvent e) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void mouseExited(java.awt.event.MouseEvent e) {
                            // TODO Auto-generated method stub

                        }
                    });

                    //

                } else if (foodnum < 0 && fooddug % 2 == 1) {
                    JOptionPane.showMessageDialog(cp, "You don't have food ... QQ ", " wait ! ",
                            JOptionPane.ERROR_MESSAGE);
                    foFrame.this.setCursor(WAIT_CURSOR);
                }

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });

    }

    public int findfood() {
        int flag = 0;
        int i = 0;

        for (i = 0; i < 5; i++) {
            if (foodcanuse[i] == 1) {
                flag = 1;
                return i;
            }
        }

        if (flag == 0) {
            return -1;
        } else {
            return i - 1;
        }

    }

    public void fishow(int af) {
        jf1.add(new jfish1());
        jf1.get(af).fishow();
        cp.add(jf1.get(af).jlabel);
        pet_s++;
        wow.setText("food : " + (count) + " fish : " + (fish_s) + " pet : " + (pet_s));
    }

    public void fishow2(int bf) {

        jf2.add(new jfish2());
        jf2.get(bf).fishow();
        cp.add(jf2.get(bf).jlabel);
        whichfish = bf;
        fish_s++;
        wow.setText("food : " + (count) + " fish : " + (fish_s) + " pet : " + (pet_s));
    }

    public void fishow3(int cf) {
        jf3.add(new jfish3());
        jf3.get(cf).fishow();
        cp.add(jf3.get(cf).jlabel);
        fish_s++;
        wow.setText("food : " + (count) + " fish : " + (fish_s) + " pet : " + (pet_s));

    }

    public void fishow4(int df) {
        jf4.add(new jfish4());
        jf4.get(df).fishow();
        pet_s++;
        cp.add(jf4.get(df).jlabel);
        wow.setText("food : " + (count) + " fish : " + (fish_s) + " pet : " + (pet_s));

    }

    public void fishow5(int ef) {
        jf5.add(new jfish5());
        jf5.get(ef).fishow();
        cp.add(jf5.get(ef).jlabel);
        pet_s++;
        wow.setText("food : " + (count) + " fish : " + (fish_s) + " pet : " + (pet_s));
        j5food(ef);
    }

    class foodtime extends Thread {

        private int frunind;

        public foodtime(int foodind) {

            frunind = foodind;

        }

        public void run() {

            try {

                sleep(1000 * 15);
                foodcanuse[frunind] = 1;
                count = fooodCheckCount();
                wow.setText("food : " + (count) + " fish : " + (fish_s) + " pet : " + (pet_s));

            } catch (Exception e) {
                System.out.println("idj");
            }

        }

    }

    public void jLabelForward(int a) {
        foodtime ff[] = new foodtime[5];

        int flag = 0;

        for (int i = 0; i < 5; i++) {
            if (foodcanuse[i] == 0 && recfood[i] != null &&
                    jf1.get(a).Rec.intersects(recfood[i])) {
                flag = 1;
                cp.remove(foods[i]);
                recfood[i] = remove(recfood);
                // cp.repaint();
                ff[i] = new foodtime(i);
                ff[i].start();
            }
        }
        if (flag == 0) {

            jf1.get(a).jLabelForward();

        }
    }

    public void jLabel2Forward(int b) {
        foodtime ff[] = new foodtime[5];

        int flag = 0;

        for (int i = 0; i < 5; i++) {
            if (foodcanuse[i] == 0 && recfood[i] != null &&
                    jf2.get(b).Rec.intersects(recfood[i])) {
                flag = 1;
                jf2.get(b).eggtimelimit = jf2.get(b).eggtimelimit - 10;
                cp.remove(foods[i]);
                recfood[i] = remove(recfood);
                // cp.repaint();
                ff[i] = new foodtime(i);
                ff[i].start();
            }
        }

        if (flag == 0) {
            jf2.get(b).jLabelForward();

        }
    }

    public void jLabel3Forward(int c) {
        foodtime ff[] = new foodtime[5];

        int flag = 0;

        for (int i = 0; i < 5; i++) {
            if (foodcanuse[i] == 0 && recfood[i] != null && jf3.get(c).Rec.intersects(recfood[i])) {
                flag = 1;
                cp.remove(foods[i]);
                recfood[i] = remove(recfood);
                ff[i] = new foodtime(i);
                ff[i].start();

            }
        }
        if (flag == 0) {

            jf3.get(c).jLabelForward();

        }

    }

    public void jLabel4Forward(int d) {

        int flag = 0;

        for (int i = 0; i < eggRe2.size(); i++) {

            if (i >= eggRe2.size()) {
                // System.out.println(i + " " + eggRe2.size() + " " + "jj");
                return;
            } else {

                if (i < eggRe2.size() && egg2.get(i) != null && eggRe2.get(i) != null
                        && jf4.get(d).Rec.intersects(eggRe2.get(i))) {
                    // System.out.println(i + " " + eggRe2.size() + " " + "jj");

                    egg1infoFrame++;
                    cp.revalidate();
                    cp.remove(egg2.get(i));
                    cp.revalidate();
                    cp.repaint();
                    egg2.remove(i);
                    eggRe2.remove(i);
                    flag = 1;
                    return;
                }

                if ((i < eggRe2.size()) && (egg2.get(i) != null) && (eggRe2.get(i) != null)
                        && (egg2.get(i).getY()) > 300 && (eggRe2.get(i).getY() > 300)) {

                    cp.revalidate();
                    cp.remove(egg2.get(i));
                    cp.revalidate();
                    cp.repaint();
                    // Rectangle tmpRectangle = removeEgg();
                    // eggRe2.set(i,tmpRectangle);
                    egg2.remove(i);
                    eggRe2.remove(i);

                    // cp.repaint();
                }

            }

        }
        if (flag == 0) {

            jf4.get(d).jLabelForward();
        }

    }

    // public void jLabel5Forward(int x, int e) throws InterruptedException {

    public void jLabel5Forward(int e) {

        jf5.get(e).jLabelForward();

    }

    public void foodForward(int f) {
        if (foods[f].getBounds().y < 200 && recfood[f] != null) {
            foods[f].setLocation(foods[f].getBounds().x, foods[f].getBounds().y + 1);
            recfood[f].setLocation(foods[f].getX() + 15, foods[f].getY() + 16);
        }
    };

    public int fooodCheckCount() {

        count = 0;

        for (int j = 0; j < 5; j++) {
            if (foodcanuse[j] == 1) {
                count++;
            }
        }

        return count;
    }

    private Rectangle remove(Rectangle[] recfood2) {
        return null;
    }

    private void j5food(int j5) {

        Timer foodtimer = new Timer(1000 * 20, new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                foodnum = findfood();

                if (foodnum >= 0) {
                    cp.revalidate();
                    repaint();
                    if (fo.f5 > j5) {
                        foods[foodnum].setBounds(jf5.get(j5).jlabel.getX() + 15, jf5.get(j5).jlabel.getY(), 25, 25);
                        foods[foodnum].setFont(new Font(null, Font.PLAIN, 30));
                        foods[foodnum].setForeground(new Color(170,100,30));
                        foods[foodnum].setHorizontalAlignment(JLabel.CENTER);
                        recfood[foodnum] = new Rectangle(jf5.get(j5).jlabel.getX(), jf5.get(j5).jlabel.getY(), 3, 3);
                        cp.add(foods[foodnum]);
                        // foods[foodnum].repaint();
                        foodcanuse[foodnum] = 0;
                    }
                    count = 0;

                    for (int j = 0; j < 5; j++) {
                        if (foodcanuse[j] == 1) {
                            count++;
                        }
                    }

                    wow.setText("food : " + (count) + " fish : " + (fish_s) + " pet : " + (pet_s));

                }
            }

        });

        foodtimer.start();

    }

    public void tryeggborn(int time, int thisfish) {

        if (time >= jf2.get(thisfish).eggtimelimit) {

            // System.out.println(time);
            JLabel tmpegg = new JLabel("O");
            tmpegg.setForeground(Color.WHITE);
            // tmpegg.setOpaque(true);
            // tmpegg.setOpaque(true);
            egg2.add(tmpegg);
            egg2.get(egg2.size() - 1).setBounds(jf2.get(thisfish).jlabel.getX(),
                    jf2.get(thisfish).jlabel.getY(), 10, 10);
            cp.revalidate();
            cp.add(egg2.get(egg2.size() - 1));
            cp.revalidate();
            // cp.repaint();
            int eggnum = egg2.size() - 1;

            Rectangle tmpRe = new Rectangle(egg2.get(eggnum).getX(),
                    egg2.get(eggnum).getY(), 10, 10);

            cp.revalidate();
            eggRe2.add(tmpRe);
            cp.revalidate();
            egg2.get(egg2.size() - 1).addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub
                    if (eggpick) {

                        egg1infoFrame++;

                        JLabel tmpJLabel = (JLabel) e.getSource();
                        int whichegg = egg2.indexOf(tmpJLabel);

                        cp.remove(egg2.get(whichegg));
                        cp.repaint();

                        eggRe2.remove(whichegg);
                        egg2.remove(whichegg);
                        cp.revalidate();
                        cp.repaint();
                    }

                    // egg2.set(egg2.size()-1 , null);

                }

                @Override
                public void mousePressed(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub

                }
            });
        }

    }

}
