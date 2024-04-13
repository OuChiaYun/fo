public class fomain {
    public static void main(String[] args) {
        foLog folog = new foLog();
        folog.setVisible(true);
        int x = 0;
        int y = 0;

        while(true){
            x++;
            // y++;
            folog.setLocation(x,200);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if(x == 425){
                folog.ani();
                // folog.ani();
                break;
            }

        }
    }
}
