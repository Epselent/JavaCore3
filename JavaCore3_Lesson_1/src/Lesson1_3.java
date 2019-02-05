import java.util.ArrayList;

public class Lesson1_3 {
    public static void main(String[] args) {

        Apple apple = new Apple("Яблоко", 1.0f);
        Orange orange = new Orange("Апельсин", 1.5f);
        Box<Apple> boxApple = new Box<Apple>();
        Box<Orange> boxOrange = new Box<Orange>();
        boxApple.putFruit(apple, 5);
        boxOrange.putFruit(orange,5);
        System.out.println("Вес коробки с яблоками " + boxApple.getWeight() + " ед. Вес коробки с апельсинами " +boxOrange.getWeight() + " ед." );
        System.out.println("Вес коробок одинаковый? " + boxApple.compare(boxOrange));
        Box<Apple> boxApple2 = new Box<Apple>();
        Box<Orange> boxOrange2 = new Box<Orange>();
        boxApple2.boxToBox(boxApple);
        System.out.println("Вес первой коробки с яблоками  " + boxApple.getWeight() + " ед. Вес второй коробки с яблоками  " +boxApple2.getWeight() + " ед." );


    }
}
class Fruit{
    private String name;
    private float weight;
    public Fruit(String name, float weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }
}
class Apple extends Fruit{

    public Apple(String name, float weight) {
        super(name, weight);
    }
}
class Orange extends Fruit{

    public Orange(String name, float weight) {
        super(name, weight);
    }
}
class Box <T extends Fruit> {
    private ArrayList<T> fruit = new ArrayList<>();

    public ArrayList<T> getFruit() {
        return fruit;
    }

    public void setFruit(ArrayList<T> fruit) {
        this.fruit = fruit;
    }
    public void removeBox(){
        this.fruit.clear();
    }

    public void putFruit (T fruit, int amount){
        for (int i = 0; i < amount ; i++) {
            this.fruit.add(fruit);
        }
    }
    public float getWeight (){
        float weight = 0;
        for (Fruit o: this.fruit) {
            weight += o.getWeight();
        }
        return weight;
    }
    public boolean compare ( Box<?> box){

        if(this.getWeight() == box.getWeight()){
            return true;
        }
        return false;

    }
    public void boxToBox (Box<T> box){

        ArrayList<T> fruit = new ArrayList<T>(box.getFruit());
        this.setFruit(fruit);
        box.removeBox();
        System.out.println("Переложили фрукты успешно!");
    }
}