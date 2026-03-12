package visitor;

import units.Infantryman;
import units.Horseman;
import equipment.Shield;
import equipment.Sword;
import composite.Group;

// Visitor: counts infantrymen and horsemen in an army
public class CountVisitor implements SoldierVisitor {
    private int infantryCount = 0;
    private int horsemanCount = 0;

    @Override
    public void visit(Infantryman infantryman) {
        infantryCount++;
    }

    @Override
    public void visit(Horseman horseman) {
        horsemanCount++;
    }

    @Override
    public void visitShield(Shield shield) {
        shield.getWrapped().accept(this);
    }

    @Override
    public void visitSword(Sword sword) {
        sword.getWrapped().accept(this);
    }

    @Override
    public void visit(Group group) {
        for (core.Soldier s : group.getMembers()) {
            s.accept(this);
        }
    }

    public int getInfantryCount() { return infantryCount; }
    public int getHorsemanCount() { return horsemanCount; }

    public void printSummary() {
        System.out.println("Infantry count: " + infantryCount);
        System.out.println("Horseman count: " + horsemanCount);
        System.out.println("Total soldiers: " + (infantryCount + horsemanCount));
    }
}
