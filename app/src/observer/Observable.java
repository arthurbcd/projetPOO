public interface Observable {
 void update(list<Object> args);
 void addObservable(Observable Observable);
 void removeObservable(Observable Observable);
 void notifyObservable(List<Object> args);
}
 