package LiskovSubstitutionPrinciple;

/**
 * Created by sunpengwei on 2016/7/30.
 */

/**
 * 里氏替换原则，基类出现的地方那么子类一定是可以替换，这才符合里氏替换原则
 */
public class A {
    //类A实现a+b的功能
    public int func1(int a,int b){
        return a+b;
    }
}
//类B实现a-b+100的功能
class B extends  A{
    @Override
    public int func1(int a, int b){
       return a-b;
    }

    public void func2(int a,int b){
        System.out.println(func1(a, b)+100);
    }
}

class Test{
    public static void main(String[] args) {
        A a = new A();
        System.out.println("a + b的值是" + a.func1(10,5));

        //此时如果利用里氏替换原则检测会发现氏错误的
        //这是因为B在继承A时重写A的func1()方法，导致子类在替换父类时父类的方法不可用。正确的做法是我们在继承时应该尽可能的不要重写或者重载父类的方法，

        /*继承包含这样一层含义：父类中凡是已经实现好的方法（相对于抽象方法而言），实际上是在设定一系列的规范和契约，
        虽然它不强制要求所有的子类必须遵从这些契约，但是如果子类对这些非抽象方法任意修改，就会对整个继承体系造成破坏。而里氏替换原则就是表达了这一层含义。

        继 承作为面向对象三大特性之一，在给程序设计带来巨大便利的同时，也带来了弊端。比如使用继承会给程序带来侵入性，
        程序的可移植性降低，增加了对象间的耦合 性，如果一个类被其他的类所继承，则当这个类需要修改时，必须考虑到所有的子类，并且父类修改后，
        所有涉及到子类的功能都有可能会产生故障。*/
        B b = new B();
        System.out.println("a + b的值是" + b.func1(10,5));
    }
}
