import java.util.List;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/5/18
 * Time:20:25
 */
/*Description:
Given an array (arr) as an argument complete the function countSmileys that should return the total number of smiling faces.

Rules for a smiling face:
-Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
-A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
-Every smiling face must have a smiling mouth that should be marked with either ) or D.
Valid smiley face examples:
:) :D ;-D :~)
Invalid smiley faces:
;( :> :} :]

Example cases:

countSmileys([':)', ';(', ';}', ':-D']);       // should return 2;
countSmileys([';D', ':-(', ':-)', ';~)']);     // should return 3;
countSmileys([';]', ':[', ';*', ':$', ';-D']); // should return 1;

Note: In case of an empty array return 0. You will not be tested with invalid input (input will always be an array)*/
public class SmileFaces {
    public static int countSmileys(List<String> arr) {
        // Just Smile :)
        String[] checkTable={
                ":-)",";~)",":)",
                ":-D",";~)",":D",
                ";-)",";~)",";)",
                ";-D",";~D",";D"
        };
        int face=0;
        for (String key :checkTable) {
            for (String tar:arr){
                if (tar.equals(key))
                    face++;
            }
        }

        return face;
    }
}
