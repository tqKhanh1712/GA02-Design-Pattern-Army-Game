package equipment;

import core.Equipment;
import core.Soldier;
import visitor.SoldierVisitor;

// WorldWar equipment: Rifle (primary weapon)
public class Rifle extends Equipment {
    private int ammo;
    private static final int MAX_AMMO = 10;
    private static final int ATTACK_BONUS = 25;

    public Rifle(Soldier soldier) {
        super(soldier);
        this.ammo = MAX_AMMO;
    }

    @Override
    public int hit() {
        int bonus = 0;
        if (ammo > 0) {
            bonus = ATTACK_BONUS;
            ammo--;
            System.out.println("[Rifle] hit() -> fires! +" + bonus + " attack (ammo=" + ammo + ")");
        } else {
            System.out.println("[Rifle] hit() -> out of ammo!");
        }
        return wrapped.hit() + bonus;
    }

    @Override
    public boolean wardOff(int strength) {
        return wrapped.wardOff(strength);
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        // treat as sword-like for visitor simplicity
        wrapped.accept(visitor);
    }

    @Override
    public String getName() { return wrapped.getName(); }

    public int getAmmo() { return ammo; }
}
