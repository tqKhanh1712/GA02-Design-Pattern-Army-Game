package equipment;

import core.Equipment;
import core.Soldier;
import visitor.SoldierVisitor;

// ScienceFiction equipment: NanoArmor (secondary defense item)
public class NanoArmor extends Equipment {
    private int integrity;
    private static final int MAX_INTEGRITY = 8;
    private static final int DEFENSE_BONUS = 20;

    public NanoArmor(Soldier soldier) {
        super(soldier);
        this.integrity = MAX_INTEGRITY;
    }

    @Override
    public int hit() {
        return wrapped.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        int effectiveDefense = 0;
        if (integrity > 0) {
            effectiveDefense = DEFENSE_BONUS * integrity / MAX_INTEGRITY;
            integrity--;
            System.out.println("[NanoArmor] wardOff(" + strength + ") -> absorbs " + effectiveDefense
                    + " (integrity=" + integrity + ")");
        } else {
            System.out.println("[NanoArmor] wardOff(" + strength + ") -> nano armor depleted!");
        }
        return wrapped.wardOff(Math.max(0, strength - effectiveDefense));
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        wrapped.accept(visitor);
    }

    @Override
    public String getName() { return wrapped.getName(); }
}
