package example;

import com.sun.org.apache.bcel.internal.util.ClassPath;

import java.io.File;

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
                }
            }
        }
    }

    public void rename(File _old, String _new) {
        _old.renameTo(new File(_new));
    }
}
