package org.ncq.captcha.utils;

import org.ncq.captcha.exception.CaptchaException;

import java.io.*;

/**
 * @author niuchangqing
 * IO工具类
 */
public class IOUtil {

    /**
     * 关闭流
     * @param closeable     流对象
     */
    public static void close(Closeable closeable){
        try {
            if (closeable != null) {
                closeable.close();
            }
        }catch (IOException e) {
        }
    }

    /**
     * inputstream转byte[]
     * @param input             inputstream
     * @return                  byte[]
     */
    public static byte[] toByteArray(InputStream input) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            copy(input, output);
        }catch (IOException e) {
            throw new CaptchaException(e);
        }
        return output.toByteArray();
    }

    public static int copy(InputStream input, OutputStream output) throws IOException {
        long count = copyLarge(input, output);
        if (count > 2147483647L) {
            return -1;
        }
        return (int)count;
    }

    public static long copyLarge(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[4096];
        long count = 0L;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }
}
