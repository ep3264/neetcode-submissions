class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
        const f = new Map();

        for (const c of s) {
            f.set(c, (f.get(c) ?? 0) + 1);
        }

        for (const c of t) {
            if (!f.has(c)) return false;

            f.set(c, f.get(c) - 1);
            if (f.get(c) === 0) f.delete(c);
        }

        return f.size === 0;
    
    }
}
