package TP06.ex1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCircle {
    Circle circle;
    @Before
    public void setup(){
        this.circle = new Circle(new Point(2,2),new Point(0));
    }
    @Test
    public void testEmptyPoint(){
        Point p1 = new Point();
        assertEquals(Math.sqrt(2),p1.distance(new Point(1,1)),.1);
    }
    @Test
    public void testLength(){
        Assert.assertEquals(2*Math.PI*Math.sqrt(8),this.circle.lenght(),.1);
    }
    @Test
    public void testRadius(){
        Assert.assertEquals(Math.sqrt(8),this.circle.radius(),.1);
    }
    @Test
    public void testSurface(){
        Assert.assertEquals(Math.PI*8,this.circle.surface(),.1);
    }
}
