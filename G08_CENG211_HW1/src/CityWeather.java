import java.util.*; 
import java.time.LocalDate;

public class CityWeather {
	
	// Attributes
	private City city;
	private Weather weather;
	private LocalDate date;
	
	// Constructor(s)
	public CityWeather() {
		city=new City();
		weather= new Weather();
		date= null;
	}
	// Getters & Setters
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Weather getWeather() {
		return weather;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String toString() {
		String returnVal = "City Name: "+this.getCity().getName()+" City Plate: "+this.getCity().getPlateNo()+" Region ID: "+this.getCity().getRegion().getId();
		returnVal+="Region Name: "+this.getCity().getRegion().getName()+" Altitude: "+this.getCity().getAltitude();
		returnVal+="Wind: "+this.getWeather().getWind() + " Temperature: "+this.getWeather().getTemperature() + " FLT : " +this.getWeather().getFeelsLikeTemperature();
		returnVal+="humidity: "+this.getWeather().getHumidity() + " Precipitation: "+this.getWeather().getPrecipitation() + " Visibility: "+this.getWeather().getVisibility();
		returnVal+="Date: "+this.date;
		returnVal+="************************************************************\n";
		return returnVal;
	}
	
}
