
class Solution {
    private record Point(int x, int y) {}

    private Set<Point> pacific = new HashSet<>();
    private Set<Point> atlantic = new HashSet<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) return Collections.emptyList();


        for (int j = 0; j < heights[0].length; j++) {
            dfs(0, j, heights, pacific);
        }
        for (int i = 0; i < heights.length; i++) {
            dfs(i, 0, heights, pacific);
        }
        for (int j = 0; j < heights[0].length; j++) {
            dfs(heights.length - 1, j, heights, atlantic);
        }
        for (int i = 0; i < heights.length; i++) {
            dfs(i, heights[0].length - 1, heights, atlantic);
        }

        pacific.retainAll(atlantic);


        return pacific.stream().map(p -> List.of(p.x, p.y)).collect(Collectors.toList());
    }

    private void dfs(int i, int j, int[][] heights, Set<Point> visited) {
        if (visited.contains(new Point(i, j)))
            return;

        visited.add(new Point(i, j));

        if (i - 1 >= 0 && heights[i][j] <= heights[i - 1][j])
            dfs(i - 1, j, heights, visited);
        if ((j - 1 >= 0) && heights[i][j] <= heights[i][j - 1])
            dfs(i, j - 1, heights, visited);
        if (i + 1 < heights.length && heights[i][j] <= heights[i + 1][j])
            dfs(i + 1, j, heights, visited);
        if (j + 1 < heights[i].length && heights[i][j] <= heights[i][j + 1])
            dfs(i, j + 1, heights, visited);
    }
}