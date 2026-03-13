package armygame.factory;

import armygame.proxy.SoldierProxy;
import armygame.units.Infantry;
import armygame.units.Cavalry;

/**
 * CONCRETE FACTORY – Sci-Fi (Khoa Học Viễn Tưởng)
 * Trang bị được phép: LaserSword, BioWeapon, NanoArmor
 *
 * Bộ Binh  → BioWeapon + NanoArmor
 * Kỵ Binh  → LaserSword + NanoArmor
 */
public class SciFiFactory implements SoldierFactory {

    @Override
    public String getEraName() { return "Sci-Fi"; }

    @Override
    public SoldierProxy createInfantry(String name) {
        SoldierProxy proxy = new SoldierProxy(new Infantry(name));
        proxy.addBioWeapon();
        proxy.addNanoArmor();
        return proxy;
    }

    @Override
    public SoldierProxy createCavalry(String name) {
        SoldierProxy proxy = new SoldierProxy(new Cavalry(name));
        proxy.addLaserSword();
        proxy.addNanoArmor();
        return proxy;
    }
}

