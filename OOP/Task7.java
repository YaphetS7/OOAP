// Задание 14.

public abstract class Developer {

}

// Так делать плохо:
public class Worker extends Developer {
    public int skill; // -1 junior, 0 middle, 1 senior

    public Worker(int skill){
        this.skill = skill;
    }
}


// Лучше делать так:
public class Senior extends Developer {
}

public class Middle extends Developer {
}

public class Junior extends Developer {
}

// Потому что теперь наш код открыт для расширений, но закрыт для изменений.
// Ну и с точки зрения семантики так куда лучше :)


// Задание 15.

public class Car {
    public Car byCar(){
        return new Car();
    }

    public void getInfo(){
        System.out.println("default car");
    }
}

public class Tesla extends Car {

    @Override
    public Car byCar(){
        return new Tesla();
    }

    @Override
    public void getInfo(){
        System.out.println("tesla car");
    }
}

// main():

// Car car = new Tesla();
// car.getInfo(); -- полиморфный вызов метода

// car.byCar(); -- ковариантный и полиморфный вызов метода

// Tesla tesla = new Tesla();
// tesla.byCar(); -- ковариантный вызов метода