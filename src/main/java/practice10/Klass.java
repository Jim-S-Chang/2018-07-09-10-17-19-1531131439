package practice10;

import java.util.LinkedList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> members = new LinkedList<>();

    public Klass(int number) {
        this.number = number;
    }
    public void assignLeader(Student leader) {
        if (members.contains(leader)) {
            this.leader = leader;
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public void appendMember(Student student) {
        this.members.add(student);
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
}
