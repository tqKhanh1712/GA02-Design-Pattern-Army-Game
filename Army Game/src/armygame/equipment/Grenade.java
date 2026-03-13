package armygame.equipment;

import armygame.core.Soldier;

/** Lựu đạn – ATK+20 | Durability: 5 | WorldWar */
public class Grenade extends EquipmentDecorator {
    public Grenade(Soldier wrapped) { super(wrapped, 5); }

    @Override public String getEquipmentName() { return "Grenade"; }
    @Override public int getAttack()  { return wrapped.getAttack() + (isWorn() ? 0 : 20); }
    @Override public int getDefense() { return wrapped.getDefense(); }
}

