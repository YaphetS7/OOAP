import java.util.Hashtable;

// ADT_HashTable:
public abstract class ADT_HashTable<T> {

    // конструктор
    // предусловие: создана пустая хэш-таблица
    public abstract ADT_HashTable ADT_HashTable();

    // ------------------
    // запросы:
    // ------------------

    public abstract boolean get(T value); // true - объект найден в таблице

    public abstract int size();

    // ------------------
    // команды:
    // ------------------

    // постусловие: в таблицу добавлено новое значение
    public abstract void put(T value);

    // предусловие: value лежит в HashTable
    // постусловие: в таблице не должно быть элемента value
    public abstract void remove(T value);

    public abstract void clear();

    // дополнительный запрос:
    public abstract int get_remove_status();

}

// ADT PowerSet на основе ADT HashTable:
public abstract class ADT_PowerSet<T> extends ADT_HashTable{

    public abstract ADT_PowerSet intersection(ADT_PowerSet set2);

    public abstract ADT_PowerSet difference(ADT_PowerSet set2);

    public abstract ADT_PowerSet union(ADT_PowerSet set2);

    public abstract boolean isSubSet(ADT_PowerSet set2);

}

// ADT PowerSet на основе концепции:
public abstract class ADT_PowerSet<T> {

    // конструктор
    // постусловие: создано новое пустое множество
    public abstract ADT_PowerSet ADT__PowerSet();


    // ------------------
    // запросы:
    // ------------------

    public abstract int size();

    public abstract boolean get(T value);

    public abstract ADT_PowerSet intersection(ADT_PowerSet set2);

    public abstract ADT_PowerSet union(ADT_PowerSet set2);

    public abstract ADT_PowerSet difference(ADT_PowerSet set2);

    public abstract boolean isSubSet(ADT_PowerSet set2);


    // ------------------
    // команды:
    // ------------------

    public abstract void clear();

    // постусловие: элемент добавлен в множество
    public abstract void put(T value);

    // предусловие: элемент должен содержаться в множестве
    // постусловие: элемент удален из множества
    public abstract void remove(T value);



    // ------------------
    // дополнительные запросы:
    // ------------------

    public abstract int get_remove_status();

}

// реализация ADT PowerSet(того, который на основе концепции):
import java.util.Hashtable;

public class PowerSet<T>  {

    public static final int REMOVE_NIL = 0;
    public static final int REMOVE_OK = 1;
    public static final int REMOVE_ERR = 2;

    private Hashtable<String, T> ht;
    private int remove_status;


    public PowerSet(){
        clear();
    }

    public int size() {
        return ht.size();
    }


    public boolean get(T value) {
        String key = value.toString();
        return (ht.containsKey(key));
    }


    public PowerSet intersection(PowerSet set2) {
        PowerSet<T> set = new PowerSet<>();

        for (String key: ht.keySet()) {
            T value = ht.get(key);

            if (!set2.get(value))
                set.put(ht.get(key));
        }

        return set;
    }


    public PowerSet union(PowerSet set2) {
        PowerSet<T> set = new PowerSet<>();

        for (String key: ht.keySet()) {
            T value = ht.get(key);
            set.put(value);
        }

        for (Object key: set2.ht.keySet()) {

            key = key.toString();

            T value = (T)set2.ht.get(key);

            set.put(value);
        }

        return set;
    }


    public PowerSet difference(PowerSet set2) {
        PowerSet<T> set = new PowerSet<>();

        for (String key: ht.keySet()) {
            T value = ht.get(key);
            set.put(ht.get(key));
        }

        for (Object key: set2.ht.keySet()) {

            key = key.toString();

            T value = (T)set2.ht.get(key);

            if(set2.get(value)) {
                set.remove(value);
            }
        }

        return set;
    }

    public boolean isSubSet(PowerSet set2) {
        boolean isSubSet = true;

        for (String key: ht.keySet()) {
            T value = ht.get(key);
            isSubSet = isSubSet && (set2.get(value));
        }

        return isSubSet;
    }


    public void clear() {
        remove_status = REMOVE_NIL;
        ht = new Hashtable<>();
    }


    public void put(T value) {
        String key = value.toString();

        ht.put(key, value);
    }


    public void remove(T value) {
        if(get(value)){
            String key = value.toString();

            ht.remove(key);

            remove_status = REMOVE_OK;
        }
        else{
            remove_status = REMOVE_ERR;
        }
    }


    public int get_remove_status() {
        return remove_status;
    }
}


