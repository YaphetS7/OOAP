
// Задание 7. Пример динамического связывания

// Пример 1.
public class Animal{
    public void voice(){
        System.out.println("I am an animal");
    }
}

public class Cat extends Animal{

    @Override
    public void voice(){
        System.out.println("I am the cat!");
    }
}

// main:

Animal cat = new Cat();

cat.voice(); // динамическое связывание


// Пример 2.

public interface Worker{
    void work();
}

public class A implements Worker{
    public void work(){
        System.out.println("I am A worker");
    }
}

public class B implements Worker{
    public void work(){
        System.out.println("I am B worker");
    }
}

public class C{
    private Worker w;
    public C(Worker w){
        this.w = w;
    }
    public void setWorker(Worker w){
        this.w = w;
    }
    public void work(){
        w.work();
    }
}

C c = new C(new A());
// ..........
c.work() // динамическое связывание


// Задание 8.

// Ковариантность:

List<Integer> l1 = new ArrayList<>();
l1.add(31);
List<? extends Number> l2 = l1; // read-only список. Безопасное приведение потомка(Integer) к родителю (Number)


// Контрвариантность:

List<Number> l3 = new ArrayList<>();

List<? super Double> l4 = l3; // write-only список. Безопасное приведение родителя (Number) к потомку (Double)

// Такой механизм позволяет обходить небезопасное приведение типов,
// когда в List<Double> могут оказаться значения типа Integer, если сначала List<Double> привести к List<Number>
