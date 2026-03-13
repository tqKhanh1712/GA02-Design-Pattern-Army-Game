package armygame.observer;

import armygame.core.Soldier;

import java.util.ArrayList;
import java.util.List;

/**
 * SINGLETON OBSERVER 2 – Observer + Singleton Pattern (Phần 3.1 + 3.2)
 * Hiển thị tên binh lính tử trận và "gửi email" xin lỗi bạn bè của họ.
 *
 * Singleton đảm bảo chỉ có một notifier duy nhất – tránh gửi email trùng lặp.
 */
public class DeathNotifierObserver implements BattleObserver {

    // ── Singleton ─────────────────────────────────────────────────────────
    private static DeathNotifierObserver instance;

    private DeathNotifierObserver() {}

    public static DeathNotifierObserver getInstance() {
        if (instance == null) {
            instance = new DeathNotifierObserver();
        }
        return instance;
    }

    // ── Trạng thái ────────────────────────────────────────────────────────
    private final List<String> fallenNames = new ArrayList<>();

    // ── BattleObserver ────────────────────────────────────────────────────
    @Override
    public void onSoldierDeath(Soldier soldier, String fromArmy) {
        fallenNames.add(soldier.getName());
        System.out.printf("[Notifier] ✝ %s (%s) thuộc quân đội '%s' đã tử trận!%n",
                soldier.getName(), soldier.getType().getDisplayName(), fromArmy);
        sendEmailToFriends(soldier.getName());
    }

    @Override
    public void onBattleEnd(String winnerArmy, int totalDeaths) {
        System.out.println("\n[Notifier] ══ Danh sách tử trận ══");
        if (fallenNames.isEmpty()) {
            System.out.println("[Notifier]   (Không có ai tử trận)");
        } else {
            fallenNames.forEach(name -> System.out.println("[Notifier]   • " + name));
        }
        System.out.println("[Notifier] Đã gửi email xin lỗi tới thân nhân của "
                + fallenNames.size() + " binh sĩ.");
    }

    // ── Giả lập gửi email ─────────────────────────────────────────────────
    private void sendEmailToFriends(String soldierName) {
        System.out.printf("[Email] → Gửi email xin lỗi tới bạn bè của %s...%n", soldierName);
    }

    // ── Tiện ích ──────────────────────────────────────────────────────────
    public List<String> getFallenNames() { return new ArrayList<>(fallenNames); }

    public void reset() { fallenNames.clear(); }
}

