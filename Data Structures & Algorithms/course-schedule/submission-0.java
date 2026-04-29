class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] courseState = new int[numCourses];

        for(int[] pr : prerequisites){
            int u = pr[0];
            int v = pr[1];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        for(int course=0; course < numCourses; course++){
            if(!dfs(course, courseState, adjList)){
               return false;
            }
        }
        return true;
    }

    public boolean dfs(int course, int[] courseState, Map<Integer, List<Integer>> adjList){
        if(courseState[course] == 2){
            return true;
        }else if(courseState[course] == 1){
            return false;
        }else{
            courseState[course] = 1;
            for(int prereq : adjList.getOrDefault(course, new ArrayList<>())){
                if(!dfs(prereq, courseState, adjList)){
                    return false;
                }
            }
            courseState[course] = 2;
            return true;
        }
    }
}
