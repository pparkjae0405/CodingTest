import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. N을 입력받고
          int N = Integer.parseInt(br.readLine());

          // 2. 배열 a를 선언하여 N만큼의 숫자를 입력받은 뒤
          int[] a = new int[N];
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < N ; i++){
               a[i] = Integer.parseInt(st.nextToken());
          }

          // 3. 배열 a를 정렬하고
          Arrays.sort(a);

          // 4. M을 입력받고
          int M = Integer.parseInt(br.readLine());

          // 5. M만큼 숫자를 입력받아 a에 몇 개 존재하는지 확인하는데
          st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < M ; i++){
               int key = Integer.parseInt(st.nextToken());
               // 9. 더이상 안나오는 지점 인덱스 - 시작 인덱스를 출력한다.
               bw.write(searchLast(a, key)-searchFirst(a, key) + " ");
          }

          bw.flush();
          bw.close();
          br.close();
     }

     // 6. key값의 개수를 알아내기 위해서는
     // 배열 안 key값의 시작과 key값이 더이상 안나오는 지점의 인덱스를 알아야 하므로
     // 7. 맨 앞 인덱스를 찾을 searchFirst 함수를 선언하여
     public static int searchFirst(int[] a, int key){
          // 시작과 끝 지점을 선언한 뒤
          int start = 0;
          int end = a.length;
          while(start < end){
               // 중간 인덱스를 선언하고
               int half = (start+end)/2;

               // key값이 중간값 이하라면 오른쪽을 배제
               if(key <= a[half]){
                    end = half;
               }else{
                    // 아니라면 왼쪽을 배제하여
                    start = half+1;
               }
          }

          // 맨 앞 인덱스를 리턴하고,
          return start;
     }
     // 8. 더이상 안나오는 지점의 인덱스를 찾을 searchLast 함수를 선언하고
     public static int searchLast(int[] a, int key){
          // 시작과 끝 지점을 선언한 뒤
          int start = 0;
          int end = a.length;
          while(start < end){
               // 중간 인덱스를 선언하고
               int half = (start+end)/2;

               // key값이 중간값 미만이라면 오른쪽을 배제
               if(key < a[half]){
                    end = half;
               }else{
                    // 아니라면 왼쪽을 배제하여
                    start = half+1;
               }
          }

          // 더이상 안나오는 지점의 인덱스를 리턴하여
          return start;
     }
}