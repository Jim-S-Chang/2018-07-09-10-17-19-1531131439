package practice11;

public interface Observerable {

    public void registerObserver(Teacher o);
    public void removeObserver(Observer o);
    public void notifyObserver(Student student);

}
