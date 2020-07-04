// АТД Queue:
public abstract class ADT_Queue<T> {

    // конструктор
    // постусловие: создана пустая очередь
    public abstract ADT_Queue<T> ADT_Queue();

    // ------------------
    // запросы:
    // ------------------

    // предусловие: очередь не пуста
    public abstract T peek();

    public abstract int size();


    // ------------------
    // команды:
    // ------------------

    // постусловие: в конец очереди добавлен новый элемент
    public abstract void enqueue(T value);

    // предусловие: очередь не пуста
    // постусловие: из очереди удален первый элемент
    public abstract void dequeue();

    // постусловие: из очереди удалены все элементы
    public abstract void clear();


    // ------------------
    // дополнительные запросы:
    // ------------------

    public abstract int get_peek_status();
    public abstract int get_dequeue_status();
}




// реализация АТД Queue:
public class Queue<T>{

    public final static int PEEL_NIL = 0;
    public final static int PEEK_OK = 1;
    public final static int PEEK_ERR = 2;

    public final static int DEQUEUE_NIL = 0;
    public final static int DEQUEUE_OK = 1;
    public final static int DEQUEUE_ERR = 2;

    private int peek_status;
    private int dequeue_status;
    private int length;

    protected Node<T> head; // начало очереди
    protected Node<T> tail; // конец очереди

    public T peek() {
        T value;
        if (length > 0){
            value = head.value;
            peek_status = PEEK_OK;
        }
        else{
            value = null;
            peek_status = PEEK_ERR;
        }
        return value;
    }

    public int size() {
        return length;
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node(value);
        if (size() == 0){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        length ++;
    }

    public void dequeue() {
        if(size() > 0){
            if(size() == 1){
                head = null;
                tail = null;
            }
            else{
                head = head.next;
            }
            dequeue_status = DEQUEUE_OK;
            length --;
        }
        else{
            dequeue_status = DEQUEUE_ERR;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        length = 0;

        peek_status = PEEL_NIL;
        dequeue_status = DEQUEUE_NIL;
    }

    public int get_peek_status() {
        return peek_status;
    }

    public int get_dequeue_status() {
        return dequeue_status;
    }

    protected class Node<T>{
        public Node<T> next;
        public T value;

        public Node(T value){
            this.value = value;
        }
    }
}
