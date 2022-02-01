package trystorage;



import java.util.List;

//временное хранилище для попыток
public interface TryRepository {

    //метод, который выводит список попыток
    List <String> findAll();

    //метод, который сохраняет попытку
    void save(String t);

    //метод, который очищает коллекцию
    void deleteTry(List <String> tryObjectList);
}
