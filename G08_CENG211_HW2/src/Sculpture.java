
public class Sculpture extends Artwork{
	// Constructor(s)
	public Sculpture(){
		super();
	}
	public Sculpture(String artist,String material, double weight){
		super();
		this.setArtist(artist);
		this.setMaterial(material);
		this.setWeight(weight);
		
	}
	public Sculpture(String name, String style,String artist,String material, double weight){
		super();
		this.setArtist(artist);
		this.setMaterial(material);
		this.setWeight(weight);
		this.setName(name);
		this.setStyle(style);
	}
	
	@Override
	public double calculateCost() {
		if (this.getMaterial().equals(TypeDefs.MATERIAL_MARBLE)) {
			return this.getWeight()*TypeDefs.UNIT_COST_MARBLE_SCULPTURE;
		}
		return this.getWeight()*TypeDefs.UNIT_COST_BRONZE_SCULPTURE;
	}
	@Override
	public boolean IsTradable() {
		if (!this.getStyle().equals(TypeDefs.STYLE_BAROQUE)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		String str="Scuplture\n\tName: "+this.getName()+"\n\tStyle: "+this.getStyle();
		str+="\n\tArtist: "+this.getArtist()+"\n\tWeight: "+this.getWeight()+"\n\tMaterial: "+this.getMaterial();
	   return str;
	}

	@Override
	protected int compareTo(TypeDefs.SortMethod sortMethod, Artwork other) {
		switch(sortMethod) {
    	case NAME:
    		return this.getName().compareTo(other.getName());
    	case STYLE:
    		return this.getStyle().compareTo(other.getStyle());
    	case ARTIST:
    		return this.getArtist().compareTo(other.getArtist());
    	case MATERIAL:
    		return this.getMaterial().compareTo(other.getMaterial());
    	default:
    		break;
		}
		return 0;
	}
	
}
