

public class Baloon extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;

    
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        String apply = "Baloon#" + this.name + "(" + this.id +   ")";

        System.out.printf("%s", apply);

        if (weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 2, coordinates.getLatitude() + 0, coordinates.getHeight() + 4);
            System.out.println(" Let's enjoy the Sun");
        }
        else if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 5);
            System.out.println(" Showers from heaven!!");
        }
        else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 3);
            System.out.println(" Cant see my Baloon in the Fog!!");
        }
        else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 15);
            System.out.println(" The baloon is too Cold!!");
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
        System.out.println("Tower say: Baloon# " + this.name +"( "+ this.id + ")"+ "registered to tower");
    }
}