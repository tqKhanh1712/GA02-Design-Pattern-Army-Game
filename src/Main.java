import composite.ArmyComposite;
import composite.Group;
import core.Soldier;
import factory.MedievalFactory;
import factory.ScienceFictionFactory;
import factory.SoldierFactory;
import factory.WorldWarFactory;
import observer.DeathCountObserver;
import observer.DeathNotifierObserver;
import observer.Subject;
import proxy.SoldierProxy;
import units.Infantryman;
import visitor.CountVisitor;
import visitor.DisplayVisitor;

public class Main {

    public static void main(String[] args) {
        // =====================================================================
        // PART 1 – Decorator & Proxy
        // =====================================================================
        System.out.println("=== PART 1: Decorator & Proxy ===\n");

        Infantryman raw = new Infantryman("Alice");
        SoldierProxy alice = new SoldierProxy(raw);
        alice.addShield();
        alice.addShield(); // duplicate – proxy blocks it
        alice.addSword();

        System.out.println("\n-- Alice attacks --");
        int attack = alice.hit();
        System.out.println("Total attack: " + attack);

        System.out.println("\n-- Alice defends against strength=20 --");
        alice.wardOff(20);

        // =====================================================================
        // PART 2 – Composite & Visitor
        // =====================================================================
        System.out.println("\n=== PART 2: Composite & Visitor ===\n");

        // Register observers before any battle so deaths are tracked
        Subject subject = Subject.getInstance();
        DeathCountObserver deathCounter = DeathCountObserver.getInstance();
        DeathNotifierObserver deathNotifier = DeathNotifierObserver.getInstance();
        subject.addObserver(deathCounter);
        subject.addObserver(deathNotifier);

        // Build Army A (Medieval)
        SoldierFactory medievalFactory = new MedievalFactory();
        Soldier a1 = medievalFactory.createInfantryman("Bob");
        Soldier a2 = medievalFactory.createHorseman("Charlie");
        medievalFactory.equipPrimary(a1);
        medievalFactory.equipSecondary(a1);
        medievalFactory.equipPrimary(a2);

        Group groupA = new Group("Alpha Squad");
        groupA.add(a1);
        groupA.add(a2);

        // Build Army B (ScienceFiction)
        SoldierFactory scifiFactory = new ScienceFictionFactory();
        Soldier b1 = scifiFactory.createInfantryman("Xeno");
        Soldier b2 = scifiFactory.createHorseman("Nova");
        b1 = scifiFactory.equipPrimary(b1);
        b1 = scifiFactory.equipSecondary(b1);
        b2 = scifiFactory.equipPrimary(b2);

        Group groupB = new Group("Beta Squad");
        groupB.add(b1);
        groupB.add(b2);

        ArmyComposite armyA = new ArmyComposite("Medieval Army");
        armyA.add(groupA);

        ArmyComposite armyB = new ArmyComposite("SciFi Army");
        armyB.add(groupB);

        // DisplayVisitor
        System.out.println("-- DisplayVisitor: Army A --");
        DisplayVisitor display = new DisplayVisitor();
        armyA.accept(display);

        System.out.println("\n-- CountVisitor: Army A --");
        CountVisitor counter = new CountVisitor();
        armyA.accept(counter);
        counter.printSummary();

        // =====================================================================
        // PART 3 – Battle with Observer + WorldWar Factory
        // =====================================================================
        System.out.println("\n=== PART 3: Battle Simulation ===\n");

        // WorldWar army
        SoldierFactory wwFactory = new WorldWarFactory();
        Soldier w1 = wwFactory.createInfantryman("Fritz");
        Soldier w2 = wwFactory.createHorseman("Hans");
        w1 = wwFactory.equipPrimary(w1);
        w1 = wwFactory.equipSecondary(w1);
        w2 = wwFactory.equipPrimary(w2);

        Group wwGroup = new Group("WWI Squad");
        wwGroup.add(w1);
        wwGroup.add(w2);

        System.out.println("\n-- Battle: Alpha Squad (Medieval) vs WWI Squad --");
        int round = 1;
        while (!groupA.getMembers().isEmpty() && !wwGroup.getMembers().isEmpty()) {
            System.out.println("\n--- Round " + round++ + " ---");
            int atkA = groupA.hit();
            int atkB = wwGroup.hit();
            System.out.println("Alpha attacks WWI with " + atkA);
            boolean wwAlive = wwGroup.wardOff(atkA);
            System.out.println("WWI attacks Alpha with " + atkB);
            boolean alphaAlive = groupA.wardOff(atkB);
            if (!wwAlive) { System.out.println("WWI Squad eliminated!"); break; }
            if (!alphaAlive) { System.out.println("Alpha Squad eliminated!"); break; }
            if (round > 10) { System.out.println("Battle draw after 10 rounds!"); break; }
        }

        System.out.println("\n-- Final death count: " + deathCounter.getDeathCount() + " --");
    }
}
