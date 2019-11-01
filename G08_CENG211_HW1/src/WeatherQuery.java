import java.time.LocalDate;
import java.util.Arrays;

public class WeatherQuery {
	private CityWeather[][] weeklyForecast;
	private static final int CITY_NUMBER=81;
	private static final int DAY_NUMBER = 7;
	private static final int REGION_NUMBER = 7;
	private static final int MAX_WIND_FOR_FLY = 40;
	private static final String VISIBILITY_LOW = "low";
	private static final String VISIBILITY_MEDIUM = "medium";
	private static final String VISIBILITY_HIGH= "high";
	
	
	// Constructor(s)
	public WeatherQuery() {
		this.weeklyForecast=null;
	}
	public WeatherQuery(CityWeather[][] weeklyForecast) {
		this.weeklyForecast=weeklyForecast;
	}
	// Getters & Setters
	public CityWeather[][] getWeeklyForecast() {
		return weeklyForecast;
	}

	public void setWeeklyForecast(CityWeather[][] weeklyForecast) {
		this.weeklyForecast = weeklyForecast;
	}
	
	// Helper Methods
	/*
	 * Traverse Weekly Forecast and Return The List of Cities which has the lowest feels-like-temperature
	 * @param: none
	 * @return: Array of Cities which has the lowest feels-like-temperature.
	 */
	public String[] getLowestFLTWeekly(){
		// Default Declarations
		String[] cityNames = new String[CITY_NUMBER];
		int count=0;
		int lowestFLT = 0;
		if(weeklyForecast!=null) {
			for(int j=1;j<CITY_NUMBER+1;j++) {
				for(int k=0;k<DAY_NUMBER;k++) {
					int currentFLT = weeklyForecast[j][k].getWeather().getFeelsLikeTemperature();
					// Base Condition
					if(count==0 && cityNames[0]=="") {
						cityNames[0]=weeklyForecast[j][k].getCity().getName();
						lowestFLT=currentFLT;
					}else if(lowestFLT > currentFLT) { // Update Lowest FLT
						for(int i=0;i<count;i++) { // Remove Old Data From Array
							cityNames[i]="";
						}
						lowestFLT=currentFLT;
						count=0;
						cityNames[0]=weeklyForecast[j][k].getCity().getName();
					}else if (lowestFLT == currentFLT) { 
						cityNames[count+1]=weeklyForecast[j][k].getCity().getName();
						count++;
					}
				}
			}
		}
		return cityNames;
	}
	/*
	 * Traverse Weekly Forecast and Return The List of Cities which has highest temperature variation
	 * @param: none
	 * @return: Array of Cities which has the lowest feels-like-temperature.
	 */
	public String[] getHighestTemperatureVariation() {
		String[] cityNames = new String[CITY_NUMBER];
		String[] cityList = new String[CITY_NUMBER];
		double[] standartDeviations = new double[CITY_NUMBER];
		if(weeklyForecast!=null) {
			for(int j=1;j<CITY_NUMBER+1;j++) {
				int[] temperatureArr=new int[DAY_NUMBER];
				for(int k=0;k<DAY_NUMBER;k++) {
					temperatureArr[k]=weeklyForecast[j][k].getWeather().getTemperature();
				}
				double currentSD=calculateSD(temperatureArr);
				cityNames[j-1]=weeklyForecast[j][0].getCity().getName();
				standartDeviations[j-1]=currentSD;
			}
			double[] maxSDList = new double[3];
			int cityCount=0;
			// get top three standart deviations
			maxSDList[0]=getAndRemoveMax(standartDeviations);
			maxSDList[1]=getAndRemoveMax(standartDeviations);
			maxSDList[2]=getAndRemoveMax(standartDeviations);
			for(int j=1;j<CITY_NUMBER+1;j++) {
				int[] temperatureArr=new int[DAY_NUMBER];
				for(int k=0;k<DAY_NUMBER;k++) {
					temperatureArr[k]=weeklyForecast[j][k].getWeather().getTemperature();
				}
				double currentSD=calculateSD(temperatureArr);
				if(inArray(currentSD,maxSDList)) {
					cityList[cityCount]=weeklyForecast[j][0].getCity().getName();
					cityCount++;
				}
			}	
		}
		return cityList;
	}
	
	public static double calculateSD(int numArray[])
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.length;
        for(double num : numArray) {
            sum += num;
        }
        double mean = sum/length;
        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        return Math.sqrt(standardDeviation/length);
    }
	
	/*
	 * Traverse Weekly Forecast and Return The Name of region which has highest average humidity
	 * @param: none
	 * @return: Name of Region which has  highest average humidity
	 */
	public String getAvrHumidityRegion() {
		String highestAvrRegion="";
		double highestAvrHum=0;
		if(weeklyForecast!=null) {
			for(int regionId=1;regionId<REGION_NUMBER+1;regionId++) {
				int totalHum = 0;
				int countCity = 0;
				String regionName="";
				for(int j=1;j<CITY_NUMBER+1;j++) {
					for(int k=0;k<DAY_NUMBER;k++) {
						CityWeather currentCW=weeklyForecast[j][k];
						if(currentCW.getCity().getRegion().getId()==regionId) {
							totalHum+=currentCW.getWeather().getHumidity();
							countCity++;
							regionName = currentCW.getCity().getRegion().getName();
						}
					}
				}
				double avrHum = totalHum/countCity;
				if(avrHum>highestAvrHum) {
					highestAvrHum=avrHum;
					highestAvrRegion=regionName;
				}
			}
		}
		
		return highestAvrRegion;
		
	}
	
	/*
	 * Traverse weekly forecast and return the mean temparatures 
	 * at cities which has highest and lowest altitudes
	 * @param: none
	 * @return: mean temperatures
	 */
	public double[] getTempAtHighestAndLowestAltitudes() {
		int lowestAltitude=1,highestAltitude=0;
		double avrTempAtLowest = 0,avrTempAtHighest = 0;
		for(int j=1;j<CITY_NUMBER+1;j++) {
			int totalTemp = 0;
			int currentAltitude = 0;
			for(int k=0;k<DAY_NUMBER;k++) {
				CityWeather currentCW=weeklyForecast[j][k];
				currentAltitude=currentCW.getCity().getAltitude();
				totalTemp+=currentCW.getWeather().getTemperature();
			}
			double tmp_totalTemp = totalTemp;
			double avrTemp=tmp_totalTemp/DAY_NUMBER;
			if(currentAltitude<lowestAltitude) {
				avrTempAtLowest=avrTemp;
				lowestAltitude=currentAltitude;
			}
			if (currentAltitude>highestAltitude) {
				avrTempAtHighest=avrTemp;
				highestAltitude=currentAltitude;
			}
		}
		double[] resp = new double[2];
		resp[0]=avrTempAtLowest;
		resp[1]=avrTempAtHighest;
		return resp;
	}
	
	/*
	 * Traverse Weekly Forecast and Return 
	 * Name of the cities which are rainy in 
	 * next two days
	 * @param: none
	 * @return: Name of the cities which are rainy in 
	 * next two days
	 */
	public String[] getRainyCityNamesNextTwoDays() {
		String[] cityNames=new String[CITY_NUMBER];
		int count=0;
		if(weeklyForecast!=null) {
			for(int j=1;j<CITY_NUMBER+1;j++) {
				boolean firstPrec = weeklyForecast[j][1].getWeather().getPrecipitation() >= 80;
				boolean secondPrec = weeklyForecast[j][2].getWeather().getPrecipitation() >= 80;
				if ( firstPrec && secondPrec) {
					cityNames[count]=weeklyForecast[j][0].getCity().getName();
					count++;
				}
			}
		}
		return cityNames;
	}
	
	/*
	 * Traverse weekly forecast and return the mean temparatures 
	 * at cities which has highest and lowest altitudes
	 * @param: none
	 * @return: mean temperatures
	 */
	public LocalDate[] getSuitableDatesForCity(String cityName) {
		LocalDate[] suitableDates = new LocalDate[DAY_NUMBER];
		int count = 0;
		if (weeklyForecast != null) {
			for(int j=1;j<CITY_NUMBER+1;j++) {
				CityWeather currentCW=weeklyForecast[j][0];
				if (currentCW.getCity().getName().equals(cityName)) {
					for(int k=0;k<DAY_NUMBER;k++) {
						currentCW=weeklyForecast[j][k];
						Weather currentWeather = currentCW.getWeather();
						boolean windStatus = currentCW.getWeather().getWind()< MAX_WIND_FOR_FLY;
						boolean visibilityStatus = currentWeather.getVisibility().equals(VISIBILITY_HIGH) || currentWeather.getVisibility().equals(VISIBILITY_MEDIUM); 
						if (windStatus && visibilityStatus) {
							suitableDates[count]=currentCW.getDate();
							count++;
						}
					}
				}
			}
		}
		return suitableDates;
	}
	///// Helpers /////
	public static double getAndRemoveMax(double[] t) {
	    double maximum = t[0];   // start with the first value
	    int maxIndex = 0;
	    for (int i=1; i<t.length; i++) {
	        if (t[i] > maximum) {
	            maximum = t[i];   // new maximum
	            maxIndex = i;
	        }
	    }
	    t[maxIndex]=0;
	    return maximum;
	}
	// check if an element is in specified array
	public static boolean inArray(double s, double[] t) {
	    for (int i=0; i<t.length; i++) {
	        if(t[i]==s) {
	        	return true;
	        }
	    }
	    return false;
	}
}
