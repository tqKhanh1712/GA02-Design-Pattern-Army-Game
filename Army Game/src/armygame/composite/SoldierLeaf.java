package armygame.composite;

import armygame.core.Soldier;
import armygame.proxy.SoldierProxy;
import armygame.visitor.UnitVisitor;

/**
 * LEAF – Composite Pattern (Phần 2.1)
 * Đại diện cho một binh lính đơn lẻ trong cây composite.
 * Bọc một SoldierProxy để tận dụng cả Decorator + Proxy từ Phần 1.
 */
public class SoldierLeaf implements MilitaryUnit {

    private final SoldierProxy soldier;

    public SoldierLeaf(SoldierProxy soldier) {
        this.soldier = soldier;
    }

    // ── MilitaryUnit ──────────────────────────────────────────────────────
    @Override public String getName()       { return soldier.getName(); }
    @Override public int    getAttack()     { return soldier.getAttack(); }
    @Override public int    getMemberCount(){ return 1; }
    @Override public boolean hasAliveMembers() { return soldier.isAlive(); }

    @Override
    public void defend(int totalDamage) {
        // Leaf nhận toàn bộ sát thương (không chia)
        soldier.takeDamage(totalDamage);
    }

    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "├─ " + soldier.describe()
                + (soldier.isAlive() ? "" : " [CHẾT]"));
    }

    // ── Truy cập Soldier bên trong ────────────────────────────────────────
    public SoldierProxy getSoldier() { return soldier; }
}

