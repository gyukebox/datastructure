package datastructure;

import java.util.ArrayList;

public class TreeNode {
    private String data;
    private TreeNode parent;
    private ArrayList<TreeNode> children; //List 타입으로 선언하면 naming 충돌이 있어서 ArrayList로 선언했습니다

    public TreeNode() {
        this.data = null;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public TreeNode(String data, TreeNode parent) {
        this.data = data;
        this.parent = parent;
        this.children = new ArrayList<>();
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<TreeNode> children) {
        this.children = children;
    }
}
