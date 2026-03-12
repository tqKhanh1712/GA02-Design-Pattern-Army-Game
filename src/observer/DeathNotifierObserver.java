package observer;

// Singleton Observer: notifies about each fallen soldier (simulates sending email)
public class DeathNotifierObserver implements BattleObserver {
    private static DeathNotifierObserver instance;

    private DeathNotifierObserver() {}

    public static DeathNotifierObserver getInstance() {
        if (instance == null) {
            instance = new DeathNotifierObserver();
        }
        return instance;
    }

    @Override
    public void onSoldierDeath(String soldierName) {
        System.out.println("[DeathNotifierObserver] Soldier '" + soldierName + "' has died in battle.");
        System.out.println("[DeathNotifierObserver] Sending apology email to friends of " + soldierName + "...");
    }
}
