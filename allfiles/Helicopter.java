
public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 2, coordinates.getLatitude() + 0, coordinates.getLongitude() + 10);
        }
        else if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 0, coordinates.getLatitude() + 0, coordinates.getLongitude() + 5);
        }
        else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 0, coordinates.getLatitude() + 0, coordinates.getLongitude() + 1);
        }
        else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getHeight() + 12, coordinates.getLatitude() + 0, coordinates.getLongitude() + 0);
        }

    }
    
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower say: Helicopter# " + this.name +"( "+ this.id + ")"+ "registered to tower");
    }
}