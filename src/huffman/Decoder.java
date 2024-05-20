package huffman;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class Decoder {
    //Стек наполняемый push командами
    static LinkedList<Character> stack = new LinkedList<>();
    //Дерево Хаффмана
    static TreeMap<Integer, Character> huffmanMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //Ввод числа команд.
        int N = in.nextInt();
        //N раз подряд в зависимости от команды вызывается операция.
        for (int i = 0; i < N + 1; i++) {

            String input = in.nextLine();
            //Операция Push
            if (input.startsWith("p")) {
                stack.add(input.charAt(1));
            }
            //Операция Combine
            if (input.equals("C")) {
                //Первый эл-т всегда имеет код 0
                if (huffmanMap.isEmpty()) {
                    huffmanMap.put(0, stack.getFirst());
                    stack.removeFirst();
                }

                combine(huffmanMap.lastEntry().getKey());
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
            huffmanMap.put(elementCode, stack.getFirst());
            stack.removeFirst();
        } else
            //Если мы в последней ноде
            if (stack.size() == 1) {
                huffmanMap.put(lastCode + 1, stack.getFirst());
                stack.removeFirst();
            }
        System.out.println(huffmanMap);
    }

    private static String transform(String s) {
        StringBuilder res = new StringBuilder();
        //Имя ноды - стек собирающийся в имя ключа
        int nodeName = 0;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                //Все ключи кроме последнего оканчиваются на 0.
                //Значит при приходе 0 надо забирать значение
                case '0': {
                    res.append(huffmanMap.get(nodeName));
                    nodeName = 0;
                    break;
                }
                case '1': {
                    //Если пришла 1 - значит это либо последний лист дерева, либо начало следующего узла
                    nodeName++;
                    //Если это последний лист - выводим его и сбрасывем стек с ключом.
                    if (nodeName == huffmanMap.lastKey()) {
                        res.append(huffmanMap.lastEntry().getValue());
                        nodeName = 0;
                    } else
                    //Если это не последний лист - добавляем к стеку 0 и идем искать в след ноду - в след итерации.
                    {
                    nodeName*=10;
                    }
                    break;
                }
            }
            System.out.println("temp " + res);
            System.out.println("nodename " + nodeName);
        }
        return res.toString();
    }
}
