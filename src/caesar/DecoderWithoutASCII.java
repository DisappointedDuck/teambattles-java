package caesar;

import java.util.Scanner;

public class DecoderWithoutASCII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Ввод базы смещения.
        int N = Integer.parseInt(in.nextLine());

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String s = in.nextLine();

        StringBuilder res = new StringBuilder();
        for (char oldChar: s.toCharArray())
        {
            char[] charArray = alphabet.toCharArray();
            int oldIndex = -1;
            for (int i = 0; i < charArray.length; i++) {
                char a = charArray[i];
                if (oldChar == a || oldChar == Character.toUpperCase(a)) {
                    oldIndex = i;
                    int newIndex = oldIndex - N;
                    if(newIndex < 0){
                        newIndex+=alphabet.length();
                    }
                    char newChar = alphabet.charAt(newIndex);
                    if(Character.isUpperCase(oldChar)){
                        newChar = Character.toUpperCase(newChar);
                    }
                    res.append(newChar);
                }
            }
            if(oldIndex == -1){
                res.append(oldChar);
            }

        }
        System.out.println(res);
    }
}
