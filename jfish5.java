import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JFrame;

public class jfish5 {

    JLabel jlabel = new JLabel("-:(X):O");
    int x;
    Boolean jbool = true;;

    public void fishow() {
        Random rX = new Random();
        Random rY = new Random();
        int uX = rX.nextInt(300);
        int uY = rY.nextInt(50) + 20;
        jlabel = new JLabel("-:(X):O");
        jlabel.setBounds(uX, uY, 40, 20);

    }

    public void jLabelForward() {
        if (!jbool) {
            jlabel.setText("O:(X):-");
        } else {
            jlabel.setText("-:(X):O");
        }

        jlabel.setLocation(jlabel.getBounds().x + fishMove(jlabel.getBounds().x), jlabel.getBounds().y);

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
