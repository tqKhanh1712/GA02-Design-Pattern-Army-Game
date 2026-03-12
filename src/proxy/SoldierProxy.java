package proxy;

import core.Soldier;
import equipment.Shield;
import equipment.Sword;
import visitor.SoldierVisitor;

// Proxy: controls equipment addition, prevents duplicate equipment
public class SoldierProxy implements Soldier {
    private Soldier soldier;
    private boolean hasShield = false;
    private boolean hasSword = false;

    public SoldierProxy(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public String getName() { return soldier.getName(); }

    @Override
    public int hit() { return soldier.hit(); }

    @Override
    public boolean wardOff(int strength) { return soldier.wardOff(strength); }

    @Override
    public void addShield() {
        if (hasShield) {
            System.out.println("[Proxy] " + soldier.getName() + " already has a shield!");
        } else {
            soldier = new Shield(soldier);
            hasShield = true;
            System.out.println("[Proxy] Shield added to " + soldier.getName());
        }
    }

    @Override
    public void addSword() {
        if (hasSword) {
            System.out.println("[Proxy] " + soldier.getName() + " already has a sword!");
        } else {
            soldier = new Sword(soldier);
            hasSword = true;
            System.out.println("[Proxy] Sword added to " + soldier.getName());
        }
    }

    // Generic method to support adding new equipment types without changing existing code
    public void addEquipment(java.util.function.Function<Soldier, Soldier> equipmentFactory, String equipmentType) {
        soldier = equipmentFactory.apply(soldier);
        System.out.println("[Proxy] " + equipmentType + " added to " + getName());
    }

    public boolean hasShield() { return hasShield; }
    public boolean hasSword() { return hasSword; }

    @Override
    public void accept(SoldierVisitor visitor) {
        soldier.accept(visitor);
    }
}
