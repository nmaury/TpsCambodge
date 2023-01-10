package Part2;

import java.util.AbstractMap;

public class ArrayQueue implements Queue{
    private int head;
    private int tail;
    private Object[] arrayQueue;
    private int n;
    public ArrayQueue(int size) {
        arrayQueue = new Object[size];
        this.head = 0;
        this.tail = 0;
        this.n = size;
    }

    @Override
    public void enqueue(Object o) {
        if(this.size() == this.n-1){
            this.increaseCapacity();
        }
        arrayQueue[this.tail]= o;
        this.tail= (this.tail+1) % this.n;
    }
    @Override
    public Object dequeue() {
        if(this.isEmpty()){
            System.out.println("The Queue is empty !");
            System.exit(-2);
        }
        Object pop = arrayQueue[this.head];
        arrayQueue[this.head] = null;
        this.head = (this.head+1) % this.n;
        if(this.isEmpty()){
            this.head=0;
            this.tail=0;
        }
        return pop;
    }

    @Override
    public int size() {
        return (this.n - this.head + this.tail) % this.n;
    }

    @Override
    public Object front() {
        if(this.isEmpty()){
            System.out.println("The Queue is empty !");
            System.exit(-3);
        }
        return arrayQueue[this.head];
    }

    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }
    public static void show(ArrayQueue arrayQueue){
        System.out.print("--------------------------------------\n");
        for (Object o : arrayQueue.arrayQueue){
                System.out.print(o + " ; ");
        }
        System.out.print("\n--------------------------------------\n");
    }
    public void increaseCapacity(){
        int temp = this.n-1;
        this.n = this.n * 2;
        Object[] newArray = new Object[this.n];
        int i = 0;
        while(!this.isEmpty()){
            newArray[i] = this.dequeue();
            i++;
        }
        this.head=0;
        this.tail = temp;
        arrayQueue = newArray;
    }
    public Object getBack(){
        Object o = null;
        while(!this.isEmpty()){
            o = this.dequeue();
        }
        return o;
    }
    public Object getBackUnchanged(){
        Object o = null;
        int taille = this.size();
        while(taille>0){
            o = this.dequeue();
            this.enqueue(o);
            taille--;
        }
        return o;
    }
    public ArrayQueue copy(){
        ArrayQueue copy = new ArrayQueue(1);
        Object o = null;
        int taille = this.size();
        while(taille>0){
            o = this.dequeue();
            this.enqueue(o);
            copy.enqueue(o);
            taille--;
        }
        return copy;
    }
    public static void remplaceIfPresent(ArrayQueue arrayQueue,Object item1,Object item2){
        Object temp = null;
        int taille = arrayQueue.size();
        while(taille>0){
            temp = arrayQueue.dequeue();
            if(temp.equals(item1)){
                arrayQueue.enqueue(item2);
            }else{
                arrayQueue.enqueue(temp);
            }
            taille--;
        }
    }


    public void addNotebooks(String data){
        String [] notebookInput = data.split(";");
        this.enqueue(new AbstractMap.SimpleEntry<Integer, Double>(Integer.parseInt(notebookInput[0]),Double.parseDouble(notebookInput[1])));
        System.out.println(((AbstractMap.SimpleEntry)this.front()).getKey());
        System.out.println(((AbstractMap.SimpleEntry)this.front()).getValue());
    }

    public void saleInputLine(int quantity){
        System.out.println(quantity+" notebooks sold");
        double total =0;
        while (quantity>0){
            int topNotebooks = (int) ((AbstractMap.SimpleEntry) this.front()).getKey();
            double priceNotebook = (double) ((AbstractMap.SimpleEntry) this.front()).getValue();
            if( topNotebooks<= quantity){
                quantity = quantity-topNotebooks;
                System.out.printf("%d at %.2f each \t sales: $%.2f \n",topNotebooks, priceNotebook*1.2, topNotebooks*priceNotebook*1.2);
                total+=topNotebooks*priceNotebook*1.2;
                this.dequeue();
            }else{
                int notebooksLeft = topNotebooks - quantity;
                System.out.printf("%d at %.2f each \t sales: $%.2f \n",quantity, priceNotebook*1.2, quantity*priceNotebook*1.2);
                total+=quantity*priceNotebook*1.2;
                quantity=0;
                this.dequeue();
                this.enqueue(new AbstractMap.SimpleEntry<>(notebooksLeft,priceNotebook));
            }
        }
        System.out.printf("\t\t\t\t\t total sales: $%.2f \n",total);
    }
}

