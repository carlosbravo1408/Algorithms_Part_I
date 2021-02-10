/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private Percolation percolation;
    private int n = 0;
    private int trials = 0;
    private double _mean = 0.0;
    private double _stddev = 0.0;

    private double[] data;

    public static void main(String[] args) {
        if (args.length == 2) {
            int n = Integer.parseInt(args[0]);
            int t = Integer.parseInt(args[1]);
            PercolationStats percolationStats = new PercolationStats(n, t);
            StdOut.println("mean                    = " + percolationStats.mean());
            StdOut.println("stddev                  = " + percolationStats.stddev());
            StdOut.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", "
                                   + percolationStats.confidenceHi() + "]");
        }
    }

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n < 1 || trials < 1) throw new IllegalArgumentException("the minimum value is 1");
        this.n = n;
        this.trials = trials;
        data = new double[trials];
        for (int i = 0; i < trials; i++) {
            percolation = new Percolation(n);
            int val = 0;
            while (!percolation.percolates()) {
                percolation.open(StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1));
            }
            val = percolation.numberOfOpenSites();
            data[i] = (double) val / ((double) (n * n));
        }
        _mean = StdStats.mean(data);
        _stddev = StdStats.stddev(data);
    }

    // sample mean of percolation threshold
    public double mean() {
        return _mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return _stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return _mean - 1.96 * _stddev / Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return _mean + 1.96 * _stddev / Math.sqrt(trials);
    }

}
