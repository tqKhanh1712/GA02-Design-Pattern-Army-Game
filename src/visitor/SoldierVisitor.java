package visitor;

import units.Infantryman;
import units.Horseman;
import equipment.Shield;
import equipment.Sword;
import composite.Group;

public interface SoldierVisitor {
    void visit(Infantryman infantryman);
    void visit(Horseman horseman);
    void visitShield(Shield shield);
    void visitSword(Sword sword);
    void visit(Group group);
}
