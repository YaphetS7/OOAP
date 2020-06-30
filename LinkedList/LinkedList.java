// ------------------
// 2.1:
// ------------------

public abstract class LinkedList<T> {

    // *_NIL - команда * еще не вызывалась
    // *_OK - команда * отбработала нормально
    // *_ERR... - команда * отработала с ошибкой

    public final static int REMOVE_ALL_NIL = 0;
    public final static int REMOVE_ALL_OK = 1;
    public final static int REMOVE_ALL_ERR = 2;

    public final static int REMOVE_NIL = 0;
    public final static int REMOVE_OK = 1;
    public final static int REMOVE_ERR = 2;

    public final static int FIND_NIL = 0;
    public final static int FIND_OK = 1;
    public final static int FIND_ERR = 2;

    public final static int REPLACE_NIL = 0;
    public final static int REPLACE_OK = 1;
    public final static int REPLACE_ERR = 2;

    public final static int RIGHT_NIL = 0;
    public final static int RIGHT_OK = 1;
    public final static int RIGHT_ERR0 = 2;
    public final static int RIGHT_ERR1 = 3;

    public final static int TAIL_NIL = 0;
    public final static int TAIL_OK = 1;
    public final static int TAIL_ERR = 2;

    public final static int HEAD_NIL = 0;
    public final static int HEAD_OK = 1;
    public final static int HEAD_ERR = 2;


    // конструктор
    // постусловие: создан пустой список
    public abstract LinkedList<T> LinkedList();

    // ------------------
    // запросы:
    // ------------------

    public abstract T get(); // получить значение текущего узла

    public abstract int size(); // посчитать кол-во узлов в списке

    // предусловие: список не пустой
    public abstract boolean is_head(); // находится ли курсор в начале списка?

    // предусловие: список не пустой
    public abstract boolean is_tail(); // находится ли курсор в конце списка?

    public abstract boolean is_value(); // установлен ли курсор на какой-либо узел в списке (по сути, непустой ли список?)


    // ------------------
    // команды:
    // ------------------

    // предусловие: список не пустой
    // постусловие: курсор установлен на первом узле в списке
    public abstract void head();

    // предусловие: список не пустой
    // постусловие: курсор установлен на последнем узле
    public abstract void tail();

    // предусловия: список не пустой, справа имеется узел
    // постусловие: курсор сдвинут на один узел вправо
    public abstract void right();

    // постусловие: следом за текущим узлом добавлен новый узел с заданным значением
    public abstract void put_right(T value);

    // постусловие: перед текущим узлом установлен новый узел с заданным значением
    public abstract void put_left(T value);

    // предусловие: список не пустой
    // постусловие: удален текущий узел
    public abstract void remove(); // удалить текущий узел (курсор смещается к правому соседу, если он есть,
                                    // в противном случае курсор смещается к левому соседу,если он есть)

    // постусловие: список пуст
    public abstract void clear();

    // постусловие: новый узел с заданным значением добавлен в конец списка
    public abstract void add_tail(T value);

    // предусловие: список не пустой
    // постусловие: значение текущего узла заменено на заданное
    public abstract void replace(T value); // заменить значение текущего узла не заданное

    // предусловие: список не пустой
    // постусловие: курсор установлен на следующий узел с искомым значением (по отношению к текущему узлу)
    public abstract void find(T value);

    // предусловие: список не пустой
    // постусловие: в списке удалены все узлы с заданным значением
    public abstract void remove_all(T value); // удалить в списке все узлы с заданным значением



    // ------------------
    // дополнительные запросы:
    // ------------------

    public abstract int get_remove_all_status(); // возвращает значение REMOVE_ALL_*
    public abstract int get_remove_status(); // возвращает значение REMOVE_*
    public abstract int get_find_status(); // возвращает значение FIND_*
    public abstract int get_replace_status(); // возвращает значение REPLACE_*
    public abstract int get_right_status(); // возвращает значение RIGHT_*
    public abstract int get_tail_status(); // возвращает значение TAIL_*
    public abstract int get_head_status(); // возвращает значение HEAD_*

}


// ------------------
// 2.2:
// Если исходить из эффективной реализации, то операция tail() должна выполняться за O(1) (например, можно хранить
// последний узел списка как поле) => tail() не может быть выражена ни через какую(-ие) операцию(-ии),
// чтобы по асимптотике это было О(1).
// Если бы нам была неинтересна эффективная реализация, то мы бы могли за О(n) выразить tail() через right().
// ------------------

// ------------------
// 2.3:
// Операция поиска всех узлов(find_all()) нам уже не нужна, т.к. у нас имеется курсор и find().
// ------------------