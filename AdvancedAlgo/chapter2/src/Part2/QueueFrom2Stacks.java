package Part2;

import Part1.ArrayStack;

public class QueueFrom2Stacks implements Queue{
    ArrayStack s1;
    ArrayStack s2;
    public QueueFrom2Stacks() {
        this.s1 = new ArrayStack();
        this.s2 = new ArrayStack();
    }

    @Override
    public void enqueue(Object o) {
        if(this.s2.isEmpty()){
            this.s1.push(o);
        }else{
            int taille = this.s2.size();
            while(taille>0){
                Object object = this.s2.pop();
                this.s1.push(object);
                taille--;
            }
            this.s1.push(o);
        }
    }

    @Override
    public Object dequeue() {
        if(this.s2.isEmpty()){
            int taille = this.s1.size();
            while(taille>1){
                Object o = this.s1.pop();
                this.s2.push(o);
                taille--;
            }
            return this.s1.pop();
        }else{
            return this.s2.pop();
        }
    }

    @Override
    public int size() {
        return this.s1.size()+this.s2.size();
    }

    @Override
    public Object front() {
        if(this.s2.isEmpty()){
            int taille = this.s1.size();
            while(taille>0){
                Object o = this.s1.pop();
                this.s2.push(o);
                taille--;
            }
            return this.s2.top();
        }else if(this.s1.isEmpty()){
            return this.s2.top();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.s1.isEmpty() && this.s2.isEmpty();
    }
    public void show(){
        System.out.println("S1: ");
        System.out.println(this.s1);
        System.out.println("S2: ");
        System.out.println(this.s2);
    }
}
