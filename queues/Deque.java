/* *****************************************************************************
 *  Name: Carlos Bravo
 *  Date: 13/02/2021
 *  Description: API class Deque,
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first = null;
    private Node last = null;
    private int size = 0;

    private class Node {
        Item item;
        Node next, prev;
    }

    public Deque() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null value");
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.prev = null;
        first.next = oldFirst;

        if (isEmpty())
            last = first;
        else
            oldFirst.prev = first;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null value");
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldLast;

        if (isEmpty())
            first = last;
        else {
            oldLast.next = last;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("No more elements");
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) last = first;
        else first.prev = null;
        return item;
    }

    public Item removeLast() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("No more elements");
        Item item = last.item;
        last = last.prev;
        size--;
        if (isEmpty()) first = last;
        else last.next = null;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException("No more elements");
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove doesn't support");
        }
    }

    public static void main(String[] args) {
        Deque<String> test1 = new Deque<String>();
        test1.addFirst("a");
        test1.addLast("b");
        test1.addFirst("c");
        test1.addLast("d");
        test1.addFirst("e");
        test1.addLast("f");
        test1.addFirst("g");
        test1.addLast("h");
        test1.addFirst("i");
        test1.addLast("j");
        test1.addFirst("k");
        test1.addLast("l");
        test1.addFirst("m");
        test1.addLast("n");
        test1.addFirst("o");
        test1.addLast("p");
        test1.addFirst("q");
        test1.addLast("r");
        test1.addFirst("s");
        test1.addLast("t");
        test1.addFirst("u");
        test1.addLast("v");
        test1.addFirst("w");
        test1.addLast("x");
        test1.addFirst("y");
        test1.addLast("z");
        for (String s : test1) {
            StdOut.print(s);
        }
        StdOut.println();
        while (!test1.isEmpty()) {
            StdOut.print(test1.removeFirst());
            StdOut.print(test1.removeLast());
        }


    }
}
