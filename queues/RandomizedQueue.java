/* *****************************************************************************
 *  Name: Carlos Bravo
 *  Date: 13/02/2021
 *  Description: API class Randomized Queue,
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node first = null, last = null;
    private int size = 0;

    private class Node {
        Item item;
        Node prev, next;

        public Node() {

        }

        public Node(Item item, Node next, Node prev) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public Node(Item item) {
            this.item = item;
        }
    }

    public RandomizedQueue() {

    }

    public boolean isEmpty() {
        return size == 0 || first == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
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

    public Item dequeue() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("No more elements");
        Item item = null;
        Node current = first;
        boolean aux = false;
        int val = StdRandom.uniform(size);
        for (int i = 0; i < val; ++i) {
            current = current.next;
        }
        item = current.item;
        Node prev = current.prev;
        Node next = current.next;
        if (prev != null)
            prev.next = next;
        else
            first = next;
        if (next != null)
            next.prev = prev;
        else
            last = prev;
        current = null;
        if (isEmpty()) last = null;
        size--;
        return item;
    }

    public Item sample() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("No more elements");
        Item item = null;
        Node current = first;
        boolean aux = false;
        int val = StdRandom.uniform(size);
        for (int i = 0; i < val; ++i) {
            current = current.next;
        }
        item = current.item;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private RandomizedQueue<Item> copy = new RandomizedQueue<Item>();

        private ListIterator() {
            Node current = first;
            while (current != null) {
                copy.enqueue(current.item);
                current = current.next;
            }
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException("No more elements");
            Item item = copy.dequeue();
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove doesn't support");
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> test = new RandomizedQueue<String>();
        test.enqueue("a");
        test.enqueue("b");
        test.enqueue("c");
        test.enqueue("d");
        test.enqueue("e");
        test.enqueue("f");
        test.enqueue("g");
        test.enqueue("h");
        test.enqueue("i");
        test.enqueue("j");
        test.enqueue("k");
        test.enqueue("l");
        test.enqueue("m");
        test.enqueue("n");
        test.enqueue("o");
        test.enqueue("p");
        test.enqueue("q");
        test.enqueue("r");
        test.enqueue("s");
        test.enqueue("t");
        test.enqueue("u");
        test.enqueue("v");
        test.enqueue("w");
        test.enqueue("x");
        test.enqueue("y");
        test.enqueue("z");
        for (String s : test) {
            StdOut.print(s);
        }
        StdOut.println();
        while (!test.isEmpty()) {
            StdOut.print(test.sample());
            StdOut.println(test.dequeue());
        }
    }
}
