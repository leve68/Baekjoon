import java.io.*;
import java.util.*;

class Solution {
    class Point {
        int index;
        int value;
        
        public Point(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;

        Deque<Point> q = new LinkedList<>();
        q.add(new Point(0, numbers[0]));
        q.add(new Point(0, numbers[0] * -1));
        
        while (!q.isEmpty()) {
            Point cPoint = q.poll();
            int i = cPoint.index;
            int v = cPoint.value;
            
            if(i == numbers.length - 1) {
                if (v == target) {
                    answer++;
                }
                continue;
            }
            
            q.add(new Point(i + 1, v + numbers[i + 1]));
            q.add(new Point(i + 1, v - numbers[i + 1]));
        }
        
        return answer;
    }
}