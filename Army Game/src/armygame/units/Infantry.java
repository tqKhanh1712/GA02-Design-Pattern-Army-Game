package armygame.units;

import armygame.core.Soldier;
import armygame.core.SoldierType;

/**
 * Bộ Binh – ConcreteComponent (Decorator Pattern)
 * Chỉ số cơ bản: HP=100, Attack=10, Defense=5
 */
public class Infantry extends Soldier {

    public Infantry(String name) {
        super(name, 100, SoldierType.INFANTRY);
    }

    @Override
    public int getAttack()  { return 10; }

    @Override
    public int getDefense() { return 5; }

    @Override
    public String describe() {
        return String.format("Bộ Binh [%s] | HP: %d/%d | ATK: %d | DEF: %d",
                name, health, maxHealth, getAttack(), getDefense());
    }
}

