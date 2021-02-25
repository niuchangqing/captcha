package org.ncq.captcha.utils;

import org.ncq.captcha.exception.CaptchaException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author niuchangqing
 * wav格式文件工具类
 */
public final class WavUtil {

    /**
     * wav格式文件合并
     * @param isList        wav格式文件inputStream集合
     * @return              合并后的文件字节
     */
    public static byte[] merge(List<InputStream> isList) {
        if (isList == null || isList.size() <= 0 ){
            throw new CaptchaException("merged file cannot be empty");
        }
        AudioInputStream audioInputStream = null;
        for (InputStream inputStream : isList) {
            if (inputStream == null) {
                throw new CaptchaException("audio file cannot be null");
            }
            AudioInputStream audio = null;
            try {
                audio = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
            }catch (Exception e) {
                //异常为UnsupportedAudioFileException.class和IOException.class
                e.printStackTrace();
                throw new CaptchaException(e.getMessage());
            }
            if (audioInputStream == null) {
                audioInputStream = new AudioInputStream(inputStream,audio.getFormat(),audio.getFrameLength());
            }else {
                audioInputStream = new AudioInputStream(new SequenceInputStream(audioInputStream,audio),audio.getFormat(),audioInputStream.getFrameLength() + audio.getFrameLength());
            }
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            AudioSystem.write(audioInputStream,AudioFileFormat.Type.WAVE,baos);
            baos.close();
        }catch (IOException e) {
            e.printStackTrace();
            throw new CaptchaException(e.getMessage());
        }
        return baos.toByteArray();
    }

    /**
     * wav格式文件合并
     * @param inputStreams          wav格式文件流集合
     * @return                      合并后文件的字节
     */
    public static byte[] merge(InputStream... inputStreams){
        List<InputStream> list = new ArrayList<>(inputStreams.length);
        Collections.addAll(list,inputStreams);
        return merge(list);
    }

    /**
     * wav格式文件合并
     * @param files             wav格式文件集合
     * @return                  合并后文件的字节流
     */
    public static byte[] merge(File... files){
        List<File> list = new ArrayList<>(files.length);
        Collections.addAll(list,files);
        return mergeByFiles(list);
    }

    /**
     * wav格式文件合并
     * @param files             wav格式文件集合
     * @return                  合并后文件的字节流
     */
    public static byte[] mergeByFiles(List<File> files) {
        if (files == null || files.size() <= 0) {
            throw new CaptchaException("merged file cannot be empty");
        }
        List<InputStream> inputStreamList = files.stream().map(m -> {
            try {
                return new FileInputStream(m);
            } catch (FileNotFoundException e) {
                throw new CaptchaException("Invalid file path");
            }
        }).collect(Collectors.toList());
        return merge(inputStreamList);
    }

    /**
     * wav格式文件合并
     * @param byteList          wav格式文件字节流集合
     * @return                  合并后文件的字节流
     */
    public static byte[] mergeByBytes(List<byte[]> byteList){
        if (byteList == null || byteList.size() <= 0) {
            throw new CaptchaException("merged file cannot be empty");
        }
        List<InputStream> list = byteList.stream().map(m -> new ByteArrayInputStream(m)).collect(Collectors.toList());
        return merge(list);
    }
}
