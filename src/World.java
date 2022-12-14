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

    private static void playerLooting(Monster monster) {
        player.gainExperience(monster);
        player.earnGold(monster);
    }

    public static void playerGoMerchant() {
        System.out.println("""
                Добро пожаловать в мою лавку!
                Посмотри нам мои восстанавливающие зелья!
                Они восстанавливают половину здоровья и стоят всего 10 золота!
                Ну что берешь?""");

        Scanner in = new Scanner(System.in);
        Merchant merchant = new Merchant();
        if (in.next().equals("да")) {
            String answer;
            while (true) {
                System.out.println("Сколько возьмешь?");
                answer = in.next();
                try {
                    if (answer.equals("уйти")) break;
                    else if (merchant.sell(player, Integer.parseInt(answer))) {
                        System.out.println("Вот твои зелья. Счастливой дороги, путник!");
                        break;
                    }
                    else System.out.println("Не, так дела не пойдут... Ты всегда можешь 'уйти' и придти, когда у тебя будет золото.");
                } catch (NumberFormatException e) {
                    System.out.println("Торговец косо смотрит на вас.");
                }
            }
        }

        System.out.println("Вы уходите..");

        /*System.out.println("Торговца нет на месте. Ждем торговца?");
        Scanner in = new Scanner(System.in);
        while (in.next().equals("да")) {
            System.out.println("Прошло 5 минут... Ждем дальше?");
        }
        System.out.println("Вы уходите.");*/
    }

    public static void playerGoChill() {
        if (player.getAbilityPoints() != 0) {
            System.out.println("У вас есть нераспределенные очки способностей.");
            Scanner in = new Scanner(System.in);

            while (player.getAbilityPoints() != 0) {
                System.out.println("""
                    \nЧто вы желаете улучшить?
                    1. Здоровье +1
                    2. Сила +1
                    3. Ловкость +1
                    4. Я передумал""");
                player.spendAbilityPoints(in.next());
            }
        }

        player.setCurrentHealth(player.getFullHealth() - player.getCurrentHealth());
        System.out.println("Вы восполнили жизненные силы!");
    }

    private static Monster createMonster() {
        Random random = new Random();
        int fullHealthEnemy = random.nextInt(player.getFullHealth() / 2, player.getFullHealth());
        return new Monster(fullHealthEnemy,
                random.nextInt(fullHealthEnemy / 2, fullHealthEnemy),
                random.nextInt(player.getStrength() / 2, player.getStrength()),
                random.nextInt(player.getDexterity() / 2, player.getDexterity()),
                enemies[random.nextInt(2)],
                random.nextInt(1, fullHealthEnemy));
    }
}
