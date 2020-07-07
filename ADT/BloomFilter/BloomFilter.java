// ADT BloomFilter:
public abstract class ADT_BloomFilter<T> {

    // конструктор
    // постусловие: создан пустой фильтр Блюма
    public abstract ADT_BloomFilter ADT_BloomFilter(int size);

    // ------------------
    // запросы:
    // ------------------

    public abstract boolean isValue(T value);


    // ------------------
    // команды:
    // ------------------

    // постусловие: в фильтр добавлен новый элемент
    public abstract void add(T value);

    public abstract void clear();

}


// реализация ADT BloomFilter:

import java.util.BitSet;

public class BloomFilter<T> {

    private int capacity;
    private BitSet bits;

    public BloomFilter(int size){
        capacity = size;
        clear();
    }

    private int hash1(String s){
        int x = 17;

        return calcHash(x, s);
    }

    private int hash2(String s){
        int x = 7;

        return calcHash(x, s);
    }

    private int calcHash(int x, String s){
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            sum = (sum + s.charAt(i) * x) % capacity;
            x = (x * x) % capacity;
        }

        return sum;
    }

    public boolean isValue(T value) {
        String str = value.toString();
        int h1 = hash1(str);
        int h2 = hash2(str);

        return (bits.get(h1) && bits.get(h2));
    }


    public void add(T value) {
        String str = value.toString();
        int h1 = hash1(str);
        int h2 = hash2(str);

        bits.set(h1);
        bits.set(h2);
    }

    public void clear(){
        bits = new BitSet(capacity);
    }
}
