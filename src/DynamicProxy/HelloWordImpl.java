package DynamicProxy;

/**
 * Created by sunpengwei on 2016/8/1.
 */
public class HelloWordImpl implements HelloWord{
    @Override
    public void print() {
        System.out.println("hello word");
    }
}

