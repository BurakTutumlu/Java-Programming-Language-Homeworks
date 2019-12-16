package Facilities;

import java.util.ArrayList;
import Containers.*;

public abstract class Facility {
	
	//our Container type is a stack
	private ArrayList<Container<?>> containers;
	
	public ArrayList<Container<?>> getContainers() {
		return containers;
	}

	public void setContainers(ArrayList<Container<?>> containers) {
		this.containers = containers;
	}
	/**
	   * Transfer a container to another facility.
	   * @param container Container to be transfered
	   * @param facility Facility to be container transfered  
	   * @throws ContainerAlreadyExistsInFacilityException 
	   */
	public void transferContainer(Container<?> container, Facility facility) throws ContainerNotFoundInFacilityException, ContainerAlreadyExistsInFacilityException {
		// Check container
		if(!checkContainerExists(container)) {
			throw new ContainerNotFoundInFacilityException();
		}
		// Transfer container
		removeContainer(container);
		facility.addContainer(container);
		// Discharge container to storage areas/tanks
		facility.dischargeContainer(container);
	}
	/**
	   * Add a container to facility.
	   * @param container Container to be added
	   * @throws ContainerAlreadyExistsInFacilityException 
	   */
	public void addContainer(Container<?> container) throws ContainerAlreadyExistsInFacilityException {
		if(checkContainerExists(container)) {
			throw new ContainerAlreadyExistsInFacilityException();
		}
		containers.add(container);
	}
	/**
	   * Add a container to facility.
	   * @param container Container to be added
	   * @throws ContainerNotFoundInFacilityException 
	   */
	public void removeContainer(Container<?> container) throws ContainerNotFoundInFacilityException {
		// Check container
		if(!checkContainerExists(container)) {
			throw new ContainerNotFoundInFacilityException();
		}
	}
	/**
	   * Check if container exists in facility
	   * @param container Container to be added
	   * @throws ContainerNotFoundInFacilityException 
	   */
	public boolean checkContainerExists(Container<?> container) {
		for (Container<?> c : containers) {
			if(c.getClass().equals(container.getClass())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	   * Discharge container's content to facility
	   * @param container Container to be discharged 
	   */
	public abstract void dischargeContainer(Container<?> container);
}
