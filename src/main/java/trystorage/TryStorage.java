package trystorage;

//класс, хранящий все попытки во время непосредственно самой игры


import java.util.ArrayList;
import java.util.List;

//хранилище для временного хранения, реализован как синглтон
public class TryStorage {
    private static final TryStorage storage;

    static {
        storage = new TryStorage();
    }

    public ArrayList<String> tryObjectList;

    private TryStorage () {
        this.tryObjectList = new ArrayList<>();
    }

    public static TryStorage storage () {
        return storage;
    }

    //список попыток
    public ArrayList<String> tries() {
        return tryObjectList;
    }
}
