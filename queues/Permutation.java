/* *****************************************************************************
 *  Name: Carlos Bravo
 *  Date: 13/02/2021
 *  Description: API class Deque,
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        // int N = StdIn.readInt();
        RandomizedQueue<String> perm = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            perm.enqueue(StdIn.readString());
        }
        int N = Integer.parseInt(args[0]);
        for (int i = 0; i < N; i++) {
            StdOut.println(perm.dequeue());
        }
    }
}

