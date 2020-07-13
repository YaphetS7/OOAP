// Задание 20.

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class General extends Object implements Serializable, Cloneable {

    public Object deepCopy(){
        return SerializationUtils.clone(this);
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

public class Any extends General{ // implementation inheritance,
                                  // т.к. мы наследуем только реализацию, ничего не добавляя и не изменяя

}


public abstract class Truck{
    public void startTruck(){
        // do smth
    }

    public void stopTruck(){
        // do smth
    }

    // ...

    public abstract void fillUp();
}


// facility inheritance:
public class GasTruck extends Truck{

    @Override
    public void fillUp() {
        // заправить грузовую машину газом
    }
}

// facility inheritance:
public class PetrolTruck extends Truck{

    @Override
    public void fillUp() {
        // заправить грузовую машину бензином
    }
}


