package observer;

// Singleton Observer: counts soldier deaths in battle
public class DeathCountObserver implements BattleObserver {
    private static DeathCountObserver instance;
    private int deathCount = 0;

    private DeathCountObserver() {}

    public static DeathCountObserver getInstance() {
        if (instance == null) {
            instance = new DeathCountObserver();
        }
        return instance;
    }

    @Override
    public void onSoldierDeath(String soldierName) {
        deathCount++;
        System.out.println("[DeathCountObserver] Total deaths so far: " + deathCount);
    }

    public int getDeathCount() { return deathCount; }

    public void reset() { deathCount = 0; }
}
