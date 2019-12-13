import java.util.ArrayList;

public class Architecture extends Artwork{
	
	// Constructor(s)
	public Architecture(){
		super();
	}
	public Architecture(double length,double width, double height,ArrayList<Architect> architects){
		super();
		this.setLength(length);
		this.setWidth(width);
		this.setHeight(height);
		this.setArchitects(architects);
	}
	public Architecture(String name, String style,double length,double width, double height,ArrayList<Architect> architects){
		super();
		this.setLength(length);
		this.setWidth(width);
		this.setHeight(height);
		this.setName(name);
		this.setStyle(style);
		this.setArchitects(architects);
	}
	
	@Override
	public double calculateCost() {
		if(this.getStyle().equals("Gothic")) {
			return this.getWidth()*this.getLength()*this.getHeight()*TypeDefs.UNIT_COST_GOTHIC_ARCHITECTURE;
		}else if (this.getStyle().equals("Baroque")) {
			return this.getWidth()*this.getLength()*this.getHeight()*TypeDefs.UNIT_COST_BAROQUE_ARCHITECTURE;
		}
		return this.getWidth()*this.getLength()*this.getHeight()*TypeDefs.UNIT_COST_DEFAULT_ARCHITECTURE;
	}
	@Override
	public boolean IsTradable() {
		if (!this.getStyle().equals(TypeDefs.STYLE_RENAISSANCE)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		String str="Architecture\n\tName: "+this.getName()+"\n\tStyle: "+this.getStyle();
		str+="\n\tWidth: "+this.getWidth()+"\n\tLength: "+this.getLength();
		str+="\n\tHeight: "+this.getHeight()+"\n\tArchitects: ";
		for (Architect a: this.getArchitects()) {
			str+=a.getName()+", ";
		}
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
    		return 1;
    	case MATERIAL:
    		return 1;
    	default:
    		break;
		}
		return 0;
	}
	
}
