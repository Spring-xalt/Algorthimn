package Lc_mid.DataStcuture;

import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
// Lc 636 函数的独占时间
public class TimeOfFuction {
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        int cur = -1;
        for (String log : logs) {
            String[] ss = log.split(":");
            int index = Integer.parseInt(ss[0]), value = Integer.parseInt(ss[2]);
            if (ss[1].equals("start")) {
                if (!s.isEmpty()) ans[s.peek()] += value-cur;
                s.push(index);
                cur = value;
            } else {
                int func = s.pop();
                ans[func] += value - cur + 1;
                cur = value + 1;
            }
        }
        return ans;
    }
}
