package transformation;

import java.util.ArrayList;
import java.util.Arrays;

//класс для преобразования данных
public class TransformationForm {

    //метод для преобразования вводных данных с формы для корректной обработки
    public static int [] transformationFormData(String resultRequest) {

        //перевод данных из строки в массив чисел
        int[] numArr = Arrays.stream(resultRequest.split("")).
                mapToInt(Integer::parseInt).toArray();
        return numArr;
    }

}
