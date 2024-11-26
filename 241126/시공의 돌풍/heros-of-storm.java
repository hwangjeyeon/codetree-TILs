import java.util.*;
import java.io.*;

public class Main {
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        ArrayList<int[]> storm = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1){
                    storm.add(new int[]{i,j});
                }
            }
        }
        


        int ans = 0;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int tc = 0; tc < t; tc++){
            // 확산과정
            int[][] tmp = new int[n][m];
            for(int i=0; i<n; i++){
                tmp[i] = arr[i].clone();
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    int p = tmp[i][j] / 5;
                    for(int k=0; k<4; k++){
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny >=0 && ny < n && nx >= 0 && nx < m && arr[ny][nx] != -1){
                            arr[ny][nx] += p; 
                            arr[i][j] -= p;
                        }
                    }
                }
            }

            // 돌풍 과정
            // 상단
            int[] start = storm.get(0);
            //상
            for(int i=start[0]-1; i>0; i--){
                arr[i][0] = arr[i-1][0];
            }

            // 우
            for(int i=0; i<m-1; i++){
                arr[0][i] = arr[0][i+1];
            }

            // 하
            for(int i=0; i<start[0]; i++){
                arr[i][m-1] = arr[i+1][m-1];
            }

            // 좌
            for(int i=m-1; i>1; i--){
                arr[start[0]][i] = arr[start[0]][i-1];
            }
            arr[start[0]][1] = 0;


            //하단
            start = storm.get(1);
            // 하
            for(int i=start[0]+1; i<n-1; i++){
                arr[i][0] = arr[i+1][0];
            }
            // 우
            for(int i=0; i<m-1; i++){
                arr[n-1][i] = arr[n-1][i+1];
            }
            //상
            for(int i=n-1; i>start[0]; i--){
                arr[i][m-1] = arr[i-1][m-1];
            }

            // 좌
            for(int i=m-1; i>1; i--){
                arr[start[0]][i] = arr[start[0]][i-1];
            }
            arr[start[0]][1] = 0;

        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]!= -1){
                    ans += arr[i][j];
                }
            }
        }


        System.out.print(ans);
    }
}