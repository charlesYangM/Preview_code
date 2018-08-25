// $Id$
package io.nio;// $Id$

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;

public class UseFileLocks {
    static private final int start = 10;
    static private final int end = 20;

    static public void main(String args[]) throws Exception {
        // Get file channel
        RandomAccessFile raf = new RandomAccessFile("usefilelocks.txt", "rw");
        FileChannel fc = raf.getChannel();
        Charset charset= Charset.forName("GBK");

        // Get lock
        System.out.println("trying to get lock");
        FileLock lock = fc.lock(start, end, false);
        System.out.println("got lock!");

        // Pause
        System.out.println("pausing");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException ie) {
        }

        ByteBuffer buffer  =ByteBuffer.allocate(12);
        // Release lock
        while (fc.read( buffer )!= -1){
        }

        buffer.flip();

        while (buffer.remaining()>0) {
            System.out.println( (char)buffer.get() );
        }
        System.out.println("going to release lock");
        lock.release();
        System.out.println("released lock");

        raf.close();
    }
}
