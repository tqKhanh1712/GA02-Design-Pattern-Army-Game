package factory;

import core.Soldier;

// Abstract Factory: defines creation of era-specific soldiers and equipment
public interface SoldierFactory {
    Soldier createInfantryman(String name);
    Soldier createHorseman(String name);
    // Each era equips soldiers differently
    Soldier equipPrimary(Soldier soldier);   // primary weapon (sword/rifle/laser)
    Soldier equipSecondary(Soldier soldier); // secondary item (shield/grenade/nano-armor)
}
