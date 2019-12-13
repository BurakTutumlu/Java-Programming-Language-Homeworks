import java.util.ArrayList;

public class Architect extends Person{
	// Constructor(s)
	public Architect(){
		super();
		
	}
	public Architect(String name){
		super(name);
		
	}
	public Architect(String name,int born, int died, String nationality){
		super(name,born,died,nationality);
		
	}
	@Override
	
	public String toString() {
		String str ="Architect:\n\tName: "+this.getName();
		if (this.getBorn()!=0) {
			str+="\n\tBorn: "+this.getBorn();
		}
		if (this.getDied()!=0) {
			str+="\n\tDied: "+this.getDied();
		}
		if (this.getNationality()!="") {
			str+="\n\tNationality: "+this.getNationality();
		}
		return str;
	}
	
}
