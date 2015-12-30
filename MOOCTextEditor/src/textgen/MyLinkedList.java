package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E>
 *            The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		this.head = new LLNode<E>(null); // Sentinel node
		this.tail = new LLNode<E>(null); // Sentinel node
		this.size = 0;

		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element
	 *            The element to add
	 */
	public boolean add(E element) {
		if (element == null) {
			throw new NullPointerException();
			//return false;
		}
		// Add Last
		LLNode<E> currentNode = new LLNode<E>(element);

		this.tail.prev.next = currentNode;
		currentNode.prev = this.tail.prev;
		this.tail.prev = currentNode;
		currentNode.next = this.tail;

		this.size++;
		return true;
	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E get(int index) {
		if (index < 0 || index >= this.size || (this.size == 0)) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> temp = new LLNode<E>(null);

		temp = this.head;

		for (int i = 0; i < index + 1; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The
	 *            index where the element should be added
	 * @param element
	 *            The element to add
	 */
	public void add(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index > this.size || (this.size == 0 && index != 0)) {
			throw new IndexOutOfBoundsException();
		}
		// TODO: Implement this method
		LLNode<E> temp = new LLNode<E>(null);
		temp = this.head;
		for (int i = 0; i < index + 1; i++) {
			temp = temp.next;
		}

		LLNode<E> currentNode = new LLNode<E>(element);

		temp.prev.next = currentNode;
		currentNode.prev = temp.prev;
		temp.prev = currentNode;
		currentNode.next = temp;

		this.size++;
	}

	/** Return the size of the list */
	public int size() {
		return this.size;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index
	 *            The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException
	 *             If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {
		if (index < 0 || index >= this.size || (this.size == 0)) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> temp = new LLNode<E>(null);
		temp = this.head;
		for (int i = 0; i < index + 1; i++) {
			temp = temp.next;
		}
		E val = temp.data;

		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;

		this.size--;

		return val;
	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index
	 *            The index of the element to change
	 * @param element
	 *            The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E set(int index, E element) {
		if (index < 0 || index >= this.size || (this.size == 0)) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		E oldVal;
		LLNode<E> temp = new LLNode<E>(null);
		temp = this.head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		oldVal = temp.next.data;
		temp.next.data = element;
		return oldVal;
	}

}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	@Override
	public String toString() {
		if (data == null) {
			return null;
		} else {
			return data.toString();
		}
	}
}
