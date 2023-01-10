package chap3;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private List<BSTNode> tree;

    public BinaryTree() {
        this.tree = new ArrayList<>();
    }
    public String parentKey(BSTNode node){
        int key = Integer.parseInt(node.key().toString());
        if(key!=0){
            int res = (key-1)/2;
            return String.valueOf(res);
        }else{
            return "-";
        }
    }
    public String leftChildKey(BSTNode node){
        int key = Integer.parseInt(node.key().toString());
        if(2*key+1<this.tree.size()){
            return String.valueOf(2*key+1);
        }else{
            return "-";
        }
    }
    public String rightChildKey(BSTNode node){
        int key = Integer.parseInt(node.key().toString());
        if(2*key+2<this.tree.size()){
            return String.valueOf(2*key+2);
        }else{
            return "-";
        }
    }
    public String leftSiblingKey(BSTNode node){
        int key = Integer.parseInt(node.key().toString());
        if(key % 2 ==0){
            return String.valueOf(key-1);
        }else{
            return "-";
        }
    }
    public String rightSiblingKey(BSTNode node){
        int key = Integer.parseInt(node.key().toString());
        if((key % 2 !=0) && (key+1 <this.tree.size())){
            return String.valueOf(key+1);
        }else{
            return "-";
        }
    }
    public void printTree(){
        String[] positions = new String[this.tree.size()];
        String[] parents = new String[this.tree.size()];
        String[] leftChilds = new String[this.tree.size()];
        String[] rightChilds = new String[this.tree.size()];
        String[] leftSibling = new String[this.tree.size()];
        String[] rightSibling = new String[this.tree.size()];

        for(BSTNode node:this.tree){
            positions[Integer.parseInt(node.key().toString())]=node.key().toString();
            parents[Integer.parseInt(node.key().toString())]=this.parentKey(node);
            leftChilds[Integer.parseInt((node.key().toString()))]=this.leftChildKey(node);
            rightChilds[Integer.parseInt((node.key().toString()))]=this.rightChildKey(node);
            leftSibling[Integer.parseInt((node.key().toString()))]=this.leftSiblingKey(node);
            rightSibling[Integer.parseInt((node.key().toString()))]=this.rightSiblingKey(node);

        }
        System.out.println("--------------------------------");
        System.out.print("\tPosition\t");
        for(String s:positions){
            System.out.print(s+"\t");
        }
        System.out.print("\n");
        System.out.print("\tParent\t");
        for(String s:parents){
            System.out.print(s+"\t");
        }
        System.out.print("\n");
        System.out.print("\tLeft Child\t");
        for(String s:leftChilds){
            System.out.print(s+"\t");
        }
        System.out.print("\n");
        System.out.print("\tRight Child\t");
        for(String s:rightChilds){
            System.out.print(s+"\t");
        }
        System.out.print("\n");
        System.out.print("\tLeft Sibling\t");
        for(String s:leftSibling){
            System.out.print(s+"\t");
        }
        System.out.print("\n");
        System.out.print("\tRight Sibling\t");
        for(String s:rightSibling){
            System.out.print(s+"\t");
        }
        System.out.print("\n");
    }
}
