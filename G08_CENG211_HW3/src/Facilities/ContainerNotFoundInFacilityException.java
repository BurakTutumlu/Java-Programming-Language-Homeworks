package Facilities;


public class ContainerNotFoundInFacilityException extends Exception {
	
	//If there is no container like that, you can not operate it.
	public ContainerNotFoundInFacilityException() {
		super();
	}
	//we called exception constructor in both constructors, if you want to overload, you can give a message
	public ContainerNotFoundInFacilityException(String message) {
		super(message);
	}

}
