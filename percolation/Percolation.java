/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n = 0;
    private boolean[][] openSite;
    private int nOpenSite = 0;
    private WeightedQuickUnionUF wqui1;
    private WeightedQuickUnionUF wqui2;

    public static void main(String[] args) {

    }

    /*constructor*/
    public Percolation(int n) {
        if (n < 1) throw new IllegalArgumentException("the minimum value is 1");
        this.n = n;
        openSite = new boolean[n][n];
        wqui1 = new WeightedQuickUnionUF(n * n + 1);
        wqui2 = new WeightedQuickUnionUF(n * n + 2);
    }

    public void open(int row, int col) {
        if (row < 1 || row > n) throw new IllegalArgumentException("Out of Range 'row'");
        if (col < 1 || col > n) throw new IllegalArgumentException("Out of Range 'col'");
        if (!isOpen(row, col)) {
            nOpenSite++;
            openSite[row - 1][col - 1] = true;
            // is near to the top
            if (row == 1) {
                wqui1.union(0, sub2ind(row, col));
                wqui2.union(0, sub2ind(row, col));
            }
            // neighbours (n,s,e,w)
            if (row > 1) {
                if (openSite[row - 2][col - 1]) {
                    wqui1.union(sub2ind(row, col), sub2ind(row - 1, col));
                    wqui2.union(sub2ind(row, col), sub2ind(row - 1, col));
                }
            }
            if (row < n) {
                if (openSite[row][col - 1]) {
                    wqui1.union(sub2ind(row, col), sub2ind(row + 1, col));
                    wqui2.union(sub2ind(row, col), sub2ind(row + 1, col));
                }
            }
            if (col > 1) {
                if (openSite[row - 1][col - 2]) {
                    wqui1.union(sub2ind(row, col), sub2ind(row, col - 1));
                    wqui2.union(sub2ind(row, col), sub2ind(row, col - 1));
                }
            }
            if (col < n) {
                if (openSite[row - 1][col]) {
                    wqui1.union(sub2ind(row, col), sub2ind(row, col + 1));
                    wqui2.union(sub2ind(row, col), sub2ind(row, col + 1));
                }
            }
            if (row == n) {
                wqui2.union(sub2ind(row, col), n * n + 1);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (row < 1 || row > n) throw new IllegalArgumentException("Out of Range 'row'");
        if (col < 1 || col > n) throw new IllegalArgumentException("Out of Range 'col'");
        return (openSite[row - 1][col - 1]);
    }

    public boolean isFull(int row, int col) {
        if (row < 1 || row > n) throw new IllegalArgumentException("Out of Range 'row'");
        if (col < 1 || col > n) throw new IllegalArgumentException("Out of Range 'col'");
        return (wqui1.find(0) == wqui1.find(sub2ind(row, col))) /*&& (wqui2.find(n * n + 1) == wqui2
                .find(sub2ind(row, col)))*/;
    }

    public int numberOfOpenSites() {
        return (nOpenSite);
    }

    public boolean percolates() {
        return wqui2.find(0) == wqui2.find(n * n + 1);
    }

    private int sub2ind(int row, int col) {
        return (row - 1) * n + col;
    }
}
