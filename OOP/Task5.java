// Задание 10.

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class General extends Object implements Serializable, Cloneable {

    public Object deepCopy(){
        return SerializationUtils.clone(this);
    }

    public static void assignment_attempt(Object target, Object source){
        if(target.getClass().isInstance(source)){
            target = source;
        }
        else{
            target = Globals.Void;
        }

    }


    public static Object cloneObj(Object object) throws Exception {

        return SerializationUtils.clone((Serializable) object);

    }

    public static boolean equals(Object first, Object second){
        return (first.equals(second));
    }

    public boolean equals(Object obj){

        checkType(obj);

        byte[] obj_bytes = SerializationUtils.serialize((Serializable) obj);
        byte[] this_bytes = SerializationUtils.serialize(this);

        int length1 = obj_bytes.length;
        int length2 = this_bytes.length;

        if (length1 != length2){
            return false;
        }

        boolean eq = true;

        for (int i = 0; i < length1; i++){
            eq = eq && (obj_bytes[i] == this_bytes[i]);
        }

        return eq;
    }

    public static byte[] serialize(Serializable obj) {
        return SerializationUtils.serialize((Serializable) obj);
    }

    public static Object deserialize(byte[] arr){
        return SerializationUtils.deserialize(arr);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    private void checkType(Object obj){
        if (!(obj instanceof Serializable)){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean instanceOf(Class clazz){
        return clazz.isInstance(this);
    }

}


public class Any extends General{
}


public class None extends Any {
}


public class Globals {
    public static None Void = new None();
}

// Полиморфное использование типа None:
// main:
Any any = new Any();
any = Globals.Void;
any.equals(new Object()); // объект any типа None использует методы супер-класса


// Задание 11.

// см. с начала 13й строки метод assignment_attempt(target, source)

// Задание 12.

public class A{
    public void publicMethod1(){
        System.out.println("wow");
    }

    public void publicMethod2(){
        System.out.println();
    }

    private void privateMethod(){
        System.out.println("sad");
    }

    protected void protectedMethod(){
        System.out.println();
    }

}

public class B extends A{
    // -- мы не имеем доступа к методу privateMethod()
    // -- мы имеем доступ к методу publicMethod1()
    // -- мы не можем сделать метод publicMethod2() закрытым в классе-потомке (в этом классе)

    // НО! При этом мы можем открыть доступ к методу (переопределив его как public) protectedMethod(), который был
    // объявлен как protected (с private такое не прокатит :)
    @Override
    public void protectedMethod(){
        super.protectedMethod();
    }
}




