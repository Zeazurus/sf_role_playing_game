import java.util.Random;
import java.util.Scanner;

public class World {
    public static Player player;
    private final static String[] enemies = new String[] { "Гоблин", "Скелет" };

    public static void create(String name) {
        player = new Player(10, 2, 5, name);

        System.out.println("Мир создан!");
    }

    public static boolean playerGoKill() {
        Monster enemy = createMonster();

        if (player.equals(Battle.fight(player, enemy))) {
            playerLooting(enemy);
            /*System.out.println("ВЫ ВЫИГРАЛИ!\nВАШИ ХАРАКТЕРИСТИКИ ПОСЛЕ БОЯ\n" +
                                player.toString());*/
            return true;
        }
        else {
            /*System.out.println("ИГРА ОКОНЧЕНА\nВАС ПОБЕДИЛ\n" +
                                enemy.toString());*/
            return false;
        }
    }

    public static void playerGoMerchant() {
        System.out.println("Торговца нет на месте. Ждем торговца?");
        Scanner in = new Scanner(System.in);
        while (in.next().equals("да")) {
            System.out.println("Прошло 5 минут... Ждем дальше?");
        }
        System.out.println("Вы уходите.");
    }

    private static Monster createMonster() {
        Random random = new Random();
        int fullHealthEnemy = random.nextInt(player.fullHealth / 2, player.fullHealth);
        return new Monster(fullHealthEnemy,
                random.nextInt(fullHealthEnemy / 2, fullHealthEnemy),
                random.nextInt(player.strength / 2, player.strength),
                random.nextInt(player.dexterity / 2, player.dexterity),
                enemies[random.nextInt(2)],
                random.nextInt(1, fullHealthEnemy));
    }

    private static void playerLooting(Monster monster) {
        player.setExperience(monster);
        player.setGold(monster);
    }
}
