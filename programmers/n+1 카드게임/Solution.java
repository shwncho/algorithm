import java.util.HashSet;
import java.util.Set;

public class Solution {
    static int N;
    public int solution(int coin, int[] cards) {
        int answer = 1;
        N = cards.length;
        Set<Integer> hands = new HashSet<>();
        Set<Integer> draw = new HashSet<>();

        for (int i = 0; i < N / 3; i++) {
            hands.add(cards[i]);
        }

        int idx = N / 3;

        while (idx < N) {
            for (int i = 0; i < 2; i++) {
                draw.add(cards[idx++]);
            }

            if (hands.size() >= 2 && isValid(hands, hands)) {
                answer++;
            } else if (hands.size() >= 1 && coin >= 1 && isValid(hands, draw)) {
                answer++;
                coin--;
            } else if (coin >= 2 && isValid(draw, draw)) {
                answer++;
                coin -= 2;
            } else {
                break;
            }
        }

        return answer;
    }

    private boolean isValid(Set<Integer> s, Set<Integer> matching) {
        for (int card : s) {
            int matchingCard = (N + 1) - card;

            if (matching.contains(matchingCard)) {
                s.remove(card);
                matching.remove(matchingCard);

                return true;
            }
        }

        return false;
    }
}
