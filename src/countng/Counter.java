package countng;

import java.util.Scanner;

public class Counter {
    /*
    0 = 0
    1 = 1
    2 = 2
    3 = 3
    4 = 4
    5 = 1e
    6 = 1d
    7 = 1c
    8 = 1b
    9 = 1a
     */


    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();

        StringBuilder res = new StringBuilder();
        addDigit(res,0,n);

    }

    public static StringBuilder addDigit(StringBuilder res, int buffer, int n) {
        if (n == 0) {
            if(buffer!= 0){
                res.append(buffer);
            }
            System.out.println(res.reverse());
            return res;
        }
        int rem = n % 10;
        String value = "";
        switch (rem) {
            case 1:
            case 2:
            case 3:
            case 4: {
                value = String.valueOf(rem + buffer);
                buffer = 0;
                break;
            }
            case 5: {
                value = buffer == 0 ? "e" : "d";
                buffer=1;
                break;
            }
            case 6: {
                value = buffer == 0 ? "d" : "c";
                buffer=1;
                break;
            }
            case 7: {
                value = buffer == 0 ? "c" : "b";
                buffer=1;
                break;
            }
            case 8: {
                value = buffer == 0 ? "b" : "a";
                buffer=1;
                break;
            }
            case 9: {
                value = buffer == 0 ? "a" : "0";
                buffer=1;
                break;
            }
        }


        res.append(value);

        addDigit(res, buffer, n / 10);
        return res;
    }
}
