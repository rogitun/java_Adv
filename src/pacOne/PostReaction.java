package pacOne;

public class PostReaction {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String name;

    private String age;

    public PostReaction(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
