package armygame.factory;

import armygame.proxy.SoldierProxy;
import armygame.units.Infantry;
import armygame.units.Cavalry;

/**
 * CONCRETE FACTORY – Medieval (Trung Cổ)
 * Trang bị được phép: Sword, Spear, Shield, Armor, SteelHelmet
 *
 * Bộ Binh  → Sword + Shield + Armor
 * Kỵ Binh  → Spear + SteelHelmet
 */
public class MedievalFactory implements SoldierFactory {

    @Override
    public String getEraName() { return "Medieval"; }

    @Override
    public SoldierProxy createInfantry(String name) {
        SoldierProxy proxy = new SoldierProxy(new Infantry(name));
        proxy.addSword();
        proxy.addShield();
        proxy.addArmor();
        return proxy;
    }

    @Override
    public SoldierProxy createCavalry(String name) {
        SoldierProxy proxy = new SoldierProxy(new Cavalry(name));
        proxy.addSpear();
        proxy.addSteelHelmet();
        return proxy;
    }
}

