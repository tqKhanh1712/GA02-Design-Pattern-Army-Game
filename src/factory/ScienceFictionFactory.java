package factory;

import core.Soldier;
import equipment.LaserSword;
import equipment.NanoArmor;
import proxy.SoldierProxy;
import units.Horseman;
import units.Infantryman;

// ScienceFiction era: laser sword + nano armor
public class ScienceFictionFactory implements SoldierFactory {

    @Override
    public Soldier createInfantryman(String name) {
        return new SoldierProxy(new Infantryman(name));
    }

    @Override
    public Soldier createHorseman(String name) {
        return new SoldierProxy(new Horseman(name));
    }

    @Override
    public Soldier equipPrimary(Soldier soldier) {
        // SciFi primary = LaserSword
        System.out.println("[ScienceFictionFactory] Equipping LaserSword on " + soldier.getName());
        return new LaserSword(soldier);
    }

    @Override
    public Soldier equipSecondary(Soldier soldier) {
        // SciFi secondary = NanoArmor
        System.out.println("[ScienceFictionFactory] Equipping NanoArmor on " + soldier.getName());
        return new NanoArmor(soldier);
    }
}
