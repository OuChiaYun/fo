import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.swing.*;

// import pclass.ranD;

import java.awt.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.awt.*;

public class foReadData {

    File file = new File("foData.txt");
    String data = new String();

    public String check(String user, String pass) {

        try (InputStream ins = new FileInputStream(file)) {
            Scanner obj = new Scanner(ins);

            String ss;

            Boolean IDHave = false;
            while (obj.hasNextLine()) {
                ss = obj.nextLine();
                String[] arr1 = ss.split(",");
                if (arr1[0].equals(user)) {
                    if (arr1[1].equals(pass)) {
                        return arr1[2];

                    } else {
                        IDHave = true;
                    }
                }

            }

            if (IDHave) {
                return "1";
            } else {
                return "2";
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "4";

    }

    public void signin(String user, String pass, String tmpnamestr) {

        try (InputStream ins = new FileInputStream(file)) {

            Scanner obj = new Scanner(ins);
            String ss = "";
            Boolean IDHave = false;
            while (obj.hasNextLine()) {
                ss = ss + obj.nextLine() + "\n";
            }

            FileWriter fw = new FileWriter(file);
            // String tmpnamestr = (String) JOptionPane.showInputDialog(null, "Input your
            // User name \n", "wait",
            // JOptionPane.PLAIN_MESSAGE);

            String tmpstring = ss + user + "," + pass + "," + "3%" + tmpnamestr + "#0#0#0#0#0#2000#0";

            char data[] = tmpstring.toCharArray();
            fw.write(data);
            fw.flush();
            fw.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void updateData(String username, String newdata) {

        try (InputStream ins = new FileInputStream(file)) {

            Scanner obj = new Scanner(ins);
            String ss = "";
            while (obj.hasNextLine()) {
                String g = obj.nextLine();
                String[] arr1 = g.split(",");
                String[] arr2 = arr1[2].split("%");
                String[] arr3 = arr2[1].split("#");

                if (arr3[0].equals(username)) {
                    ss = ss + arr1[0] + "," + arr1[1] + ",3%" + username + newdata + "\n";
                } else {
                    ss = ss + g + "\n";
                }
            }

            FileWriter fw = new FileWriter(file);
            char data[] = ss.toCharArray();
            fw.write(data);
            fw.flush();
            fw.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
