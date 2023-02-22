package stack.p10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] stack;
    static int pointer = -1;
    public static void main(String[] args) throws IOException {
        // 한줄씩 읽어옴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        stack = new int[T + 1];
        List<Integer> list = new ArrayList<>(T + 1);

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int val = -1;
            switch (op) {
                case "push" -> {
                    int inputVal = Integer.parseInt(st.nextToken());
                    pointer++;
                    stack[pointer] = inputVal;
                }
                case "top" -> {
                    val = pointer == -1 ? -1 : stack[pointer];
                    list.add(val);
                }
                case "pop" -> {
                    if (pointer == -1) {
                        val = -1;
                    } else {
                        val = stack[pointer];
                        pointer--;
                    }
                    list.add(val);
                }
                case "size" -> list.add(pointer + 1);
                case "empty" -> {
                    val = pointer == -1 ? 1 : 0;
                    list.add(val);
                }
            }
        }

        list.forEach(System.out::println);
    }

}
