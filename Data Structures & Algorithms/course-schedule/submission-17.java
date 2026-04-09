class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> completed = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
           if(!dfs(i, new HashSet<>(), completed, prerequisites)) return false;
        }

        return true;
    }

    public boolean dfs(int course, Set<Integer> visited, Set<Integer> completed, int[][] prerequisites) {
        if (completed.contains(course)) return true;
        if (visited.contains(course)) return false;
    

        visited.add(course);
        for (int j = 0; j < prerequisites.length; j++) {

            if (prerequisites[j][0] == course) {
                if (!dfs(prerequisites[j][1], visited, completed, prerequisites)) {
                    return false;
                }
            }
        }


        completed.add(course);
        return true;
    }
}
