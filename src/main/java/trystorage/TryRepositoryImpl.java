package trystorage;



import java.util.List;

//реализация интерфейса
public class TryRepositoryImpl implements TryRepository{

    //возвращение списка попыток
    public List<String> findAll() {
        return TryStorage.storage().tries();
    }

    //сохранение новой попытки в список
    public void save(String t) {
        TryStorage.storage().tries().add(t);
    }

    //очищение списка
    public void deleteTry(List<String> tryObjectList) {
        TryStorage.storage().tries().removeAll(tryObjectList);
    }

}
