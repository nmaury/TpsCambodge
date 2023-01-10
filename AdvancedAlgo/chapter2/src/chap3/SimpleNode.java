package chap3;

import java.util.ArrayList;
import java.util.List;

public class SimpleNode implements BinNode{
    private int value;
    SimpleNode left;
    SimpleNode right;

    public SimpleNode(int value, SimpleNode left, SimpleNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public Object element() {
        return value;
    }

    @Override
    public void setElement(Object v) {
        this.value= (int) v;
    }

    @Override
    public BinNode left() {
        return left;
    }

    @Override
    public BinNode right() {
        return right;
    }

    @Override
    public boolean isLeaf() {
        return ((left==null)&&(right==null));
    }
    public static void printTree(SimpleNode root){
        if(!root.isLeaf()) {
            if(root.left!=null) {
                SimpleNode.printTree(root.left);
            }
            System.out.print("\t" + root.value);
            if(root.right!=null) {
                SimpleNode.printTree(root.right);
            }
        }else{
            System.out.print("\t" + root.value);
        }
    }
    public static boolean search(SimpleNode s,int k){
        if(s.value==k){
            return true;
        }else{
            if(!s.isLeaf()) {
                if((s.left!=null)&&(s.right!=null)) {
                    return (search(s.left, k) || search(s.right, k));
                }else if(s.left==null){
                    return search(s.right,k);
                }else {
                    return search(s.left,k);
                }
            }else{
                return false;
            }
        }
    }
    public static int sumAllNodes(SimpleNode s){
        if(!s.isLeaf()){
            if ((s.left!=null) && (s.right!=null)){
                return s.value+sumAllNodes(s.left)+sumAllNodes(s.right);
            }else if(s.left==null){
                return s.value+sumAllNodes(s.right);
            }else{
                return s.value+sumAllNodes(s.left);
            }
        }else{
            return s.value;
        }
    }
    public static int height(SimpleNode s){
        if(!s.isLeaf()){
            if ((s.left!=null) && (s.right!=null)){
                int hLeft = height(s.left);
                int hRight = height(s.right);
                if(hLeft>hRight){
                    return 1+hLeft;
                }else{
                    return 1+hRight;
                }
            }else if(s.left==null){
                return 1+height(s.right);
            }else{
                return 1+height(s.left);
            }
        }else{
            return 1;
        }
    }
    public static int leafNumber(SimpleNode s){
        if(!s.isLeaf()){
            if ((s.left!=null) && (s.right!=null)){
                return leafNumber(s.left)+leafNumber(s.right);
            }else if(s.left==null){
                return leafNumber(s.right);
            }else{
                return leafNumber(s.left);
            }
        }else{
            return 1;
        }
    }

    private static void printGivenLevel(SimpleNode root,int level){
        if(root == null){
            return;
        }
        if(level == 1){
            System.out.print(root.value+" ");
        }else if(level>1){
            printGivenLevel(root.left,level-1);
            printGivenLevel(root.right,level-1);
        }
    }
    public static void printLevelOrder(SimpleNode root){
        int h = height(root);
        for(int i = 1;i<=h;i++){
            printGivenLevel(root,i);
            System.out.println("\n");
        }
    }
    public static boolean isBts(SimpleNode root){
        if(!root.isLeaf()){
            if ((root.left!=null) && (root.right!=null)){
                if((root.value>=root.left.value)&&(root.value<=root.right.value)){
                    return isBts(root.left) && isBts(root.right);
                }else{
                    return false;
                }
            }else if(root.left==null){
                    if(root.value<=root.right.value){
                        return isBts(root.right);
                    }else{
                        return false;
                    }
            }else{
                    if(root.value>=root.left.value){
                        return isBts(root.left);
                    }else{
                        return false;
                    }
            }
        }else{
            return true;
        }
    }
    public static void main(String[] args) {
        SimpleNode leaf2 = new SimpleNode(2,null,null);
        SimpleNode leaf120 = new SimpleNode(120,null,null);
        SimpleNode node7 = new SimpleNode(7,leaf2,null);
        SimpleNode node32 = new SimpleNode(32,null,null);
        SimpleNode node24 = new SimpleNode(24,node7,node32);
        SimpleNode node42_1 = new SimpleNode(42,null,leaf120);
        SimpleNode node40 = new SimpleNode(40,null,null);
        SimpleNode node42_2 = new SimpleNode(42,node40,node42_1);
        SimpleNode root = new SimpleNode(37,node24,node42_2);
        System.out.println("Tree printing with the inorder traversal method: ");
        SimpleNode.printTree(root);
        System.out.print("\n");
        System.out.println(SimpleNode.search(root,2));
        System.out.println(SimpleNode.search(root,40));
        System.out.println(SimpleNode.search(root,4));
        System.out.println(SimpleNode.search(root,32));
        System.out.println("Sum: "+SimpleNode.sumAllNodes(root));
        System.out.println("Height: "+SimpleNode.height(root));
        System.out.println("Number of leaves: "+SimpleNode.leafNumber(root));
        System.out.println("Tree printing with the level traversal method:");
        SimpleNode.printLevelOrder(root);
        System.out.println("isBts: ");
        System.out.println(SimpleNode.isBts(root));
    }
}
