package CodeInJava.C16;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/17
 * Time:15:11
 */

/**
 * 实现Comparable接口
 */
public class Hero implements Comparable<Hero> {
    int Health;
    int Attack;

    public Hero(int health, int attack) {
        Health = health;
        Attack = attack;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "Health=" + Health +
                ", Attack=" + Attack +
                '}';
    }

    /**
     * 自定义比较规则
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Hero o) {
        //自定义攻击/血量为有价值的英雄
        float _1 = Attack / Health;
        float _2 = o.Attack / o.Health;
        return (_1 < _2 ? -1 : (_1 == _2 ? 0 : 1));
    }
}
