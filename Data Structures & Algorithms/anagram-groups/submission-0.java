class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mp=new HashMap<>();

        for(int i=0;i<strs.length;i++) {
            String word=strs[i];

            char[] ch=word.toCharArray();

            Arrays.sort(ch);

            String key=new String(ch);

            if(mp.containsKey(key)) {
                mp.get(key).add(word);

            } else {
                List<String> ls=new ArrayList<>();
                ls.add(word);
                mp.put(key,ls);
            }
        }
      return new ArrayList<>(mp.values());
    }
}