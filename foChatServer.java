import java.net.*;
import java.nio.ByteBuffer;
import java.util.Scanner;
import java.util.logging.ErrorManager;
import java.io.*;
import java.awt.*;
import javax.swing.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;

public class foChatServer extends Thread {

    String hostIP, hostName;
    InetAddress inetAddr;
    int port = 5300;
    Socket socket;
    OutputStream outStream;
    InputStream inStream;
    ServerSocket serverSocket;
    foWinChat2 chatFram;
    fodraw2 tmpshow = new fodraw2();
    String clientname;

    public foChatServer(foWinChat2 frm) {
        this.setDaemon(true);
        chatFram = frm;
        try {

            inetAddr = InetAddress.getLocalHost();
            hostIP = inetAddr.getHostAddress();
            hostName = inetAddr.getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("Can't find IP information ~ ");
        }

    }

    public void run() {

        byte data[] = new byte[1024];
        int n = 0;
        Boolean fileBoolean = false;
        Boolean imageBoolean = false;

        try {
            serverSocket = new ServerSocket(port);
            chatFram.appendMessage("Server start, waitting client connect.......");
            chatFram.repaint();
            socket = serverSocket.accept();
            chatFram.appendMessage(
                    "Client connect ! \n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            inStream = socket.getInputStream();
            n = inStream.read(data);
            clientname = new String(data, 0, n);
            chatFram.jbtnSend.setEnabled(true);
            chatFram.jbtndoc.setEnabled(true);
            chatFram.jbtnpic.setEnabled(true);

            outStream = socket.getOutputStream();

            while (true) { //

                inStream = socket.getInputStream();

                if (fileBoolean) {
                    n = inStream.read(data);
                    String h = new String(data, 0, n);
                    savefile(data, h);
                    fileBoolean = false;
                } else if (imageBoolean) {
                    getpic();
                    imageBoolean = false;
                }
                n = inStream.read(data); //

                if ((new String(data, 0, n)).equals("#disConnect")) {
                    chatFram.appendMessage(clientname + " is disconnect ! ");
                    close(); // close all things
                    break;

                } else {

                    String h = new String(data, 0, n);

                    if (!h.equals("*send a file*") && !h.equals("*send a image*") && !imageBoolean && !fileBoolean) {
                        chatFram.appendMessage(clientname + " : " + h);
                    }

                    if (h.equals("*send a file*")) {
                        chatFram.appendMessage(clientname + " : " + h);
                        fileBoolean = true;
                    } else if (h.equals("*send a image*")) {
                        chatFram.appendMessage(clientname + " : " + h);
                        imageBoolean = true;
                    }
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(chatFram, e.toString(), "Error", 1); // 1 : Error message
        }

    }

    public void sendMsg(String msg) {
        if (socket != null) {
            try {
                outStream.write(msg.getBytes());
                chatFram.appendMessage("Server : " + msg);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(chatFram, e.toString(), "Error", 1);
            }
        }
    }

    public void savefile(byte buf[], String e) throws IOException {
        int yn = (int) JOptionPane.showOptionDialog(null,
                clientname + " send a file,\nDo you want to receive the file ? ",
                "hey",
                JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION, null, null, null);
        String nofile = "";

        String tmpfilestr;

        File New_File;

        while (yn == 0) {

            tmpfilestr = (String) JOptionPane.showInputDialog(null, "Input your file name \n", "wait",
                    JOptionPane.PLAIN_MESSAGE);

            if (tmpfilestr != null) {

                if (!tmpfilestr.equals("")) {
                    New_File = new File(tmpfilestr + ".txt");

                    if (New_File.createNewFile()) {

                        JOptionPane.showMessageDialog(null, "The file is created successfully!", "good",
                                JOptionPane.INFORMATION_MESSAGE);
                        FileWriter fw = new FileWriter(New_File);
                        char data[] = e.toCharArray();
                        fw.write(data);
                        fw.close();
                        chatFram.tf.append("  -- Server save the file in (" + New_File + ") -- \n");

                        fodraw2 tmpshowtext = new fodraw2();
                        tmpshowtext.showtext(New_File);
                        tmpshowtext.setVisible(true);

                        break;

                    } else {
                        nofile = " " + tmpfilestr + " ";
                        JOptionPane.showMessageDialog(null, "The file (" + nofile + ") already exists\ntry again !.",
                                "ERROR", JOptionPane.OK_CANCEL_OPTION);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The file can't be null.", "ERROR",
                            JOptionPane.OK_CANCEL_OPTION);
                }

            } else {

                JFileChooser jfc = new JFileChooser(".//");
                jfc.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
                jfc.addChoosableFileFilter(filter);

                if (jfc.showOpenDialog(chatFram) == JFileChooser.APPROVE_OPTION) {
                    File selectFile = jfc.getSelectedFile();
                    FileWriter fw = new FileWriter(selectFile);
                    char data[] = e.toCharArray();
                    fw.write(data);
                    fw.close();
                    chatFram.tf.append("  -- Server save the file in (" + selectFile + ") -- \n");
                    fodraw2 tmpshowtext = new fodraw2();
                    tmpshowtext.showtext(selectFile);
                    tmpshowtext.setVisible(true);

                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "savinging file is not succeed", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                    chatFram.tf.append("  -- Server have an error to save the image -- \n");
                    break;
                }

            }

        }

        if (yn == 1) {
            chatFram.tf.append("  -- Server refuse to save the file -- \n");
            return;
        }

    }

    public void sendfile() {

        try {

            JFileChooser jfc = new JFileChooser(".//");
            jfc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
            jfc.addChoosableFileFilter(filter);
            if (jfc.showOpenDialog(chatFram) == JFileChooser.APPROVE_OPTION) {
                File selectFile = jfc.getSelectedFile();

                InputStream ins = new FileInputStream(selectFile);
                Scanner obj = new Scanner(ins);
                String ss = new String();

                String sendfilemsg = "*send a file*";

                chatFram.appendMessage("Server : " + sendfilemsg);
                outStream.write(sendfilemsg.getBytes());

                while (obj.hasNextLine()) {
                    ss = ss + obj.nextLine() + '\n';
                }
                // System.out.println(ss);
                outStream.write(ss.getBytes());

            }

            outStream.flush();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //
    public void sendpic() throws InterruptedException, IOException {

        JFileChooser jfc = new JFileChooser(".//");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG images", "png", "jpg");
        jfc.addChoosableFileFilter(filter);

        if (jfc.showOpenDialog(chatFram) == JFileChooser.APPROVE_OPTION) {

            File selectFile = jfc.getSelectedFile();

            String sendfilemsg = "*send a image*";

            chatFram.appendMessage("Server : " + sendfilemsg);
            outStream.write(sendfilemsg.getBytes());

            BufferedImage image = ImageIO.read(selectFile);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", byteArrayOutputStream);

            byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
            outStream.write(size);
            outStream.write(byteArrayOutputStream.toByteArray());
            outStream.flush();
            // System.out.println("Flushed: " + System.currentTimeMillis());

            Thread.sleep(120);

        }

    }
    //

    public void getpic() throws IOException {

        int yn = (int) JOptionPane.showOptionDialog(null,
                clientname + " send an image,\nDo you want to receive an image ? ", "hey",
                JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION, null, null, null);

        String nofile = "";
        String tmpfilestr;

        while (yn == 0) {

            tmpfilestr = (String) JOptionPane.showInputDialog(null, "Input you image name\n", "wait",
                    JOptionPane.PLAIN_MESSAGE);

            if (tmpfilestr == null) {

                JOptionPane.showMessageDialog(null, "saveing the img is not succeed", "ERROR",
                        JOptionPane.OK_CANCEL_OPTION);
                chatFram.tf.append("  -- Server have an error to save the image -- \n");
                byte[] sizeAr = new byte[4];
                inStream.read(sizeAr);
                int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

                byte[] imageAr = new byte[size];
                inStream.read(imageAr);

                return;
            }

            if (tmpfilestr != null && !tmpfilestr.equals("")) {
                int ynexist = 0;
                File New_File = new File(tmpfilestr + ".jpg");

                if (!New_File.createNewFile()) {
                    ynexist = (int) JOptionPane.showOptionDialog(null,
                            "the (" + tmpfilestr + ".jpg ) is exist ,do you want to cover it ? ", "hey",
                            JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION, null, null, null);

                }
                if (New_File.createNewFile() || (ynexist == 0)) {

                    // System.out.println("Reading: " + System.currentTimeMillis());

                    byte[] sizeAr = new byte[4];
                    inStream.read(sizeAr);
                    int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

                    byte[] imageAr = new byte[size];
                    inStream.read(imageAr);

                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

                    // System.out.println("Received " + image.getHeight() + "x" + image.getWidth() +
                    // ": " + System.currentTimeMillis());
                    ImageIO.write(image, "jpg", New_File);
                    chatFram.tf.append("  -- Server save the image in (" + New_File + ") -- \n");

                    int w = image.getWidth();
                    int h = image.getHeight();

                    tmpshow.getimgvalue(New_File, tmpfilestr + ".jpg", w, h);
                    tmpshow.showtmpimg();
                    return;

                } else {
                    nofile = " " + tmpfilestr + " ";
                    JOptionPane.showMessageDialog(null, "The file (" + nofile + ".jpg ) already exists\ntry again !.",
                            "ERROR", JOptionPane.OK_CANCEL_OPTION);
                }

            }

        }

        if (yn == 1) {
            chatFram.tf.append("  -- Server refuse to save the image -- \n");
            byte[] sizeAr = new byte[4];
            inStream.read(sizeAr);
            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

            byte[] imageAr = new byte[size];
            inStream.read(imageAr);

            return;
        }

    }

    //
    public String getHostIP() {
        System.out.println(hostIP);
        return hostIP;
    }

    public String getHoString() {
        return hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int newPort) {
        if (newPort > 1024 && newPort < 65536) {
            port = newPort;
        } else {
            JOptionPane.showMessageDialog(chatFram, "port rang [1024 ~ 65536] ", "ERROR", 1);
        }
    }

    public void close() {
        try {
            outStream.close();
            inStream.close();
            socket.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(chatFram, e.toString(), "ERROR", 1);
        }
    }

}
