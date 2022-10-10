package a_java00;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalPractical {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1L,"h",35));

        List<temp> temps = new ArrayList<>();
        temps.add(new temp(1,"25"));




    }
    private static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        for (T t : list) {
            if(predicate.test(t)){
                System.out.println("yes");
            }
        }
        return list;
    }
}

class temp{
    private int id;
    private String hi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHi() {
        return hi;
    }

    public void setHi(String hi) {
        this.hi = hi;
    }

    public temp(int id, String hi) {
        this.id = id;
        this.hi = hi;
    }
}

class Product{
    private Long id;
    private String name;
    private int price;

    public Product() {
    }

    public Product(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
