import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        //In in = new In(args[0]);
        int i = 0;
        String win = "";
        String s = "";
        while (!StdIn.isEmpty()) {
            s = StdIn.readString();
            i++;
            if (StdRandom.bernoulli(1.0 / i)) win = s;
        }
        System.out.println(win);
    }
}
