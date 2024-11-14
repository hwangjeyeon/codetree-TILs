import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};

        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{n-1, 0});
        list.add(new int[]{n-1, 1});
        list.add(new int[]{n-2, 0});
        list.add(new int[]{n-2, 1});

        int ans = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 이동방향으로 특수영양제 변경
            int size = list.size();
            switch(a){
                case 1:
                for(int j=0; j<size; j++){
                    int[] pos = list.get(j);
                    pos[1] = (pos[1] + b)%n;
                    if(pos[0] < 0){
                        pos[0] = n  + pos[0];
                    }
                    if(pos[1] < 0){
                        pos[1] = n  + pos[1];
                    }
                    arr[pos[0]][pos[1]]++;
                    list.add(new int[]{pos[0],pos[1]});
                }
                break;
                case 2:
                for(int j=0; j<size; j++){
                    int[] pos = list.get(j);
                    pos[0] = (pos[0] - b) % n;
                    pos[1] = (pos[1] + b) % n;
                    if(pos[0] < 0){
                        pos[0] = n  + pos[0];
                    }
                    if(pos[1] < 0){
                        pos[1] = n  + pos[1];
                    }
                    arr[pos[0]][pos[1]]++;
                    list.add(new int[]{pos[0],pos[1]});
                }
                break;
                case 3:
                for(int j=0; j<size; j++){
                    int[] pos = list.get(j);
                    pos[0] = (pos[0] - b) % n;
                    if(pos[0] < 0){
                        pos[0] = n  + pos[0];
                    }
                    if(pos[1] < 0){
                        pos[1] = n  + pos[1];
                    }
                    arr[pos[0]][pos[1]]++;
                    list.add(new int[]{pos[0],pos[1]});
                }
                break;
                case 4:
                for(int j=0; j<size; j++){
                    int[] pos = list.get(j);
                    pos[0] = (pos[0] - b) % n;
                    pos[1] = (pos[1] - b) % n;
                    if(pos[0] < 0){
                        pos[0] = n  + pos[0];
                    }
                    if(pos[1] < 0){
                        pos[1] = n  + pos[1];
                    }
                    arr[pos[0]][pos[1]]++;
                    list.add(new int[]{pos[0],pos[1]});
                }
                break;
                case 5:
                for(int j=0; j<size; j++){
                    int[] pos = list.get(j);
                    pos[1] = (pos[1] - b) % n;
                    if(pos[0] < 0){
                        pos[0] = n  + pos[0];
                    }
                    if(pos[1] < 0){
                        pos[1] = n  + pos[1];
                    }
                    arr[pos[0]][pos[1]]++;
                    list.add(new int[]{pos[0],pos[1]});
                }
                break;
                case 6:
                for(int j=0; j<size; j++){
                    int[] pos = list.get(j);
                    pos[0] = (pos[0] + b) % n;
                    pos[1] = (pos[1] - b) % n;
                    if(pos[0] < 0){
                        pos[0] = n  + pos[0];
                    }
                    if(pos[1] < 0){
                        pos[1] = n  + pos[1];
                    }
                    arr[pos[0]][pos[1]]++;
                    list.add(new int[]{pos[0],pos[1]});
                }
                break;
                case 7:
                for(int j=0; j<size; j++){
                    int[] pos = list.get(j);
                    pos[0] = (pos[0] + b) % n;  
                    if(pos[0] < 0){
                        pos[0] = n  + pos[0];
                    }
                    if(pos[1] < 0){
                        pos[1] = n  + pos[1];
                    }   
                    arr[pos[0]][pos[1]]++;      
                    list.add(new int[]{pos[0],pos[1]});       
                }
                break;
                case 8:
                for(int j=0; j<size; j++){
                    int[] pos = list.get(j);
                    pos[0] = (pos[0] + b) % n;                
                    pos[1] = (pos[1] + b) % n;
                    if(pos[0] < 0){
                        pos[0] = n  + pos[0];
                    }
                    if(pos[1] < 0){
                        pos[1] = n  + pos[1];
                    }
                    arr[pos[0]][pos[1]]++;
                    list.add(new int[]{pos[0],pos[1]});
                }
                break;
            }
            for(int j=0; j<size; j++){
                list.remove(0);
            }

            // 대각선 탐색 후 개수 파악해서 특수영양제 위치 합산
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j=0; j<size; j++){
                int[] now = list.get(j);
                int count = 0;
                for(int k=0; k<4; k++){
                    int ny = dy[k] + now[0];
                    int nx = dx[k] + now[1];
                    if(ny >=0 && ny < n && nx >=0 && nx < n && arr[ny][nx] > 0){
                        count++;
                    }
                    
                }
                tmp.add(count);
            }
            for(int j=0; j<tmp.size(); j++){
                int[] now = list.get(j);
                arr[now[0]][now[1]] += tmp.get(j);
            }

            // for(int j=0; j<n; j++){
            //     for(int k=0; k<n; k++){
            //         System.out.print(arr[j][k] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();

            // 특수 영양제 위치 변경
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    boolean isOk = true;
                    for(int l=0; l<size; l++){
                        int[] now = list.get(l);
                        if(now[0] == j && now[1] == k){
                            isOk = false;
                            break;
                        }
                    }
                    if(!isOk){
                        continue;
                    }
                    if(arr[j][k] >= 2){
                        arr[j][k] -= 2;
                        list.add(new int[]{j,k});
                    }

                }
            }
            for(int j=0; j<size; j++){
                list.remove(0);
            }

        }

        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                ans += arr[i][j];
            }
        }
        
        System.out.print(ans);
    }
}