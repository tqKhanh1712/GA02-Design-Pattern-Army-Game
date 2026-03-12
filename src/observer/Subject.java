package observer;

import java.util.ArrayList;
import java.util.List;

// Subject (Observable) - manages observers, notified when a soldier dies
public class Subject {
    private static Subject instance;
    private List<BattleObserver> observers = new ArrayList<>();

    private Subject() {}

    public static Subject getInstance() {
        if (instance == null) {
            instance = new Subject();
        }
        return instance;
    }

    public void addObserver(BattleObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BattleObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String soldierName) {
        for (BattleObserver o : observers) {
            o.onSoldierDeath(soldierName);
        }
    }
}
