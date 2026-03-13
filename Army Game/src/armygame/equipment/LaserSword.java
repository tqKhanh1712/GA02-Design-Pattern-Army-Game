package armygame.equipment;

import armygame.core.Soldier;

/** Kiếm laser – ATK+25, DEF+5 | Durability: 15 | SciFi */
public class LaserSword extends EquipmentDecorator {
    public LaserSword(Soldier wrapped) { super(wrapped, 15); }

    @Override public String getEquipmentName() { return "LaserSword"; }
    @Override public int getAttack()  { return wrapped.getAttack() + (isWorn() ? 0 : 25); }
    @Override public int getDefense() { return wrapped.getDefense() + (isWorn() ? 0 : 5); }
}

