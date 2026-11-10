class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            minheap.offer(s);
        }

        while (minheap.size() > 1) {
            int first = minheap.poll();
            int second = minheap.poll();
            if (first != second) {
                minheap.add(first-second);
            }
        }

        return minheap.isEmpty() ? 0 : minheap.poll();
    }
}
