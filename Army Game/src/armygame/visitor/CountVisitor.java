package armygame.visitor;

import armygame.composite.Army;
import armygame.composite.Group;
import armygame.composite.SoldierLeaf;
import armygame.core.SoldierType;

/**
 * CONCRETE VISITOR 2 – Visitor Pattern (Phần 2.2)
 * Đếm số lượng Bộ Binh và Kỵ Binh trong toàn quân đội.
 * Chỉ tính tại SoldierLeaf, bỏ qua Group/Army.
 */
public class CountVisitor implements UnitVisitor {

    private int infantryCount = 0;
    private int cavalryCount  = 0;

    @Override
    public void visit(SoldierLeaf leaf) {
        if (leaf.getSoldier().getType() == SoldierType.INFANTRY) {
            infantryCount++;
        } else {
            cavalryCount++;
        }
    }

    @Override public void visit(Group group) { /* không đếm ở node */ }
    @Override public void visit(Army army)   { /* không đếm ở node */ }

    // ── Getters ────────────────────────────────────────────────────────────
    public int getInfantryCount() { return infantryCount; }
    public int getCavalryCount()  { return cavalryCount; }
    public int getTotalCount()    { return infantryCount + cavalryCount; }

    public void reset() {
        infantryCount = 0;
        cavalryCount  = 0;
    }

    public void printReport() {
        System.out.println("=== Thống kê binh lính ===");
        System.out.println("  Bộ Binh  : " + infantryCount);
        System.out.println("  Kỵ Binh  : " + cavalryCount);
        System.out.println("  Tổng cộng: " + getTotalCount());
    }
}

