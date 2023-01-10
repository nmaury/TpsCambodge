package Part2;

public interface Queue {
    public void enqueue(Object o);
    public Object dequeue();
    public int size();
    public Object front();
    public boolean isEmpty();
}
