class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();


        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String tmp = new String(chars);
            if(!map.containsKey(tmp))   map.put(tmp,new ArrayList<>());

            map.get(tmp).add(str);
        }

        return new ArrayList<>(map.values());
    }
}