//https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
package backtracking;

class solve {
    // Function to determine if it is safe to color vertex 'v' with color 'c'
    // This function checks if any adjacent vertex of 'v' has the same color 'c'
    private boolean isSafe(boolean graph[][], int v, int[] colors, int c, int n) {
        // Check all vertices to see if any adjacent vertex has the same color 'c'
        for (int i = 0; i < n; i++) {
            if (graph[v][i] && colors[i] == c) {
                return false; // If adjacent vertex has the same color, it's not safe
            }
        }
        return true; // It's safe to color vertex 'v' with color 'c'
    }

    // Main function to helper the M-Coloring problem
    // Returns true if the graph can be colored with at most 'm' colors, otherwise false
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] colors = new int[n]; // Array to store assigned colors to vertices
        // Initialize all vertices with no color (0)
        for (int i = 0; i < n; i++) {
            colors[i] = 0;
        }
        // Start coloring from the first vertex (vertex 0)
        return helper(graph, m, colors, 0, n);
    }

    // Utility function to try assigning colors to all vertices
    private boolean helper(boolean graph[][], int m, int[] colors, int v, int n) {
        // Base case: If all vertices are assigned a color, return true
        if (v == n) {
            return true;
        }

        // Try assigning each color from 1 to m to vertex 'v'
        for (int c = 1; c <= m; c++) {
            // Check if it's safe to assign color 'c' to vertex 'v'
            if (isSafe(graph, v, colors, c, n)) {
                // Assign color 'c' to vertex 'v'
                colors[v] = c;

                // Recur to assign colors to the rest of the vertices
                if (helper(graph, m, colors, v + 1, n)) {
                    return true; // If solution is found, return true
                }

                // If assigning color 'c' doesn't lead to a solution, backtrack
                colors[v] = 0; // Remove the color assignment (backtracking)
            }
        }

        // If no color can be assigned to vertex 'v', return false
        return false;
    }
}

