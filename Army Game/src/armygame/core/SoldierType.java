package armygame.core;

/**
 * Enum phân loại binh lính.
 * Dùng trong Visitor Pattern (CountVisitor) để đếm theo loại.
 */
public enum SoldierType {
    INFANTRY("Bộ Binh"),
    CAVALRY("Kỵ Binh");

    private final String displayName;

    SoldierType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

