package TP06.ex1;

public class Circle {
    Point center;
    Point p;
    public Circle(Point _center,Point p){
        this.center=_center;
        this.p=p;
    }
    public double lenght(){
        return 2*Math.PI*this.p.distance(this.center);
    }
    public double surface(){
        return Math.PI*Math.pow(this.p.distance(this.center),2);
    }
    public double radius(){
        return this.p.distance(this.center);
    }
}
