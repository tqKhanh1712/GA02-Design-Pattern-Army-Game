package units;

import core.Soldier;
import visitor.SoldierVisitor;

public class Infantryman implements Soldier {
    private String name;
    private int health;
    private static final int BASE_ATTACK = 10;
    private static final int BASE_DEFENSE = 5;

    public Infantryman(String name) {
        this.name = name;
        this.health = 100;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int hit() {
        System.out.println("[Infantryman:" + name + "] hit() called -> attack=" + BASE_ATTACK);
        return BASE_ATTACK;
    }

    @Override
    public boolean wardOff(int strength) {
        int damage = Math.max(0, strength - BASE_DEFENSE);
        health -= damage;
        System.out.println("[Infantryman:" + name + "] wardOff(" + strength + ") -> damage=" + damage + ", health=" + health);
        if (health <= 0) {
            System.out.println("[Infantryman:" + name + "] has fallen!");
            return false;
        }
        return true;
    }

    @Override
    public void addShield() {
        // handled by proxy
    }

    @Override
    public void addSword() {
        // handled by proxy
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        visitor.visit(this);
    }

    public int getHealth() { return health; }
}
