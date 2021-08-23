/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lrafael
 */
public class DateApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        System.out.println(formatter.format(date));
        Date actual = null;
        Date mais10 = null;
        
        String actual_texto = null;
        String mais10_texto = null;
        
        actual_texto = conversor(new Date());
        mais10 = increment10min();
        mais10_texto = conversor (mais10);
        
        actual = conversor(actual_texto);
        mais10 = conversor(mais10_texto);
        
        System.out.println("actual: " + actual);
        System.out.println("mais10: " + mais10);
        System.out.println("----------------------------");
        System.out.println("actual_texto: " + actual_texto);
        System.out.println("mais10_texto: " + mais10_texto);
        
        System.out.println("compare: "+compare_dates());
        System.out.println("Diff: "+getDateDiff(TimeUnit.MINUTES));
    }

    public static String conversor(Date data) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(data);
    }

    public static Date conversor(String data) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date novaData = null;
        try {
            novaData = formatter.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(DateApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return novaData;
    }

    public static Date increment10min() {
        LocalDateTime dateTime = LocalDateTime.now().plus(Duration.of(10, ChronoUnit.MINUTES));
        Date added10Mins = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

        return added10Mins;
    }
    
    public static int compare_dates(){
        
        Date date1 = conversor("23-08-2021 09:55:13");
        Date date2 = new Date();
        
        return date1.compareTo(date2);
    }
    
    public static long getDateDiff (TimeUnit timeUnit)
    {
        Date date1 = conversor("23-08-2021 11:24:13");
        Date date2 = new Date();
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
}
