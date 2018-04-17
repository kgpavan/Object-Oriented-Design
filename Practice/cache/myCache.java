package design.practice.cache;


import java.util.HashMap;

/*10-7*/
class Cache {

	public static int MAX_SIZE = 10;
	public Node head;
	public Node tail;
	public HashMap<String, Node> map;
	public int size = 0;

	public Cache() {

		map = new HashMap<String, Node>();
	}

	public void moveToFront(Node node) {

		if (node == head) {
			return;
		}

		removeFromLinkedList(node);
		node.next = head;

		if (head != null) {

			head.prev = node;
		}

		head = node;
		size++;

		if (tail == null) {

			tail = node;
		}
	}

	public void moveToFront(String query) {
		Node node = map.get(query);
		moveToFront(node);
	}

	public void removeFromLinkedList(Node node) {
		if (node == null) {
			return;
		}

		if (node.next != null || node.prev != null) {
			size--;
		}

		Node prev = node.prev;
		if (prev != null) {
			prev.next = node.next;
		}

		Node next = node.next;
		if (next != null) {
			next.prev = prev;
		}

		if (node == head) {
			head = next;
		}

		if (node == tail) {
			tail = prev;
		}

		node.next = null;
		node.prev = null;
	}

	public String[] getResults(String query) {
		if (map.containsKey(query)) {
			Node node = map.get(query);
			moveToFront(node);
			return node.results;
		}
		return null;
	}

	public void insertResults(String query, String[] results) {
		if (map.containsKey(query)) {
			Node node = map.get(query);
			node.results = results;
			moveToFront(node);
			return;
		}

		Node node = new Node(query, results);
		moveToFront(node);
		map.put(query, node);

		if (size > MAX_SIZE) {
			map.remove(tail.query);
			removeFromLinkedList(tail);
		}
	}
}




class Node {
	public Node prev;
	public Node next;
	public String[] results;
	public String query;

	public Node(String q, String[] res) {
		results = res;
		query = q;
	}
}

/*10-7*/



public class myCache {

	public static String[] generateResults(int i) {
		String[] results =  {"resultA" + i, "resultB" + i, "resultC" + i};
		return results;
	}

	public static void main(String[] args) {

		/*10-7*/
		Cache cache = new Cache();
		for (int i = 0; i < 20; i++) {
			String query = "query" + i;
			cache.insertResults(query, generateResults(i));
			if (i == 9 || i == 16 || i == 19) {
				cache.getResults("query" + 2);
				cache.getResults("query" + 6);
				cache.getResults("query" + 9);
			}
		}

		for (int i = 0; i < 30; i++) {
			String query = "query" + i;
			String[] results = cache.getResults(query);
			System.out.print(query + ": ");
			if (results == null) {
				System.out.print("null");
			} else {
				for (String s : results) {
					System.out.print(s + ", ");
				}
			}
			System.out.println("");
		}
		/*10-7*/
	}

}

