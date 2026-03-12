package equipment;

import core.Equipment;
import core.Soldier;
import visitor.SoldierVisitor;

// Decorator: adds sword attack bonus with wear mechanism
public class Sword extends Equipment {
    private int durability;
    private static final int MAX_DURABILITY = 5;
    private static final int ATTACK_BONUS = 10;

    public Sword(Soldier soldier) {
        super(soldier);
        this.durability = MAX_DURABILITY;
    }

    @Override
    public int hit() {
        int bonus = 0;
        if (durability > 0) {
            bonus = ATTACK_BONUS * durability / MAX_DURABILITY;
            durability--;
            System.out.println("[Sword] hit() -> sword adds +" + bonus + " attack (durability=" + durability + "/" + MAX_DURABILITY + ")");
        } else {
            System.out.println("[Sword] hit() -> sword is broken, no bonus");
        }
        return wrapped.hit() + bonus;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println("[Sword] wardOff(" + strength + ") -> delegating to wrapped soldier");
        return wrapped.wardOff(strength);
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        visitor.visitSword(this);
    }

    @Override
    public String getName() { return wrapped.getName(); }

    public int getDurability() { return durability; }
}
