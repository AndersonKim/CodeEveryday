package com.CodeWar;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/5/19
 * Time:10:20
 */
/*In this kata, you must create a digital root function.

A digital root is the recursive sum of all the digits in a number. Given n, take the sum of the digits of n. If that value has two digits, continue reducing in this way until a single-digit number is produced. This is only applicable to the natural numbers.

Here's how it works (Ruby Util given):

digital_root(16)
=> 1 + 6
=> 7

digital_root(942)
=> 9 + 4 + 2
=> 15 ...
=> 1 + 5
=> 6

digital_root(132189)
=> 1 + 3 + 2 + 1 + 8 + 9
=> 24 ...
=> 2 + 4
=> 6

digital_root(493193)
=> 4 + 9 + 3 + 1 + 9 + 3
=> 29 ...
=> 2 + 9
=> 11 ...
=> 1 + 1
=> 2*/
public class SumOfDigits {
    /**
     * //1.分解n所有数位
     * //2.判断和数位
     * //2.1 2位分解
     * //2.2 1位输出
     *
     * @param n
     * @return
     */
    public int digital_root(int n) {
        while (n >= 10) {
            n = sumDigit(n);
        }
        return n;
    }

    /**
     * 求解输入数的子数的和
     *
     * @param n
     * @return
     */
    public int sumDigit(int n) {
        int result = 0;
        while (n != 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }

    /**
     * 求解输入数的子数的和,递归
     *
     * @param n
     * @return
     */
    public int sumDigit_(int n) {
        if (n / 10 == 0) return n;
        return n % 10 + sumDigit_(n / 10);
    }
}
