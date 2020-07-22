package practice11;

import java.util.LinkedList;
import java.util.List;

public class Klass implements Observerable{
    private int number;
    private Student leader;
    private List<Student> members = new LinkedList<>();
    private Teacher observer;

    public Klass(int number) {
        this.number = number;
    }
    public void assignLeader(Student leader) {
        if (members.contains(leader)) {
            this.notifyObserver(" I know " + leader.getName() + " become Leader of Class " + this.number + ".");
            this.leader = leader;
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public void appendMember(Student student) {
        this.members.add(student);
        this.notifyObserver(" I know " + student.getName() + " has joined Class " + this.number + ".");
    }

    public Student getLeader() {
        return leader;
    }

    public String getDisplayName() {
        return "Class " + this.number;
    }

    public int getNumber() {
        return number;
    }
    public boolean isIn(Student student) {
        if (members.contains(student)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void registerObserver(Teacher o) {
        this.observer = o;
    }

    @Override
    public void notifyObserver(String message) {
        if (this.observer != null) {
            this.observer.update(message);
        }

    }
}
