class Solution {
        fun numIslands(grid: Array<CharArray>): Int {
        val visited = Array(grid.size) { IntArray(grid[0].size) }

        return findIslands(grid, visited)
    }

    private fun findIslands(grid: Array<CharArray>, visited: Array<IntArray>): Int {
        var count = 0

        grid.forEachIndexed { i, line ->
            line.forEachIndexed { j, char ->
                if (visited[i][j] == 0 && char == '1') {
                    adventure(grid, visited, i, j)
                    count++
                }
            }
        }

        return count
    }

    private fun adventure(grid: Array<CharArray>, visited: Array<IntArray>, i: Int, j: Int) {
        if (i >= grid.size || j >= grid[0].size || i < 0 || j < 0) {
            return
        }

        if (visited[i][j] == 1 || grid[i][j] == '0') {
            return
        }
        
        visited[i][j] = 1

        adventure(grid, visited, i + 1, j)
        adventure(grid, visited, i, j + 1)
        adventure(grid, visited, i - 1, j)
        adventure(grid, visited, i, j - 1)
    }
}