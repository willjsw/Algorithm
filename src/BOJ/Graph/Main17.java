package BOJ.Graph;

class Apple{

}

class Pencil{

}
class Manage<T>{
    private T t;
    public T get(){
        return this.t;
    }

    public void set(T t){
        this.t = t;
    }
}

class KeyValue<K, V>{
    private K key;
    private V value;

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setKey(K k){
        this.key = k;
    }



}

class GenericMethod{

}

public class Main17 {
    public static void main(String[] args){
        Manage<Apple> goods = new Manage<>();
        goods.set(new Apple());
//        Pencil pen = (Pencil)goods.get();

        KeyValue<String, Void> key = new KeyValue<>();

        //매개변수에만 제네릭 사용
        //접근지정자 <T> void 메서드 (T t){ ... }

        //return 타입에만 제네릭 사용
        //접근지정 <T> T 메서드명 (int a){ ... }

    }

}
