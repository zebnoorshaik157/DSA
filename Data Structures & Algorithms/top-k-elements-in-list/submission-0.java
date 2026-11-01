class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     HashMap<Integer,Integer> mp=new HashMap<>();
     List<Integer>[] freq=new List[nums.length+1];

     for(int i=0;i<freq.length;i++) {
        freq[i]=new ArrayList<>();
     }

    for(int num:nums) {
        mp.put(num,mp.getOrDefault(num,0)+1);
     }

    for (Map.Entry<Integer, Integer> mpp : mp.entrySet()) {
          freq[mpp.getValue()].add(mpp.getKey());
    }
    int[] res=new int[k];
    int index=0;
    for(int i=freq.length-1;i>0 && index < k;i--) {
        for(int num:freq[i]) {
            res[index++]=num;
        }
        if(index==k) {
                return res;
            }
       
    }
    return res;
}
}