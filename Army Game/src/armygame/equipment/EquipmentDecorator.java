package armygame.equipment;

import armygame.core.Soldier;
import armygame.core.SoldierType;

/**
 * ABSTRACT DECORATOR – Decorator Pattern (Phần 1.1)
 * Bọc một Soldier và thêm trang bị lên trên.
 * Cơ chế hao mòn (Phần 1.3) được xử lý trong lớp này:
 *   - Mỗi lần takeDamage() gọi degrade() → giảm durability
 *   - Khi durability <= 0, trang bị coi như hỏng → bonus = 0
 *   - Hoàn toàn trong suốt với code bên ngoài (không cần biết trang bị đang hao mòn)
 */
public abstract class EquipmentDecorator extends Soldier {

    protected Soldier wrapped;      // đối tượng được bọc
    protected int durability;       // độ bền hiện tại
    protected int maxDurability;    // độ bền tối đa

    public EquipmentDecorator(Soldier wrapped, int durability) {
        super(wrapped.getName(), wrapped.getHealth(), wrapped.getType());
        this.wrapped      = wrapped;
        this.durability   = durability;
        this.maxDurability = durability;
    }

    // ── Tên trang bị (mỗi decorator cụ thể tự đặt) ───────────────────────
    public abstract String getEquipmentName();

    // ── Hao mòn (Phần 1.3) – trong suốt với bên ngoài ────────────────────
    protected void degrade() {
        if (durability > 0) {
            durability--;
            if (durability == 0) {
                System.out.printf("  [HAO MÒN] %s của %s đã hỏng hoàn toàn!%n",
                        getEquipmentName(), name);
            }
        }
    }

    public boolean isWorn()        { return durability <= 0; }
    public int     getDurability() { return durability; }
    public int     getMaxDurability() { return maxDurability; }

    // ── Delegate các getter cơ bản xuống wrapped ──────────────────────────
    @Override
    public int getHealth() { return wrapped.getHealth(); }

    @Override
    public SoldierType getType() { return wrapped.getType(); }

    @Override
    public boolean isAlive() { return wrapped.isAlive(); }

    // ── takeDamage kích hoạt hao mòn ─────────────────────────────────────
    @Override
    public void takeDamage(int damage) {
        degrade();                    // hao mòn trang bị (trong suốt)
        wrapped.takeDamage(damage);   // truyền xuống chain
        // sync lại health field để isAlive() trên lớp này cũng đúng
        this.health = wrapped.getHealth();
    }

    // ── describe hiển thị toàn bộ chain ──────────────────────────────────
    @Override
    public String describe() {
        String wornTag = isWorn() ? " [HỎng]" : String.format(" [%d/%d]", durability, maxDurability);
        return wrapped.describe() + " + " + getEquipmentName() + wornTag;
    }
}

