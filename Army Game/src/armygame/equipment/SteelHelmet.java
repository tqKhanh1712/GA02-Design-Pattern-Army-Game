package armygame.equipment;

import armygame.core.Soldier;

/** Mũ sắt – DEF+3 | Durability: 40 | WorldWar */
public class SteelHelmet extends EquipmentDecorator {
    public SteelHelmet(Soldier wrapped) { super(wrapped, 40); }

    @Override public String getEquipmentName() { return "SteelHelmet"; }
    @Override public int getAttack()  { return wrapped.getAttack(); }
    @Override public int getDefense() { return wrapped.getDefense() + (isWorn() ? 0 : 3); }
}

