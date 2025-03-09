package java.leetcode.jumpGame;

public class solution {

    // jump game
    public static boolean jumpGame(int[] niz) {
        int target = niz.length - 1;
        for (var i = target; i >= 0; i--) {
            int maxJumps = niz[i];
            if (i + maxJumps >= target) {
                target = i;
            }
        }
        return (target == 0) ? true : false;
    }

    // jump game II
    public static int jumpGame2(int[] niz) {
        int jumps = 0;
        int near = 0;
        int far = 0;
        while (far < niz.length - 1) {
            int farthest = 0;
            for (var i = near; i <= far; i++) {
                farthest = Math.max(farthest, i + niz[i]);
            }
            near = far + 1;
            far = farthest;
            jumps++;
        }
        return jumps;
    }

    // jump game II drugi nacin
    public static int jumpGame3(int[] niz) {
        int jump = 0;
        int far = 0;
        int near = 0;
        for (var i = 0; i < niz.length - 1; i++) {
            far = Math.max(far, niz[i] + i);
            if (i == near) {
                jump++;
                near = far;
            }
        }
        return jump;
    }
}
