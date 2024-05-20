package huffman;

import java.io.IOException;
import java.util.*;

public class Encoder {
    //Стек наполняемый pX командами
    static LinkedList<Character> stack = new LinkedList<>();
    //Дерево используемое для перевода
    static TreeMap<Character, Integer> huffmanMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //Ввод числа команд.
        int N = in.nextInt();
        //N раз подряд в зависимости от команды вызывается операция.
        for (int i = 0; i < N+1; i++) {

            String input = in.nextLine();
            //Операция Push
            if (input.startsWith("p")) {
                stack.add(input.charAt(1));
            }
            //Операция Combine
            if (input.equals("C")) {
                //Первый эл-т всегда имеет код 0
                if(huffmanMap.isEmpty()){
                    huffmanMap.put(stack.getFirst(), 0);
                    stack.removeFirst();
                }

                combine(huffmanMap.lastEntry().getValue());
            }
        }
        System.out.println(transform(in.nextLine()));
    }

    private static void combine(int lastCode) {
        //Если мы не в последней ноде
        if (stack.size() >= 2) {
            System.out.println(stack);
            int nodeName = lastCode + 1;
            int elementCode = nodeName * 10;
            huffmanMap.put(stack.getFirst(), elementCode);
            stack.removeFirst();
        } else
        //Если мы в последней ноде
        if (stack.size() == 1){
            huffmanMap.put(stack.getFirst(), lastCode+1);
            stack.removeFirst();
        }
        System.out.println(huffmanMap);
    }

    private static String transform(String s) {
        StringBuilder res = new StringBuilder();
        for (char ch : s.toCharArray()) {
            res.append(huffmanMap.get(ch));
        }
        return res.toString();
    }
}
