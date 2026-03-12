package equipment;

import core.Equipment;
import core.Soldier;
import visitor.SoldierVisitor;

// Decorator: adds shield defense bonus with wear mechanism
public class Shield extends Equipment {
    private int durability;
    private static final int MAX_DURABILITY = 5;
    private static final int DEFENSE_BONUS = 8;

    public Shield(Soldier soldier) {
        super(soldier);
        this.durability = MAX_DURABILITY;
    }

    @Override
    public int hit() {
        System.out.println("[Shield] hit() -> delegating to wrapped soldier");
        return wrapped.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        int effectiveDefense = 0;
        if (durability > 0) {
            effectiveDefense = DEFENSE_BONUS * durability / MAX_DURABILITY;
            durability--;
            System.out.println("[Shield] wardOff(" + strength + ") -> shield absorbs " + effectiveDefense
                    + " damage (durability=" + durability + "/" + MAX_DURABILITY + ")");
        } else {
            System.out.println("[Shield] wardOff(" + strength + ") -> shield is broken, no protection");
        }
        int reduced = Math.max(0, strength - effectiveDefense);
        return wrapped.wardOff(reduced);
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        visitor.visitShield(this);
    }

    @Override
    public String getName() { return wrapped.getName(); }

    public int getDurability() { return durability; }
}
