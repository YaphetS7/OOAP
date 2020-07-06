// ADT_HashTable:
public abstract class ADT_HashTable {

    // конструктор
    // предусловие: создана пустая хэш-таблица
    public abstract ADT_HashTable ADT_HashTable();

    // ------------------
    // запросы:
    // ------------------

    public abstract boolean find(String value); // true - объект найден в таблице


    // ------------------
    // команды:
    // ------------------

    // предусловие: место в таблице для нового значения должно найтись
    // постусловие: в таблицу добавлено новое значение
    public abstract void put(String value);

    // постусловие: в таблице не должно быть элемента value
    public abstract void remove(String value);

    public abstract void clear();

    // дополнительный запрос:
    public abstract int get_put_status();

}


// реализация ADT HashTable
public class HashTable {

    public final static int PUT_NIL = 0;
    public final static int PUT_OK = 1;
    public final static int PUT_ERR0 = 2;

    private String[] arr;

    private final int step = 7;
    private int capacity;

    private int put_status;

    public HashTable(int capacity){
        this.capacity = capacity;
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

        if (arr[i] != null){

            while(i < capacity && arr[i] != null){
                i += step;
            }

            if (i > capacity){
                i = -1;
            }
        }

        return i;
    }

    public boolean find(String value) {
        int i = hashFun(value);

        while(i < capacity && value != arr[i]){
            i += step;
        }

        return (i < capacity);
    }


    public void put(String value) {
        int i = seekSlot(value);
        if (i >= 0){
            arr[i] = value;
            put_status = PUT_OK;
        }
        else{
            put_status = PUT_ERR0;
        }
    }

    public void remove(String value){
        int i = seekSlot(value);

        if (i >= 0){
            arr[i] = null;
        }
    }

    public void clear(){
        arr = new String[capacity];
        put_status = PUT_NIL;
    }


    public int get_put_status() {
        return put_status;
    }
}

