// Задание 19.

public class Animal{

    public void voice(){
        System.out.println("I am animal");
    }
}


public class Dog extends Animal{

    @Override
    public void voice(){ // functional variation inheritance
        System.out.println("I am the dog");
    }
}

public class Cat extends Animal{


    // Тут мы не можем писать Override, т.к. сигнатура метода изменилась
    public void voice(Voice v){ // type variation inheritance
        v.voiceInfo(this);
    }


}

public abstract class Car {
    public abstract void startEngine();

    public abstract void stopEngine();

    public abstract void lightsOn();

    public abstract void lightsOff();

}


public class Toyota extends Car { // reification inheritance, т.к. Car - абстрактный класс
    // (он мог быть частисно реализован)

    @Override
    public void startEngine() {
        System.out.println(this + "'s engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println(this + "'s engine stopped");
    }

    @Override
    public void lightsOn() {
        System.out.println(this + "'s lights on");
    }

    @Override
    public void lightsOff() {
        System.out.println(this + "'s lights off");
    }

    @Override
    public String toString(){
        return "Toyota";
    }

}

public interface Working {
    void work();
}

public class Human implements Working { // structure inheritance

    @Override
    public void work() {
        System.out.println("I am working :C");
    }
}
