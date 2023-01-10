package TP10.ex4;

import TP10.ex3.Customer;
import TP10.ex3.Status;

import java.util.ArrayList;
import java.util.List;

public class CustomerQueue {
    List<Customer> customerList;

    public CustomerQueue() {
        customerList=new ArrayList<>();
    }
    public int getNumbersCustomers(){
        return this.customerList.size();
    }
    public void addNewCustomer(){
        if(this.getNumbersCustomers()<100){
            this.customerList.add(Customer.createNewCustomer());
        }else{
            System.out.println("the Popular Store is full. Please come later !");
        }
    }
    public void addNewCustomer(Customer c){
        if(this.getNumbersCustomers()<100){
            this.customerList.add(c);
        }else{
            System.out.println("the Popular Store is full. Please come later !");
        }
    }
    public Customer removeCustomer(){
        if(!this.customerList.isEmpty()){
            Customer c=null;
            for(Customer customer : this.customerList){
                if(customer.getStatus()==Status.WAITING_TO_ORDER){
                    c=customer;
                    this.customerList.remove(customer);
                    break;
                }
            }
            assert c != null;
            c.setStatus(Status.ORDERING);
            return c;
        }else{
            System.out.println("The Popular Store is empty!");
            return null;
        }
    }
    public Customer serveCustomer(){
        if(!this.customerList.isEmpty()){
            Customer c=null;
            for(Customer customer : this.customerList){
                if(customer.getStatus()==Status.WAITING_FOR_FOOD){
                    c=customer;
                    this.customerList.remove(customer);
                    break;
                }
            }
            assert c != null;
            c.setStatus(Status.SERVED);
            return c;
        }else{
            System.out.println("The Popular Store is empty!");
            return null;
        }
    }
    @Override
    public String toString() {
        String s="";
        for(Customer c:this.customerList){
            s += c+"\n";
        }
        return s;
    }

    public static void main(String[] args) {
        CustomerQueue customerQueue= new CustomerQueue();
        customerQueue.addNewCustomer();
        customerQueue.addNewCustomer();
        System.out.println(customerQueue);
        Customer c =customerQueue.removeCustomer();
        System.out.println(c);
        System.out.println(customerQueue);
        c.setStatus(Status.WAITING_FOR_FOOD);
        customerQueue.addNewCustomer(c);
        System.out.println(customerQueue);
        Customer c1 = customerQueue.serveCustomer();
        System.out.println(c1);
        System.out.println(customerQueue);
    }
}
