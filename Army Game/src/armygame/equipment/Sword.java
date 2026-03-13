package armygame.equipment;

import armygame.core.Soldier;

/** Kiếm – ATK+8 | Durability: 30 | Medieval */
public class Sword extends EquipmentDecorator {
    public Sword(Soldier wrapped) { super(wrapped, 30); }

    @Override public String getEquipmentName() { return "Sword"; }
    @Override public int getAttack()  { return wrapped.getAttack() + (isWorn() ? 0 : 8); }
    @Override public int getDefense() { return wrapped.getDefense(); }
}

