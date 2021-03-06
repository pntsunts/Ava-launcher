

public class WeatherTower extends Tower {
    WeatherProvider weatherProvider = new WeatherProvider(); 

    public String getWeather(Coordinates coordinates)
    {
        return weatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather(){
        this.conditionsChanged();
    }   
}