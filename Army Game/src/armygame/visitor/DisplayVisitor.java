package armygame.visitor;

import armygame.composite.Army;
import armygame.composite.Group;
import armygame.composite.SoldierLeaf;
import armygame.proxy.SoldierProxy;

/**
 * CONCRETE VISITOR 1 – Visitor Pattern (Phần 2.2)
 * In ra danh sách toàn bộ thành viên trong quân đội:
 *   tên, loại, HP, ATK, DEF, danh sách trang bị.
 */
public class DisplayVisitor implements UnitVisitor {

    private int depth = 0;

    private String indent() { return "  ".repeat(depth); }

    @Override
    public void visit(Army army) {
        System.out.println(indent() + "╔══ QUÂN ĐỘI: " + army.getName()
                + " [" + army.getEraName() + "] ══╗");
        System.out.println(indent() + "   Tổng binh sĩ: " + army.getMemberCount()
                + " | Tổng ATK: " + army.getAttack());
        depth++;
        // children visited via composite.accept recursion
    }

    @Override
    public void visit(Group group) {
        System.out.println(indent() + "┌─ Nhóm: " + group.getName()
                + " (" + group.getMemberCount() + " người | ATK: " + group.getAttack() + ")");
        depth++;
    }

    @Override
    public void visit(SoldierLeaf leaf) {
        SoldierProxy s = leaf.getSoldier();
        String status  = s.isAlive() ? "SỐNG" : "CHẾT";
        System.out.printf("%s├─ [%s] %s | HP: %d | ATK: %d | DEF: %d | Trang bị: %s%n",
                indent(),
                s.getType().getDisplayName(),
                s.getName(),
                s.getHealth(),
                s.getAttack(),
                s.getDefense(),
                s.getEquippedItems().isEmpty() ? "(không có)" : String.join(", ", s.getEquippedItems())
        );
    }
}

