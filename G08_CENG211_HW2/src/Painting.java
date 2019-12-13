
public class Painting extends Artwork{
	// Constructor(s)
	public Painting(){
		super();
	}
	public Painting(String artist,double length, double width){
		super();
		this.setArtist(artist);
		this.setLength(length);
		this.setWidth(width);
	}
	public Painting(String name, String style,String artist,double length, double width){
		super();
		this.setArtist(artist);
		this.setLength(length);
		this.setWidth(width);
		this.setName(name);
		this.setStyle(style);
	}
	
	@Override
	public double calculateCost() {
		if(this.getStyle().equals(TypeDefs.STYLE_RENAISSANCE)) {
			return this.getWidth()*this.getLength()*TypeDefs.UNIT_COST_RENAISSANCE_PAINTING;
		}else if(this.getStyle().equals(TypeDefs.STYLE_BAROQUE)) {
			return this.getWidth()*this.getLength()*TypeDefs.UNIT_COST_BAROQUE_PAINTING;
		}
		return this.getWidth()*this.getLength()*TypeDefs.UNIT_COST_DEFAULT_PAINTING;
	}
	@Override
	public boolean IsTradable() {
		if (!this.getStyle().equals(TypeDefs.STYLE_GOTHIC)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		String str="Painting\n\tName: "+this.getName()+"\n\tStyle: "+this.getStyle();
		str+="\n\tArtist: "+this.getArtist()+"\n\tSize: "+this.getWidth()+ " x "+this.getLength();

	   return str;
	}
	@Override
	public int compareTo(TypeDefs.SortMethod sortMethod, Artwork other) {
		switch(sortMethod) {
    	case NAME:
    		return this.getName().compareTo(other.getName());
    	case STYLE:
    		return this.getStyle().compareTo(other.getStyle());
    	case ARTIST:
    		return this.getArtist().compareTo(other.getArtist());
    	case MATERIAL:
    		return 1;
    	default:
    		break;
		}
		return 0;
	}
}
