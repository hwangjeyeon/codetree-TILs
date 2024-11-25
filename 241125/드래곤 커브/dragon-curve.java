import java.util.*;
import java.io.*;

public class Main {
    static int[][] dir = {{0,1},{-1,0}, {0,-1}, {1,0}}; // 우 상 좌 하
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        boolean[][] visited = new boolean[101][101];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            list.add(d);
            visited[y][x] = true;
            y += dir[d][0];
            x += dir[d][1];
            visited[y][x] = true;
            for(int j=1; j<=g; j++){
                int size = list.size();
                for(int k=size-1; k>=0; k--){
                    int tmp = list.get(k);
                    tmp++;
                    if(tmp > 3){
                        tmp= 0;
                    }
                    y += dir[tmp][0];
                    x += dir[tmp][1];
                    list.add(tmp);
                    visited[y][x] = true;
                }
            }
        }
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(visited[i][j] && visited[i+1][j] && visited[i][j+1] && visited[i+1][j+1]){
                    ans++;
                    // System.out.println(i + " " + j);
                    // System.out.println((i+1) + " " + j);
                    // System.out.println(i + " " + (j+1));
                    // System.out.println((i+1) + " " + (j+1));
                    // System.out.println();
                }
            }
        }
        System.out.print(ans);
    }
}