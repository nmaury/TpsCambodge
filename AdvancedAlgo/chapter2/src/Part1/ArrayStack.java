package Part1;

import java.util.AbstractMap;

public class ArrayStack implements Stack {
    // default capacity of stack
    public static final int CAPACITY = 1024;

    private int N; // maximum capacity of the stack
    private Object S[]; // S holds the elements of the stack
    private int t = -1; // the top element of the stack

    public ArrayStack(){
        this(CAPACITY);
    }
    public ArrayStack(int cap){
        this.N=cap;
        this.S=new Object[this.N];
    }
    @Override
    public void push(Object obj)  {
        if(this.size()==this.N){
            this.extendSize(obj);
        }else{
            this.t++;
            this.S[this.t]=obj;
        }
    }
    public void extendSize(Object obj){
        Object[] NewS = new Object[2*this.N];
        for (int i = 0; i<this.size();i++){
            NewS[i]= this.S[i];
        }
        this.t++;
        NewS[this.t]=obj;
        this.S = NewS;
    }

    @Override
    public String toString() {
        String res = "";
        for(int i=0;i<this.size();i++) {
            res += this.S[i] + " ; ";
        }
        if(res!=""){
            return res.substring(0,res.length()-3);

        }else {
            return res;
        }
    }

    @Override
    public Object pop() throws StackException {
        if(this.isEmpty()){
            throw new StackException("Part1.Stack is empty !");
        }else{
            Object res = this.S[this.t];
            this.S[this.t]=null;
            this.t--;
            return res;
        }
    }

    @Override
    public Object top() throws StackException {
        if(this.isEmpty()){
            throw new StackException("Part1.Stack is empty !");
        }else {
            return this.S[this.t];
        }
    }

    @Override
    public boolean isEmpty() {
        return this.t<0;
    }

    @Override
    public int size() {
        return (this.t+1);
    }
    public String readAndPrintReverse(String data){
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Enter a set of numbers using the template \"number1;number2;...;numberN\": ");
        String data = sc.next();*/
        String[] numbers = data.split(";");
        for (int i = numbers.length-1; i>=0;i--){
            this.push(numbers[i]);
        }
        System.out.println(this);
        return this.toString();
    }
    public boolean isRightParenthesis(String data){
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String containing parenthesis patterns: ");
        String data = sc.next();*/
        for (int i =0;i<data.length();i++){
            if(data.charAt(i)=='('){
                this.push("(");
            }else if(data.charAt(i)==')'){
                try {
                    this.pop();
                }catch (StackException s){
                    return false;
                }
            }
        }
        return this.isEmpty();
    }
    public boolean isRightParenthesisAndBrackets(String data){
        for(int i = 0 ; i< data.length();i++){
            if(data.charAt(i)=='['){
                this.push("[");
            }else if(data.charAt(i)=='('){
                this.push("(");
            }else if(data.charAt(i)==')'){
                if(this.top()=="("){
                    this.pop();
                }else{
                    return false;
                }
            }else if(data.charAt(i)==']'){
                if(this.top()=="["){
                    this.pop();
                }else{
                    return false;
                }
            }
        }
        return this.isEmpty();
    }
    public boolean aEqualsToB(String data){
        int ite = 0;
        while(data.charAt(ite)=='A'){
            this.push("A");
            ite++;
        }
        for(int i = ite; i<data.length();i++){
            if(data.charAt(i)=='B'){
                this.pop();
            }else{
                return false;
            }
        }
        return this.isEmpty();
    }
    public boolean aEqualsToBEqualsToC(String data){
        ArrayStack bToC =new ArrayStack();
        int ite = 0;
        while(data.charAt(ite)=='A'){
            this.push("A");
            ite++;
        }
        while(data.charAt(ite)=='B'){
            this.pop();
            bToC.push("B");
            ite++;
        }
        for(int i = ite; i<data.length();i++){
            if(data.charAt(i)=='C'){
                bToC.pop();
            }else{
                return false;
            }
        }
        return this.isEmpty() && bToC.isEmpty();
    }

    public void addNotebooks(String data){
        String [] notebookInput = data.split(";");
        this.push(new AbstractMap.SimpleEntry<Integer, Double>(Integer.parseInt(notebookInput[0]),Double.parseDouble(notebookInput[1])));
        //System.out.println(((AbstractMap.SimpleEntry)this.top()).getKey());
        //System.out.println(((AbstractMap.SimpleEntry)this.top()).getValue());
    }
    public double saleInputLine(int quantity){
        System.out.println(quantity+" notebooks sold");
        double total =0;
        while (quantity>0){
            int topNotebooks = (int) ((AbstractMap.SimpleEntry) this.top()).getKey();
            double priceNotebook = (double) ((AbstractMap.SimpleEntry) this.top()).getValue();
            if( topNotebooks<= quantity){
                quantity = quantity-topNotebooks;
                System.out.printf("%d at %.2f each \t sales: $%.2f \n",topNotebooks, priceNotebook*1.2, topNotebooks*priceNotebook*1.2);
                total+=topNotebooks*priceNotebook*1.2;
                this.pop();
            }else{
                int notebooksLeft = topNotebooks - quantity;
                System.out.printf("%d at %.2f each \t sales: $%.2f \n",quantity, priceNotebook*1.2, quantity*priceNotebook*1.2);
                total+=quantity*priceNotebook*1.2;
                quantity = 0;
                this.pop();
                this.push(new AbstractMap.SimpleEntry<>(notebooksLeft,priceNotebook));
            }
        }
        System.out.printf("\t\t\t\t\t total sales: $%.2f \n",total);
        return total;
    }

}
