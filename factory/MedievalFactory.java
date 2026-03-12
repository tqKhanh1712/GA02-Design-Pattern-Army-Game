package factory;

import core.Soldier;
import proxy.SoldierProxy;
import units.Horseman;
import units.Infantryman;

// Medieval era: sword + shield
public class MedievalFactory implements SoldierFactory {

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
        // Medieval primary = Sword
        soldier.addSword();
        return soldier;
    }

    @Override
    public Soldier equipSecondary(Soldier soldier) {
        // Medieval secondary = Shield
        soldier.addShield();
        return soldier;
    }
}
