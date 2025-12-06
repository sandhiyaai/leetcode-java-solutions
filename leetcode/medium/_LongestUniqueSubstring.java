| Method                   | Time Complexity | Space Complexity |
| ------------------------ | --------------- | ---------------- |
| Brute Force              | **O(N²)**       | **O(1)**         |
| Sliding Window Optimized | **O(N)**        | **O(1)**         |

// Brute Force Approach (Higher Time Complexity)
class SolutionBrute {
    public int longestUniqueSubstr(String s) {
        int len = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            int hash[] = new int[256];
            for (int j = i; j < s.length(); j++) {
                if (hash[s.charAt(j)] == 1) break;

                len = j - i + 1;
                max = Math.max(len, max);
                hash[s.charAt(j)] = 1;
            }
        }
        return max;
    }
}


// Optimized Sliding Window (Better Time Complexity)
class SolutionOptimized {
    public int longestUniqueSubstr(String s) {

        int[] hash = new int[256];
        for (int i = 0; i < 256; i++) {
            hash[i] = -1;
        }

        int l = 0, r = 0;
        int len = 0, maxlen = 0;

        while (r < s.length()) {
            if (hash[s.charAt(r)] != -1) {
                if (l <= hash[s.charAt(r)]) {
                    l = hash[s.charAt(r)] + 1;
                }
            }

            len = r - l + 1;
            maxlen = Math.max(len, maxlen);

            hash[s.charAt(r)] = r;
            r++;
        }
        return maxlen;
    }
}
