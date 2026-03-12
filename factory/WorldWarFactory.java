package factory;

import core.Soldier;
import equipment.Helmet;
import equipment.Rifle;
import proxy.SoldierProxy;
import units.Horseman;
import units.Infantryman;

// WorldWar era: rifle + helmet
public class WorldWarFactory implements SoldierFactory {

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
        // WorldWar primary = Rifle
        System.out.println("[WorldWarFactory] Equipping Rifle on " + soldier.getName());
        return new Rifle(soldier);
    }

    @Override
    public Soldier equipSecondary(Soldier soldier) {
        // WorldWar secondary = Helmet
        System.out.println("[WorldWarFactory] Equipping Helmet on " + soldier.getName());
        return new Helmet(soldier);
    }
}
