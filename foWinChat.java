import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.sql.Timestamp;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class foWinChat extends JFrame {

    foChatClient chatClient;
    Container cp;
    String st = "";
    JTextField jtf = new JTextField(5);
    JTextArea tf = new JTextArea();
    JScrollPane jsp = new JScrollPane(tf);

    JButton jbtnSend = new JButton("Send");
    JButton jbtnStart = new JButton("Connect");
    JButton jbtnExit = new JButton("Exit");

    JLabel jlb1 = new JLabel("IP : ");
    JLabel jlb2 = new JLabel("Port : ");

    JTextField jtfIP = new JTextField();
    JTextField jtfId = new JTextField();

    String fontkind[] = { "null", "Times New Roman", "Comic Sans MS", "Viner Hand ITC", "Mistral", "..." };
    JComboBox chList = new JComboBox(fontkind);
    String str = new String();

    JButton bkcolor = new JButton();
    JButton txareacolor = new JButton();
    JButton txcolor = new JButton();

    JButton btncolor = new JButton();
    JButton orcolor = new JButton();

    // try to send Pic

    JButton pic = new JButton();

    ImageIcon docimg = new ImageIcon("doc.jpg");
    JButton jbtndoc = new JButton(docimg);
    // ImageIcon imageIcon = new ImageIcon("D1050886_p1.jpg");

    ImageIcon picimg = new ImageIcon("img.jpg");
    JButton jbtnpic = new JButton(picimg);
    Boolean flag = false;
    //

    // JPanel jpnHostPane = new JPanel(new GridLayout(1,5,3,3));

    public foWinChat() {
        init();
    }

    private void init() {

        tf.setEditable(false); // make player cant't edit their chatting record
        this.setTitle("Chat Room 1 ");

        cp = this.getContentPane();
        cp.setLayout(null);
        cp.setBackground(new Color(100, 200, 200));
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 400, 400, 300);

        // chatClient.setchatname(this.getTitle());

        jbtnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO Auto-generated method stub

                chatClient.start();
                chatClient.setchatname(foWinChat.this.getTitle());
                jbtnSend.setEnabled(true);
                jbtndoc.setEnabled(true);
                jbtnpic.setEnabled(true);
                flag = true;

            }
        });

        jbtnExit.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO Auto-generated method stub
                chatClient.disConnect();
                foWinChat.this.dispose();

            }
        });

        jbtnSend.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                if (chatClient != null && !jtf.getText().equals("") && flag) {
                    chatClient.sendMsg(jtf.getText());
                    jtf.setText("");
                }
            }
        });

        jbtndoc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO Auto-generated method stub
                if (chatClient != null && flag) {
                    chatClient.sendfile();
                }

            }
        });

        jbtnpic.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO Auto-generated method stub

                if (chatClient != null && flag) {
                    try {
                        chatClient.sendpic();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });

        chList.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {

                    str = (String) event.getItem();
                    if (str.equals("...")) {
                        str = (String) JOptionPane.showInputDialog(null, "input your text type\n", "wait",
                                JOptionPane.PLAIN_MESSAGE);
                    }
                    tf.setFont(new Font(str, Font.PLAIN, 12));
                }
            }
        });

        bkcolor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                Color color = JColorChooser.showDialog(foWinChat.this, "which One? ", null);

                if (color == null) {
                    return;
                }
                cp.setBackground(color);
                bkcolor.setBackground(color);
                orcolor.setEnabled(true);
            }

        });

        txareacolor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                Color color = JColorChooser.showDialog(foWinChat.this, "which One? ", null);

                if (color == null) {
                    return;
                }
                tf.setBackground(color);
                txareacolor.setBackground(color);
                orcolor.setEnabled(true);
            }

        });

        txcolor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                Color color = JColorChooser.showDialog(foWinChat.this, "which One? ", null);

                if (color == null) {
                    return;
                }
                tf.setForeground(color);
                txcolor.setBackground(color);
                orcolor.setEnabled(true);
            }

        });

        btncolor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                Color color = JColorChooser.showDialog(foWinChat.this, "which One? ", null);

                if (color == null) {
                    return;
                }
                jbtnExit.setBackground(color);
                jbtnSend.setBackground(color);
                jbtnStart.setBackground(color);
                btncolor.setBackground(color);
                orcolor.setEnabled(true);
            }

        });

        orcolor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                cp.setBackground(new Color(100, 200, 200));
                tf.setBackground(Color.WHITE);
                tf.setForeground(Color.BLACK);
                jbtnSend.setBackground(Color.GRAY);
                jbtnSend.setForeground(Color.WHITE);
                jbtnStart.setBackground(Color.GRAY);
                jbtnStart.setForeground(Color.WHITE);
                jbtnExit.setBackground(Color.GRAY);
                jbtnExit.setForeground(Color.WHITE);
                orcolor.setEnabled(false);

                bkcolor.setBackground(new Color(100, 200, 200));
                txareacolor.setBackground(Color.WHITE);
                txcolor.setBackground(Color.BLACK);

                btncolor.setBackground(Color.GRAY);

            }

        });

        jtf.setBounds(15, 225, 208, 30);

        jlb1.setBounds(3, 5, 38, 10);
        jlb2.setBounds(3, 22, 38, 10);
        jlb1.setHorizontalAlignment(JLabel.RIGHT);
        jlb2.setHorizontalAlignment(JLabel.RIGHT);

        jbtnExit.setBounds(305, 5, 60, 30);
        jbtnExit.setBackground(Color.GRAY);
        jbtnExit.setForeground(Color.WHITE);
        jbtnExit.setHorizontalAlignment(JButton.CENTER);

        jbtnStart.setBounds(135, 5, 83, 30);
        jbtnStart.setBackground(Color.GRAY);
        jbtnStart.setForeground(Color.WHITE);
        jbtnStart.setHorizontalAlignment(JButton.CENTER);

        jtfIP.setBounds(40, 3, 90, 16);
        jtfId.setBounds(40, 20, 90, 16);

        chatClient = new foChatClient(foWinChat.this);
        jtfIP.setText("127.0.0.1");
        jtfId.setText(chatClient.getPort() + "");
        System.out.println(chatClient.getPort());

        jbtnSend.setBounds(295, 225, 70, 30);
        jsp.setBounds(15, 40, 350, 175);

        jbtnSend.setBackground(Color.GRAY);
        jbtnSend.setForeground(Color.WHITE);

        chList.setBounds(221, 5, 80, 30);
        chList.setBackground(Color.WHITE);

        bkcolor.setBounds(370, 40, 10, 10);
        bkcolor.setBackground(new Color(100, 200, 200));

        txareacolor.setBounds(370, 55, 10, 10);
        txareacolor.setBackground(Color.WHITE);

        txcolor.setBounds(370, 70, 10, 10);
        txcolor.setBackground(Color.BLACK);

        btncolor.setBounds(370, 85, 10, 10);
        btncolor.setBackground(Color.GRAY);

        orcolor.setBounds(370, 5, 10, 10);
        orcolor.setEnabled(false);

        // btndoc.setBackground(Color.GRAY);
        jbtndoc.setBounds(261, 225, 30, 30);
        jbtndoc.setContentAreaFilled(false);
        jbtndoc.setOpaque(false);

        jbtnpic.setBounds(227, 225, 30, 30);
        jbtnpic.setContentAreaFilled(false);
        jbtnpic.setOpaque(false);

        jbtnSend.setEnabled(false);
        jbtndoc.setEnabled(false);
        jbtnpic.setEnabled(false);

        cp.add(jbtnpic);
        cp.add(jbtndoc);

        cp.add(jtfIP);
        cp.add(jtfId);
        // cp.add(jtfPort);
        cp.add(jsp);
        cp.add(jtf);
        cp.add(jbtnSend);
        cp.add(jbtnStart);
        cp.add(jbtnExit);
        cp.add(jlb1);
        cp.add(jlb2);

        cp.add(chList);

        cp.add(bkcolor);
        cp.add(txareacolor);
        cp.add(txcolor);
        cp.add(btncolor);
        cp.add(orcolor);

        // cp.add(tf);

    }

    public void appendMessage(String msg) {
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        tf.append(timestamp + "\n  " + msg + "\n\n");
    }

    public String getServerIP() {
        return jtfIP.getText();
    }

    public int getPort() {
        return Integer.parseInt(jtfId.getText());
    }

}
