

public class Baloon extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String apply = "Baloom#" + this.name + "(" + this.id + ")";

        System.out.printf("%s", apply);
        
        String weather = weatherTower.getWeather(this.coordinates);

        if(weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 4, coordinates.getLatitude() + 0, coordinates.getLongitude() + 2);
            System.out.println("Yoooo yoooo it's so hot!!");
        }
        else if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(coordinates.getHeight() - 5, coordinates.getLatitude() + 0, coordinates.getLongitude() + 0);
            System.out.println("Damn Rain!! its slippery");
        }
        else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getHeight() - 3, coordinates.getLatitude() + 0, coordinates.getLongitude() + 0);
            System.out.println("Damn!!! i cannot see this Fog!!");
        }
        else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getHeight() - 15, coordinates.getLatitude() + 0, coordinates.getLatitude() + 0);
            System.out.println("its Freezing out here");
        }
        if (this.coordinates.getHeight() < 1)
        {
            System.out.println(apply + " landing ");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: " + apply + " unregistered from the Tower!!");
        }

    }
    public void registerTower(WeatherTower wTower) {

        this.weatherTower = wTower;
        wTower.register(this);
        System.out.println("Tower says: Baloon# " + this.name +"( "+ this.id + ")"+ "registered to tower");
    }
}