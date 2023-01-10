package Part2;

import org.junit.Test;

public class TestQueueFrom2Stacks {

    @Test
    public void partC(){
        QueueFrom2Stacks queueFrom2Stacks = new QueueFrom2Stacks();
        queueFrom2Stacks.enqueue(10);
        queueFrom2Stacks.show();
        queueFrom2Stacks.enqueue(20);
        queueFrom2Stacks.show();
        queueFrom2Stacks.enqueue(30);
        queueFrom2Stacks.show();
        queueFrom2Stacks.dequeue();
        queueFrom2Stacks.show();
        queueFrom2Stacks.dequeue();
        queueFrom2Stacks.show();
        queueFrom2Stacks.enqueue(40);
        queueFrom2Stacks.show();
        queueFrom2Stacks.dequeue();
        queueFrom2Stacks.show();
        queueFrom2Stacks.enqueue(50);
        queueFrom2Stacks.show();
        queueFrom2Stacks.enqueue(60);
        queueFrom2Stacks.show();
        queueFrom2Stacks.dequeue();
        queueFrom2Stacks.show();
        queueFrom2Stacks.dequeue();
        queueFrom2Stacks.show();
        queueFrom2Stacks.dequeue();
        queueFrom2Stacks.show();
    }
}
