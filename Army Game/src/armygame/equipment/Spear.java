package armygame.equipment;

import armygame.core.Soldier;

/** Giáo – ATK+10 | Durability: 20 | Medieval */
public class Spear extends EquipmentDecorator {
    public Spear(Soldier wrapped) { super(wrapped, 20); }

    @Override public String getEquipmentName() { return "Spear"; }
    @Override public int getAttack()  { return wrapped.getAttack() + (isWorn() ? 0 : 10); }
    @Override public int getDefense() { return wrapped.getDefense(); }
}

