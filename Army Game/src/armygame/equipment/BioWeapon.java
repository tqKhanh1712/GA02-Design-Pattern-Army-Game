package armygame.equipment;

import armygame.core.Soldier;

/** Vũ khí sinh học – ATK+30, DEF-5 | Durability: 10 | SciFi */
public class BioWeapon extends EquipmentDecorator {
    public BioWeapon(Soldier wrapped) { super(wrapped, 10); }

    @Override public String getEquipmentName() { return "BioWeapon"; }
    @Override public int getAttack()  { return wrapped.getAttack() + (isWorn() ? 0 : 30); }
    @Override public int getDefense() { return wrapped.getDefense() - (isWorn() ? 0 : 5); }
}

