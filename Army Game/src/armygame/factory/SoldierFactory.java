package armygame.factory;

import armygame.proxy.SoldierProxy;

/**
 * ABSTRACT FACTORY – Abstract Factory Pattern (Phần 3.3)
 * Định nghĩa giao diện tạo binh lính tương thích với từng thế hệ.
 * Mỗi factory chỉ tạo binh lính với trang bị phù hợp thời đại của mình.
 * → Một binh lính Medieval không thể có LaserSword (SciFi).
 */
public interface SoldierFactory {

    /**
     * Tạo Bộ Binh kèm trang bị mặc định của thời đại.
     * @param name tên binh lính
     */
    SoldierProxy createInfantry(String name);

    /**
     * Tạo Kỵ Binh kèm trang bị mặc định của thời đại.
     * @param name tên binh lính
     */
    SoldierProxy createCavalry(String name);

    /** Tên thời đại (hiển thị trong menu, Army) */
    String getEraName();
}

