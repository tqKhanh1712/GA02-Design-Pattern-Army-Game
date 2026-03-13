package armygame.composite;

import armygame.visitor.UnitVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * TOP-LEVEL COMPOSITE – Composite Pattern (Phần 2.1)
 * Quân đội: mở rộng từ Group, thêm tiện ích lấy danh sách leaf để dùng trong Battle/Observer.
 */
public class Army extends Group {

    private String eraName;   // Thế hệ (Medieval / WorldWar / SciFi) – dùng cho Factory

    public Army(String name, String eraName) {
        super(name);
        this.eraName = eraName;
    }

    public String getEraName() { return eraName; }

    /**
     * Lấy toàn bộ SoldierLeaf còn sống (flatten cây đệ quy).
     * Dùng trong Battle để tính lượt tấn công / Observer.
     */
    public List<SoldierLeaf> getAliveLeaves() {
        List<SoldierLeaf> result = new ArrayList<>();
        collectLeaves(this, result);
        return result;
    }

    /** Lấy TẤT CẢ leaf (kể cả đã chết) – dùng để hiển thị. */
    public List<SoldierLeaf> getAllLeaves() {
        List<SoldierLeaf> result = new ArrayList<>();
        collectAllLeaves(this, result);
        return result;
    }

    private void collectLeaves(Group group, List<SoldierLeaf> result) {
        for (MilitaryUnit unit : group.getMembers()) {
            if (unit instanceof SoldierLeaf leaf) {
                if (leaf.hasAliveMembers()) result.add(leaf);
            } else if (unit instanceof Group subGroup) {
                collectLeaves(subGroup, result);
            }
        }
    }

    private void collectAllLeaves(Group group, List<SoldierLeaf> result) {
        for (MilitaryUnit unit : group.getMembers()) {
            if (unit instanceof SoldierLeaf leaf) {
                result.add(leaf);
            } else if (unit instanceof Group subGroup) {
                collectAllLeaves(subGroup, result);
            }
        }
    }

    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visit(this);
        members.forEach(m -> m.accept(visitor));
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "╔═ [QUÂN ĐỘI] " + name
                + " (" + eraName + ") | " + getMemberCount() + " binh sĩ");
        members.forEach(m -> m.display(indent + "║  "));
    }
}

