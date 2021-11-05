import java.io.*;
import java.util.*;
 //중간 2580 어케 하지? 

public class Keypad {
    public static void main(String[] args) {
        int[] array = {1,3,4,5,8,2,1,4,5,9,5};
        String input = "right"; 
        String result = solution(array, input);
        
        System.out.println("result is "+ array);
        // for(int a = 0; a<result.length; a++)
        //     System.out.println(result[a]);
    }
    
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int right = -1;
        int left = -1;
        
        for(int a = 0; a < numbers.length; a++){
            System.out.println("right: left  "+ right+":"+left);
            System.out.println(numbers[a] + " answer  "+ answer);
            if(right == left && numbers[a]==0){
                if(hand.equals("right")){
                    answer = answer.concat("R");
                    right= numbers[a];
                }else {
                    answer= answer.concat("L");
                    left = numbers[a];
                }
            }

            if(numbers[a]%3==0){
                answer= answer.concat("R");
                right = numbers[a];
            }else if(numbers[a]==1 || numbers[a]==4 || numbers[a]==7){
                answer= answer.concat("L");
                left = numbers[a];
            }else{
                if(Math.abs(numbers[a]-left) > Math.abs(numbers[a]-right)){
                    answer= answer.concat("R");
                    right = numbers[a];
                }else if(Math.abs(numbers[a]-left) < Math.abs(numbers[a]-right)){
                    answer= answer.concat("L");
                    left = numbers[a];
                }else{
                    if(hand.equals("right")){
                        answer= answer.concat("R");
                        right= numbers[a];
                    }else {
                        answer= answer.concat("L");
                        left = numbers[a];
                    }
                }

            }
        }
        return answer;
    }
}