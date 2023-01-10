package Part2;

import java.sql.Time;

import static org.junit.Assert.assertEquals;

public class TestQueue {
    public static void main(String[] args) {
        //partA();
        //partB1();
        //partB2();
       //partB3();
        //partB4();
        //partB5();
        partB6();
        partB7();
    }
    private static void partA(){
        ArrayQueue barbeQueue = new ArrayQueue(1);
        barbeQueue.enqueue(10);
        ArrayQueue.show(barbeQueue);
        barbeQueue.enqueue(20);
        ArrayQueue.show(barbeQueue);
        barbeQueue.enqueue(30);
        ArrayQueue.show(barbeQueue);
        barbeQueue.dequeue();
        ArrayQueue.show(barbeQueue);
        barbeQueue.dequeue();
        ArrayQueue.show(barbeQueue);
        barbeQueue.enqueue(40);
        ArrayQueue.show(barbeQueue);
        barbeQueue.dequeue();
        ArrayQueue.show(barbeQueue);
        barbeQueue.enqueue(50);
        ArrayQueue.show(barbeQueue);
        barbeQueue.enqueue(60);
        ArrayQueue.show(barbeQueue);
        barbeQueue.dequeue();
        ArrayQueue.show(barbeQueue);
        barbeQueue.dequeue();
        ArrayQueue.show(barbeQueue);
        barbeQueue.dequeue();
        ArrayQueue.show(barbeQueue);
    }
    private static void partB1(){
        ArrayQueue barbeQueue = new ArrayQueue(1);
        barbeQueue.enqueue(10);
        barbeQueue.enqueue(20);
        barbeQueue.enqueue(30);
        barbeQueue.enqueue(40);
        barbeQueue.enqueue(50);
        barbeQueue.enqueue(60);
        ArrayQueue.show(barbeQueue);
        System.out.println(barbeQueue.getBack());
        ArrayQueue.show(barbeQueue);
    }
    private static void partB2(){
        ArrayQueue barbeQueue = new ArrayQueue(1);
        barbeQueue.enqueue(10);
        barbeQueue.enqueue(20);
        barbeQueue.enqueue(30);
        barbeQueue.enqueue(40);
        barbeQueue.enqueue(50);
        barbeQueue.enqueue(60);
        ArrayQueue.show(barbeQueue);
        System.out.println(barbeQueue.getBackUnchanged());
        ArrayQueue.show(barbeQueue);
    }
    private static void partB3(){
        ArrayQueue barbeQueue = new ArrayQueue(1);
        barbeQueue.enqueue(10);
        /*barbeQueue.enqueue(20);
        barbeQueue.enqueue(30);
        barbeQueue.enqueue(40);
        barbeQueue.enqueue(50);
        barbeQueue.enqueue(60);*/
        ArrayQueue.show(barbeQueue);
        ArrayQueue.show(barbeQueue.copy());
        ArrayQueue.show(barbeQueue);
        barbeQueue.enqueue(20);
        ArrayQueue.show(barbeQueue);
    }

    private static void partB4(){
        ArrayQueue barbeQueue = new ArrayQueue(1);
        barbeQueue.enqueue(10);
        barbeQueue.enqueue(20);
        barbeQueue.enqueue(30);
        barbeQueue.enqueue(40);
        barbeQueue.enqueue(50);
        barbeQueue.enqueue(60);
        ArrayQueue.show(barbeQueue);
        ArrayQueue.remplaceIfPresent(barbeQueue,20,10);
        ArrayQueue.remplaceIfPresent(barbeQueue,30,10);
        ArrayQueue.remplaceIfPresent(barbeQueue,70,10);
        ArrayQueue.show(barbeQueue);
    }
    public static void partB5(){
        ArrayQueue barbeQueue = new ArrayQueue(1);
        barbeQueue.addNotebooks("50;1.25");
        barbeQueue.addNotebooks("100;1.10");
        barbeQueue.addNotebooks("50;1.00");
        barbeQueue.saleInputLine(175);
    }
    public static void partB6(){
        BusStop busStop = new BusStop();
        busStop.addInputLine('p',new Time(10,10,10),15);
        busStop.addInputLine('p',new Time(10,15,10),10);
        busStop.addInputLine('p',new Time(10,16,10),5);
        busStop.addInputLine('b',new Time(10,20,52),25);
        BusStop.getResult();
        busStop.addInputLine('p',new Time(12,16,10),5);
        busStop.addInputLine('p',new Time(12,16,10),15);
        busStop.addInputLine('b',new Time(14,20,52),25);
        BusStop.getResult();
    }
    public static void partB7(){
        BusStopEnhanced busStop = new BusStopEnhanced();
        busStop.addInputLine('p',new Time(10,10,10),15);
        busStop.addInputLine('p',new Time(10,15,10),10);
        busStop.addInputLine('p',new Time(10,16,10),5);
        busStop.addInputLine('b',new Time(10,20,52),25);
        BusStopEnhanced.getResult();
        busStop.addInputLine('p',new Time(12,16,10),5);
        busStop.addInputLine('p',new Time(12,16,10),15);
        busStop.addInputLine('b',new Time(14,20,52),25);
        BusStopEnhanced.getResult();
    }


}
