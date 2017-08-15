import java.io.*;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/5/29
 * Time:10:15
 */
public class FileUtil {
    public static void main(String[] args) {
        File f1 = new File("d:/JavaCode/CodeEveryDay/src");
        if (f1.isDirectory()) {
            File[] fileList = f1.listFiles();
            for (File f : fileList) {
                if (f.isDirectory()) {
                    System.out.println("Dir: " + f.getName());
                } else {
                    System.out.println("File: " + f.getName());
                    FileUtil fileUtil = new FileUtil();
                    //fileUtil.stream_read_file(f);

                    //fileUtil.stream_write_file(f,new FileOutputStream(f));
                    fileUtil.divide_file(f, 300);




                }
            }
        }
    }

    /**
     * 字节流形式写文件
     *
     * @param f
     */
    public void stream_write_file(File f, FileOutputStream fileOutputStream) {
        String line = "append line";
        try {
            fileOutputStream.write(line.getBytes());
            fileOutputStream.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流形式读取文件
     *
     * @param f
     */
    public void stream_read_file(File f) {
        try {
            FileInputStream fileInputStream = new FileInputStream(f);
            byte[] all = new byte[(int) f.length()];
            fileInputStream.read(all);
            for (byte b : all) {
                System.out.println("byte: " + b + " char: " + (char) b);
            }
            fileInputStream.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void assemble_file(File[] files, File dest) {

    }

    /**
     * 根据制定的大小分割文件
     *
     * @param f    文件
     * @param size 每个文件大小
     */
    public void divide_file(File f, int size) {
        try {
            //1.读取文件内容
            FileInputStream fis = new FileInputStream(f);
            byte[] content = new byte[(int) f.length()];
            fis.read(content);
            fis.close();
            //2.分割文件
            int batch = 0;
            if (content.length % size != 0) {
                batch = content.length / size + 1;
            } else {
                batch = content.length / size;
            }
            byte[][] subByte = new byte[batch][];
            get_byte_divide(subByte, content, size);
            //3.保存文件
            for (int i = 0; i < batch; i++) {
                File subFile = new File("d:/JavaCode/CodeEveryDay/src/subFile-" + i + ".txt");
                FileOutputStream fos = new FileOutputStream(subFile);
                fos.write(subByte[i]);
                fos.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据大小将字节流分割
     *
     * @param dest
     * @param origin
     * @param size
     */
    public void get_byte_divide(byte[][] dest, byte[] origin, int size) {
        for (int i = 0; i < dest.length; i++) {
            dest[i] = new byte[size];
            for (int j = 0; j < size; j++) {
                if (size * i + j < origin.length)
                    dest[i][j] = origin[size * i + j];
            }
        }
    }
}
