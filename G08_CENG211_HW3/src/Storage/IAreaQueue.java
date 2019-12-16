package Storage;
import java.util.Queue;


public interface IAreaQueue<T>{
	public void addQ(T item);
	public void removQ();
	public double getCapacity();
	public void setCapacity(double capacity);
	public Queue<T> getQueue();
	public void setQueue(Queue<T> queue);
	public void addCap(double liter);
	public void removCap(double liter);
	public boolean isEmpty();
	public T seeFirst();
	public double lookFor(double liter);
}
