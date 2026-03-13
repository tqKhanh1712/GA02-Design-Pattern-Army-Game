package armygame.equipment;

import armygame.core.Soldier;

/** Giáp nano – ATK+5, DEF+20 | Durability: 35 | SciFi */
public class NanoArmor extends EquipmentDecorator {
    public NanoArmor(Soldier wrapped) { super(wrapped, 35); }

    @Override public String getEquipmentName() { return "NanoArmor"; }
    @Override public int getAttack()  { return wrapped.getAttack() + (isWorn() ? 0 : 5); }
    @Override public int getDefense() { return wrapped.getDefense() + (isWorn() ? 0 : 20); }
}

