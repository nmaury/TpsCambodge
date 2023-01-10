package TP10.ex3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Customer {
    private static int numbers=0;
    private Date enterDate;
    private Status status;
    private int id;
    public Customer() {
        this.status = Status.WAITING_TO_ORDER;
        this.enterDate=Date.from(Instant.now());
        this.id = ++Customer.numbers;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        return "Customer n°"+this.id+" ; enter date: "+dateFormat.format(this.enterDate)+" ; status: "+this.status;
    }

    public static Customer createNewCustomer(){
        Customer c = new Customer();
        System.out.println("A new Customer is arrived !");
        return c;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

}
