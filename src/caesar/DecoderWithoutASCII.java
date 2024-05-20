package caesar;

import java.util.Scanner;

//Вариант сугубо алгоритмический, без знания ASCII кодов
public class DecoderWithoutASCII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Ввод базы смещения.
        int N = Integer.parseInt(in.nextLine());

        //Введем англицкий алфавит по которому будем искать совпадения.
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String s = in.nextLine();

        StringBuilder res = new StringBuilder();
        for (char oldChar: s.toCharArray())
        {
            char[] charArray = alphabet.toCharArray();
            //нужно если символа в алфавите нет
            int oldIndex = -1;
            for (int i = 0; i < charArray.length; i++) {
                char a = charArray[i];
                if (oldChar == a || oldChar == Character.toUpperCase(a)) {
                    oldIndex = i;
                    //осуществляем смещение
                    int newIndex = oldIndex - N;
                    //если индекс меньше нуля - прибваляем весь алфавит сначала и попадаем на нужный символ
                    if(newIndex < 0){
                        newIndex+=alphabet.length();
                    }
                    char newChar = alphabet.charAt(newIndex);
                    //фиксим регистр
                    if(Character.isUpperCase(oldChar)){
                        newChar = Character.toUpperCase(newChar);
                    }
                    res.append(newChar);
                }
            }
            //Если символа в алфавите нет - оставляем его первозданным
            if(oldIndex == -1){
                res.append(oldChar);
            }

        }
        System.out.println(res);
    }
}
