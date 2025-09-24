class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];

        for(int i = 0; i<spells.length; i++) {
            int num = spells[i];
            int left = 0;
            int right = potions.length;
            while(left<right) {
                int mid = left + (right - left)/2;
                long p = (long)potions[mid] * num;

                if(p < success) left = mid + 1;
                else    right = mid;
            }
            result[i] = potions.length - left;
        }

        return result;
    }
}