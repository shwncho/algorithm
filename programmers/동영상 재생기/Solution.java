class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int videoLen = toSec(video_len);
        int cur = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);

        // 오프닝 구간이면 먼저 점프
        if (cur >= opStart && cur <= opEnd) {
            cur = opEnd;
        }

        for (String cmd : commands) {

            // 명령어 수행
            if (cmd.equals("prev")) {
                cur = Math.max(0, cur - 10);
            } else { // next
                cur = Math.max(cur + 10, 0);
                cur = Math.min(cur, videoLen);
            }

            // 명령 후 오프닝 구간에 들어오면 점프
            if (cur >= opStart && cur <= opEnd) {
                cur = opEnd;
            }
        }

        return toMMSS(cur);
    }

    private int toSec(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    private String toMMSS(int sec) {
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d", m, s);
    }
}