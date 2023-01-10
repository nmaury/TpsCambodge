import org.junit.Test;
import java.util.AbstractMap;

import static org.junit.Assert.*;

public class TestStack {

        private ArrayStack arrayStack = new ArrayStack();;

        @Test
         public void partA(){
             this.arrayStack.push(1);
             assertEquals("1", this.arrayStack.toString());
             this.arrayStack.push(2);
             assertEquals("1 ; 2", this.arrayStack.toString());
             this.arrayStack.push(3);
             assertEquals("1 ; 2 ; 3", this.arrayStack.toString());
         }
         @Test
         public void partB1(){
             assertEquals("5 ; 4 ; 3 ; 2 ; 1",this.arrayStack.readAndPrintReverse("1;2;3;4;5"));
         }
         @Test
         public  void partB2(){
             assertTrue(this.arrayStack.isRightParenthesis("()(())"));
             assertFalse(this.arrayStack.isRightParenthesis("(()(()"));
         }
         @Test
         public void partB3(){
            assertTrue(this.arrayStack.isRightParenthesisAndBrackets("[()[]]"));
            assertFalse(this.arrayStack.isRightParenthesisAndBrackets("[(])"));
        }
        @Test
        public void partB4(){
            assertTrue(this.arrayStack.aEqualsToB("AAABBB"));
            assertFalse(this.arrayStack.aEqualsToB("AAABB"));
            assertFalse(this.arrayStack.aEqualsToB("ABABAB"));
        }
        @Test
    public void partB5(){
            assertTrue(this.arrayStack.aEqualsToBEqualsToC("AABBCC"));
        }
        @Test
    public void partB6(){
            this.arrayStack.addNotebooks("50;1.25");
            this.arrayStack.addNotebooks("100;1.10");
            this.arrayStack.addNotebooks("50;1.00");
            assertEquals(267,this.arrayStack.saleInputLine(200),.1);
        }

}
