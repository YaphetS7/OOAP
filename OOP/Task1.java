
// Задание 1.
public class Animal {
    public void voice(){
        System.out.println("I am animal!");
    }
}

public class Head {

}


public class Cat extends Animal { // наследование

    private Head head; // композиция

    // При вызове voice() у подтипов типа Animal системе не обязательно знать конкретный тип,
    // главное, что этот подтип - потомок класса Animal.
    // Т.е. мы используем метод класса-родителя без создания объекта класса-родителя, а путем
    // создания объекта класса-наследника - полиморфизм
    @Override
    public void voice(){
        System.out.println("I am the cat!");
    }
}

// Задание 2.

public class Human{

    // -- voice()
    // -- walk()
    // -- run()
}

public class Worker extends Human{ // специализация класса-родителя, т.к. рабочий - более частный случай,
                                   // т.к. все работники - люди, но не все люди - работники
    // -- work()
}

public class Car{
    // -- drive()
    // -- park()
    // -- startEngine()
}

public class AutonomousCar extends Car{ // расширение класса-родителя, т.к. все самоуправляемые машины
                                        // являются машинами, но не все машины - самоуправляемы

    // -- autoDrive()
    // -- autoPark()

}

// Задание 3.
// Концепция "класс как модуль" в Java поддерживается путем иерархии папок.
// Корневой узел такой иерархии и называется модулем.
// Для подключения модуля используется синтаксис package *name1.name2....* или import *name1.name2....*

