import java.io.*;
import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        Arrays.sort(schars);
        Arrays.sort(tchars);

        return new String(schars).equals(new String(tchars));
    }
}