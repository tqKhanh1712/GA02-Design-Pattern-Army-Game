package armygame.core;

/**
 * COMPONENT – Decorator Pattern (Phần 1)
 * Lớp trừu tượng đại diện cho mọi binh lính (có hoặc chưa có trang bị).
 * Cũng đóng vai trò Leaf-wrappee trong Composite Pattern (Phần 2).
 */
public abstract class Soldier {

    protected String name;
    protected int health;
    protected int maxHealth;
    protected SoldierType type;

    public Soldier(String name, int health, SoldierType type) {
        this.name      = name;
        this.health    = health;
        this.maxHealth = health;
        this.type      = type;
    }

    // ── Core stats (overridden by decorators) ──────────────────────────────
    public abstract int getAttack();
    public abstract int getDefense();

    // ── Description (overridden by decorators to show full chain) ──────────
    public abstract String describe();

    // ── Common behaviour ───────────────────────────────────────────────────
    public void takeDamage(int damage) {
        int actual = Math.max(0, damage - getDefense());
        health     = Math.max(0, health - actual);
        System.out.printf("  [%s] nhận %d sát thương (thực tế: %d), HP còn lại: %d%n",
                name, damage, actual, health);
    }

    public boolean isAlive() {
        return health > 0;
    }

    // ── Getters ────────────────────────────────────────────────────────────
    public String      getName()    { return name; }
    public int         getHealth()  { return health; }
    public int         getMaxHealth() { return maxHealth; }
    public SoldierType getType()    { return type; }
}

