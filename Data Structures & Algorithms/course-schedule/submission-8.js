class Solution {
    /**
     * @param {number} numCourses
     * @param {number[][]} prerequisites
     * @return {boolean}
     */
    canFinish(numCourses, prerequisites) {
        let b = true;

        for (let i = 0; i < prerequisites.length; i++) {
            b = b && this.dfs(prerequisites[i][1], new Set(), prerequisites);
        }

        return b;
    }

    dfs(i, visited, prerequisites) {
        if (visited.has(i)) return false;
        visited.add(i);
        let b = true;
        for (let j = 0; j < prerequisites.length; j++) {
            if (prerequisites[j][0] == i) {
                b = b && this.dfs(prerequisites[j][1], visited, prerequisites);
            }
        }

        return b;
    }
}
