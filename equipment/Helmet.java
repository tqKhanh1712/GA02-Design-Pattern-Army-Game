package equipment;

import core.Equipment;
import core.Soldier;
import visitor.SoldierVisitor;

// WorldWar equipment: Helmet (secondary defense item)
public class Helmet extends Equipment {
    private int durability;
    private static final int MAX_DURABILITY = 3;
    private static final int DEFENSE_BONUS = 12;

    public Helmet(Soldier soldier) {
        super(soldier);
        this.durability = MAX_DURABILITY;
    }

    @Override
    public int hit() {
        return wrapped.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        int effectiveDefense = 0;
        if (durability > 0) {
            effectiveDefense = DEFENSE_BONUS;
            durability--;
            System.out.println("[Helmet] wardOff(" + strength + ") -> absorbs " + effectiveDefense
                    + " (durability=" + durability + ")");
        } else {
            System.out.println("[Helmet] wardOff(" + strength + ") -> helmet destroyed, no protection");
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
