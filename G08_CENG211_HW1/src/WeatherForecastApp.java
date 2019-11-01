import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class WeatherForecastApp {

	private static final String CITIES_FILE_PATH = "src/CENG211_HW1_Cities.csv";
	private static final String WEEKLY_FORECAST_FILE_PATH = "src/CENG211_HW1_WeeklyForecast.csv";
	private static final int DAY_NUMBER = 7;
	private static final int CITY_NUMBER = 81;
	private static final int REGION_NUMBER = 7;
	private static final LocalDate START_DATE = LocalDate.of(2019, 10, 14);
	private static final LocalDate END_DATE = LocalDate.of(2019, 10, 20);
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		// Create WeeklyForecast var.
		CityWeather[][] weeklyForecast = new CityWeather[CITY_NUMBER+1][DAY_NUMBER];
		Region[] regionList =new Region[REGION_NUMBER+1];
		String[] cityNames = new String[CITY_NUMBER];
		// Read Cities File
		BufferedReader readerCities = FileIO.ReadFile(CITIES_FILE_PATH);
		String lineCities = readerCities.readLine();
		while (lineCities!=null) {
			String[] cityArr=lineCities.split(",");
			if(cityArr.length == 5) {
				int newCityPlateNo = Integer.parseInt(cityArr[0]);
				String newCityName=cityArr[1];
				int newCityRegionId = Integer.parseInt(cityArr[2]);
				String newCityRegionName = cityArr[3];
				int newCityAltitude = Integer.parseInt(cityArr[4]);
				Region newRegion = new Region(newCityRegionId,newCityRegionName);
				for(int i=0;i<DAY_NUMBER;i++) {
					City newCity = new City(newCityPlateNo,newCityName,newRegion,newCityAltitude);
					 weeklyForecast[newCityPlateNo][i]=new CityWeather();
					 weeklyForecast[newCityPlateNo][i].setCity(newCity);
				}
				// Save city names
				cityNames[newCityPlateNo-1]=newCityName;
			}
			lineCities=readerCities.readLine();
		}
		//Read weekly forecast
		BufferedReader readerForecast = FileIO.ReadFile(WEEKLY_FORECAST_FILE_PATH);
		String lineForecast = readerForecast.readLine();
		
		while(lineForecast != null) {
			String[] forecastArr = lineForecast.split(",");
			if(forecastArr.length == 8) {
				// File Order : PlateNo,Date,Wind,Temperature,FeelsLikeTemperature,Humidity,Precipitation,Visibility
				int plateNo = Integer.parseInt(forecastArr[0]);
				// Set date
				LocalDate date = null;
				String fullDate = forecastArr[1];
				String[] fullDateArr = fullDate.split("\\.");
				if(fullDateArr.length == 3) {
					int day = Integer.parseInt(fullDateArr[0]);
					int month = Integer.parseInt(fullDateArr[1]);
					int year = Integer.parseInt(fullDateArr[2]);
					date = LocalDate.of(year,month,day);
				}
				int wind = Integer.parseInt(forecastArr[2]);
				int temperature = Integer.parseInt(forecastArr[3]);
				int feelsLikeTemperature = Integer.parseInt(forecastArr[4]);
				int humidity = Integer.parseInt(forecastArr[5]);
				int precipitation = Integer.parseInt(forecastArr[6]);
				String visibility = forecastArr[7];
				// Setters
				if(date!=null) {
					int dayId = date.getDayOfMonth()-START_DATE.getDayOfMonth();
					CityWeather cityWeather = weeklyForecast[plateNo][dayId];
					Weather currentWeather = cityWeather.getWeather();
					// Set Date
					cityWeather.setDate(date);
					// Set Wind
					currentWeather.setWind(wind);
					// Set Temperature
					currentWeather.setTemperature(temperature);
					//Set FeelsLikeTemperature
					currentWeather.setFeelsLikeTemperature(feelsLikeTemperature);
					//Set Humidity
					currentWeather.setHumidity(humidity);
					//Set Precipitation
					currentWeather.setPrecipitation(precipitation);
					//Set Visibility
					currentWeather.setVisibility(visibility);		
					cityWeather.setWeather(currentWeather);
				}
				
			}
			lineForecast = readerForecast.readLine();
		}
		
		WeatherQuery weatherQuery = new WeatherQuery(weeklyForecast);
		// Case 1
		String[] citiesHasLowestFLT=weatherQuery.getLowestFLTWeekly();
		String citiesHasLowestFLTStr="";
		for(int i=0;i<citiesHasLowestFLT.length;i++) {
			if(citiesHasLowestFLT[i]!=null) {
				citiesHasLowestFLTStr+=citiesHasLowestFLT[i]+" , ";
			}
		}
		if(citiesHasLowestFLTStr!="") {
			System.out.println("1) "+citiesHasLowestFLTStr);
		}
		// Case 2 
		String[] topCitiesHighestTemperatureVariation=weatherQuery.getHighestTemperatureVariation();
		String topCitiesHighestTemperatureVariationStr="";
		for(int i=0;i<topCitiesHighestTemperatureVariation.length;i++) {
			if(topCitiesHighestTemperatureVariation[i]!=null) {
				topCitiesHighestTemperatureVariationStr+=topCitiesHighestTemperatureVariation[i]+" , ";
			}
		}
		if(topCitiesHighestTemperatureVariationStr!="") {
			System.out.println("2) "+topCitiesHighestTemperatureVariationStr);
		}
		// Case 3
		String highestHumRegion = weatherQuery.getAvrHumidityRegion();
		System.out.println("3) "+highestHumRegion);
		// Case 4
		double[] tempAtHighestAndLowestAltitude = weatherQuery.getTempAtHighestAndLowestAltitudes();
		System.out.printf("4) %,.2f , %,.2f%n", tempAtHighestAndLowestAltitude[1],tempAtHighestAndLowestAltitude[0]);
		// Case 5
		String[] rainyCities = weatherQuery.getRainyCityNamesNextTwoDays();
		String rainyCitiesStr="";
		for(int i=0;i<rainyCities.length;i++) {
			if(rainyCities[i]!=null) {
				rainyCitiesStr+=rainyCities[i]+" , ";
			}
		}
		if(rainyCitiesStr!="") {
			System.out.println("5) "+rainyCitiesStr);
		}
		// Case 6
		Scanner scan= new Scanner(System.in);
		loop: while(true) {
			System.out.println("6) Enter a city name to view flightworthy days: \n");
			System.out.println("(press q to quit, press 1 to display city names)\n");
			String text= scan.nextLine();
			switch (text) {
		        case "q" :
		        	System.out.println("Terminated.");
		        	break loop; 
		        case "1" :
		        	if (cityNames!=null) {
		        		String cityNamesStr = "";
		        		for(int i=0; i<cityNames.length;i++) {
		        			if(cityNames[i]!=null) {
		        				cityNamesStr+=cityNames[i]+" , ";
		        				if(i!=0) {
		        					if(i%10==0) {
			        					cityNamesStr+="\n";
			        				}
		        				}
		        			}
		        		}
		        		System.out.println(cityNamesStr);
	        			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		        	}
		        	break;
		        default:
		        	if (cityNames != null) {
		        		boolean checkCity = false;
		        		for(int i=0;i<CITY_NUMBER;i++) {
		        			if(cityNames[i].equals(text)) {
		        				checkCity = true;
		        				break;
		        			}
		        		}
		        		if(!checkCity) {
		        			System.out.println("There is no such City.");
		        			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		        		}else {
		        			LocalDate[] suitableCityNames = weatherQuery.getSuitableDatesForCity(text);
		        			String suitableCityNamesStr="";
		        			for(int i=0;i<suitableCityNames.length;i++) {
		        				if(suitableCityNames[i]!=null) {
		        			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY"); 
		        					suitableCityNamesStr+=formatter.format(suitableCityNames[i])+" , ";
		        				}
		        			}
		        			if(suitableCityNamesStr!="") {
		        				System.out.println(suitableCityNamesStr);
		        			}
		        		}
		        	}
		        	break;
			}
		}
		

	}
	
}
