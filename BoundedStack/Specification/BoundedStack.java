package Specification;

public abstract class BoundedStack<T> {

    public static final int PUSH_NIL = 0; // push() ещё не вызывалась
    public static final int PUSH_OK = 1; // последняя push() отработала нормально
    public static final int PUSH_ERR = 2; // стек переполнен

    public static final int POP_NIL = 0; // pop() ещё не вызывалась
    public static final int POP_OK = 1; // последняя pop() отработала нормально
    public static final int POP_ERR = 2; // стек пуст

    public static final int PEEK_NIL = 0; // peek() ещё не вызывалась
    public static final int PEEK_OK = 1; // последняя peek() вернула корректное значение
    public static final int PEEK_ERR = 2; // стек пуст

    // конструктор
    public abstract BoundedStack<T> Stack(int capacity); // постусловие: создан новый пустой стек

    //--------------------
    // команды:
    //--------------------

    // предусловие: в стеке кол-во элементов строго меньше, чем допустимый размер стека
    // постусловие: в стек добавлено новое значение
    public abstract void push(T value);

    // предусловие: стек не пустой;
    // постусловие: из стека удалён верхний элемент
    public abstract void pop();

    // постусловие: из стека удалятся все значения
    public abstract void clear();

    //--------------------
    // запросы:
    //--------------------

    // предусловие: стек не пустой
    public abstract T peek();

    public abstract int size();

    //--------------------
    // дополнительные запросы:
    //--------------------

    public abstract int get_pop_status(); // возвращает значение POP_*
    public abstract int get_peek_status(); // возвращает значение PEEK_*
    public abstract int get_push_status(); // возвращает значение PUSH_*
}
