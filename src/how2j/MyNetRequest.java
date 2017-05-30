package how2j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/5/30
 * Time:14:36
 */
public class MyNetRequest {
    public static void main(String args[]) {
        try {
            Process p = Runtime.getRuntime().exec("ping 192.168.1.1");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                if (line.length() != 0) {
                    sb.append(line + "\r\n");
                }
            }
            System.out.println("return cmd:");
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
