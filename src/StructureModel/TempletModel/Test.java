package StructureModel.TempletModel;

/**
 * Created by sunpengwei on 2016/8/14.
 */
public class Test {

    public static void main(String[] args) {
        AbstractTmplet abstractTmplet = new ConcretreTmplet();
        abstractTmplet.templetMethod();
    }
}
