/*
 * ************** Commands to excute the file ****************
 * javac TemperatureHumidity.java
 * java TemperatureHumidity
 */
import java.io.*;
public class TemperatureHumidity {
    
    public static void main(String a[]) throws InterruptedException, IOException {
        while(true) {
            read();
            Thread.sleep(1000);
        }
    }
    
    public static void read (){
        try{
            Process p = Runtime.getRuntime().exec("python TemperatureHumidity.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            float temperature = Float.valueOf(in.readLine()).floatValue();
            float humidity = Float.valueOf(in.readLine()).floatValue();
            System.out.println("Temperature : " + temperature + "\nHumidity : " + humidity);
        } catch(Exception e){}
    }
    
}
