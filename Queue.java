
public class Queue<Item> {

    private Node first, last;

    private class Node {
        Item item;
        Node next;
    }

    public void enqueue(Item input) {
        Node oldlast = last;
        last = new Node();
        last.item = input;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
        }
    }

    public Item dequeue() {
       Item item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

}
