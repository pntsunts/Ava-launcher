

public class Baloon extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;

    protected Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        if (weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 2, coordinates.getLatitude() + 0, coordinates.getLongitude() + 10);
            System.out.println("Yoooo yoooo it's so hot!!");
            
        }
        else if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 0, coordinates.getLatitude() + 0, coordinates.getLongitude() + 5);
            System.out.println("Yoooo yoooo it's so hot!!");
        }
        else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 0, coordinates.getLatitude() + 0, coordinates.getLongitude() + 1);
            System.out.println("Yoooo yoooo it's so hot!!");
        }
        else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 12, coordinates.getLatitude() + 0, coordinates.getLongitude() + 0);
            System.out.println("Yoooo yoooo it's so hot!!");
        }

    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower say: Baloon# " + this.name +"( "+ this.id + ")"+ "registered to tower");
    }
}