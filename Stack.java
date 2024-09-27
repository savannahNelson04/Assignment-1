
public class Stack<Item> {

    private Node first = null;
    int size = 0;

    private class Node
    {
        Item item;
        Node next;
    }

    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        return item;
    }




}
