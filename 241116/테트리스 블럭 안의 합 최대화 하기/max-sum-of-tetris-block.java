import java.util.*;
import java.io.*;

public class Main {

    static int[][] dx = {{0,1,2,3}, {0,0,0,0}, {0,1,0,1}, 
        {0,0,0,1}, {0, 1, 2, 0}, {0, 1, 1,1}, {0,1,2,2}, {0,1,1,1}, {0,1,2,0}, {0,1,0,0}, {0,1,2,2},
        {0,0,0,1}, {0,1,2,1}, {0, 1,1,1}, {0,1,2,1},
        {0,0,1,1}, {1, 2, 0, 1}, {0,0,1,1}, {0,1,1,2},
    };
    static int[][] dy = {{0,0,0,0}, {0,1,2,3}, {0,0,1,1}, 
        {0,1,2,2}, {0,0,0,1}, {0,0,1,2}, {1,1,1,0}, {2,2,1,0}, {0,1,1,1}, {0,0,1,2}, {0,0,0,1},
        {0,1,2,1}, {0,0,0,1}, {1,0,1,2}, {1,1,1,0},
        {0,1,1,2}, {0,0,1,1}, {1,2,0,1}, {0,0,1,1}
    };
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<19; k++){
                    int sum = 0;
                    for(int l=0; l<4; l++){
                        int ny = dy[k][l] + i;
                        int nx = dx[k][l] + j;
                        if(ny >=0 && ny < n && nx >=0 && nx < m){
                            sum += arr[ny][nx];
                        }else{
                            break;
                        }
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }
        System.out.print(ans);

    }
}