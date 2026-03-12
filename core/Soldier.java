package core;

public interface Soldier {
    String getName();
    int hit();
    boolean wardOff(int strength);
    void addShield();
    void addSword();
    void accept(visitor.SoldierVisitor visitor);
}
