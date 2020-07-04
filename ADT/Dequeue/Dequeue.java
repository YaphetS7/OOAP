// ADT Dequeue на основе концепции:
public abstract class ADT_Dequeue<T>  {

    // конструктор
    // постусловие: создана пустая двусторонняя очередь
    public abstract ADT_Dequeue<T> ADT_Dequeue();

    // ------------------
    // запросы:
    // ------------------

    // предусловие: очередь не пуста
    public abstract T peekLast();

    public abstract int size();

    // предусловие: очередь не пуста
    public abstract T peekFirst();

    // ------------------
    // команды:
    // ------------------

    // предусловие: очередь не пуста
    // постуловие: хвостовой элемент удален
    public abstract void removeLast();

    // постусловие: новый элемент добавлен в голову
    public abstract void addFirst(T value);

    // предусловие: очередь не пуста
    // постуловие: головной элемент удален
    public abstract void removeFirst();

    // постусловие: новый элемент добавлен в хвост
    public abstract void addLast(T value);

    // постусловие: очередь очищена
    public abstract void clear();


    // ------------------
    // дополнительные запросы:
    // ------------------

    public abstract int get_removeLast_status();
    public abstract int get_peekLast_status();
    public abstract int get_removeFirst_status();
    public abstract int get_peekFirst_status();
}

// реализация ADT Dequeue на основе концепции:
public class Dequeue<T> {

    public static final int REMOVEFIRST_NIL = 0; // команда removeFirst() не вызывалась
    public static final int REMOVEFIRST_OK = 1; // последняя команда removeFirst() отработала успешно
    public static final int REMOVEFIRST_ERR = 3; // список пуст

    public static final int REMOVELAST_NIL = 0; // команда removeLast() не вызывалась
    public static final int REMOVELAST_OK = 1; // последняя команда removeLast() отработала успешно
    public static final int REMOVELAST_ERR = 3; // список пуст

    public static final int PEEKFIRST_NIL = 0; // команда peekFirst() не вызывалась
    public static final int PEEKFIRST_OK = 1; // последняя команда peekFirst() отработала успешно
    public static final int PEEKFIRST_ERR = 3; // список пуст

    public static final int PEEKLAST_NIL = 0; // команда peekLast() не вызывалась
    public static final int PEEKLAST_OK = 1; // последняя команда peekLast() отработала успешно
    public static final int PEEKLAST_ERR = 3; // список пуст


    public Dequeue(){
        clear();
    }

    private int length;
    private Node<T> head;
    private Node<T> tail;

    private int removeFirst_status;
    private int removeLast_status;
    private int peekFirst_status;
    private int peekLast_status;


    public int size() {
        return length;
    }

    public T peekFirst() {
        T value;
        if (length > 0){
            value = head.value;

            peekFirst_status = PEEKFIRST_OK;
        }
        else{
            value = null;
            peekFirst_status = PEEKFIRST_ERR;
        }
        return value;
    }

    public T peekLast() {
        T value;
        if (length > 0){
            value = tail.value;

            peekLast_status = PEEKLAST_OK;
        }
        else{
            value = null;
            peekLast_status = PEEKLAST_ERR;
        }
        return value;
    }

    public void removeFirst() {
        if (length > 0){
            head = head.next;
            head.prev = null;

            length --;
            removeFirst_status = REMOVEFIRST_OK;
        }
        else{
            removeFirst_status = REMOVEFIRST_ERR;
        }

    }

    public void removeLast() {
        if (length > 0){
            tail = tail.prev;
            head.next = null;

            length --;
            removeLast_status = REMOVELAST_OK;
        }
        else{
            removeLast_status = REMOVELAST_ERR;
        }
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node(value);

        if (length == 0){
            init(newNode);
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        length ++;
    }

    private void init(Node<T> node){
        head = node;
        tail = node;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node(value);

        if(length == 0){
            init(newNode);
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        length ++;
    }

    public void clear(){
        length = 0;
        head = null;
        tail = null;

        peekFirst_status = PEEKFIRST_NIL;
        peekLast_status = PEEKLAST_NIL;

        removeFirst_status = REMOVEFIRST_NIL;
        removeLast_status = REMOVELAST_NIL;
    }

    public int get_removeLast_status(){
        return removeLast_status;
    }

    public int get_removeFirst_status(){
        return removeFirst_status;
    }

    public int get_peekFirst_status(){
        return peekFirst_status;
    }

    public int get_peekLast_status(){
        return peekLast_status;
    }


    protected class Node<T>{
        public Node<T> prev;
        public Node<T> next;
        public T value;

        public Node(T value){
            this.value = value;
        }
    }
}

// ADT Queue в иерархии:
public abstract class ADT_Queue<T> {

    // конструктор
    // постусловие: создана пустая двусторонняя очередь
    public abstract ADT_Queue<T> ADT_Queue();

    // ------------------
    // запросы:
    // ------------------

    public abstract int size();

    // предусловие: очередь не пуста
    public abstract T peekFirst();

    // ------------------
    // команды:
    // ------------------

    // предусловие: очередь не пуста
    // постуловие: головной элемент удален
    public abstract void removeFirst();

    // постусловие: новый элемент добавлен в хвост
    public abstract void addLast(T value);

    // постусловие: очередь очищена
    public abstract void clear();

    // ------------------
    // дополнительные запросы:
    // ------------------

    public abstract int get_removeFirst_status();
    public abstract int get_peekFirst_status();

}

// ADT Dequeue в иерархии:
public abstract class ADT_Dequeue<T> extends ADT_Queue<T> {

    // конструктор
    // постусловие: создана пустая двусторонняя очередь
    public abstract ADT_Dequeue<T> ADT_Dequeue();

    // ------------------
    // запросы:
    // ------------------

    // предусловие: очередь не пуста
    public abstract T peekLast();

    // ------------------
    // команды:
    // ------------------

    // предусловие: очередь не пуста
    // постуловие: хвостовой элемент удален
    public abstract void removeLast();

    // постусловие: новый элемент добавлен в голову
    public abstract void addFirst(T value);


    // ------------------
    // дополнительные запросы:
    // ------------------

    public abstract int get_removeLast_status();
    public abstract int get_peekLast_status();


}


// реализация ADT Queue в иерархии
public class Queue<T> {
    public static final int REMOVEFIRST_NIL = 0; // команда removeFirst() не вызывалась
    public static final int REMOVEFIRST_OK = 1; // последняя команда removeFirst() отработала успешно
    public static final int REMOVEFIRST_ERR = 3; // список пуст

    public static final int PEEKFIRST_NIL = 0; // команда peekFirst() не вызывалась
    public static final int PEEKFIRST_OK = 1; // последняя команда peekFirst() отработала успешно
    public static final int PEEKFIRST_ERR = 3; // список пуст


    public Queue(){
        clear();
    }

    protected int length;
    protected Node<T> head;
    protected Node<T> tail;

    private int removeFirst_status;
    private int peekFirst_status;


    public int size() {
        return length;
    }

    public T peekFirst() {
        T value;
        if (length > 0){
            value = head.value;

            peekFirst_status = PEEKFIRST_OK;
        }
        else{
            value = null;
            peekFirst_status = PEEKFIRST_ERR;
        }
        return value;
    }

    public void removeFirst() {
        if (length > 0){
            head = head.next;
            head.prev = null;

            length --;
            removeFirst_status = REMOVEFIRST_OK;
        }
        else{
            removeFirst_status = REMOVEFIRST_ERR;
        }

    }

    public void addLast(T value) {
        Node<T> newNode = new Node(value);

        if(length == 0){
            init(newNode);
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        length ++;
    }

    protected void init(Node<T> node){
        head = node;
        tail = node;
    }

    public void clear(){
        length = 0;
        head = null;
        tail = null;

        peekFirst_status = PEEKFIRST_NIL;

        removeFirst_status = REMOVEFIRST_NIL;
    }

    public int get_removeFirst_status(){
        return removeFirst_status;
    }

    public int get_peekFirst_status(){
        return peekFirst_status;
    }

    protected class Node<T>{
        public Node<T> prev;
        public Node<T> next;
        public T value;

        public Node(T value){
            this.value = value;
        }
    }

}

// реализация ADT Dequeue в иерархии на основе класса Queue:
public class Dequeue2<T> extends Queue<T>{

    public static final int REMOVELAST_NIL = 0; // команда removeLast() не вызывалась
    public static final int REMOVELAST_OK = 1; // последняя команда removeLast() отработала успешно
    public static final int REMOVELAST_ERR = 3; // список пуст

    public static final int PEEKLAST_NIL = 0; // команда peekLast() не вызывалась
    public static final int PEEKLAST_OK = 1; // последняя команда peekLast() отработала успешно
    public static final int PEEKLAST_ERR = 3; // список пуст

    private int removeLast_status;
    private int peekLast_status;


    public T peekLast() {
        T value;
        if (length > 0){
            value = tail.value;

            peekLast_status = PEEKLAST_OK;
        }
        else{
            value = null;
            peekLast_status = PEEKLAST_ERR;
        }
        return value;
    }


    public void addLast(T value) {
        Node<T> newNode = new Node(value);

        if(length == 0){
            init(newNode);
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        length ++;
    }

    public void clear(){
        super.clear();

        removeLast_status = REMOVELAST_NIL;
        peekLast_status = PEEKLAST_NIL;
    }

    public int get_removeLast_status(){
        return removeLast_status;
    }

    public int get_peekLast_status(){
        return peekLast_status;
    }

}


