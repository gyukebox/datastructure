package datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    private TreeNode root;
    private TreeNode currentNode;

    private String command;
    private Queue<String> options;

    private List history;

    public Tree(String data) {
        root = new TreeNode(data, null);
        currentNode = root;
        history = new List();
    }

    public TreeNode parent(TreeNode v) {
        return v.getParent();
    }

    public ArrayList<TreeNode> children(TreeNode v) {
        return v.getChildren();
    }

    public boolean isInternal(TreeNode v) {
        if (!children(v).isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExternal(TreeNode v) {
        if (children(v).isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRoot(TreeNode v) {
        if (parent(v) == null) {
            return true;
        } else {
            return false;
        }
    }

    public void addChild(TreeNode p, String data) {
        TreeNode newNode = new TreeNode(data, p);
        p.getChildren().add(newNode);
    }

    public TreeNode remove(TreeNode v) {
        for (TreeNode child : children(v.getParent())) {
            if (child == v) {
                v.getParent().getChildren().remove(v);
                break;
            }
        }
        return v;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void preorder(TreeNode v) {
        System.out.println(v.getData());
        for (TreeNode child : children(v)) {
            preorder(child);
        }
    }

    private TreeNode recursiveFinder(TreeNode v, String data) {
        //visit
        if (v.getData().equals(data)) {
            return v;
        } else {
            for (TreeNode child : children(v)) {
                TreeNode target = recursiveFinder(child, data);
                if (target != null) {
                    return target;
                }
            }
            return null;
        }
    }

    public TreeNode findNode(String data) {
        return recursiveFinder(root, data);
    }

    //dealing with currentNode

    public void setCurrentNode(TreeNode v) {
        this.currentNode = v;
    }

    public String getCurrentNodePath() {
        Stack<String> stack = new Stack<>();
        TreeNode curr = currentNode;

        while (curr != null) {
            stack.push(curr.getData());
            stack.push("/");
            curr = curr.getParent();
        }

        String path = "";
        while (!stack.isEmpty()) {
            path += stack.pop();
        }

        return path;
    }

    //dealing with options
    private String getCommand() {
        return this.command;
    }

    private Queue<String> getOptions() {
        return this.options;
    }

    public void parseCommand(String str) {
        this.options = new LinkedList<>();
        String array[] = str.split(" ");
        this.command = array[0];
        for (int i = 1; i < array.length; i++) {
            this.options.offer(array[i]);
        }
    }

    public void executeCommand(String str) {
        history.addLast(str);
        parseCommand(str);

        if (this.command.equals("ls")) {
            this.executeLs();
        } else if (this.command.equals("cd")) {
            this.executeCd();
        } else if (this.command.equals("mkdir")) {
            this.executeMkdir();
        } else if (this.command.equals("pwd")) {
            this.executePwd();
        } else if (this.command.equals("whereis")) {
            this.executeWhereis();
        } else if (this.command.equals("history")) {
            this.executeHistory();
        } else if (this.command.equals("rm")) {
            this.executeRm();
        } else if (this.command.equals("cp")) {
            this.executeCp();
        } else if (this.command.equals("mv")) {
            this.executeMv();
        } else {
            System.out.println("===============================================");
            System.out.println("| Usage:[Command] [Option arg]                 |");
            System.out.println("| ->Command list:(pwd, ls, cd, mkdir, whereis) |");
            System.out.println("===============================================");
        }
    }

    private void executeLs() {
        for (TreeNode subDirectory : children(currentNode)) {
            System.out.print(subDirectory.getData() + " ");
        }
        System.out.println();
    }

    private void executeCd() {
        //cd dir
        if (options.size() == 0) {
            System.out.println("Error : size is 0");
            return;
        }

        String dirName = options.poll();
        if (dirName.equals("..")) {
            this.setCurrentNode(this.currentNode.getParent());
        } else {
            for (TreeNode target : children(currentNode)) {
                if (target.getData().equals(dirName)) {
                    this.setCurrentNode(target);
                    return;
                }
            }
            System.out.println("Error : invalid option");
        }
    }

    private void executeMkdir() {
        if (options.size() == 0) {
            return;
        }

        String newdir = options.poll();
        this.addChild(currentNode, newdir);
    }

    private void executePwd() {
        System.out.println(getCurrentNodePath());
    }

    private void executeWhereis() {
        if (options.size() == 0) {
            return;
        }

        String dirName = options.poll();
        TreeNode original = this.currentNode;
        this.setCurrentNode(findNode(dirName));
        System.out.println(getCurrentNodePath());
        setCurrentNode(original);
    }

    private void executeHistory() {
        if (options.size() == 0) {
            ListNode curr = history.getHeader().getNextNode();
            while (curr != history.getTrailer()) {
                System.out.println(curr.getCommand());
                curr = curr.getNextNode();
            }
        } else {
            String opt = options.poll();
            if (opt.equals("-c")) {
                history.initialization();
            }
        }
    }

    private void executeRm() {
        String opt = options.poll();

        if (opt.equals("-r")) {
            String toRemoveName = options.poll();
            if (toRemoveName == null) {
                return;
            }

            TreeNode toRemove = findNode(toRemoveName);
            remove(toRemove);
        } else {
            TreeNode toRemove = findNode(opt);
            if (toRemove == null) {
                System.out.println("Error : Directory does not exist");
                return;
            }

            if (isInternal(toRemove)) {
                System.out.println("Error : Directory not empty");
            } else {
                remove(toRemove);
            }
        }
    }

    private void executeCp() {
        // cp folder dest
        // cp -r folder dest
        String str = options.poll();
        String folderName;
        String destName;
        TreeNode dest;

        if (str.equals("-r")) {
            folderName = options.poll();
            destName = options.poll();

            if (folderName == null || destName == null) {
                return;
            }

            if(findNode(folderName) == null) {
                System.out.println("Error : Directory does not exist");
                return;
            }

            dest = findNode(destName);
            if(dest == null) {
                System.out.println("Error : Directory does not exist");
                return;
            }

            for (TreeNode t : children(dest)) {
                if (t.getData().equals(folderName)) {
                    System.out.println("Error : Duplicate");
                    return;
                }
            }

            addChild(dest, folderName);
        } else {
            folderName = str;
            destName = options.poll();

            if (folderName == null || destName == null) {
                return;
            }

            TreeNode folder = findNode(folderName);
            if(folder == null) {
                System.out.println("Error : Directory does not exist");
                return;
            }

            if (isExternal(folder)) {
                dest = findNode(destName);
                if(dest == null) {
                    System.out.println("Error : Directory does not exist");
                    return;
                }

                for (TreeNode t : children(dest)) {
                    if (t.getData().equals(folderName)) {
                        System.out.println("Error : Duplicate");
                        return;
                    }
                }
                addChild(dest, folderName);
            } else {
                System.out.println("Error : Directory not empty");
            }
        }
    }

    private void executeMv() {
        //mv -r target new
        //mv target new

        String opt = options.poll();

        if (opt.equals("-r")) {
            String target = options.poll();
            String dest = options.poll();
            TreeNode targetNode = findNode(target);
            TreeNode destNode = findNode(dest);

            if(targetNode == null || destNode == null) {
                System.out.println("Error : Directory does not exist");
                return;
            }

            for (TreeNode t : children(parent(targetNode))) {
                if(t == targetNode) {
                    children(parent(targetNode)).remove(t);
                    break;
                }
            }
            targetNode.setParent(destNode);
            children(destNode).add(targetNode);
        } else {
            String target = opt;
            String dest = options.poll();
            TreeNode targetNode = findNode(target);
            TreeNode destNode = findNode(dest);

            if(targetNode == null || destNode == null) {
                System.out.println("Error : Directory does not exist");
                return;
            }

            if (isExternal(targetNode)) {
                for (TreeNode t : children(parent(targetNode))) {
                    if(t == targetNode) {
                        children(parent(targetNode)).remove(t);
                        break;
                    }
                }

                targetNode.setParent(destNode);
                children(destNode).add(targetNode);
            } else {
                System.out.println("Error : Directory not empty");
            }
        }
    }

}
