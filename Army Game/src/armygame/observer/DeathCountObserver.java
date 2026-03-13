package armygame.observer;

import armygame.core.Soldier;

import java.util.HashMap;
import java.util.Map;

/**
 * SINGLETON OBSERVER 1 – Observer + Singleton Pattern (Phần 3.1 + 3.2)
 * Đếm và hiển thị số lượng binh lính đã tử trận theo từng quân đội.
 *
 * Singleton đảm bảo chỉ có duy nhất một bộ đếm trong toàn chương trình,
 * tránh đếm trùng nếu nhiều nơi đăng ký observer.
 */
public class DeathCountObserver implements BattleObserver {

    // ── Singleton ─────────────────────────────────────────────────────────
    private static DeathCountObserver instance;

    private DeathCountObserver() {}

    public static DeathCountObserver getInstance() {
        if (instance == null) {
            instance = new DeathCountObserver();
        }
        return instance;
    }

    // ── Trạng thái ────────────────────────────────────────────────────────
    private int totalDeaths = 0;
    private final Map<String, Integer> deathsByArmy = new HashMap<>();

    // ── BattleObserver ────────────────────────────────────────────────────
    @Override
    public void onSoldierDeath(Soldier soldier, String fromArmy) {
        totalDeaths++;
        deathsByArmy.merge(fromArmy, 1, Integer::sum);
        System.out.printf("[DeathCount] Tử trận: %d | Quân đội '%s': %d tử vong%n",
                totalDeaths, fromArmy, deathsByArmy.get(fromArmy));
    }

    @Override
    public void onBattleEnd(String winnerArmy, int totalDeaths) {
        System.out.println("\n[DeathCount] ══ Tổng kết tử vong ══");
        System.out.println("[DeathCount]   Tổng tử vong : " + this.totalDeaths);
        deathsByArmy.forEach((army, count) ->
                System.out.println("[DeathCount]   " + army + " : " + count));
    }

    // ── Tiện ích ──────────────────────────────────────────────────────────
    public void printReport() {
        System.out.println("=== Báo cáo tử vong ===");
        System.out.println("  Tổng: " + totalDeaths);
        deathsByArmy.forEach((k, v) -> System.out.println("  " + k + ": " + v));
    }

    public int getTotalDeaths()                    { return totalDeaths; }
    public Map<String, Integer> getDeathsByArmy()  { return new HashMap<>(deathsByArmy); }

    public void reset() {
        totalDeaths = 0;
        deathsByArmy.clear();
    }
}

