package equipment;

import core.Equipment;
import core.Soldier;
import visitor.SoldierVisitor;

// ScienceFiction equipment: LaserSword (primary weapon)
public class LaserSword extends Equipment {
    private int energy;
    private static final int MAX_ENERGY = 20;
    private static final int ATTACK_BONUS = 40;

    public LaserSword(Soldier soldier) {
        super(soldier);
        this.energy = MAX_ENERGY;
    }

    @Override
    public int hit() {
        int bonus = 0;
        if (energy > 0) {
            bonus = ATTACK_BONUS * energy / MAX_ENERGY;
            energy = Math.max(0, energy - 2);
            System.out.println("[LaserSword] hit() -> +" + bonus + " attack (energy=" + energy + ")");
        } else {
            System.out.println("[LaserSword] hit() -> energy depleted!");
        }
        return wrapped.hit() + bonus;
    }

    @Override
    public boolean wardOff(int strength) {
        return wrapped.wardOff(strength);
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        wrapped.accept(visitor);
    }

    @Override
    public String getName() { return wrapped.getName(); }
}
