package lambda.constructor;

public class Apple {

    private int weight;

    private String color;

    public Apple(int weight) {
        this.weight = weight;
        this.color = "Color " + weight;
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String toString() {

        return "weight : " + weight + "\n"
                + "color : " + color
                + "\n";
    }
}
