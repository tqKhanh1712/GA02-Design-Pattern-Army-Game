package visitor;

import units.Infantryman;
import units.Horseman;
import equipment.Shield;
import equipment.Sword;
import composite.Group;

// Visitor: displays all members in an army
public class DisplayVisitor implements SoldierVisitor {
    private String indent = "";

    @Override
    public void visit(Infantryman infantryman) {
        System.out.println(indent + "[Infantryman] " + infantryman.getName()
                + " | HP=" + infantryman.getHealth());
    }

    @Override
    public void visit(Horseman horseman) {
        System.out.println(indent + "[Horseman] " + horseman.getName()
                + " | HP=" + horseman.getHealth());
    }

    @Override
    public void visitShield(Shield shield) {
        System.out.println(indent + "  +[Shield] durability=" + shield.getDurability());
        shield.getWrapped().accept(this);
    }

    @Override
    public void visitSword(Sword sword) {
        System.out.println(indent + "  +[Sword] durability=" + sword.getDurability());
        sword.getWrapped().accept(this);
    }

    @Override
    public void visit(Group group) {
        System.out.println(indent + "[Group] " + group.getName() + " (" + group.getMembers().size() + " members):");
        String prevIndent = indent;
        indent += "  ";
        for (core.Soldier s : group.getMembers()) {
            s.accept(this);
        }
        indent = prevIndent;
    }
}
