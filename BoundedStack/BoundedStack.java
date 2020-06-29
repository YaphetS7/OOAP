// Specification

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








// Implementation

import java.util.LinkedList;

public class BoundedStack<T> {

    // скрытые поля
    private LinkedList<T> stack; // основное хранилище стека
    private int peek_status = 0; // статус запроса peek()
    private int pop_status = 0; // статус команды pop()
    private int push_status = 0; // статус команды push()
    private int capacity; // максимальная глубина стека

    public static final int PUSH_NIL = 0; // push() ещё не вызывалась
    public static final int PUSH_OK = 1; // последняя push() отработала нормально
    public static final int PUSH_ERR = 2; // стек переполнен

    public static final int POP_NIL = 0; // pop() ещё не вызывалась
    public static final int POP_OK = 1; // последняя pop() отработала нормально
    public static final int POP_ERR = 2; // стек пуст

    public static final int PEEK_NIL = 0; // peek() ещё не вызывалась
    public static final int PEEK_OK = 1; // последняя peek() вернула корректное значение
    public static final int PEEK_ERR = 2; // стек пуст

    // конструкторы
    // постусловие: создан новый пустой стек
    public void BoundedStack(int capacity){
        this.capacity = capacity;
        clear();
    }

    public void BoundedStack(){
        BoundedStack(32);
    }

    //--------------------
    // команды:
    //--------------------

    // предусловие: в стеке кол-во элементов строго меньше, чем допустимый размер стека
    // постусловие: в стек добавлено новое значение
    public void push(T value){
        if (size() < capacity) {
            stack.addLast(value);
            push_status = PUSH_OK;
        }
        else {
            push_status = PUSH_ERR;
        }
    }

    // предусловие: стек не пустой;
    // постусловие: из стека удалён верхний элемент
    public void pop(){
        if (size() > 0){
            stack.removeLast();
            pop_status = POP_OK;
        }
        else{
            pop_status = POP_ERR;
        }
    }

    // постусловие: из стека удалятся все значения
    public void clear(){
        stack.clear();

        push_status = PUSH_NIL;
        pop_status = POP_NIL;
        peek_status = PEEK_NIL;
    }

    //--------------------
    // запросы:
    //--------------------

    // предусловие: стек не пустой
    public T peek(){
        T result;

        if (size() > 0){
            result = stack.getLast();
            peek_status = PEEK_OK;
        }
        else{
            result = null;
            peek_status = PEEK_ERR;
        }

        return result;
    }

    public int size(){
        return stack.size();
    }

    //--------------------
    // дополнительные запросы:
    //--------------------

    // возвращает значение POP_*
    public int get_pop_status(){
        return pop_status;
    }

    // возвращает значение PEEK_*
    public int get_peek_status(){
        return peek_status;
    }

    // возвращает значение PUSH_*
    public int get_push_status(){
        return push_status;
    }
}
