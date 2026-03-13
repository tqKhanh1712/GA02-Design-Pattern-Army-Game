package armygame.composite;

import armygame.visitor.UnitVisitor;

/**
 * COMPONENT – Composite Pattern (Phần 2.1)
 * Interface chung cho cả binh lính đơn lẻ (Leaf) lẫn nhóm/quân đội (Composite).
 * Cho phép xử lý thống nhất toàn bộ cấu trúc phân cấp.
 */
public interface MilitaryUnit {

    /** Tên đơn vị */
    String getName();

    /** Tổng sức mạnh tấn công của đơn vị (= tổng tất cả thành viên với composite) */
    int getAttack();

    /**
     * Phòng thủ: nhận tổng sát thương, chia đều cho mỗi thành viên còn sống.
     * @param totalDamage tổng lượng sát thương nhận vào
     */
    void defend(int totalDamage);

    /** Số lượng binh lính (đệ quy xuống toàn bộ cây) */
    int getMemberCount();

    /** Kiểm tra còn binh lính sống không */
    boolean hasAliveMembers();

    /** Cho phép Visitor duyệt (Phần 2.2) */
    void accept(UnitVisitor visitor);

    /** In cấu trúc ra console với indent */
    void display(String indent);
}

