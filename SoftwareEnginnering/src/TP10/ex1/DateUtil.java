package TP10.ex1;

import java.awt.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DateUtil {
    static int id = 0;
    public static void computeSubstraction(Date dateStart, Date dateEnd) throws SQLException, ClassNotFoundException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long timeDifference = dateStart.getTime()-dateEnd.getTime();
        long daysDifference = timeDifference /(1000*3600*24);
        long daysDifferenceAbs = Math.abs(daysDifference)+1;
        //System.out.println(daysDifferenceAbs);
        int idSub = ++DateUtil.id;
        Date dateNow = Date.from(Instant.now());
        String data = "("+idSub+",\""+dateFormat.format(dateStart)+"\",\""+dateFormat.format(dateEnd)+"\","+daysDifferenceAbs+",\"Substraction\",\""+dateFormat.format(dateNow)+"\")";
        System.out.println(data);
        DateTable.insertDateTable(data,"****************");
    }
    static void computeIncrease(Date startDate,int numberOfDays) throws SQLException, ClassNotFoundException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long daysToTime;
        if(numberOfDays<0) {
            daysToTime = (numberOfDays-1) * 1000 * 3600 * 24;
        }else{
         daysToTime = numberOfDays * 1000 * 3600 *24;
        }
        long timeDifference = startDate.getTime()+daysToTime;
        Date newDate = new Date(timeDifference);
        //System.out.println(dateFormat.format(newDate));
        int idSub = ++DateUtil.id;
        Date dateNow = Date.from(Instant.now());
        String data = "("+idSub+",\""+dateFormat.format(startDate)+"\",\""+dateFormat.format(newDate)+"\","+numberOfDays+",\"Increment\",\""+dateFormat.format(dateNow)+"\")";
        System.out.println(data);
        DateTable.insertDateTable(data,"****************");
    }
    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
        DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
        Date dateStart =dateFormat.parse("2022-01-01");
        Date dateEnd = dateFormat.parse("2022-01-28");
        Date dateEnd2 = dateFormat.parse("2022-01-29");
        Date dateStart2 = dateFormat.parse("2022-01-28");
        Date dateStart3 = dateFormat.parse("2020-02-01");
        DateUtil.computeSubstraction(dateStart,dateEnd);
        DateUtil.computeSubstraction(dateStart,dateEnd2);
        DateUtil.computeSubstraction(dateStart2,dateEnd);
        DateUtil.computeSubstraction(dateStart2,dateEnd2);
        DateUtil.computeSubstraction(dateStart3,dateEnd2);
        DateUtil.computeIncrease(dateStart2,3);
        DateUtil.computeIncrease(dateStart3,-11);
        DateUtil.computeIncrease(dateStart3,7);
        DateUtil.computeIncrease(dateStart2,-3);
        DateUtil.computeIncrease(dateStart3,5);
    }
}
