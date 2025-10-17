import java.util.*;

class Solution {
    public int answer = 0;
    public boolean[] visited;
    public int[] vArr;
    public int[][] edgeArr;
    public int solution(int[] info, int[][] edges) {
        vArr = new int[info.length];
        for (int i = 0 ; i < info.length ; i++) {
            vArr[i] = info[i];
        }
        edgeArr = new int[edges.length][edges[0].length];
        for (int i = 0 ; i < edges.length ; i++) {
            for(int j = 0 ; j < edges[0].length ; j++) {
                edgeArr[i][j] = edges[i][j];
            }
        }
        
        visited = new boolean[info.length];
        visited[0] = true;
        dfs(1, 0);
        
        return answer;
    }
    
    public void dfs(int sheep, int wolf) {
        if (sheep > wolf) answer = Math.max(answer, sheep);
        else return;
        
        for (int[] edge : edgeArr) {
            if (visited[edge[0]] == true && visited[edge[1]] == false) {
                visited[edge[1]] = true;
                if (vArr[edge[1]] == 0) {
                    dfs(sheep + 1, wolf);
                } else {
                    dfs(sheep, wolf + 1);
                }
                visited[edge[1]] = false;
            }
        }
    }
}