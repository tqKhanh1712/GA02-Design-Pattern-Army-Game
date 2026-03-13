import armygame.game.GameMenu;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Entry point – Army Game
 * Chạy: javac -d out -sourcepath src src/Main.java && java -cp out Main
 * CMD: chcp 65001 để hiển thị tiếng Việt đúng
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // Thiết lập UTF-8 cho stdout & stderr
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));
        new GameMenu().start();
    }
}


