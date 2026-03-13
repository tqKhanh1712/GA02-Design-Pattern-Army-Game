package armygame.equipment;

import armygame.core.Soldier;

/** Khiên – DEF+5 | Durability: 50 | Medieval / WorldWar */
public class Shield extends EquipmentDecorator {
    public Shield(Soldier wrapped) { super(wrapped, 50); }

    @Override public String getEquipmentName() { return "Shield"; }
    @Override public int getAttack()  { return wrapped.getAttack(); }
    @Override public int getDefense() { return wrapped.getDefense() + (isWorn() ? 0 : 5); }
}

