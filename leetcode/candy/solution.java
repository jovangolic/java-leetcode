package java.leetcode.candy;

public class solution {

    // candy primer ratings = [1,0,2]
    public static int candy(int[] ratings) {
        int[] candyArr = new int[ratings.length];
        // Arrays.fill(ratings, 1);
        int min = 0;
        // popunjavanje niza sa default-nim vrednostima.Vrednosti su jedinice
        for (var i = 0; i < ratings.length; i++) {
            candyArr[i] = 1; // candy niz sa default-nim vrednostima[1,1,1]
        }
        // krece se od leve ka desnoj strani, bez nultog indeksa
        for (var i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candyArr[i] = candyArr[i - 1] + 1;
            }
        }
        // krece se od desna ka levoj bez poslednjeg indeksa
        for (var i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyArr[i] = Math.max(candyArr[i], candyArr[i + 1] + 1);
                // candyArr[i] = candyArr[i + 1] + 1;
            }
        }
        for (var i = 0; i < candyArr.length; i++) {
            min += candyArr[i];
        }
        return min;
    }
}
