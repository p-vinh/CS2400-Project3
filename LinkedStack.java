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

		T top = topNode.getData();
		topNode.setNextNode(topNode.getNextNode());
		return top;
	}

	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return topNode.getData();
	}

	public boolean isEmpty() {
		return topNode == null;
	}

	public void clear() {
		topNode = null;
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

		public void setData(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public void setNextNode(Node node) {
			this.next = node;
		}

		public Node getNextNode() {
			return next;
		}
	}
}
