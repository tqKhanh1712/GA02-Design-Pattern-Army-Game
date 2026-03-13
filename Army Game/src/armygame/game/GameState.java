package armygame.game;

import armygame.composite.Army;
import armygame.factory.SoldierFactory;
import armygame.observer.Battle;

import java.util.ArrayList;
import java.util.List;

/**
 * Lưu trạng thái toàn bộ game (danh sách quân đội, factory hiện tại, trận đang diễn ra).
 */
public class GameState {

    private final List<Army> armies = new ArrayList<>();
    private SoldierFactory   currentFactory;
    private Battle           currentBattle;

    // ── Quân đội ─────────────────────────────────────────────────────────
    public void addArmy(Army army)     { armies.add(army); }
    public void removeArmy(Army army)  { armies.remove(army); }
    public List<Army> getArmies()      { return armies; }

    public Army getArmy(int index) {
        if (index < 0 || index >= armies.size()) return null;
        return armies.get(index);
    }

    // ── Factory ───────────────────────────────────────────────────────────
    public SoldierFactory getCurrentFactory()                { return currentFactory; }
    public void           setCurrentFactory(SoldierFactory f){ currentFactory = f; }

    // ── Battle ────────────────────────────────────────────────────────────
    public Battle getCurrentBattle()             { return currentBattle; }
    public void   setCurrentBattle(Battle battle){ currentBattle = battle; }
}

