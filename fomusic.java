import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.util.concurrent.locks.Lock;

public class fomusic extends Thread implements Runnable {

    protected boolean mflag;
    int sumByteRead = 0;
    int time = 0;
    int fulltime = 0;
    File file = new File("fo.wav");
    AudioInputStream am;
    Long fitime ;
    Long setime;
    float durationInSeconds;
    Clip clip;
    public fomusic() {

    }

    public void run(){


        try{

            am = AudioSystem.getAudioInputStream(file);

//length

            // AudioFormat af = am.getFormat();
            // Long audioFileLength = file.length();
            // int framesize = af.getFrameSize();
            // float framerate = af.getFrameRate();
            // durationInSeconds = (audioFileLength / (framesize*framerate));

//

            clip = AudioSystem.getClip();
            
            clip.open(am);
            clip.getMicrosecondPosition();
            // System.out.println(clip.getMicrosecondPosition());
            // System.out.println(clip.getMicrosecondLength());
            clip.loop(Clip.LOOP_CONTINUOUSLY);


        } catch (Exception e) {
            //TODO: handle exception
        }




    }














    // public void run() {

    //     System.out.println("PP");
        

    //     try {
    //         am = AudioSystem.getAudioInputStream(file);
    //         AudioFormat af = am.getFormat();
    //         SourceDataLine sd;

    //         Long audioFileLength = file.length();
    //         int framesize = af.getFrameSize();
    //         float framerate = af.getFrameRate();
    //         durationInSeconds = (audioFileLength / (framesize*framerate));

    //         System.out.println(durationInSeconds);

    //         sd = AudioSystem.getSourceDataLine(af);
    //         sd.open();
    //         sd.start();
    //         byte[] b = new byte[320];

    //         // Lock lock = new Lock() {

    //         // @Override
    //         // public void lock() {
    //         // // TODO Auto-generated method stub

    //         // }

    //         // @Override
    //         // public void lockInterruptibly() throws InterruptedException {
    //         // // TODO Auto-generated method stub

    //         // }

    //         // @Override
    //         // public boolean tryLock() {
    //         // // TODO Auto-generated method stub
    //         // return false;
    //         // }

    //         // @Override
    //         // public boolean tryLock(long time, TimeUnit unit) throws InterruptedException
    //         // {
    //         // // TODO Auto-generated method stub
    //         // return false;
    //         // }

    //         // @Override
    //         // public void unlock() {
    //         // // TODO Auto-generated method stub
    //         // try {
    //         // sumByteRead = am.read(b,0,b.length);
    //         // } catch (IOException e) {
    //         // // TODO Auto-generated catch block
    //         // e.printStackTrace();
    //         // }

    //         // if(sumByteRead >= 0){
    //         // sd.write(b, 0, b.length);
    //         // }

    //         // }

    //         // @Override
    //         // public Condition newCondition() {
    //         // // TODO Auto-generated method stub
    //         // return null;
    //         // }

    //         // };

    //         System.out.println();
    //         while (sumByteRead != -1) { // -1 represent
    //             time++;
    //             sumByteRead = am.read(b, 0, b.length);

    //             if (sumByteRead >= 0) {
    //                 sd.write(b, 0, b.length);
    //             }

    //             if (mflag) {
    //                 sd.stop();
    //                 // lock.lock();
    //             } else {
    //                 // lock.unlock();
    //                 sd.start();
    //             }
    //             System.out.printf("");
    //         }
    //         sd.drain();
    //         sd.close();

    //     } catch (UnsupportedAudioFileException | IOException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     } catch (LineUnavailableException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }

    // }

}
