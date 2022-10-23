package Chap_4_Stream.sample;

public class Dish {

    private String name;
    private boolean vegetarian;
    private int calory;
    private Type type;

    public Dish(String name, boolean vegetarian, int calory, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calory = calory;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getCalory() {
        return calory;
    }

    public void setCalory(int calory) {
        this.calory = calory;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {MEAT,OTHER,FISH}

}
