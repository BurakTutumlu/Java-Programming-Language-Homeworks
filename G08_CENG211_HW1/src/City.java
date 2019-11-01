import java.util.Date;

public class City {
	
	// Attributes
	private int plateNo;
	private String name;
	private Region region;
	private int altitude;
	
	// Constructor(s)
	public City() {
		plateNo=0;
		name= "";
		region=new Region();
		altitude=0;
	}
	public City(int plateNo, String name,Region region, int altitude) {
		this.plateNo=plateNo;
		this.name=name;
		this.region=region;
		this.altitude=altitude;
	}
	// Getters & Setters
	public int getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(int plateNo) {
		this.plateNo = plateNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public int getAltitude() {
		return altitude;
	}
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	
}
