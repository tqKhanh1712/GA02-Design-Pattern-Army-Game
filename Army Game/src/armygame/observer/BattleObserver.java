package armygame.observer;

import armygame.core.Soldier;

/**
 * OBSERVER interface – Observer Pattern (Phần 3.1)
 * Mọi observer theo dõi trận chiến đều implement interface này.
 */
public interface BattleObserver {

    /** Được gọi mỗi khi một binh lính tử trận */
    void onSoldierDeath(Soldier soldier, String fromArmy);

    /** Được gọi khi trận chiến kết thúc */
    void onBattleEnd(String winnerArmy, int totalDeaths);
}

