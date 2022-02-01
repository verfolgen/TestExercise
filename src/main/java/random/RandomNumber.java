package random;

import java.util.*;

public class RandomNumber {
    private static HashSet <Integer> numbers;

    //метод для генерации случайного числа
    public static HashSet <Integer> getRandomNumber() {
        numbers = new HashSet<>();
        Random random = new Random();

        do{
            numbers.add(random.nextInt(10));
        } while (numbers.size() != 4);
        return  numbers;
    }
}
