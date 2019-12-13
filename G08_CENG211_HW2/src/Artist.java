import java.util.ArrayList;

public class Artist extends Person{
	
	// Constructor(s)
	public Artist(){
		super();
		
	}
	public Artist(String name){
		super(name);
		
	}
	public Artist(String name,int born, int died, String nationality,ArrayList<String> periods){
		super(name,born,died,nationality,periods);
	}
	@Override
	public String toString() {
		String output = "Artist:\n\tName: "+this.getName()+"\n\tBorn:"+this.getBorn()+
		"\n\tDied: "+this.getDied()+"\n\tNationality: "+this.getNationality();
	   return output;
	}
}
