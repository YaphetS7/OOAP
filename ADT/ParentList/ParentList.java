// АТД ParentList:
public abstract class ParentList<T> {

    // конструктор
    // постусловие: создан пустой список
    // public abstract ParentList<T> LinkedList();

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

    // предусловие: список не пуст
    // постусловие: следом за текущим узлом добавлен новый узел с заданным значением
    public abstract void put_right(T value);

    // предусловие: список не пуст
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

    // постусловие: курсор установлен на следующий узел с искомым значением (по отношению к текущему узлу)
    public abstract void find(T value);

    // постусловие: в списке удалены все узлы с заданным значением
    public abstract void remove_all(T value); // удалить в списке все узлы с заданным значением



    // ------------------
    // дополнительные запросы:
    // ------------------

    public abstract int get_remove_status(); // возвращает значение REMOVE_*
    public abstract int get_replace_status(); // возвращает значение REPLACE_*
    public abstract int get_right_status(); // возвращает значение RIGHT_*
    public abstract int get_tail_status(); // возвращает значение TAIL_*
    public abstract int get_head_status(); // возвращает значение HEAD_*
    public abstract int get_put_left_status(); // возвращает значение PUT_LEFT_*
    public abstract int get_put_right_status(); // возвращает значение PUT_LEFT_*

}

// АТД TwoWayList:

public abstract class TwoWayList<T> extends ParentList<T> {

    // конструктор
    // постусловие: создан новый объект
    // public abstract TwoWayList<T> TwoWayList();

    // предусловия: список не пустой, слева имеется узел
    // постусловие: курсор сдвинут на один узел влево
    public abstract void left();
}

// Реализация LinkedList (тоже, что и реализация АТД ParentList):

public class LinkedList<T> extends ParentList<T> {

    // *_NIL - команда * еще не вызывалась
    // *_OK - команда * отбработала нормально
    // *_ERR... - команда * отработала с ошибкой

    public final static int REMOVE_NIL = 0;
    public final static int REMOVE_OK = 1;
    public final static int REMOVE_ERR = 2;

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

    public final static int PUT_LEFT_NIL = 0;
    public final static int PUT_LEFT_OK = 1;
    public final static int PUT_LEFT_ERR = 2;

    public final static int PUT_RIGHT_NIL = 0;
    public final static int PUT_RIGHT_OK = 1;
    public final static int PUT_RIGHT_ERR = 2;

    private int head_status;
    private int tail_status;
    private int right_status;
    private int replace_status;
    private int remove_status;
    private int put_right_status;
    private int put_left_status;

    private int length;

    private Node head;
    private Node tail;

    public Node<T> cursor;

    public LinkedList(){
        clear();
    }

    @Override
    public T get() {
        return cursor.value;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean is_head() {
        return (cursor == head);
    }

    @Override
    public boolean is_tail() {
        return (cursor == tail);
    }

    @Override
    public boolean is_value() {
        return (size() > 0);
    }

    @Override
    public void head() {
        if (size() > 0){
            cursor = head;
            head_status = HEAD_OK;
        }
        else{
            head_status = HEAD_ERR;
        }
    }

    @Override
    public void tail() {
        if (size() > 0){
            cursor = tail;
            tail_status = TAIL_OK;
        }
        else{
            tail_status = TAIL_ERR;
        }
    }

    @Override
    public void right() {
        if (size() > 0){
            if(cursor.right == null){
                right_status = RIGHT_ERR1;
            }
            else{
                cursor = cursor.right;
                right_status = RIGHT_OK;
            }
        }
        else{
            right_status = RIGHT_ERR0;
        }
    }

    @Override
    public void put_right(T value) {
        if (size() > 0){
            if (cursor == tail){
                add_tail(value);
            }
            else{
                Node newNode = new Node(value);

                Node right = cursor.right;
                right.left = newNode;
                newNode.right = right;

                newNode.left = cursor;
                cursor.right = newNode;

                length ++;
            }

            put_right_status = PUT_RIGHT_OK;

        }
        else{
            put_right_status = PUT_RIGHT_ERR;
        }
    }

    @Override
    public void put_left(T value) {
        if (size() > 0){
            Node newNode = new Node(value);

            if (cursor == head){
                head = newNode;
                head.right = cursor.right;
                head.right.left = cursor;
            }
            else {
                Node left = cursor.left;
                left.right = newNode;
                newNode.left = left;

                newNode.right = cursor;
                cursor.left = newNode;
            }

            put_left_status = PUT_LEFT_OK;
            length ++;

        }
        else {
            put_left_status = PUT_LEFT_ERR;
        }
    }

    @Override
    public void remove() {
        if (size() > 0){
            if (cursor == tail){
                tail = cursor.left;
                cursor = tail;
            }
            else
            if (cursor == head){
                head = head.right;
                cursor = head;
            }
            else{
                Node temp = cursor.left;
                temp.right = cursor.right;
                cursor = cursor.right;
            }

            remove_status = REMOVE_OK;
            length --;
        }
        else{
            remove_status = REMOVE_ERR;
        }
    }

    @Override
    public void clear() {
        length = 0;

        head_status = HEAD_NIL;
        tail_status = TAIL_NIL;
        right_status = RIGHT_NIL;
        replace_status = REPLACE_NIL;
        remove_status = REMOVE_NIL;
        put_left_status = PUT_LEFT_NIL;
        put_right_status = PUT_RIGHT_NIL;

        head = null;
        tail = null;
    }

    @Override
    public void add_tail(T value) {
        Node temp = cursor;

        tail();

        Node newNode = new Node(value);

        cursor.right = newNode;
        newNode.left = cursor;

        cursor = temp;

        length ++;
    }

    @Override
    public void replace(T value) {
        if (size() > 0) {
            cursor.value = value;
            replace_status = REPLACE_OK;
        }
        else {
            replace_status = REPLACE_ERR;
        }
    }

    @Override
    public void find(T value) {
        head();
        while (cursor.value != value) {
            right();
        }

    }

    @Override
    public void remove_all(T value) {
        Node temp = cursor;

        head();

        while(cursor != null){
            cursor = cursor.right;
            if (cursor.value == value){
                deleteNode(cursor);
            }
        }

        cursor = temp;

    }

    private void deleteNode(Node<T> node){
        boolean deleted = false;
        Node left = node.left;
        Node right = node.right;

        if(left == null){
            head = head.right;
            head.left = null;
            deleted = true;
        }

        if (right == null) {
            tail = tail.left;
            tail.right = null;
            deleted = true;
        }

        if (!deleted){
            left.right = right;
            right.left = left;
        }

        length --;
    }


    @Override
    public int get_remove_status() {
        return remove_status;
    }


    @Override
    public int get_replace_status() {
        return replace_status;
    }

    @Override
    public int get_right_status() {
        return right_status;
    }

    @Override
    public int get_tail_status() {
        return tail_status;
    }

    @Override
    public int get_head_status() {
        return head_status;
    }

    @Override
    public int get_put_right_status(){
        return put_right_status;
    }

    @Override
    public int get_put_left_status(){
        return put_left_status;
    }

}

// реализация АТД TwoWayList

public class LinkedList_next_prev<T> extends LinkedList<T> {

    public final static int LEFT_NIL = 0;
    public final static int LEFT_OK = 1;
    public final static int LEFT_ERR0 = 2;
    public final static int LEFT_ERR1 = 3;

    private int left_status;

    public void left(){

        if (size() > 0){
            if (cursor.left != null) {
                cursor = cursor.left;
            }
            else{
                left_status = LEFT_ERR1;
            }
        }
        else{
            left_status = LEFT_ERR0;
        }
    }


    public void clear(){
        super.clear();
        left_status = LEFT_NIL;
    }

    public int get_left_status(){
        return left_status;
    }

}




