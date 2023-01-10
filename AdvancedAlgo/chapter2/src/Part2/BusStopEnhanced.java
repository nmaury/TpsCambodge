package Part2;

import java.sql.Time;
import java.util.AbstractMap;

public class BusStopEnhanced {
    ArrayQueue peopleFront;
    ArrayQueue peopleBack;
    ArrayQueue buses;
    static int peopleOnTheLine=0;
    static int peoplePassed=0;
    static double averageWait=0.0;
    public BusStopEnhanced() {
        peopleBack = new ArrayQueue(1);
        peopleFront = new ArrayQueue(1);
        buses = new ArrayQueue(1);
    }
    public int peopleCount(ArrayQueue array){
        int number=0;
        ArrayQueue copy = array.copy();
        while(!copy.isEmpty()){
            Object o = copy.dequeue();
            int numberOfPeople = (int) ((AbstractMap.SimpleEntry<Time,Integer>)o).getValue();
            number+=numberOfPeople;
        }
        return number;
    }
    public void addInputLine(char code, Time time, int numberPeople){
        if(code == 'p'){
            if(this.peopleCount(this.peopleFront)<this.peopleCount(this.peopleBack)){
                this.peopleFront.enqueue(new AbstractMap.SimpleEntry<Time,Integer>(time,numberPeople));
            }else{
                this.peopleBack.enqueue(new AbstractMap.SimpleEntry<Time,Integer>(time,numberPeople));
            }
            peopleOnTheLine+=numberPeople;
            System.out.println("Time "+time+". "+numberPeople+ " people arrive. "+peopleOnTheLine+" people are now on the line.");
        }else if(code == 'b'){
            this.buses.enqueue(new AbstractMap.SimpleEntry<Time,Integer>(time,numberPeople));
            int peopleGetIn = this.computeBusStop();
            System.out.println("Time "+time+". "+peopleGetIn+ " people get on the bus. "+peopleOnTheLine+" people now remain.");
        }
    }
    public static void getResult(){
        System.out.println("Total number of people: "+BusStopEnhanced.peoplePassed);
        System.out.println("Total number of seconds wait: "+BusStopEnhanced.averageWait);
        System.out.println("Average wait Time: "+BusStopEnhanced.averageWait/(BusStopEnhanced.peoplePassed*60)+" minutes");
        int averageMinutes = (int) BusStopEnhanced.averageWait/(BusStopEnhanced.peoplePassed*60);
        double secondsLeft = (BusStopEnhanced.averageWait - averageMinutes*60*BusStopEnhanced.peoplePassed)/BusStopEnhanced.peoplePassed;
        System.out.println("Average wait Time: "+averageMinutes+" minutes and "+secondsLeft+" seconds.");
    }
    public int computeBusStop(){
        int result =0;
        Object o = this.buses.dequeue();
        Time busTime =  (Time) ((AbstractMap.SimpleEntry) o).getKey();
        int numberSeatLeft =  (int) ((AbstractMap.SimpleEntry) o).getValue();
        this.showBusStop(busTime);
        int numberFront=0;
        int numberBack=0;
        if(this.peopleCount(this.peopleFront)<this.peopleCount(this.peopleBack)){
            numberBack= numberSeatLeft/2;
            numberFront= numberSeatLeft/2+numberSeatLeft%2;
        }else{
            numberFront= numberSeatLeft/2;
            numberBack= numberSeatLeft/2+numberSeatLeft%2;
        }
        //System.out.println("bus arrived at: "+busTime);
        //System.out.println("numbers seats left: "+numberSeatLeft);
        while(numberFront>0 && !this.peopleFront.isEmpty()){
            Object people = this.peopleFront.dequeue();
            Time peopleTime = (Time) ((AbstractMap.SimpleEntry) people).getKey();
            int numberPeople =  (int) ((AbstractMap.SimpleEntry) people).getValue();
            if(people!=null){
                if(numberFront>=numberPeople) {
                    numberFront = numberFront-numberPeople;
                    peopleOnTheLine = peopleOnTheLine -numberPeople;
                    peoplePassed += numberPeople;
                    result+=numberPeople;
                    AbstractMap.SimpleEntry<Integer,Integer> gapDate = this.gapDate(busTime,peopleTime);
                    averageWait= averageWait + (gapDate.getKey()*60+gapDate.getValue())*numberPeople;
                }else{
                    int peopleLeft = numberPeople-numberFront;
                    peopleOnTheLine = peopleOnTheLine -numberFront;
                    peoplePassed+=numberFront;
                    result+=numberFront;
                    AbstractMap.SimpleEntry<Integer,Integer> gapDate = this.gapDate(busTime,peopleTime);
                    averageWait= averageWait + (gapDate.getKey()*60+gapDate.getValue())*numberFront;
                    this.peopleFront.enqueue(new AbstractMap.SimpleEntry<Time,Integer>(peopleTime,peopleLeft));
                    numberFront=0;
                }
            }
        }
        while(numberBack>0 && !this.peopleBack.isEmpty()){
            Object people = this.peopleBack.dequeue();
            Time peopleTime = (Time) ((AbstractMap.SimpleEntry) people).getKey();
            int numberPeople =  (int) ((AbstractMap.SimpleEntry) people).getValue();
            if(people!=null){
                if(numberBack>=numberPeople) {
                    numberBack = numberBack-numberPeople;
                    peopleOnTheLine = peopleOnTheLine -numberPeople;
                    peoplePassed += numberPeople;
                    result+=numberPeople;
                    AbstractMap.SimpleEntry<Integer,Integer> gapDate = this.gapDate(busTime,peopleTime);
                    averageWait= averageWait + (gapDate.getKey()*60+gapDate.getValue())*numberPeople;
                }else{
                    int peopleLeft = numberPeople-numberBack;
                    peopleOnTheLine = peopleOnTheLine -numberBack;
                    peoplePassed+=numberBack;
                    result+=numberBack;
                    AbstractMap.SimpleEntry<Integer,Integer> gapDate = this.gapDate(busTime,peopleTime);
                    averageWait= averageWait + (gapDate.getKey()*60+gapDate.getValue())*numberBack;
                    this.peopleFront.enqueue(new AbstractMap.SimpleEntry<Time,Integer>(peopleTime,peopleLeft));
                    numberBack=0;
                }
            }
        }
        return result;
    }

    public void showBusStop(Time busTime){
        ArrayQueue copy = this.peopleFront.copy();
        Object o = null;
        System.out.println("Bus : "+ busTime);
        System.out.println("Front Queue: ");
        while(!copy.isEmpty()){
            o = copy.dequeue();
            if(o != null){
                AbstractMap.SimpleEntry<Integer,Integer> gapDate = this.gapDate(busTime,(Time)((AbstractMap.SimpleEntry)o).getKey());
                System.out.println("Attente: "+gapDate.getKey()+" minutes and "+gapDate.getValue()+" seconds ; gens qui attendent: " +((AbstractMap.SimpleEntry) o).getValue());
            }
        }
        ArrayQueue copyBack = this.peopleBack.copy();
        System.out.println("Back Queue: ");
        while(!copyBack.isEmpty()){
            o = copyBack.dequeue();
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
}
