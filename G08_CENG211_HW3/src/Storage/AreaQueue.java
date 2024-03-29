package Storage;
import java.util.LinkedList;
import java.util.Queue;


public class AreaQueue<T> implements IAreaQueue<T>{
	private double capacity;
	private Queue<T> queue;
	public AreaQueue() {
		this(50);
	}
	public AreaQueue(int capacity) {
		this.setCapacity(capacity);
		setQueue(new LinkedList<T>());
	}
	public void addQ(T item) {
		queue.add(item);
	}
	public void removQ() {
		queue.poll();
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public Queue<T> getQueue() {
		return queue;
	}
	public void setQueue(Queue<T> queue) {
		this.queue = queue;
	}
	public void addCap(double liter) {
		this.capacity += liter;
	}
	public void removCap(double liter) {
		this.capacity -= liter;
	}
	public boolean isEmpty() {
		return 	this.queue.isEmpty();
	}
	public T seeFirst() {
		return queue.peek();
	}
	public double lookFor(double liter) {
		return this.capacity-liter;
	}
}