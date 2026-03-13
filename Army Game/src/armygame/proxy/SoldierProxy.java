package armygame.proxy;

import armygame.core.Soldier;
import armygame.core.SoldierType;
import armygame.equipment.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * PROXY – Proxy Pattern (Phần 1.2)
 * Đóng vai trò trung gian bọc một Soldier, kiểm soát việc gắn trang bị:
 *   - Đảm bảo không trùng lặp trang bị (ràng buộc Phần 1.1.6)
 *   - Giao diện thêm trang bị rõ ràng: addShield(), addSword(), ...
 *   - Dễ mở rộng thêm loại trang bị mới mà không sửa code hiện tại
 *   - Delegate tất cả logic xuống chain trang bị (Decorator)
 */
public class SoldierProxy extends Soldier {

    private Soldier soldier;                     // đầu chain decorator
    private final Set<String>   equippedSet  = new HashSet<>();
    private final List<String>  equippedList = new ArrayList<>();

    public SoldierProxy(Soldier baseSoldier) {
        super(baseSoldier.getName(), baseSoldier.getHealth(), baseSoldier.getType());
        this.soldier = baseSoldier;
    }

    // ── Helper chung – kiểm tra trùng rồi wrap ────────────────────────────
    private boolean addEquipment(String name, Function<Soldier, ? extends Soldier> factory) {
        if (equippedSet.contains(name)) {
            System.out.printf("  [PROXY] %s đã có %s rồi! Không thể trang bị trùng.%n",
                    getName(), name);
            return false;
        }
        soldier = factory.apply(soldier);
        equippedSet.add(name);
        equippedList.add(name);
        System.out.printf("  [PROXY] Gắn %s lên %s thành công.%n", name, getName());
        return true;
    }

    // ── API trang bị (Phần 1.2) ───────────────────────────────────────────
    public boolean addShield()      { return addEquipment("Shield",      Shield::new); }
    public boolean addSword()       { return addEquipment("Sword",       Sword::new); }
    public boolean addSpear()       { return addEquipment("Spear",       Spear::new); }
    public boolean addArmor()       { return addEquipment("Armor",       Armor::new); }
    public boolean addRifle()       { return addEquipment("Rifle",       Rifle::new); }
    public boolean addGrenade()     { return addEquipment("Grenade",     Grenade::new); }
    public boolean addSteelHelmet() { return addEquipment("SteelHelmet", SteelHelmet::new); }
    public boolean addLaserSword()  { return addEquipment("LaserSword",  LaserSword::new); }
    public boolean addBioWeapon()   { return addEquipment("BioWeapon",   BioWeapon::new); }
    public boolean addNanoArmor()   { return addEquipment("NanoArmor",   NanoArmor::new); }

    // ── Delegate xuống chain ──────────────────────────────────────────────
    @Override public int getAttack()  { return soldier.getAttack(); }
    @Override public int getDefense() { return soldier.getDefense(); }
    @Override public int getHealth()  { return soldier.getHealth(); }
    @Override public SoldierType getType() { return soldier.getType(); }
    @Override public boolean isAlive()    { return soldier.isAlive(); }

    @Override
    public void takeDamage(int damage) {
        soldier.takeDamage(damage);
        this.health = soldier.getHealth();
    }

    @Override
    public String describe() {
        return soldier.describe();
    }

    // ── Thông tin trang bị ────────────────────────────────────────────────
    public List<String> getEquippedItems() { return new ArrayList<>(equippedList); }
    public boolean      hasEquipment(String name) { return equippedSet.contains(name); }
}

