package armygame.equipment;

import armygame.core.Soldier;

/** Súng trường – ATK+15 | Durability: 25 | WorldWar */
public class Rifle extends EquipmentDecorator {
    public Rifle(Soldier wrapped) { super(wrapped, 25); }

    @Override public String getEquipmentName() { return "Rifle"; }
    @Override public int getAttack()  { return wrapped.getAttack() + (isWorn() ? 0 : 15); }
    @Override public int getDefense() { return wrapped.getDefense(); }
}

