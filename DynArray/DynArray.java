
// АТД DynArray
public abstract class DynArray<T> {


    // конструктор
    // постусловие: создан пустой динамический массив
    //public abstract DynArray<T> DynArray();

    // ------------------
    // запросы:
    // ------------------

    public abstract int size(); // возвращает текущее кол-во элементов в динамическом массиве

    public abstract int get_capacity(); // возвращает текущую емкость динамического массива

    // предусловие: индекс должен находиться в допустимом диапазоне 0 <= i < size()
    public abstract T getItem(int i); // возвращает объект под i-м индексом

    // ------------------
    // команды:
    // ------------------

    // предусловие: индекс должен находиться в допустимом диапазоне 0 <= i < size()
    // постусловие: value должно быть добавлено в i-ю позицию,
    // а все идущие следом элементы должны быть сдвинуты вправо
    public abstract void insert(T value, int i);

    // предусловие: индекс должен находиться в допустимом диапазоне 0 <= i < size()
    // постусловия: объект под i-м индексом должен быть удален;
    // все элементы, стоящие правее i-го, должны быть сдвинуты влево
    public abstract void remove(int i);

    // постусловие: объект value должен быть добавлен в конец "рабочего" массива
    public abstract void append(T value);

    // постусловие: массив очищен
    public abstract void clear();

    // постусловия: буфер должен изменить свой размер;
    // данные должны быть верно перенесены из "старого" массива в "новый"
    // public abstract void makeArray(int newCapacity);


    // ------------------
    // дополнительные запросы:
    // ------------------

    public abstract int get_remove_status();
    public abstract int get_insert_status();
    public abstract int get_getItem_status();

}

// Реализация АТД DynArray

public class DynArray<T> {

    public static final int INSERT_NIL = 0; // insert(val, i) ещё не вызывалась
    public static final int INSERT_OK = 1; // последняя insert(val, i) отработала нормально
    public static final int INSERT_ERR = 2; // неверное значение для i

    public static final int REMOVE_NIL = 0; // remove(i) ещё не вызывалась
    public static final int REMOVE_OK = 1; // последняя insert(i) отработала нормально
    public static final int REMOVE_ERR = 2; // неверное значение для i

    public static final int GETITEM_NIL = 0; // getItem(i) ещё не вызывался
    public static final int GETITEM_OK = 1; // запрос getItem(i) отработал нормально
    public static final int GETITEM_ERR = 2; // неверное значение для i

    private int capacity;
    private int count;
    private T[] arr;
    private int insert_status;
    private int remove_status;
    private int getItem_status;

    public DynArray(){
        clear();
    }

    public int size() {
        return count;
    }

    public int get_capacity() {
        return capacity;
    }

    public T getItem(int i) {

        T value;

        if (i >= 0 && i < size()){
            value = arr[i];
            getItem_status = GETITEM_OK;
        }
        else{
            value = null;
            getItem_status = GETITEM_ERR;
        }

        return value;
    }

    public void insert(T value, int i) {
        if (i >= 0 && i < size()){
            if (size() == capacity){
                makeArray(capacity * 2);
            }

            for (int j = size(); j > i; j--){
                arr[j] = arr[j - 1];
            }
            arr[i] = value;

            count ++;

            insert_status = INSERT_OK;
        }
        else{
            insert_status = INSERT_ERR;
        }
    }

    public void remove(int i) {
        if (i >= 0 && i < size()){

            for (int j = i; j < size(); j++)
                arr[j] = arr[j + 1];

            count --;

            if((capacity / count) < 2) {
                makeArray((int) (capacity / 1.5));
            }

            remove_status = REMOVE_OK;
        }
        else{
            remove_status = REMOVE_ERR;
        }
    }

    public void clear(){
        insert_status = INSERT_NIL;
        remove_status = REMOVE_NIL;
        getItem_status = GETITEM_NIL;

        capacity = 16;
        count = 0;

        arr = (T[])new Object[capacity];
    }

    public void append(T value) {
        if (size() == capacity){
            makeArray(capacity * 2);
        }

        arr[size()] = value;
        count ++;
    }

    private void makeArray(int newCapacity){
        T[] buffer = arr.clone();
        arr = (T[])new Object[newCapacity];

        for (T item: buffer) {
            append(item);
        }
    }

    public int get_remove_status() {
        return remove_status;
    }

    public int get_insert_status() {
        return insert_status;
    }

    public int get_getItem_status() {
        return getItem_status;
    }
}
