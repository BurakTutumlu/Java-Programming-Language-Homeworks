package Facilities;

public class ContainerAlreadyExistsInFacilityException extends Exception {
	
	//if container is in facility, you can not create one more
	public ContainerAlreadyExistsInFacilityException() {
		super();
	}
	//we called exception constructor in both constructors, if you want to overload, you can give a message
	public ContainerAlreadyExistsInFacilityException(String message) {
		super(message);
	}

}
