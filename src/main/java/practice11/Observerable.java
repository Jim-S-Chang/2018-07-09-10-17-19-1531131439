package practice11;

public interface Observerable {

    public void registerObserver(Teacher o);
    public void notifyObserver(String message);

}