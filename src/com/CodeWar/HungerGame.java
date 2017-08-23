package CodeWar;

import org.junit.Test;

/*
*
* Story

Old MacDingle had a farm...

...and on that farm he had

horses
chickens
rabbits
some apple trees
a vegetable patch
Everything is idylic in the MacDingle farmyard unless somebody leaves the gates open

Depending which gate was left open then...

horses might run away
horses might eat the apples
horses might eat the vegetables
chickens might run away
rabbits might run away
rabbits might eat the vegetables
Kata Task

Given the state of the farm gates in the evening, your code must return what the farm looks like the next morning
when daylight reveals what the animals got up to.

Legend

H horse
C chicken
R rabbit
A apple tree
V vegetables
| gate (closed),
\ or / gate (open)
. everything else
Example

Before
|..HH....\AAAA\CC..|AAA/VVV/RRRR|CCC
After
|..HH....\....\CC..|AAA/.../RRRR|...
Because:
The horses ate whatever apples they could get to
The rabbits ate the vegetables
The chickens ran away
Notes

If the animals can eat things and also run away then they do BOTH - it is best not to run away when you are hungry!
An animal cannot "go around" a closed gate...
...but it is possible to run away from the farm and then RUN BACK and re-enter though more open gates on the other side!
*
* */
public class HungerGame {
    /**
     * divide str into mutipart string by using |
     */
    public String oneNightPass(String input) {
        String output = "";
        input = input.replace("|", "-");
        String[] units = input.split("-");
        for (int i = 0; i < units.length; i++) {
            String unit = units[i];
            //animal can't run away  at tail
            if ((input.charAt(0) == '-') && (i == 0)) {
                //eat and run
                //house eat
                if (unit.contains("H")) {
                    if (unit.contains("A") || unit.contains("V")) {
                        unit = unit.replace("A", ".");
                        unit = unit.replace("V", ".");
                    }
                }
                //rabbit eat
                if (unit.contains("R")) {
                    if (unit.contains("V")) {
                        unit = unit.replace("V", ".");
                    }
                }
                //chicker eat
                if (unit.contains("C")) {
                    if (unit.contains("V")) {
                        unit = unit.replace("V", ".");
                    }
                }

            }
            //animal run away  at head
            if ((input.charAt(0) != '-') && (i == 0)) {
                //eat and run
                //house eat
                if (unit.contains("H")) {
                    if (unit.contains("A") || unit.contains("V")) {
                        unit = unit.replace("A", ".");
                        unit = unit.replace("V", ".");
                    }
                }
                //rabbit eat
                if (unit.contains("R")) {
                    if (unit.contains("V")) {
                        unit = unit.replace("V", ".");
                    }
                }
                //chicker eat
                if (unit.contains("C")) {
                    if (unit.contains("V")) {
                        unit = unit.replace("V", ".");
                    }
                }
                //run away
                if (unit.contains("H") || unit.contains("R") || unit.contains("C")) {
                    unit = unit.replace("H", ".");
                    unit = unit.replace("R", ".");
                    unit = unit.replace("C", ".");
                }
            }
            //animal can't run away  at tail
            if ((input.charAt(input.length() - 1) == '-') && (i == units.length - 1)) {
                //eat and run
                //house eat
                if (unit.contains("H")) {
                    if (unit.contains("A") || unit.contains("V")) {
                        unit = unit.replace("A", ".");
                        unit = unit.replace("V", ".");
                    }
                }
                //rabbit eat
                if (unit.contains("R")) {
                    if (unit.contains("V")) {
                        unit = unit.replace("V", ".");
                    }
                }
                //chicker eat
                if (unit.contains("C")) {
                    if (unit.contains("V")) {
                        unit = unit.replace("V", ".");
                    }
                }
            }
            //animal run away  at tail
            if ((input.charAt(input.length() - 1) != '-') && (i == units.length - 1)) {
                //eat and run
                //house eat
                if (unit.contains("H")) {
                    if (unit.contains("A") || unit.contains("V")) {
                        unit = unit.replace("A", ".");
                        unit = unit.replace("V", ".");
                    }
                }
                //rabbit eat
                if (unit.contains("R")) {
                    if (unit.contains("V")) {
                        unit = unit.replace("V", ".");
                    }
                }
                //chicker eat
                if (unit.contains("C")) {
                    if (unit.contains("V")) {
                        unit = unit.replace("V", ".");
                    }
                }
                //run away
                if (unit.contains("H") || unit.contains("R") || unit.contains("C")) {
                    unit = unit.replace("H", ".");
                    unit = unit.replace("R", ".");
                    unit = unit.replace("C", ".");
                }
            }
            //house eat
            if (unit.contains("H")) {
                if (unit.contains("A") || unit.contains("V")) {
                    unit = unit.replace("A", ".");
                    unit = unit.replace("V", ".");
                }
            }
            //rabbit eat
            if (unit.contains("R")) {
                if (unit.contains("V")) {
                    unit = unit.replace("V", ".");
                }
            }
            //chicker eat
            if (unit.contains("C")) {
                if (unit.contains("V")) {
                    unit = unit.replace("V", ".");
                }
            }
            output = output.concat(unit) + "|";
        }
        //solve output | by first and last
        if (input.charAt(input.length() - 1) != '-') {
            output = output.substring(0, output.length() - 1);
        }
        System.out.println("not yet");
        return output;
    }

    @Test
    public void test() {
        HungerGame h = new HungerGame();
        h.oneNightPass("|HHH/RRR/VVVV/AAAAA/CCCC|AAA|VVV|VVVVV/CCC/AAA/HHH|");
        /*
        * Before: /RRR|AAA|VVV|AAA/VVV/CCCC
After:  /...|AAA|VVV|AAA/.../....
        *
        *
        * Before: |HHH/RRR/VVVV/AAAAA/CCCC|AAA|VVV|VVVVV/CCC/AAA/HHH|
After:  |HHH/RRR/..../...../CCCC|AAA|VVV|...../CCC/.../HHH|
        * */
    }
}
