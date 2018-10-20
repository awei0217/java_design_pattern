package DependenceInversionPrinciple;

/**
 * Created by sunpengwei on 2016/7/30.
 */

/**
 * 依赖倒置原则,核心就是面向接口编程
 * 定义：高层模块不应该依赖于底层模块，两者都因该依赖于抽象,抽象不应该依赖于细节，细节应该依赖抽象
 * 问题由来:类A依赖与类B,假如要将类A改成依赖与类C，那么必须要修改类A的代码来完成，这种场景下，类A一般是高层模块，负责复杂的业务逻辑，类B和类C是底层模块，负责基本的原子操作，假如修改类A，会给程序带来不必要的风险
 * 解决方案：将类A修改成依赖接口I，类B和类C分别实现接口I,类A通过接口I间接与类B和类C发声联系，则会大大降低修改类A的概率
 */

/*依赖倒置原则基于这样一个事实：相对于细节的多变性，抽象的东西要稳定的多。以抽象为基础搭建起来的架构比以细节为基础搭建起来的架构要稳定的多。在java中，抽象指的是接口或者抽象类，细节就是具体的实现类，使用接口或者抽象类的目的是制定好规范和契约，而不去涉及任何具体的操作，把展现细节的任务交给他们的实现类去完成。


        依赖倒置原则的中心思想是面向接口编程，我们依旧用一个例子来说明面向接口编程比相对于面向实现编程好在什么地方。场景是这样的，母亲给孩子讲故事，只要给她一本书，她就可以照着书给孩子讲故事了。代码如下：*/
public class Book {
    public String getContent(){
            return "很久很久以前有一个阿拉伯的故事……";
    }
}
class  Mother{
        public void narrate(Book book){
                System.out.println(book.getContent());
        }
}
class Test{
        public static void main(String[] args) {
                Mother mother = new Mother();
                mother.narrate(new Book());
        }
}

/*运行结果

        妈妈开始讲故事

很久很久以前有一个阿拉伯的故事……

        运行良好，假如有一天，需求变成这样：不是给书而是给一份报纸，让这位母亲讲一下报纸上的故事。*/

class Newspaper{

        public String getContent(){

                return "林书豪38+7领导尼克斯击败湖人……";

        }

}

/*这位母亲却办不到，因为她居然不会读报纸上的故事，这太荒唐了，只是将书换成报纸，居然必须要修改Mother才能读。假如以后需求换成杂志呢？换成网页呢？还要不断地修改Mother，这显然不是好的设计。原因就是Mother与Book之间的耦合性太高了，必须降低他们之间的耦合度才行。

        我们引入一个抽象的接口IReader。读物，只要是带字的都属于读物。*/

interface IReader{
        public abstract String getContent();
}
//Mother类与接口IReader发生依赖关系，而Book1和Newspaper1都属于读物的范畴，他们各自都去实现IReader接口，这样就符合依赖倒置原则了，代码修改为：
class Book1 implements IReader{

        @Override
        public String getContent() {
                return "很久很久以前有一个阿拉伯的故事....";
        }
}

class Newspaper1 implements IReader{

        @Override
        public String getContent() {
                return "林书豪38+7领导尼克斯击败湖人……";
        }
}
class Mother1{
        public void narrate(IReader iReader){
                System.out.println(iReader.getContent());
        }
}
class Test1{
        public static void main(String[] args) {
                Mother1 mother = new Mother1();
                //讲书上的故事
                mother.narrate(new Book1());
                //讲报纸上的故事
                mother.narrate(new Newspaper1());
        }
}
/**
 这样修改后，无论以后怎样扩展Test类，都不需要再修改Mother类了。这只是一个简单的例子，实际情况中，代表高层模块的Mother类将负责完成主要的业务逻辑，一旦需要对它进行修改，引入错误的风险极大。所以遵循依赖倒置原则可以降低类之间的耦合性，提高系统的稳定性，降低修改程序造成的风险。

 采用依赖倒置原则给多人并行开发带来了极大的便利，比如上例中，原本Mother类与Book类直接耦合时，Mother类必须等Book类编码完成后才可以进行编码，因为Mother类依赖于Book类。修改后的程序则可以同时开工，互不影响，因为Mother与Book类一点关系也没有。参与协作开发的人越多、项目越庞大，采用依赖导致原则的意义就越重大。现在很流行的TDD开发模式就是依赖倒置原则最成功的应用。

 传递依赖关系有三种方式，以上的例子中使用的方法是接口传递，另外还有两种传递方式：构造方法传递和setter方法传递，相信用过Spring框架的，对依赖的传递方式一定不会陌生。

 在实际编程中，我们一般需要做到如下3点：

 低层模块尽量都要有抽象类或接口，或者两者都有。

 变量的声明类型尽量是抽象类或接口。

 使用继承时遵循里氏替换原则。

 总之，依赖倒置原则就是要我们面向接口编程，理解了面向接口编程，也就理解了依赖倒置。
 */