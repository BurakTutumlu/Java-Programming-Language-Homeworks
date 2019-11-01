
public class Region {
	// Attributes
	private int id;
	private String name;
	private City[] cities;
	
	// Constructor
	public Region() {
		this.id=0;
		this.name="";
	}
	public Region(int id, String name) {
		this.id=id;
		this.name=name;
	}
	// Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City[] getCities() {
		return cities;
	}
	public void setCities(City[] cities) {
		this.cities = cities;
	}
	
	
}
