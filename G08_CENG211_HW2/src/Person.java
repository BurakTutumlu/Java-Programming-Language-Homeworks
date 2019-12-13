import java.util.ArrayList;

public abstract class Person implements IComparable<Person>,ISearchable{
	private String name;
	private int born;
	private int died;
	private String nationality;
	private ArrayList<String> periods;
	
	// Constructor(s)
	public Person(){
		name="";
		born=0;
		died=0;
		nationality="";
		periods=new ArrayList<String>();
		
	}
	public Person(String name){
		this.name=name;
		born=0;
		died=0;
		nationality="";
		periods=new ArrayList<String>();
	}
	public Person(String name, int born, int died, String nationality){
		this.name=name;
		this.born=born;
		this.died=died;
		this.nationality=nationality;
		this.periods=new ArrayList<String>();
	}
	public Person(String name, int born, int died, String nationality,ArrayList<String> periods){
		this.name=name;
		this.born=born;
		this.died=died;
		this.nationality=nationality;
		this.periods=periods;
	}
	// Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBorn() {
		return born;
	}
	public void setBorn(int born) {
		this.born = born;
	}
	public int getDied() {
		return died;
	}
	public void setDied(int died) {
		this.died = died;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public ArrayList<String> getPeriods() {
		return periods;
	}

	public void setPeriods(ArrayList<String> periods) {
		this.periods = periods;
	}
	public int compareTo(TypeDefs.SortMethod sortMethod, Person other) {
		switch(sortMethod) {
    	case NAME:
    		return name.compareTo(other.getName());
    	case BIRTHDAY:
    		int cmp = born > other.getBorn() ? +1 : born < other.getBorn() ? -1 : 0;
    		return cmp;
    	case NATIONALITY:
    		return nationality.compareTo(other.getNationality());
    	default:
    		break;
		}
		return 0;
	}
	
	public boolean searchFor(String str) {
		if(name.equals(str) || Integer.toString(born).equals(str)
				|| Integer.toString(died).equals(str) || nationality.equals(str)) {
			return true;
		}
		return false;
	}
	public boolean isEqual(Person other) {
		if (name.equals(other.getName()) && born==other.getBorn() && died==other.getDied()) {
			return true;
		}
		return false;
	}
	
}
