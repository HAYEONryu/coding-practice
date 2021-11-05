import java.io.*;
import java.util.*;
 //테스트케이스 14번 하나 통과 못함

public class PrimNumCheck {
    public static void main(String[] args) {
        int[] num = {1,2,3,4};
        int result = solution(num);
        // for(int a = 0; a<result.length; a++)
        System.out.println(result);
    }
    public static int solution(int[] nums) {
        int answer = 0;
        for(int a = 0; a< nums.length-2; a++){
            for(int k = a+1; k< nums.length-1; k++){
                for(int l = k+1; l< nums.length; l++){

                    int temp = nums[a]+ nums[l]+ nums[k];
                    int prim = 0;
                    for (int i = 2; i <= Math.sqrt(temp); i++) { //
                        //가장 효율적으로 소수 판별하기
                        if(temp% i == 0) {
                            //하나라도 나누어 떨어지면 소수가 아니다. 
                            prim++;
                        }
                    }
                    if(prim == 0) {//소수이면 
                        answer++;
                    }

                }
            }
        }
        return answer;
    }
}