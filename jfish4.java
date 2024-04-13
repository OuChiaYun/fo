import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JFrame;

public class jfish4 {

    JLabel jlabel = new JLabel("_Q_Y");
    Rectangle Rec = new Rectangle();
    int x;
    Boolean jbool = true;;

    public void fishow() {
        Random rX = new Random();
        Random rY = new Random();
        int uX = rX.nextInt(300);
        int uY = rY.nextInt(10) + 200;
        jlabel = new JLabel("_Q_Y");
        jlabel.setBounds(uX, uY, 35, 20);
        Rec = new Rectangle(uX, uY, 35, 20);

    }

    public void jLabelForward() {
        if (!jbool) {
            jlabel.setText("Y_Q_");
        } else {
            jlabel.setText("_Q_Y");
        }

        jlabel.setLocation(jlabel.getBounds().x + fishMove(jlabel.getBounds().x), jlabel.getBounds().y);
        Rec.setLocation(jlabel.getBounds().x, jlabel.getY());

    }

    public int fishMove(int i) {
        if (!jbool) {
            if (i - 1 < 0) {
                jbool = true;
                return -i;
            }
            return (-1);
        } else {
            if (i + 35 + 1 > 400) {
                jbool = false;
                return 400 - (i + 50);
            }
            return 1;
        }
    }

}
