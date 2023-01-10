package TP06.ex1;

public class Point {
    int x;
    int y;
    public Point(){
        this(0,0);
    }
    public Point(int x){
        this(x,0);
    }
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public double distance(Point anotherPoint){
        return Math.sqrt(Math.pow(this.x-anotherPoint.x,2)+Math.pow(this.y-anotherPoint.y,2));
    }
}
