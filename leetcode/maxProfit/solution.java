package java.leetcode.maxProfit;

public class solution {

    // metoda za max profit
    public static int maxProfit(int[] niz) {
        if (niz.length == 0) {
            return 0;
        }
        int profit = 0;
        int lowPrice = niz[0];
        for (var i = 1; i < niz.length; i++) {
            if (lowPrice > niz[i]) {
                lowPrice = niz[i];
            }
            profit = Math.max(profit, niz[i] - lowPrice);
        }
        return profit;
    }

    // Best Time to Buy and Sell Stock II
    public static int maxProfit2(int[] niz) {
        int profit = 0;
        for (var i = 0; i < niz.length - 1; i++) {
            int diff = niz[i + 1] - niz[i];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

    // drugi nacin
    public static int maxProfit3(int[] niz) {
        int i = 0;
        int low = 0;
        int high = 0;
        int profit = 0;
        while (i < niz.length - 1) {
            // kada treba da se kupi
            while (i < niz.length - 1 && niz[i] >= niz[i + 1]) {
                i++;
            }
            low = niz[i];
            // kada treba da se proda
            while (i < niz.length - 1 && niz[i] <= niz[i + 1]) {
                i++;
            }
            high = niz[i];
            profit += high - low;
        }
        return profit;
    }
}
