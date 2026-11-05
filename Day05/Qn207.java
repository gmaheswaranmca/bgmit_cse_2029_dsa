import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build graph and compute indegree
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        
        // Insert all indegree 0 nodes into queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        
        // While queue is not empty
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll(); // Remove course
            count++;
            
            // Reduce indegree of neighbors
            for (int neighbor : adj.get(currentCourse)) {
                indegree[neighbor]--;
                // If neighbor indegree becomes 0, insert into queue
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If count == total courses, return true; Else return false
        return count == numCourses;
    }
}
