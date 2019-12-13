import java.util.ArrayList;

public abstract class Artwork implements ISearchable,ITradable {
	private String name;
	private String style;
	private String artist;
	private String material;
	private double weight;
	private double length;
	private double width;
	private ArrayList<Architect> architects;
	private double height;
	
	// Constructor(s)
	public Artwork() {
		name="";
		style="";
		artist="";
		material="";
		weight=0.0;
		length=0.0;
		width=0.0;
		architects=new ArrayList<Architect>();
		height=0.0;
	}
	// Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	public ArrayList<Architect> getArchitects() {
		return architects;
	}

	public void setArchitects(ArrayList<Architect> architects) {
		this.architects = architects;
	}
	// Funcs
	public abstract double calculateCost();
	
	protected abstract int compareTo(TypeDefs.SortMethod sortMethod, Artwork item);
	
	public boolean searchFor(String str) {
		
		if(name.equals(str) || style.equals(str) || artist.equals(str) || material.equals(str)
				|| Double.toString(weight).equals(str) || Double.toString(length).equals(str)
				|| Double.toString(width).equals(str) || Double.toString(height).equals(str)) {
			return true;
		}
		for (Architect arch : architects) {
			if(arch.searchFor(str)) {
				return true;
			}
		}
		
		return false;
	}
	public boolean isEqual(Artwork other) {
		if (name.equals(other.getName()) && style.equals(other.getStyle())) {
			return true;
		}
		return false;
	}
	
}
