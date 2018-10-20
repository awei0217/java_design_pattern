package StructureModel.Composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by sunpengwei on 2016/8/4.
 */
public class TreeNode {

    private String name;
    private TreeNode parent;
    private Vector<TreeNode> childrens = new Vector<TreeNode>();

    public TreeNode(String name){
        this.name = name;
    }

    public void addChildren(TreeNode children){
       childrens.add(children);
    }
    public void removeChildren(TreeNode children){
        childrens.remove(children);
    }

    public Enumeration selectChildens(){
        return childrens.elements();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
