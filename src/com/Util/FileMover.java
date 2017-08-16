import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*


        //用于去除不想要的共同字段
        String[] strings={"[ 天堂www.dy2018.net]","[美国队长1+2(国英)]Captain.America.Duology.2011-2014.BluRay.720p.x264.2Audio.AAC-iSCG-","[ 天堂www.dy2018.com]","The.Hobbit.Trilogy.EXTENDED.BluRay.720p.x264.AC3-CnSCG-","飘花 piaohua.com","哈利波特1-7部全集￡圣城归来-","新建文件夹F=-其他-电影-","电影","【迅雷下载www.dy131.com】","[阳光电影www.ygdy8.com]"};
        String[] types={".mp4",".mkv",".rmvb"};
        //用于批处理不同的文件格式
        for (int i=0;i<types.length;i++){
            FileMover.type=types[i];
            FileMover.renameBatch(strings);
        }


*/

/**
 * 集成文件应用功能：
 * 1.搜索文件
 * 2.重命名文件
 * 3.移动文件
 */
public class FileMover {
    //目标文件类型
    public static String type = ".rmvb";
    //搜索指定类型文件
    private static List<File> fileList = new ArrayList<File>();
    //文件移动别名
    private static String[] destName = null;
    //移动目的地文件目录:注意使用\结尾才可以放到文件夹里面
    private static String destRoot = "F:\\其他\\新建文件夹\\";

    /**
     * 获取指定文件类型路径
     * 重命名文件
     * 移动文件
     */
    public static void run() {
        try {
            indexDocs(new File("F:\\其他\\电影"), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("fileList size: " + fileList.size());
        genNameFromPath(fileList);
        moveFilesToDest();
    }

    /**
     * 移动文件到指定的路径
     */
    private static void moveFilesToDest() {
        int i = 0;
        for (File file : fileList) {
            if (file.renameTo(new File(destRoot + destName[i++])))
                System.out.println(file.getPath() + " move successfully. ");
            else
                System.out.println(file.getPath() + " move not successfully. ");
        }
    }

    /**
     * 从名称中移除指定的字符串
     *
     * @param str
     */
    public static void renameBatch(String[] str) {
        try {
            indexDocs(new File("F:\\其他\\电影"), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("fileList size: " + fileList.size());
        for (File file : fileList) {
            for (String key : str) {
                if (file.getName().contains(key)) {

                    String parent = file.getParent();
                    String name = file.getName();
                    name = name.replace(key, " ");
                    name = name.trim();
                    String newPath = parent + "\\" + name;
                    file.renameTo(new File(newPath));
                }
            }
        }
    }

    /**
     * 根据文件路径转换名称
     *
     * @param fileList
     */
    private static void genNameFromPath(List<File> fileList) {
        destName = new String[fileList.size()];
        int i = 0;
        for (File file : fileList) {
            String path = file.getParent() + "\\" + file.getName();
            path = path.replace(":", "=");
            path = path.replace("\\", "-");
            path = path.trim();
            destName[i++] = path;
        }
    }

    /**
     * 取得目标根目录下的所有指定类型的文件并放置于静态变量fileList中
     * 递归解决方案：
     * 递归获取指定路径下的所有文件的list，遍历是文件夹递归调用，不是文件夹并且符合类型则放入数组中
     *
     * @param file 根目录
     * @param type 文件类型
     * @throws Exception
     */
    private static void indexDocs(File file, String type) throws Exception {
        if (file.isDirectory()) {// 是不是目录
            String[] files = file.list();// 返回该目录下所有文件及文件夹数组
            Arrays.sort(files); // 排序
            for (int i = 0; i < files.length; i++) {
                indexDocs(new File(file, files[i]), type); // 递归(File parent, String child)
            }
        } else if (file.getPath().endsWith(type)) {
            fileList.add(new File(file.getParent() + "\\" + file.getName()));
        }
    }
}
