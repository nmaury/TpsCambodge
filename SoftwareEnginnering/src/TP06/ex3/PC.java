package TP06.ex3;

public class PC {
    int id;
    Status status;
    static int pcNumber = 0;
    public PC(){
        this.id=++pcNumber;
        this.status=Status.NEUTRAL;
    }
    public void setAsDamaged(){
        this.status = Status.DAMAGED;
    }
    public void setAsGood(){
        this.status = Status.GOOD;
    }

    @Override
    public String toString() {
        return id+" -> "+this.status;
    }
}

enum Status{
    NEUTRAL,GOOD,DAMAGED
}
