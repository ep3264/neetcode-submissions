class Solution {
    /**
     * @param {number} numCourses
     * @param {number[][]} prerequisites
     * @return {boolean}
     */
    canFinish(numCourses, prerequisites) {
        for (let i = 0; i < prerequisites.length; i++) {
          if (!this.dfs(prerequisites[i][1], new Set(), prerequisites)) return false;
        }

        return true;
    }

    dfs(i, visited, prerequisites) {
        if (visited.has(i)) return false;
        visited.add(i);
        for (let j = 0; j < prerequisites.length; j++) {
            if (prerequisites[j][0] == i) {
                if(!this.dfs(prerequisites[j][1], visited, prerequisites)) return false;
            }
        }

        return true;
    }
}
