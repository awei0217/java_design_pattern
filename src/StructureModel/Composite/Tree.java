package StructureModel.Composite;

import java.util.Enumeration;

/**
 * Created by sunpengwei on 2016/8/4.
 */
public class Tree {

    public TreeNode root;

    public Tree(String name){
        root = new TreeNode(name);
    }

    public static void main(String[] args) {
        Tree  tree = new Tree("root");
        TreeNode treeNodeA = new TreeNode("A");
        TreeNode treeNodeB = new TreeNode("B");

        treeNodeB.addChildren(treeNodeA);
        tree.root.addChildren(treeNodeB);

        Enumeration<TreeNode> enumeration =  tree.root.selectChildens();

        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement().getName());
        }
        System.out.println();


    }
}
