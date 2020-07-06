// ADT NativeDictionary:
public abstract class ADT_NativeDictionary<T> {

    // конструктор
    // предусловие: создан пустой словарь размера size
    public abstract ADT_NativeDictionary<T> ADT_NativeDictionary(int size);


    // ------------------
    // запросы:
    // ------------------

    public abstract boolean isKey(String key); // true - если key является ключом

    // предусловие: ключ имеется в словаре
    public abstract T get(String key);



    // ------------------
    // команды:
    // ------------------

    public abstract void clear();

    // постусловие: новый объект добавлен в словарь
    public abstract void put(String key, T value);

    // предусловие: объект с индексом key существует
    // постусловие: объект с индексом key удален
    public abstract void remove(String key);


    // ------------------
    // дополнительные запросы:
    // ------------------

    public abstract int get_remove_status();
    public abstract int get_get_status();
}

// реализация ADT NativeDictionary:
public class NativeDictionary<T>{

    public static final int REMOVE_NIL = 0;
    public static final int REMOVE_OK = 1;
    public static final int REMOVE_ERR = 2;

    public static final int GET_NIL = 0;
    public static final int GET_OK = 1;
    public static final int GET_ERR = 2;

    private int get_status;
    private int remove_status;

    private String[] keys;
    private T[] values;

    private final int step = 7;
    private int capacity;



    public NativeDictionary(int size){
        capacity = size;
        clear();
    }


    private int hashFun(String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++){
            sum += value.charAt(i);
        }
        return sum % capacity;
    }

    private int seekSlot(String value) {
        int i = hashFun(value);

        if (keys[i] != null){

            while(i < capacity && keys[i] != null){
                i += step;
            }

            if (i > capacity){
                i = -1;
            }
        }

        return i;
    }

    public boolean isKey(String key) {
        return (seekSlot(key) >= 0);
    }

    public T get(String key) {

        T res = null;

        int i = seekSlot(key);
        if (i >= 0){
            res = values[i];

            get_status = GET_OK;
        }
        else{
            get_status = GET_ERR;
        }

        return res;
    }

    public void clear() {
        get_status = GET_NIL;
        remove_status = REMOVE_NIL;

        keys = new String[capacity];
        values = (T[])new Object[capacity];

    }

    public void put(String key, T value) {
        int i = seekSlot(key);

        if(i >= 0){
            keys[i] = key;
            values[i] = value;
        }
    }

    public void remove(String key) {
        int i = seekSlot(key);

        if(i >= 0){
            keys[i] = null;
            values[i] = null;

            remove_status = REMOVE_OK;
        }
        else{
            remove_status = REMOVE_ERR;
        }
    }

    public int get_remove_status() {
        return remove_status;
    }

    public int get_get_status() {
        return get_status;
    }
}
