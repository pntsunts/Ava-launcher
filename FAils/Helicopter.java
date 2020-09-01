
public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        String apply = "Helicopter#" + this.name + "(" + this.id + ")";

        System.out.printf("%s", apply);

        if (weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 2, coordinates.getLatitude() + 0, coordinates.getLongitude() + 10);
            System.out.println("Yoooo yoooo it's so hot!!");
            
        }
        else if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 0, coordinates.getLatitude() + 0, coordinates.getLongitude() + 5);
            System.out.println("The rain is too much!!");
        }
        else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 0, coordinates.getLatitude() + 0, coordinates.getLongitude() + 1);
            System.out.println("I cannot see i am gonna hit the clouds!!");
        }
        else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 12, coordinates.getLatitude() + 0, coordinates.getLongitude() + 0);
            System.out.println("its cold up here!!");
        }

    }
    
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower say: Helicopter# " + this.name +"( "+ this.id + ")"+ "registered to tower");
    }
}