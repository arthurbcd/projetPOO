public interface Observable {
    void addObservable(Observable Observable);

    void removeObservable(Observable Observable);

    void notifyObservable(Object arg);
}
