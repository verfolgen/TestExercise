package validation;

//класс для валидации данных
public class ValidationData {

    //проверка на количество данных и качество данных
    public static boolean validation(String requestForm) {
        boolean  condition = true;

        if(requestForm.length() != 4) {
            condition = false;
        }

        try {
            Integer.parseInt(requestForm);
        } catch (NumberFormatException e) {
            condition = false;
        }
        return condition;
    }
}
