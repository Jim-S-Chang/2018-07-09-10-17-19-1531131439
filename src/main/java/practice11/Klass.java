package practice11;

import java.util.LinkedList;
import java.util.List;

public class Klass implements Observerable {
    private int number;
    private Student leader;
    private List<Student> members = new LinkedList<>();
    private Teacher teacher;

    public Klass(int number) {
        this.number = number;
    }
    public void assignLeader(Student leader) {
        if (members.contains(leader)) {
            this.leader = leader;
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public void appendMember(Student student) {
        this.members.add(student);
        this.notifyObserver(student);
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
        for (int i = 0; i < members.size(); i++) {
            if (student.getId() == members.get(i).getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void registerObserver(Teacher o) {
        teacher = o;
    }

    @Override
    public void removeObserver(Observer o) {
        if(this.teacher != null) {
            this.teacher = null;
        }
    }

    @Override
    public void notifyObserver(Student student) {
        this.teacher.update(" I know " + student.getName() + " has joined Class " + this.number + ".");
    }
}
