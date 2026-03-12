package core;

// Abstract Decorator
public abstract class Equipment implements Soldier {
    protected Soldier wrapped;

    public Equipment(Soldier soldier) {
        this.wrapped = soldier;
    }

    public Soldier getWrapped() { return wrapped; }

    @Override
    public String getName() {
        return wrapped.getName();
    }

    @Override
    public int hit() {
        return wrapped.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        return wrapped.wardOff(strength);
    }

    @Override
    public void addShield() {
        wrapped.addShield();
    }

    @Override
    public void addSword() {
        wrapped.addSword();
    }

    @Override
    public void accept(visitor.SoldierVisitor visitor) {
        wrapped.accept(visitor);
    }
}
