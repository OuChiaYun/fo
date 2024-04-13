import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JFrame;

public class jfish3 {

    JLabel jlabel = new JLabel("><SHARKD");
    Rectangle Rec = new Rectangle();
    int x;
    Boolean jbool = true;;

    public void fishow() {
        Random rX = new Random();
        Random rY = new Random();
        int uX = rX.nextInt(300);
        int uY = rY.nextInt(130) + 40;
        jlabel = new JLabel("><SHARKD");
        jlabel.setBounds(uX, uY, 70, 20);
        Rec = new Rectangle(uX, uY, 70, 20);

    }

    public void jLabelForward() {
        if (!jbool) {
            jlabel.setText("GSHARK><");
        } else {
            jlabel.setText("><SHARKD");
        }

        jlabel.setLocation(jlabel.getBounds().x + fishMove(jlabel.getBounds().x), jlabel.getBounds().y);
        Rec.setLocation(jlabel.getBounds().x, jlabel.getY());

    }

    public int fishMove(int i) {
        if (!jbool) {
            if (i - 3 < 0) {
                jbool = true;
            }
            return (-3);
        } else {
            if (i + 70 + 3 > 400) {
                jbool = false;
                return 400 - (i + 70);
            }
            return 3;
        }
    }

}
