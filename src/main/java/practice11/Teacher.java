package practice11;

import java.util.LinkedList;
import java.util.List;

public class Teacher extends Person implements Observer{
    private List<Klass> classes = new LinkedList<>();

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        for (int i = 0; i < classes.size(); i++) {
            classes.get(i).registerObserver(this);
        }
    }
    public Teacher(int id, String name, int age) {
        super(id,name, age);
    }

    public String introduce() {
        if (this.classes.size() == 0) {
            return super.introduce() + " I am a Teacher. I teach No Class.";
        } else {
            String introduction = super.introduce() + " I am a Teacher. I teach Class ";
            for (int i = 0; i < this.classes.size(); i++) {
                introduction += classes.get(i).getNumber();
                if (i != this.classes.size() - 1) {
                    introduction += ", ";
                }
            }
            return introduction + ".";
        }
    }
    public boolean isTeaching(Student student) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).isIn(student)) {
                return true;
            }
        }
        return false;
    }

    public String introduceWith(Student student) {
        for (int i = 0; i < classes.size(); i++) {
            if (student.getKlass().getNumber() == classes.get(i).getNumber()) {
                return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
            }
        }
        return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
    }

    public List<Klass> getClasses() {
        return classes;
    }

    @Override
    public void update(String message) {
        System.out.print("I am " + this.name + "." + message + "\n");
    }
}