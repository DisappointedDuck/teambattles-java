package caesar;

import java.util.Scanner;

public class DecoderWithASCII {
    public static void main(String[] args) {
        final int ENGLISH_LOWCASE_OFFSET_BOTTOM = 97;
        final int ENGLISH_LOWCASE_OFFSET_TOP = 122;
        final int ENGLISH_UPCASE_OFFSET_BOTTOM = 65;
        final int ENGLISH_UPCASE_OFFSET_TOP = 90;
        Scanner in = new Scanner(System.in);
        //Ввод базы смещения.
        int N = Integer.parseInt(in.nextLine());

        String s = in.nextLine();

        StringBuilder res = new StringBuilder();
        for (char oldChar : s.toCharArray()) {
            int charcode = oldChar;
            int newcharcode = charcode - N;
            if (newcharcode < ENGLISH_UPCASE_OFFSET_BOTTOM)
            {
                newcharcode = ENGLISH_UPCASE_OFFSET_TOP + newcharcode - ENGLISH_UPCASE_OFFSET_BOTTOM +1;
            }
            else if (Character.isLowerCase(oldChar) && newcharcode < ENGLISH_LOWCASE_OFFSET_BOTTOM ) {
                newcharcode = ENGLISH_LOWCASE_OFFSET_TOP + newcharcode - ENGLISH_LOWCASE_OFFSET_TOP +1;
            }
            res.append((char) newcharcode);

        }
        System.out.println(res);
    }
}
