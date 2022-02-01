package logic;

import random.RandomNumber;

import java.sql.Array;
import java.util.*;

//класс для проверки ответа
public class ExaminationLogic {
    private static Object[] list1Array;
    private static Object[] list2Array;


    public static String examineLogic(HashSet <Integer> list1, ArrayList <Integer> list2) {
        //счетчик игры
        int b = 0;
        int k = 0;

        String result = "";

        //переводим в массив чтобы был доступ и к порядковому номеру и к значению
        list1Array = list1.toArray();

        list2Array = list2.toArray();

        for (int i = 0; i < list1Array.length; i++) {
            if (list1Array[i] == list2Array[i]) {
                    b++;
                }

            for (int j = 0; j < list2Array.length; j++) {
                if (list1Array[i] == list2Array[j] && i != j) {
                        k++;
                    }
                }
            }
             result = b + "Б" + k + "К";

            //условие выхода из цикла
            if (b == 4 & k == 0) {
                System.out.println("Успешно!");
            }
            //обнуляем переменные перед следующим проходом
            b = 0;
            k = 0;

            //очищаем коллекуию перед следующим проходом
            list2.clear();

        return result;
    }
}


