import java.io.*;
import java.util.*;

class Solution {
    public int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // union find
        parent = new int[n];
        for (int i = 0 ; i < n ; i++) {
            parent[i] = i;
        }
        
        for (int i = 0 ; i < n ; i++) {
            for (int j = i + 1 ; j < n ; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
                
        Set<Integer> set = new HashSet<>();
        for (int i : parent) {
            int p = find(i);
            if (set.contains(p)) continue;
            set.add(p);
        }
        return set.size();
    }
    
    private void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        
        if (aParent != bParent) parent[aParent] = bParent;
    }
    
    private int find(int children) {
        if(parent[children] == children) {
            return children;
        }
        return parent[children] = find(parent[children]);
    }
}