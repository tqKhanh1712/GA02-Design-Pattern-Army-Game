package composite;

import core.Soldier;
import observer.Subject;
import visitor.SoldierVisitor;

import java.util.ArrayList;
import java.util.List;

// Composite: represents a group/army of soldiers
public class Group implements Soldier {
    private String name;
    private List<Soldier> members = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void add(Soldier soldier) {
        members.add(soldier);
    }

    public void remove(Soldier soldier) {
        members.remove(soldier);
    }

    public List<Soldier> getMembers() { return members; }

    @Override
    public String getName() { return name; }

    // Total attack = sum of all members
    @Override
    public int hit() {
        int total = 0;
        for (Soldier s : members) {
            total += s.hit();
        }
        System.out.println("[Group:" + name + "] total hit() = " + total);
        return total;
    }

    // Defense: split damage equally among members, remove fallen soldiers
    @Override
    public boolean wardOff(int strength) {
        if (members.isEmpty()) return false;
        int share = Math.max(1, strength / members.size());
        System.out.println("[Group:" + name + "] wardOff(" + strength + ") -> each member receives " + share);
        List<Soldier> fallen = new ArrayList<>();
        for (Soldier s : members) {
            boolean alive = s.wardOff(share);
            if (!alive) {
                fallen.add(s);
                Subject.getInstance().notifyObservers(s.getName());
            }
        }
        members.removeAll(fallen);
        return !members.isEmpty();
    }

    // Add equipment to all members
    @Override
    public void addShield() {
        for (Soldier s : members) s.addShield();
    }

    @Override
    public void addSword() {
        for (Soldier s : members) s.addSword();
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        visitor.visit(this);
    }
}
