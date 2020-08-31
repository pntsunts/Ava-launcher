
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Run {

    public static void main(String[] args) {
        
        if (args.length == 1)
        {
            validate(args);
            
        }
        else
        {
            System.out.println("NO ARGUMENTS");
        }
    }
    public static void validate(String[] args) {
        WeatherTower weatherTower = new WeatherTower();
        
        try {
            File myfile = new File(args[0]);
            Scanner some = new Scanner(myfile);
            List<String> ls = new ArrayList<>();
            int i = 0;

            while (some.hasNextLine()) {
                ls.add(some.nextLine());
               // System.out.println(ls.get(i++));
            }
            some.close();
            
            if (ls.get(0) != null)
            {
                int counter = Integer.parseInt(ls.get(0));

                if (counter <= 0)
                {
                    System.out.println("Counter must be not be less or equal to 0");
                    System.exit(1);
                }
            }
            i = 1;
            
            while(i < ls.size()){      
                
                String lines[] = ls.get(i).split(" ");
                if (lines.length == 5){

                   Flyable flyable = Aircraftfactory.newAircraft(lines[0], lines[1], Integer.parseInt(lines[2]), Integer.parseInt(lines[3]), Integer.parseInt(lines[4])); 
                   
                   if (flyable != null)
                   {
                       flyable.registerTower(weatherTower);
                   }
                    
                }
                else {
                    System.out.println("Error!! Format is TYPE NAME LONGITUDE LATITUDE HEIGHT ");
                    System.exit(1);
                }
                i++;
            }
        }
        catch (FileNotFoundException e){
            System.out.println("ERROR FILE NOT FOUND");
            e.printStackTrace();
        }
    }
}