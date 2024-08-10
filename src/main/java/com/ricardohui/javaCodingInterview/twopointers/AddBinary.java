package com.ricardohui.javaCodingInterview.twopointers;
import java.util.*;
public class AddBinary {
    public static String addBinary (String str1, String str2) {
        StringBuffer sb = new StringBuffer();
        // Replace this placeholder return statement with your code
        int carry = 0;
        for(int i = str1.length()-1; i > 0; i--){
            for (int j = str2.length()-1; j > 0; j--){
                if(str1.charAt(i) == '0'){
                    if(str2.charAt(j) == '1'){
                        if(carry == 1){
                            sb.append(0);
                            carry = 0;
                        }else{
                            sb.append(1);
                        }
                    }else{
                        // str2.chatAt(j) is 0
                        if(carry == 1){
                            sb.append(1);
                            carry = 0;
                        }else{
                            sb.append(0);
                        }
                    }
                }else{
                    // str1.chatAt(i) is 1
                    if(str2.charAt(j) == '1'){
                        if(carry == 1){
                            sb.append(0);
                            carry = 1;
                        }else{
                            sb.append(1);
                        }
                    }else{
                        // str2.chatAt(j) is 0
                        if(carry == 1){
                            sb.append(1);
                            carry = 0;
                        }else{
                            sb.append(0);
                        }
                    }

                }

            }
        }

        return sb.reverse().toString();

    }


}
