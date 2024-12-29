
import java.util.*;

class Tree {

    private Object info = null;
    private Tree left = null;
    private Tree right = null;

    public Tree() {
        this(null, null, null);
    }

    public Tree(Object info) {
        this(info, null, null);
    }

    public Tree(Object info, Tree left, Tree right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Object getInfo() {
        return this.info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Tree getLeft() {
        return this.left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return this.right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public void insertionTree(Tree tree, Tree tree1) {
        if ((int) tree1.getInfo() < (int) tree.getInfo()) {
            if (tree.getLeft() == null) {
                tree.setLeft(tree1);
                return;
            }
            insertionTree(tree.getLeft(), tree1);
        } else {
            if (tree.getRight() == null) {
                tree.setRight(tree1);
                return;
            }
            insertionTree(tree.getRight(), tree1);
        }
    }

    public int getHeight(Tree tree) {
        if (tree == null) {
            return 0;
        }
        int L = getHeight(tree.getLeft());
        int R = getHeight(tree.getRight());
        return Math.max(L, R) + 1;
    }

    public boolean search(Tree tree, Object info) {
        if (tree == null) {
            return false;
        }
        boolean b = false;
        if ((int) info < (int) tree.getInfo()) {
            System.out.print("L");
            b = search(tree.getLeft(), info);
        } else if ((int) info > (int) tree.getInfo()) {
            System.out.print("R");
            b = search(tree.getRight(), info);
        } else if ((int) info == (int) tree.getInfo()) {
            return true;
        }
        return b;
    }

    public void printPreOrder(Tree tree) {
        if (tree == null) {
            System.out.print("-");
            return;
        }
        System.out.print(tree.getInfo());
        System.out.print("[");
        printPreOrder(tree.getLeft());
        printPreOrder(tree.getRight());
        System.out.print("]");
    }

    public void printPostOrder(Tree tree) {
        if (tree == null) {
            System.out.print("-");
            return;
        }
        System.out.print("[");
        printPreOrder(tree.getLeft());
        printPreOrder(tree.getRight());
        System.out.print("]");
        System.out.print(tree.getInfo());
    }

    public void printInOrder(Tree tree) {
        if (tree == null) {
            System.out.print("-");
            return;
        }
        System.out.print("[");
        printPreOrder(tree.getLeft());
        System.out.print(tree.getInfo());
        printPreOrder(tree.getRight());
        System.out.print("]");
    }
}

public class BinarySearchTree {

    public static void main(String[] args) {
        Random R = new Random();
        Object n = R.nextInt(11) + 10;
        System.out.println("---Random numbers [" + n + "] ---");
        Object m = R.nextInt(51);
        Tree tree = new Tree(m);
        System.out.print(m + " ");
        for (int i = 0; i < (int) n - 1; i++) {
            m = R.nextInt(51);
            System.out.print(m + " ");
            Tree tree1 = new Tree(m);
            tree.insertionTree(tree, tree1);
        }
        System.out.println();
        System.out.println("--- Tree (Height=" + (tree.getHeight(tree) - 1) + ") ---");
        tree.printPreOrder(tree);
        System.out.println();
        System.out.println("--- Search ---");
        boolean b = false;
        while (!b) {
            m = R.nextInt(51);
            System.out.print(m + ": (");
            boolean bi = tree.search(tree, m);
            System.out.print(") ");
            if (bi) {
                b = bi;
                System.out.println("Found!");
            } else {
                System.out.println("Not Found!");
            }
        }
        //tese1
        /*Tree tree = new Tree(10);
        Object[] m = {2, 6, 3, 8, 4, 12, 14, 16, 15};
        for (int i = 0; i < 9; i++) {
            Tree tree1 = new Tree(m[i]);
            tree.insertionTree(tree, tree1);
        }
        System.out.println();
        tree.printPreOrder(tree);
        System.out.println();
        System.out.println("--- Tree (Height=" + (tree.getHeight(tree) - 1) + ") ---");
        boolean bi = tree.search(tree, 10);
        System.out.print(" " + bi + " ");
        if (bi) {
            System.out.println("Found!");
        } else {
            System.out.println("Not Found!");
        }*/
        //test2
        /*Tree tree = new Tree(5);
        Object[] m = {3,1,4,8,9};
        for(int i=0;i<5;i++){
            Tree tree1 = new Tree(m[i]);
            tree.insertionTree(tree,tree1);
        }
        System.out.println();
        tree.printPreOrder(tree);
        System.out.println();
        System.out.println("--- Tree (Height="+tree.getHeight(tree)+") ---");*/
    }
}
