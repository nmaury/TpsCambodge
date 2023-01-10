package chap3;

public class BST {
    public static void main(String[] args) {
        BSTNode node2 = new BSTNode(2,2,null,null);
        BSTNode node120 = new BSTNode(120,120,null,null);
        BSTNode node7 = new BSTNode(7,7,node2,null);
        BSTNode node32 = new BSTNode(32,32,null,null);
        BSTNode node40 = new BSTNode(40,40,null,null);
        BSTNode node42 = new BSTNode(42,42,null,node120);
        BSTNode node24 = new BSTNode(24,24,node7,node32);
        BSTNode node42b=new BSTNode(42,42,node40,node42);
        BSTNode root = new BSTNode(37,37,node24,node42b);
    }
}
