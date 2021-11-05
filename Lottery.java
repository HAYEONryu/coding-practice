import java.io.*;
import java.util.*;
 //로또의 최고 순위와 최저 순위

public class Lottery {
    public static void main(String[] args) {
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win = {20, 9, 3, 45, 4, 35};
        //String input = "right"; 
        int[] result = solution(lottos, win);

        System.out.println("result is "+ result[0]+result[1]);
        for(int a = 0; a<result.length; a++)
            System.out.println(result[a]);
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int min_answer=0;
        int max_answer=0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int k = 0;
         for(int a = 0; a<lottos.length; a++){
             if(lottos[a]==0){
                 max_answer++;
             }else{
                while(k<win_nums.length){
                    if(win_nums[k] < lottos[a]){
                        k++;
                        continue;
                    }else if(lottos[a] == win_nums[k]){
                        min_answer++;
                        k++;
                        break;
                   }else if(lottos[a] < win_nums[k]){
                       break;
                   }
               }
            }
         }

         max_answer= max_answer+min_answer;
         
        answer[0] = Math.abs(max_answer-7); 

        if(Math.abs(min_answer-7)<6)
            answer[1] = Math.abs(min_answer-7);
        else answer[1] = 6;

        return answer;
    }
}