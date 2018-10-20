package LawOfDemeter;

/**
 * Created by sunpengwei on 2016/7/31.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 迪米特法则
 * 定义：一个对象应该对其它对象保持最小的理解
 * 问题由来：类与类之间的关系越密切，耦合度越大，当一个类发生改变时，对另一个类的影响也就越大
 * 解决方案：尽量降低类与类之间的耦合
 *      自从我们接触编程开始，就知道了软件编程的总原则，低耦合，高内聚。无论是面向过程编程还是面向对象编程，只有使各个模块之间耦合尽量的低，才能提高代码的复用率
 *  低耦合的优点不言而喻，但怎么样的编程才能做到低耦合呢？那正是迪米特法则要去完成的。
 *
 *      迪米特法则又叫最少知道原则，通俗的来讲就是一个类对自己依赖的类知道的越少越好，也就是说，对于被依赖的类说来说，
 *  无论逻辑多么复杂，都尽量的将逻辑封装在类的内部。
 *
 *      举一个例子，有一个集团公司，下属单位有分公司和直属部门，现在要求打印出所有下属单位的员工ID，先来看一下违反迪米特法则的设计
 */
//总公司员工
public class Employee {

    private String id;
    public void setId(String id){
        this.id = id;
    }

    public String getId(){

        return id;
    }
}

//分公司员工
class SubEmployee{
    private String id;

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}

class SubCompanyManager{
    public List<SubEmployee> getAllEmployee(){
        List<SubEmployee> list = new ArrayList<SubEmployee>();
        for (int i = 0; i <100 ; i++) {
            SubEmployee emp = new SubEmployee();
            //为分公司员工按顺序分配一个ID
            emp.setId("分公司"+i);
            list.add(emp);
        }
        return list;
    }
}

class CompanyManager{
    public List<Employee> getAllEmployee(){
        List<Employee> list = new ArrayList<Employee>();
        for (int i = 0; i <100 ; i++) {
            Employee emp = new Employee();
            emp.setId("总公司"+i);
            list.add(emp);
        }
        return list;
    }
    //打印所有下属单位的ID

    public void printAllEmployee(SubCompanyManager scm){
        //打印分公司的
        List<SubEmployee> subList = scm.getAllEmployee();
        for (int i = 0; i < subList.size(); i++) {
            System.out.println(subList.get(i).getId());
        }
        //打印总公司的
        List<Employee> cp = this.getAllEmployee();
        for (Employee e:cp){
            System.out.println(e.getId());
        }
    }
}

//这个设计的问题主要出现在CompanyManager中，根据迪米特法则，而
//SubEmployee类并不是CompanyManager类的直接朋友，从逻辑上讲总公司只与
//他的分公司耦合就行了，与分公司的员工没有任何关系，这样设计显然增加了不必要的耦合，按照
//迪米特法则，应该避免类中出现这样非直接朋友关系的耦合


//修改后代码如下
class SubCompanyManager1{

    public List<SubEmployee> getAllEmployee(){

        List<SubEmployee> list = new ArrayList<SubEmployee>();

        for(int i=0; i<100; i++){

            SubEmployee emp = new SubEmployee();

            //为分公司人员按顺序分配一个ID

            emp.setId("分公司"+i);

            list.add(emp);

        }

        return list;

    }

    public void printEmployee(){

        List<SubEmployee> list = this.getAllEmployee();

        for(SubEmployee e:list){

            System.out.println(e.getId());

        }

    }

}
class CompanyManage1r{

    public List<Employee> getAllEmployee(){

        List<Employee> list = new ArrayList<Employee>();

        for(int i=0; i<30; i++){

            Employee emp = new Employee();

            //为总公司人员按顺序分配一个ID

            emp.setId("总公司"+i);

            list.add(emp);

        }

        return list;

    }



    public void printAllEmployee(SubCompanyManager1 sub1){

        sub1.printEmployee();

        List<Employee> list2 = this.getAllEmployee();

        for(Employee e:list2){

            System.out.println(e.getId());

        }

    }

}

/*
修改后，为分公司增加了打印人员ID的方法，总公司直接调用来打印，从而避免了与分公司的员工发生耦合。

        迪 米特法则的初衷是降低类之间的耦合，由于每个类都减少了不必要的依赖，因此的确可以降低耦合关系。但是凡事都有度，虽然可以避免与非直接的类通信，
        但是要 通信，必然会通过一个“中介”来发生联系，例如本例中，总公司就是通过分公司这个“中介”来与分公司的员工发生联系的。过分的使用迪米特原则，
        会产生大量 这样的中介和传递类，导致系统复杂度变大。所以在采用迪米特法则时要反复权衡，既做到结构清晰，又要高内聚低耦合。*/
