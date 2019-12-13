import java.util.Arrays;
import java.util.Random;

public class Vault {

    private IBag <Artwork> artBag;
    private IBag <Person> personBag;
    // Constructor(s)
    public Vault() {
        artBag = new Bag <Artwork>();
        personBag = new Bag <Person>();

    }
    /**
     * Add new person
     * @param: person
     * @return: none
     */
    public void addPerson(Person newPerson) {
    	if(!personContains(newPerson.getName())) {
    		personBag.add(newPerson);
    	}
    }
    /**
     * Add new artwork
     * @param: person
     * @return: none
     */
    public void addArtwork(Artwork newArtwork) {
        artBag.add(newArtwork);
    }
    /**
     * Print artists
     * @param:none
     * @return: none
     */
    public void printArtists() {
        int bagLen = personBag.getItemCount();
        for (int i = 0; i < bagLen; i++) {
            Person pers = personBag.getItem(i);
            if (pers instanceof Artist) {
                System.out.println(pers.toString());
            }
        }
    }
    /**
     * Print architects
     * @param:none
     * @return: none
     */
    public void printArchitects() {
        int bagLen = personBag.getItemCount();
        for (int i = 0; i < bagLen; i++) {
            Person pers = personBag.getItem(i);
            if (pers instanceof Architect) {
                System.out.println(pers.toString());
            }
        }
    }
    /**
     * Print paintings
     * @param:none
     * @return: none
     */
    public void printPaintings() {
        int bagLen = artBag.getItemCount();
        for (int i = 0; i < bagLen; i++) {
            Artwork art = artBag.getItem(i);
            if (art instanceof Painting) {
                System.out.println(art.toString());
            }
        }
    }
    /**
     * Print sculptures
     * @param:none
     * @return: none
     */
    public void printSculptures() {
        int bagLen = artBag.getItemCount();
        for (int i = 0; i < bagLen; i++) {
            Artwork art = artBag.getItem(i);
            if (art instanceof Sculpture) {
                System.out.println(art.toString());
            }
        }
    }
    /**
     * Print architecture
     * @param:none
     * @return: none
     */
    public void printArchitecture() {
        int bagLen = artBag.getItemCount();
        for (int i = 0; i < bagLen; i++) {
            Artwork art = artBag.getItem(i);
            if (art instanceof Architecture) {
                System.out.println(art.toString());
            }
        }
    }
    /**
     * Sort Persons with respect to sort method
     * @param: sortMethod (TypeDefs.SortMethod)
     * @return: none
     */
    public void sortPersons(TypeDefs.SortMethod sortMethod) {
        int bagSize = personBag.getSize();
        int itemCount = personBag.getItemCount();
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < itemCount - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < itemCount; j++){  
                if (personBag.getItem(j).compareTo(sortMethod, personBag.getItem(index))<0){  
                    index = j;//searching for lowest index  
                }  
            }  
            Person smaller= personBag.getItem(index);
            personBag.update(index,personBag.getItem(i));
            personBag.update(i,smaller);
        }  
    }
    /**
     * Sort Artworks with respect to sort method
     * @param: sortMethod (TypeDefs.SortMethod)
     * @return: none
     */
    public void sortArtworks(TypeDefs.SortMethod sortMethod) {
        int bagSize = artBag.getSize();
        int itemCount = artBag.getItemCount();
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < itemCount - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < itemCount; j++){  
        		if (artBag.getItem(j).compareTo(sortMethod, artBag.getItem(index))<0){  
                    index = j;//searching for lowest index  
                }  
            }  
            Artwork smaller= artBag.getItem(index);
            artBag.update(index,artBag.getItem(i));
            artBag.update(i,smaller);
        }  
    }
    /**
     * Check if a person contains in bag
     * @param:none
     * @return: none
     */
    public boolean personContains(String name) {
        int bagLen = personBag.getItemCount();
        for (int i = 0; i < bagLen; i++) {
            if(personBag.getItem(i).getName().equals(name)) {
            	return true;
            }
        }
        return false;
    }
    /**
     * Display items in the vault with respect to specified word
     * @param:str , String to search
     * @return: none
     */
    public void searchVault(String str) {
    	int personBagCount = personBag.getItemCount();
    	int artBagCount = artBag.getItemCount();
    	for (int i=0;i<personBagCount;i++) {
    		Person currPerson = personBag.getItem(i);
    		if(currPerson.searchFor(str)) {
    			System.out.println(currPerson.toString());
    		}
    	}
    	for (int i=0;i<artBagCount;i++) {
    		Artwork currArt = artBag.getItem(i);
    		if(currArt.searchFor(str)) {
    			System.out.println(currArt.toString());
    		}
    	}
    }
    /**
     * Select an artwork randomly which is tradable
     * @param: none
     * @return: selected artwork
     */
    public Artwork selectRandomTradableArtwork() {
    	int bagCount = artBag.getItemCount();
    	Random rand = new Random();
    	int randNum = rand.nextInt(bagCount);
    	if(artBag.getItem(randNum).IsTradable()) {
    		return artBag.getItem(randNum);
    	}
    	return selectRandomTradableArtwork();
    }
    /**
     * Trans
     * @param: none
     * @return: selected artwork
     */
    public boolean transferArtwork(IBag <Artwork> otherBag,Artwork art) {
    	return artBag.transferTo(otherBag, art);
    }
}