import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JFrame;

public class jfish2 {

     JLabel jlabel = new JLabel("><D");
     Rectangle Rec = new Rectangle();
     int x;
     Boolean jbool = true;;
     int time = 0;
     int updown = 0;
     int timeegg = 0;
     double eggtimelimit = 500;
     // int eggtimelimit = 500;

     public void fishow() {
          Random rX = new Random();
          Random rY = new Random();
          int uX = rX.nextInt(300);
          int uY = rY.nextInt(160) + 30;

          jlabel = new JLabel("><D");
          jlabel.setBounds(uX, uY, 25, 20);
          Rec = new Rectangle(uX, uY, 25, 20);

     }

     public void jLabelForward() {

          if (!jbool) {
               jlabel.setText("G><");
          } else {
               jlabel.setText("><D");
          }

          jlabel.setLocation(jlabel.getBounds().x + fishMove(jlabel.getBounds().x), jlabel.getBounds().y);
          Rec.setLocation(jlabel.getBounds().x, jlabel.getY());

          if (time % 100 == 0) {

               Random updowRan = new Random();
               updown = updowRan.nextInt(9) - 5;

               if (updown > 1 || updown < -1) {
                    updown = 0;
               }

               if ((jlabel.getBounds().y + updown > 191 && updown > 0)
                         || ((jlabel.getBounds().y + updown < 60 && updown < 0))) {
                    updown = -updown;

               }
               jlabel.setLocation(jlabel.getBounds().x + x, jlabel.getBounds().y +
                         updown);
               Rec.setLocation(jlabel.getX() + x, jlabel.getY());
          }

          if ((jlabel.getBounds().y + updown < 60 && updown < 0)
                    || ((jlabel.getBounds().y + updown > 191 && updown > 0))) {
               updown = -updown;

          }

          jlabel.setLocation(jlabel.getBounds().x + x, jlabel.getBounds().y +
                    updown);
          Rec.setLocation(jlabel.getX() + x, jlabel.getY());

          double bcos = Math.toRadians(jlabel.getBounds().x + x);

          if (((int) (jlabel.getBounds().y + (float) Math.cos(10 * bcos) +
                    0.49999999999999289121)) > 191
                    || ((int) (jlabel.getBounds().y + (float) Math.cos(10 * bcos) +
                              0.49999999999999289121) < 30)) {
               jlabel.setLocation(jlabel.getBounds().x, jlabel.getBounds().y);
          } else {
               jlabel.setLocation(jlabel.getBounds().x,
                         (int) (jlabel.getBounds().y + (float) Math.cos(10 * bcos) +
                                   0.49999999999999289121));
          }
          Rec.setLocation(jlabel.getX(), jlabel.getY());

          time++;
          time = time % 100;

     }

     public int fishMove(int i) {
          if (!jbool) {
               if (i - 2 < 0) {
                    jbool = true;
               }
               return (-2);
          } else {
               if (i + 40 + 2 > 395) {
                    jbool = false;
               }
               return 2;
          }
     }

}
