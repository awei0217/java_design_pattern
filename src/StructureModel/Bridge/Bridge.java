package StructureModel.Bridge;

/**
 * Created by sunpengwei on 2016/8/4.
 */
public abstract class Bridge {

    public Sourceable sourceable;

    public void print(){
        sourceable.method();
    }



    public Sourceable getSourceable(){
        return  sourceable;
    }

    public void setSourceable(Sourceable sourceable){
        this.sourceable = sourceable;
    }
}
