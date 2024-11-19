import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dice = {0,0,0,0,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            int dir = Integer.parseInt(st.nextToken())-1;
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            // System.out.println(ny + " " + nx);
            if(ny >=0 && ny < n && nx >=0 && nx < m){
                y = ny;
                x = nx;
                if(dir == 0){
                    int tmp1 = dice[4];
                    int tmp2 = dice[5];
                    dice[4] = dice[1];
                    dice[5] = dice[0];
                    dice[0] = tmp1;
                    dice[1] = tmp2;
                }else if(dir == 1){
                    int tmp1 = dice[4];
                    int tmp2 = dice[5];
                    dice[4] = dice[0];
                    dice[5] = dice[1];
                    dice[0] = tmp2;
                    dice[1] = tmp1;
                }else if(dir == 2){
                    int tmp1 = dice[2];
                    int tmp2 = dice[3];
                    dice[2] = dice[1];
                    dice[3] = dice[0];
                    dice[0] = tmp1;
                    dice[1] = tmp2;
                }else{
                    int tmp1 = dice[2];
                    int tmp2 = dice[3];
                    dice[2] = dice[0];
                    dice[3] = dice[1];
                    dice[0] = tmp2;
                    dice[1] = tmp1;
                }


                if(arr[ny][nx] == 0){
                    arr[ny][nx] = dice[1];
                }else{
                    dice[1] = arr[ny][nx];
                    arr[ny][nx] = 0;
                }
                System.out.println(dice[0]);
            }
            
        }

    }
}