
class Solution {
 record Point(int x, int y) {}
    private Set<Point> hashSet;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) return Collections.emptyList();

        var result = new ArrayList<List<Integer>>();

       hashSet = new HashSet<Point>();

        for (int i = 0; i < heights.length; i++) {
            int m = heights[i].length;
            for (int j = 0; j < m; j++) {
                if (test(i, j, heights)) {
                    result.add(new ArrayList<>(List.of(i, j)));
                    hashSet.add(new Point(i, j));
                }
            }
        }

        return result;
    }

    private boolean test(int i, int j, final int[][] heights) {
        return canFlow(i, j, heights, (a, b) -> a == 0 || b == 0, new HashSet<>())
                && canFlow(i, j, heights, (a, b) -> a == heights.length - 1 || b == heights[a].length - 1, new HashSet<>());
    }

    private boolean canFlow(int i, int j, int[][] heights, BiPredicate<Integer, Integer> p, Set<Point> visited) {
        if (p.test(i, j))
            return true;

        if (visited.contains(new Point(i, j)))
            return false;

        visited.add(new Point(i, j));

        return  hashSet.contains(new Point(i, j)) ||

                ((i - 1 >= 0) && heights[i][j] >= heights[i - 1][j] && canFlow(i - 1, j, heights, p, visited))
                ||
                ((j - 1 >= 0) && heights[i][j] >= heights[i][j - 1]
                && canFlow(i, j - 1, heights, p, visited))
                ||
                ((i + 1 < heights.length) && heights[i][j] >= heights[i + 1][j]
                        && canFlow(i + 1, j, heights, p, visited))
                ||  ((j + 1 < heights[i].length)
                && heights[i][j] >= heights[i][j + 1] && canFlow(i, j + 1, heights, p, visited));
    }

interface BiPredicate<T, U> {

    boolean test(T t, U u);
}
}