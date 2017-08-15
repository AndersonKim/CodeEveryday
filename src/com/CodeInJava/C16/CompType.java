package CodeInJava.C16;

import sun.nio.cs.Surrogate;

import java.util.Random;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/17
 * Time:12:04
 */
public class CompType implements Comparable<CompType> {
    int i;
    int j;

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "CompType{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }

    @Override
    public int compareTo(CompType o) {
        return (i < o.i ? -1 : (i == o.i ? 0 : 1));
    }


}
