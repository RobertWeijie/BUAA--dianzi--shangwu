package src2;

import com.oocourse.spec2.exceptions.EqualMessageIdException;
import com.oocourse.spec2.exceptions.EqualPersonIdException;

import java.util.TreeSet;

public class MyEqualMessageIdException extends EqualMessageIdException {

    public int id;

    public static int count = 0;


    public static TreeSet<MultiCount> multiCountSet = new TreeSet<>();;


    public MyEqualMessageIdException(int id) {
        this.id = id;
    }

    @Override
    public void print() {
        count++;
        MultiCount multiCount = new MultiCount(id,1);
        if (multiCountSet.contains(multiCount)) {
            for (MultiCount multiCount1 : multiCountSet) {
                if (multiCount1.equals(multiCount)) {
                    multiCount1.count += multiCount.count;//统计的是相等的人员 id 的出现次数。
                }
            }
        } else {
            multiCountSet.add(multiCount);
        }
        System.out.println("emi-" + count + ", " + id + "-" + multiCountSet.ceiling(new MultiCount(id,1)).count);
    }
}
//count 代表异常的个数
//multiCountSet 代表异常的 id 以及出现的次数

