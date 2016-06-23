public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!canFinish(i, prerequisites, visited, onStack)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean canFinish(int i, int[][] prerequisited, boolean[] visited, boolean[] onStack) {
        visited[i] = true;
        onStack[i] = true;
        
        for (int j = 0; j < prerequisited.length; j++) {
            if (prerequisited[j][0] == i) {
                if (!visited[prerequisited[j][1]]) {
                    if(!canFinish(prerequisited[j][1], prerequisited, visited, onStack)) {
                        return false;
                    }
                } else if (onStack[prerequisited[j][1]]) {
                    return false;
                }
            }
        }
        
        onStack[i] = false;
        return true;
    }
}