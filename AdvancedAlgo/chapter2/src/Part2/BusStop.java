package Part2;

import java.sql.Time;
import java.util.AbstractMap;

public class BusStop {
    ArrayQueue buses;
    ArrayQueue people;
    static double averageWait= 0.0;
    static int peopleOnTheLine =0;
    static  int peoplePassed =0;
    public BusStop() {
        this.buses = new ArrayQueue(1);
        this.people = new ArrayQueue(1);
    }
    public void addInputLine(char code, Time time,int numberPeople){
        if(code == 'p'){
            this.people.enqueue(new AbstractMap.SimpleEntry<Time,Integer>(time,numberPeople));
            peopleOnTheLine+=numberPeople;
            System.out.println("Time "+time+". "+numberPeople+ " people arrive. "+peopleOnTheLine+" people are now on the line.");
        }else if(code == 'b'){
            this.buses.enqueue(new AbstractMap.SimpleEntry<Time,Integer>(time,numberPeople));
            int peopleGetIn = this.computeBusStop();
            System.out.println("Time "+time+". "+peopleGetIn+ " people get on the bus. "+peopleOnTheLine+" people now remain.");
        }
    }
    public static void getResult(){
        System.out.println("Total number of people: "+BusStop.peoplePassed);
        System.out.println("Total number of seconds wait: "+BusStop.averageWait);
        System.out.println("Average wait Time: "+BusStop.averageWait/(BusStop.peoplePassed*60)+" minutes");
        int averageMinutes = (int) BusStop.averageWait/(BusStop.peoplePassed*60);
        double secondsLeft = (BusStop.averageWait - averageMinutes*60*BusStop.peoplePassed)/BusStop.peoplePassed;
        System.out.println("Average wait Time: "+averageMinutes+" minutes and "+secondsLeft+" seconds.");
    }
    public int computeBusStop(){
        int result =0;
        Object o = this.buses.dequeue();
        Time busTime =  (Time) ((AbstractMap.SimpleEntry) o).getKey();
        int numberSeatLeft =  (int) ((AbstractMap.SimpleEntry) o).getValue();
        this.showBusStop(busTime);
        //System.out.println("bus arrived at: "+busTime);
        //System.out.println("numbers seats left: "+numberSeatLeft);
        while(numberSeatLeft>0){
            Object people = this.people.dequeue();
            Time peopleTime = (Time) ((AbstractMap.SimpleEntry) people).getKey();
            int numberPeople =  (int) ((AbstractMap.SimpleEntry) people).getValue();
            if(people!=null){
                if(numberSeatLeft>=numberPeople) {
                    numberSeatLeft = numberSeatLeft-numberPeople;
                    peopleOnTheLine = peopleOnTheLine -numberPeople;
                    peoplePassed += numberPeople;
                    result+=numberPeople;
                    AbstractMap.SimpleEntry<Integer,Integer> gapDate = this.gapDate(busTime,peopleTime);
                    averageWait= averageWait + (gapDate.getKey()*60+gapDate.getValue())*numberPeople;
                }else{
                    int peopleLeft = numberPeople-numberSeatLeft;
                    peopleOnTheLine = peopleOnTheLine -numberSeatLeft;
                    peoplePassed+=numberSeatLeft;
                    result+=numberSeatLeft;
                    AbstractMap.SimpleEntry<Integer,Integer> gapDate = this.gapDate(busTime,peopleTime);
                    averageWait= averageWait + (gapDate.getKey()*60+gapDate.getValue())*numberSeatLeft;
                    this.people.enqueue(new AbstractMap.SimpleEntry<Time,Integer>(peopleTime,peopleLeft));
                    numberSeatLeft=0;
                }
            }
        }
        return result;
    }
    public void showBusStop(Time busTime){
        ArrayQueue copy = this.people.copy();
        Object o = null;
        System.out.println("Bus : "+ busTime);
        while(!copy.isEmpty()){
            o = copy.dequeue();
            if(o != null){
                AbstractMap.SimpleEntry<Integer,Integer> gapDate = this.gapDate(busTime,(Time)((AbstractMap.SimpleEntry)o).getKey());
                System.out.println("Attente: "+gapDate.getKey()+" minutes and "+gapDate.getValue()+" seconds ; gens qui attendent: " +((AbstractMap.SimpleEntry) o).getValue());
            }
        }

    }
    public AbstractMap.SimpleEntry<Integer,Integer> gapDate(Time busTime,Time peopleTime) {
        int gapHours = busTime.getHours() - peopleTime.getHours();
        int gapMinutes = busTime.getMinutes() - peopleTime.getMinutes();
        int gapSeconds = busTime.getSeconds() - peopleTime.getSeconds();
        int gap = gapHours * 60 + gapMinutes;
        return new AbstractMap.SimpleEntry<>(gap,gapSeconds);
    }

    public int getTotalPeople() {
        ArrayQueue copy = this.people.copy();
        Object o = null;
        int numberOfPeople = 0;
        while(!copy.isEmpty()){
            o = copy.dequeue();
            if(o!=null){
               numberOfPeople+= (int) ((AbstractMap.SimpleEntry) o).getValue();
            }
        }
        return numberOfPeople;
    }
}
