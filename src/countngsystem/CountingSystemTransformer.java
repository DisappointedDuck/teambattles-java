package countngsystem;

import java.util.Scanner;

public class CountingSystemTransformer {
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

    //res - текущая строка в процессе формирования
    //buffer - разрядный перенос
    //n - то что осталось от оригинального числа после отщипывания последней цифры
    public static StringBuilder addDigit(StringBuilder res, int buffer, int n) {
        //если дошли до конца - выходим из рекурсии
        if (n == 0) {

            //если был разраядный перенос в отстуствующий разряд
            if(buffer!= 0){
                res.append(buffer);
            }
            //так как разворачивали число с последнего символа
            System.out.println(res.reverse());
            return res;
        }
        //получаем последнюю цифру
        int rem = n % 10;
        String value = "";
        switch (rem) {
            case 1:
            case 2:
            case 3:
            case 4: {
                //для символов меньше 4-х - просто записываем их. Если прошлая операция сообщила о разраядном переносе - плюсуем его, и дальше не передаем
                value = String.valueOf(rem + buffer);
                buffer = 0;
                break;
            }
            case 5: {
                //если разрядного переноса не было, то 5 = 10 - e. Но если был - 10 - e + 1
                value = buffer == 0 ? "e" : "d";
                //10 = разярядный перенос 1 в след разряд
                buffer=1;
                break;
            }
            case 6: {
                //по аналогии
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
