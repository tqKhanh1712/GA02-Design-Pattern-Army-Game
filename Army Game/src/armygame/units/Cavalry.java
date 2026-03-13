package armygame.units;

import armygame.core.Soldier;
import armygame.core.SoldierType;

/**
 * Kỵ Binh – ConcreteComponent (Decorator Pattern)
 * Chỉ số cơ bản: HP=120, Attack=15, Defense=8
 */
public class Cavalry extends Soldier {

    public Cavalry(String name) {
        super(name, 120, SoldierType.CAVALRY);
    }

    @Override
    public int getAttack()  { return 15; }

    @Override
    public int getDefense() { return 8; }

    @Override
    public String describe() {
        return String.format("Kỵ Binh [%s] | HP: %d/%d | ATK: %d | DEF: %d",
                name, health, maxHealth, getAttack(), getDefense());
    }
}

