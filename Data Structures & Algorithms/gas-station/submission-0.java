class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr = 0;
        int start = 0;
        int diff = 0;
        int total_fuel = 0;
        int total_cost = 0;

        for (int i = 0; i < gas.length; i++) {
            total_fuel += gas[i];
            total_cost += cost[i];
        }

        if (total_fuel < total_cost)
            return -1;

        for (int i = 0; i < gas.length; i++) {
            curr += (gas[i] - cost[i]);

            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }
        return start;
    }
}
