package LintCode;

public class AaddB {
    /*
    * be aware of bit operation
    * a&b
    * a^b   change value without other number a=a^b;b=b^a;a=a^b;
    * a<<b  return a*(2^b)
    * */
    public int aplusb(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
