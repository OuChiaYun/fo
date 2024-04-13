import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JFrame;

public class jfish1 {

     JLabel jlabel = new JLabel(">-i=i-<");
     Rectangle Rec = new Rectangle();
     int x;
     Boolean jbool = true;;

     public void fishow() {
          Random rX = new Random();
          Random rY = new Random();
          int uX = rX.nextInt(300);
          int uY = rY.nextInt(20) + 200;
          jlabel = new JLabel(">-i=i-<");
          jlabel.setBounds(uX, uY, 40, 20);
          Rec = new Rectangle(uX, uY, 40, 20);

     }

     public void jLabelForward() {

          jlabel.setLocation(jlabel.getBounds().x + fishMove(jlabel.getBounds().x), jlabel.getBounds().y);
          Rec.setLocation(jlabel.getBounds().x, jlabel.getY());

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
