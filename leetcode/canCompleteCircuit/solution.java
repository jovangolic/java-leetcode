package java.leetcode.canCompleteCircuit;

public class solution {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int sumGas = 0;
        int sumCost = 0;
        for (var i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if (sumGas < sumCost)
            return -1;
        for (var i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }
        return start;
    }

    // drugi nacin
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int start = 0;
        int totalGas = 0;
        int currentGas = 0;
        for (int i = 0; i < gas.length; i++) {
            int fuelGain = gas[i] - cost[i];
            totalGas += fuelGain;
            currentGas += fuelGain;
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }
        return totalGas < 0 ? -1 : start;
    }
}
