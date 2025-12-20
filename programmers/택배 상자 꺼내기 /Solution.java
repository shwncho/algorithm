class Solution {
    public int solution(int n, int w, int num) {
        // num 번 상자의 (행, 열) 좌표 구하기
        int[] numPos = getPosition(num, w);
        int numRow = numPos[0];
        int numCol = numPos[1];

        // num 위에 있는 상자들 중 num을 꺼내려면 제거해야 할 상자 개수
        int count = 0;

        // num보다 위에 있는 모든 상자 확인
        for (int box = num + 1; box <= n; box++) {
            int[] boxPos = getPosition(box, w);
            int boxRow = boxPos[0];
            int boxCol = boxPos[1];

            // 같은 열에 있고 더 위에 있으면 꺼내야 함
            if (boxCol == numCol && boxRow > numRow) {
                count++;
            }
        }

        // num 상자 자신도 포함
        return count + 1;
    }

    // 상자 번호를 입력받아 (행, 열) 좌표 반환
    private int[] getPosition(int num, int w) {
        // num은 1부터 시작하므로 0부터 시작하는 인덱스로 변환
        int index = num - 1;

        // 몇 번째 층인지 (행)
        int row = index / w;

        // 그 층에서 몇 번째 위치인지 (열)
        int colInLayer = index % w;

        // 짝수 행(0, 2, 4, ...): 왼쪽→오른쪽 (열 그대로)
        // 홀수 행(1, 3, 5, ...): 오른쪽→왼쪽 (열 반전)
        int col;
        if (row % 2 == 0) {
            // 짝수 행: 왼쪽→오른쪽
            col = colInLayer;
        } else {
            // 홀수 행: 오른쪽→왼쪽 (반전)
            col = w - 1 - colInLayer;
        }

        return new int[]{row, col};
    }
}