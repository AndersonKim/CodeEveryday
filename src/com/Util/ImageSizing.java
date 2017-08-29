package com.Util;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/18
 * Time:11:35
 */

/***
 * image resizing
 */
public class ImageSizing {
    public static void main(String[] args) {

        Image image = null;
        try {


            // Read from a URL
            URL url = new URL("http://common.cnblogs.com/images/wechat.png");
            image = ImageIO.read(url);
            int w, h;
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null) / 2, image.getHeight(null) / 2, BufferedImage.TYPE_INT_RGB);
            bufferedImage.getGraphics().drawImage(image, 0, 0, image.getWidth(null) / 2, image.getHeight(null) / 2, null); //绘制缩小后的图
            FileOutputStream out = null;
            out = new FileOutputStream("newfile.jpg"); //输出到文件流
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(bufferedImage); //近JPEG编码
            out.close();
        } catch (IOException e) {
        }

        // Use a label to display the image
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        //关闭窗口--退出调试
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

