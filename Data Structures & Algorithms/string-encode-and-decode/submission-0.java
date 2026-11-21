class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {

            int j = i;

            // Find #
            while (str.charAt(j) != '#') {
                j++;
            }

            // Get length
            int len = Integer.parseInt(str.substring(i, j));

            // Get original string
            String word = str.substring(j + 1, j + 1 + len);

            result.add(word);

            // Move to next string
            i = j + 1 + len;
        }

        return result;
    }
}