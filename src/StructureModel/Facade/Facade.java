package StructureModel.Facade;

/**
 * Created by sunpengwei on 2016/8/4.
 */

/**
 * 外观模式是解决类与类之间的依赖关系，就像Spring一样，可以将类与类之间的关系配置xml文件中
 * 而外观模式就是将他们的关系放在一个Facade类中，降低了类类之间的耦合度
 */
public class Facade {

    private CPU cpu;
    private Disk disk;
    private Memory memory;

    public Facade(CPU cpu, Disk disk,Memory memory){
        this.cpu = cpu;
        this.disk = disk;
        this.memory = memory;
    }

    public void startComputer(){
        cpu.startCpu();;
        memory.startMemory();;
        disk.startDisk();
    }
}
