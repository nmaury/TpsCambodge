package TP09.ex2;

import java.util.Scanner;

public class Point3D {
    private int x;
    private int y;
    private int z;
    private Scanner sc;

    public Point3D() {
        this.sc = new Scanner(System.in);
        this.setX();
        this.setY();
        this.setZ();
    }

    public int getX() {
        return x;
    }

    public void setX() {
        System.out.print("Enter a X value: ");
        while(!this.sc.hasNextInt()){
            this.sc.next();
            System.out.print("Enter a X value: ");
        }
        this.x = this.sc.nextInt();
    }

    public int getY() {
        return y;
    }

    public void setY() {
        System.out.print("Enter a Y value: ");
        while(!this.sc.hasNextInt()){
            this.sc.next();
            System.out.print("Enter a Y value: ");
        }
        this.y = this.sc.nextInt();
    }

    public int getZ() {
        return z;
    }

    public void setZ() {
        System.out.print("Enter a Z value: ");
        while(!this.sc.hasNextInt()){
            this.sc.next();
            System.out.print("Enter a Z value: ");
        }
        this.z = this.sc.nextInt();
    }

    @Override
    public String toString() {
        return "Point -> x: "+this.x+" ; y: "+this.y+" ; z: "+this.z+" ;";
    }

    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D);
    }
}
