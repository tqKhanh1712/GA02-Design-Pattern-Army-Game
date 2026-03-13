package armygame.equipment;

import armygame.core.Soldier;

/** Áo giáp – DEF+8 | Durability: 60 | Medieval / WorldWar */
public class Armor extends EquipmentDecorator {
    public Armor(Soldier wrapped) { super(wrapped, 60); }

    @Override public String getEquipmentName() { return "Armor"; }
    @Override public int getAttack()  { return wrapped.getAttack(); }
    @Override public int getDefense() { return wrapped.getDefense() + (isWorn() ? 0 : 8); }
}

