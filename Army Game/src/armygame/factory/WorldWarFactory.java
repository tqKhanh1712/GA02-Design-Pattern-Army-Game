package armygame.factory;

import armygame.proxy.SoldierProxy;
import armygame.units.Infantry;
import armygame.units.Cavalry;

/**
 * CONCRETE FACTORY – World War (Thế Chiến)
 * Trang bị được phép: Rifle, Grenade, Armor, SteelHelmet, Shield
 *
 * Bộ Binh  → Rifle + Grenade + Armor
 * Kỵ Binh  → Rifle + SteelHelmet + Shield
 */
public class WorldWarFactory implements SoldierFactory {

    @Override
    public String getEraName() { return "WorldWar"; }

    @Override
    public SoldierProxy createInfantry(String name) {
        SoldierProxy proxy = new SoldierProxy(new Infantry(name));
        proxy.addRifle();
        proxy.addGrenade();
        proxy.addArmor();
        return proxy;
    }

    @Override
    public SoldierProxy createCavalry(String name) {
        SoldierProxy proxy = new SoldierProxy(new Cavalry(name));
        proxy.addRifle();
        proxy.addSteelHelmet();
        proxy.addShield();
        return proxy;
    }
}

