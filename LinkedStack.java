import java.util.EmptyStackException;

public class LinkedStack<T> implements InterfaceStack<T> {

	private Node firstNode;
	private int numberOfEntries;

	public LinkedStack() {
		firstNode = null;
		numberOfEntries = 0;
	}

	public void push(T newEntry) {
		Node newNode = new Node(newEntry);

		newNode.next = firstNode;
		firstNode = newNode;
		numberOfEntries++;
	}

	public T pop() {
		if (!isEmpty()) {
			Node current = firstNode;
			T data = firstNode.data;
			firstNode = current.next;
			numberOfEntries--;
			return data;
		}
		throw new EmptyStackException();
	}

	public T peek() {
		if (firstNode == null)
			return firstNode.data;
		throw new EmptyStackException();
	}

	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	public void clear() {
		while(!isEmpty())
			pop();
	}

	private class Node {
		private T data;
		private Node next;

		private Node(T dataPortion) {
			this(dataPortion, null);
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
	}
}
