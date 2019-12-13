
public interface IComparable<T> {
	/**
     * Compare two object with respect to sort method
     * @param: sortMethod (TypeDefs.SortMethod)
     * @param: other; object to be compare
     * @return: integer to declare priority of object
     */
	public int compareTo(TypeDefs.SortMethod sortMethod, T other);
}
