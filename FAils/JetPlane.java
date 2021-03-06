

public class JetPlane extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        String apply = "JetPlane#" + this.name + "(" + this.id + ")";

        System.out.printf("%s", apply);

        if (weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
            System.out.println(" The Sun is shining!!");
        }
        else if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 5, coordinates.getHeight() + 0);
            System.out.println(" Careful the lightning!!");
        }
        else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 1, coordinates.getHeight() + 0);
            System.out.println(" we cannot the cities the Fog ishhh!!");
        }
        else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 7);
            System.out.println(" The wind is cold!!");
        }
        
        if (this.coordinates.getHeight() < 1)
        {
            System.out.println(apply + " Landing now !!!!");
            this.weatherTower.unregister(this);
            System.out.println("Tower Says: " + apply + "Unregistered from the Tower");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower say: JetPlane# " + this.name +"( "+ this.id + ")"+ "registered to tower");
    }
}