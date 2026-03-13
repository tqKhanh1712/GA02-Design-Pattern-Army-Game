package armygame.visitor;

import armygame.composite.Army;
import armygame.composite.Group;
import armygame.composite.SoldierLeaf;

/**
 * VISITOR interface – Visitor Pattern (Phần 2.2)
 * Định nghĩa các phương thức visit cho từng loại node trong cây Composite.
 * Thêm chức năng mới (new Visitor) mà không cần sửa các lớp MilitaryUnit.
 */
public interface UnitVisitor {
    void visit(SoldierLeaf leaf);
    void visit(Group group);
    void visit(Army army);
}

