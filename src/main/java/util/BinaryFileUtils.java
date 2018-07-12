package util;

import java.io.*;

/**
 * Created by CharlesYang on 2018/7/12/012.
 */
public class BinaryFileUtils {

    public static void copy(InputStream input, OutputStream output) throws IOException {
        byte[] buf = new byte[4096];
        int bytesRead = 0;
        while ((bytesRead = input.read(buf)) != -1) {
            output.write(buf, 0, bytesRead);
        }
    }

    public static final byte[] readFileToByte(String fileName) throws IOException {
        FileInputStream input = new FileInputStream(fileName);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            copy(input, output);
            return output.toByteArray();
        } finally {
            input.close();
        }

    }
}
