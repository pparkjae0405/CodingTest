import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 명령 개수 N이 주어지고, 덱 a를 선언한다.
          int N = Integer.parseInt(br.readLine());
          Deque<Integer> a = new ArrayDeque<>();

          // 2. N만큼 명령이 주어지는데
          int lastCount = 0;
          for(int i = 0 ; i < N ; i++){
               StringTokenizer st = new StringTokenizer(br.readLine(), " ");
               // 처음 들어오는 값 first가 push_front이면
               String first = st.nextToken();
               if(first.equals("push_front")){
                    // 그 다음 들어오는 정수를 lastCount에 저장한 뒤 덱 앞에 추가하고
                    lastCount = Integer.parseInt(st.nextToken());
                    a.addFirst(lastCount);
               }else if(first.equals("push_back")){
                    // push_back이면 그 다음 들어오는 정수를 lastCount에 저장한 뒤 덱 뒤에 추가하고
                    lastCount = Integer.parseInt(st.nextToken());
                    a.addLast(lastCount);
               }else if(first.equals("pop_front")){
                    // pop_front일 때 a가 비어있지 않다면 맨 앞 값을 빼고 출력하고
                    if(!a.isEmpty()){
                         bw.write(a.removeFirst() + "\n");
                    }else{
                         // 비어있다면 -1을 출력,
                         bw.write("-1" + "\n");
                    }
               }else if(first.equals("pop_back")){
                    // pop_back일 때 a가 비어있지 않다면 맨 뒤 값을 빼고 출력하고
                    if(!a.isEmpty()){
                         bw.write(a.removeLast() + "\n");
                    }else{
                         // 비어있다면 -1을 출력,
                         bw.write("-1" + "\n");
                    }
               }else if(first.equals("size")){
                    // size이면 a에 들어있는 정수 개수를 출력하고,
                    bw.write(a.size() + "\n");
               }else if(first.equals("empty")){
                    // empty일 때 a가 비어있지 않다면 0 출력,
                    if(!a.isEmpty()){
                         bw.write("0" + "\n");
                    }else{
                         // 비어있다면 1 출력,
                         bw.write("1" + "\n");
                    }
               }else if(first.equals("front")){
                    // front일 때 a가 비어있지 않다면 가장 앞의 수 출력,
                    if(!a.isEmpty()){
                         bw.write(a.getFirst() + "\n");
                    }else{
                         // 비어있다면 -1을 출력,
                         bw.write("-1" + "\n");
                    }
               }else if(first.equals("back")){
                    // back일 때 a가 비어있지 않다면 가장 뒤의 수 출력,
                    if(!a.isEmpty()){
                         bw.write(a.getLast() + "\n");
                    }else{
                         // 비어있다면 -1을 출력한다.
                         bw.write("-1" + "\n");
                    }
               }
          }
          bw.flush();
          bw.close();
          br.close();
     }
}