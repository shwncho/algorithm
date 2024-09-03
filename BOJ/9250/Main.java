import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Trie {
        Trie[] go;
        Trie fail;
        boolean output;

        Trie() {
            go = new Trie[26];
            output = false;
        }

        void insert(String key) {
            Trie current = this;
            for (char c : key.toCharArray()) {
                int next = c - 'a';
                if (current.go[next] == null) {
                    current.go[next] = new Trie();
                }
                current = current.go[next];
            }
            current.output = true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Trie root = new Trie();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            root.insert(str);
        }

        Queue<Trie> queue = new LinkedList<>();
        root.fail = root;
        queue.add(root);

        while (!queue.isEmpty()) {
            Trie current = queue.poll();

            for (int i = 0; i < 26; i++) {
                Trie next = current.go[i];
                if (next == null) continue;

                if (current == root) {
                    next.fail = root;
                } else {
                    Trie dest = current.fail;
                    while (dest != root && dest.go[i] == null) {
                        dest = dest.fail;
                    }
                    if (dest.go[i] != null) {
                        dest = dest.go[i];
                    }
                    next.fail = dest;
                }

                if (next.fail.output) {
                    next.output = true;
                }

                queue.add(next);
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            Trie current = root;
            boolean result = false;

            for (char c : str.toCharArray()) {
                int next = c - 'a';
                while (current != root && current.go[next] == null) {
                    current = current.fail;
                }
                if (current.go[next] != null) {
                    current = current.go[next];
                }
                if (current.output) {
                    result = true;
                    break;
                }
            }

            sb.append(result ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}
