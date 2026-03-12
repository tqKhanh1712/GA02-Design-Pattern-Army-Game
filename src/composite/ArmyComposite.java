package composite;

import core.Soldier;
import visitor.SoldierVisitor;

import java.util.ArrayList;
import java.util.List;

// ArmyComposite: top-level army container (can contain Groups or individual Soldiers)
public class ArmyComposite implements Soldier {
    private String name;
    private List<Soldier> units = new ArrayList<>();

    public ArmyComposite(String name) {
        this.name = name;
    }

    public void add(Soldier s) { units.add(s); }
    public void remove(Soldier s) { units.remove(s); }
    public List<Soldier> getUnits() { return units; }

    @Override
    public String getName() { return name; }

    @Override
    public int hit() {
        int total = 0;
        for (Soldier s : units) total += s.hit();
        System.out.println("[Army:" + name + "] total hit() = " + total);
        return total;
    }

    @Override
    public boolean wardOff(int strength) {
        if (units.isEmpty()) return false;
        int share = Math.max(1, strength / units.size());
        List<Soldier> fallen = new ArrayList<>();
        for (Soldier s : units) {
            if (!s.wardOff(share)) fallen.add(s);
        }
        units.removeAll(fallen);
        return !units.isEmpty();
    }

    @Override
    public void addShield() {
        for (Soldier s : units) s.addShield();
    }

    @Override
    public void addSword() {
        for (Soldier s : units) s.addSword();
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        for (Soldier s : units) s.accept(visitor);
    }
}
