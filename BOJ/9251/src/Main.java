import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashSet<String> list1 = new HashSet<>();
    static HashSet<String> list2 = new HashSet<>();

    static int max=0;
    public static void powerset(HashSet<String> list, String[] arr, boolean[] state, int i, int end) {

        // 탈출문
        if (i >= end) {

            // 현재 true로 체크되어 있는 인덱스의 값만 출력
            for (int w = 0; w < end; w++) {

                if (state[w]) {
                    list.add(arr[w]);
                }
            }
            return;
        }

        // "내가 없을 경우"를 체크한 뒤 다른 부분집합을 구하는 재귀함수 호출 (다음 인덱스로 기준 이동)
        state[i] = false;
        powerset(list,arr, state, i + 1, end);

        // "내가 있을 경우"를 체크한 뒤 다른 부분집합을 구하는 재귀함수 호출 (다음 인덱스로 기준 이동)
        state[i] = true;
        powerset(list,arr, state, i + 1, end);
    }


    public static void main(String[] args) throws IOException {
        String s1 = br.readLine();
        String s2 = br.readLine();


        String[] arr1 = s1.split("");
        String[] arr2 = s2.split("");

        boolean[] state1 = new boolean[arr1.length];
        boolean[] state2 = new boolean[arr2.length];

        powerset(list1,arr1,state1,0,s1.length());
        powerset(list2,arr2,state2,0,s2.length());

        System.out.println(list1);
        System.out.println(list2);

    }
}
