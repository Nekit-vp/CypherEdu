package com.example.cypheredu.encryption.caesar;

import com.example.cypheredu.encryption.Encryption;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CodeOfCaesar implements Encryption {
//    public static void main(String[] args) throws IOException {
//
//        String text;
//        int step;
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("Шифр Цезаря //латинский алфавит\n");
//
//        int act = 3;
//
//        while (act != 0){
//
//            System.out.println("Что необходимо сделать: \n2...Шифрование\n1...Расшифрование\n0...Завершить");
//            act = Integer.parseInt(reader.readLine());
//
//            if (act == 2) {
//                System.out.print("Введите текст для шифрования: ");
//                text = reader.readLine();
//                System.out.print("Введите шаг шифрования: ");
//                step = Integer.parseInt(reader.readLine()) % 26;
//                System.out.println("Текст зашифрован: " + encrypt(text, step) + "\n");
//            }else if (act == 1){
//                System.out.print("Введите текст для расшифрования: ");
//                text = reader.readLine();
//                System.out.print("Введите ключ шифрования: ");
//                step = Integer.parseInt(reader.readLine()) % 26;
//                System.out.println("Текст расшифрован: " + decrypt(text, step) + "\n");
//            }
//        }
//    }

    @Override
    public String encrypt(String text, int delta){

        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (checkLowerCase(text.charAt(i)))
                newStr.append((char) (((((int) text.charAt(i) - (int) 'a')) + delta) % 26 + (int) 'a'));
            else
            if (checkHighCase(text.charAt(i)))
                newStr.append((char) (((((int) text.charAt(i) - (int) 'A')) + delta) % 26 + (int) 'A'));
            else
                newStr.append(text.charAt(i));
        }
        return newStr.toString();
    }

    @Override
    public String decrypt(String text, int delta){

        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (checkLowerCase(text.charAt(i)))
                newStr.append((char) (((((int) text.charAt(i) - (int) 'a')) - delta + 26) % 26 + (int) 'a'));
            else
            if (checkHighCase(text.charAt(i)))
                newStr.append((char) (((((int) text.charAt(i) - (int) 'A')) - delta + 26) % 26 + (int) 'A'));
            else
                newStr.append(text.charAt(i));
        }

        return newStr.toString();
    }

    private static boolean checkLowerCase (Character character){
        return ((int) character >= (int) 'a') && ((int) character <= (int) 'z');
    }

    private static boolean checkHighCase (Character character){
        return ((int) character >= (int) 'A') && ((int) character <= (int) 'Z');
    }
}
