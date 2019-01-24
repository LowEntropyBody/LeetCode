class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        // index表示char的值，value表示，离当前最近的的char出现的位置
        int[] lastShowPosition = new int[128];
        for (int i = 0; i < lastShowPosition.length; i++) {
            lastShowPosition[i] = -1;
        }
        int nowStart = 0;
        for (int i = 0; i < s.length(); i++) {
            int nowChar = s.charAt(i);
            // 如果上一个重复的nowChar的位置比当前nowStart的位置近，则更新nowStart到重复位置之后一位
            nowStart = Math.max(nowStart, (lastShowPosition[nowChar] + 1));
            result = Math.max(result, i - nowStart + 1);
            lastShowPosition[nowChar] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}