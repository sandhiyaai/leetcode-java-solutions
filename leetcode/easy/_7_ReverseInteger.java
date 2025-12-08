/**
 * Reverse Integer
 *
 * Description:
 * Given a signed 32-bit integer x, reverse its digits.
 * If the reversed value overflows beyond the 32-bit signed range
 * [-2^31, 2^31 − 1], return 0.
 *
 * Example:
 *  Input: 123  -> Output: 321
 *  Input: -120 -> Output: -21
 *
 * Approach:
 * Extract digits one by one, build the reversed number, and
 * check for overflow before multiplying.
 *
 * Time Complexity:  O(log10(n))  // proportional to number of digits
 * Space Complexity: O(1)
 */

class Solution {
    public int reverse(int x) {
        int s = 0;
        while (x != 0) {
            int rem = x % 10;
            // check for overflow before multiplying by 10
            if (s < Integer.MIN_VALUE / 10 || s > Integer.MAX_VALUE / 10) return 0;
            s = s * 10 + rem;
            x = x / 10;
        }
        return s;
    }
}
