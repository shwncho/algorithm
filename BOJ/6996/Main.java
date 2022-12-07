import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static boolean solveAnagrams(String first, String second ) {
        /* ------------------- INSERT CODE HERE --------------------
         *
         * Your code should return true if the two strings are anagrams of each other.
         *
         * */
        HashMap<Character,Integer> h1=new HashMap<>();
        HashMap<Character,Integer> h2=new HashMap<>();

        for(char x : first.toCharArray()){
            h1.put(x, h1.getOrDefault(x,0)+1);
        }

        for(char x : second.toCharArray()){
            h2.put(x, h2.getOrDefault(x,0)+1);
        }

        for(char x : h1.keySet()){
            if(!h1.get(x).equals(h2.get(x)))    return false;
        }

        return true;

        /* -------------------- END OF INSERTION --------------------*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}
