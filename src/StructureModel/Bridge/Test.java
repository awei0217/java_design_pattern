package StructureModel.Bridge;



/**
 * Created by sunpengwei on 2016/8/4.
 */
public class Test {

    public static void main(String[] args) {

        Bridge bridge = new MyBridge();
        Sourceable sourceA = new SourceableA();
        bridge.setSourceable(sourceA);
        bridge.print();

    }
}
