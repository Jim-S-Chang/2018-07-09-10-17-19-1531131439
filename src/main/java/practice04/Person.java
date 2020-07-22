package practice04;

public class Person {
    private String name;
    private int age;
    protected String basicIntroduce;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.basicIntroduce = introduce();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String introduce() {
        return "My name is " + this.name + ". I am " + this.age + " years old.";
    }
}
