package caesar;

import java.util.Scanner;

public class DecoderWithASCII {
    public static void main(String[] args) {
        //ASCII код символа 'a'
        final int ENGLISH_LOWCASE_OFFSET_BOTTOM = 97;
        //ASCII код символа 'z'
        final int ENGLISH_LOWCASE_OFFSET_TOP = 122;
        //ASCII код символа 'A'
        final int ENGLISH_UPCASE_OFFSET_BOTTOM = 65;
        //ASCII код символа 'Z'
        final int ENGLISH_UPCASE_OFFSET_TOP = 90;
        Scanner in = new Scanner(System.in);
        //Ввод базы смещения.
        int N = Integer.parseInt(in.nextLine());

        String s = in.nextLine();

        StringBuilder res = new StringBuilder();
        for (char oldChar : s.toCharArray()) {
            int charcode = oldChar;
            //осуществляем смещение
            int newcharcode = charcode - N;

            //если код оказался меньше 'A' - считаем код выражением Z + ? - A
            if (newcharcode < ENGLISH_UPCASE_OFFSET_BOTTOM)
            {
                newcharcode = ENGLISH_UPCASE_OFFSET_TOP + newcharcode - ENGLISH_UPCASE_OFFSET_BOTTOM +1;
            }
            //если код оказался меньше 'a' - считаем код выражением z + ? - a
            else if (Character.isLowerCase(oldChar) && newcharcode < ENGLISH_LOWCASE_OFFSET_BOTTOM ) {
                newcharcode = ENGLISH_LOWCASE_OFFSET_TOP + newcharcode - ENGLISH_LOWCASE_OFFSET_TOP +1;
            }
            res.append((char) newcharcode);

        }
        System.out.println(res);
    }
}
