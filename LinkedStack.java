import java.util.EmptyStackException;


public class LinkedStack<T> implements InterfaceStack<T> {

	private Node topNode;

	public LinkedStack() {
		topNode = null;
	}

	public void push(T newEntry) {
		topNode = new Node(newEntry, topNode);
	}

	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();

		T top = topNode.data;
		topNode = topNode.next;
		return top;
	}

	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return topNode.data;
	}

	public boolean isEmpty() {
		return topNode == null;
	}

	public void clear() { // change everything to null
		while (!isEmpty()) {
			topNode = null;
			topNode = topNode.next;
		}
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
