class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if (n % groupSize != 0)
            return false;

        HashMap<Integer, Integer> cardCnt = new HashMap<>();
        for (int card : hand) {
            cardCnt.put(card, cardCnt.getOrDefault(card, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(cardCnt.keySet());

        while (!minHeap.isEmpty()) {
            int card = minHeap.poll();
            int cnt = cardCnt.get(card);
            if (cnt <= 0)
                continue;
            for (int i = 1; i < groupSize; i++) {
                int nextCard = card + i;
                if (!cardCnt.containsKey(nextCard) || cardCnt.get(nextCard) < cnt) {
                    return false;
                } else {
                    cardCnt.put(nextCard, cardCnt.get(nextCard) - cnt);
                }
            }
        }
        return true;
    }
}
