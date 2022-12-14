import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Загрузка
        System.out.println("Добро пожаловать в Role Playing Game. Пожалуйста используйте ответы в нижнем регистре.");
        Scanner in = new Scanner(System.in);

        //Сама игра
        System.out.println("Введите свое имя: ");
        World.create(in.next());
        System.out.println("Отлично! Счастливых приключений, " + World.player.name + "!");

        boolean isExiting = false;
        while (!isExiting) {
            System.out.println("""
                    \nВы в городе. Перед вами три пути. Куда пойдете?
                    1. К торговцу
                    2. В тёмный лес
                    3. Проверить характеристики
                    4. Отдохнуть у костра
                    5. На выход""");

            switch (in.next()) {
                case "1" -> World.playerGoMerchant();
                case "2" -> {
                    System.out.println("Вы отправились в темный лес!");
                    do {
                        if (!World.playerGoKill()) {
                            isExiting = true;
                            System.out.println("Вы проиграли...");
                            break;
                        }
                        System.out.println("\nПродолжаем идти по темному лесу?");
                    } while (in.next().equals("да"));
                }
                case "3" -> System.out.println(World.player.toString());
                case "4" -> World.playerGoChill();
                case "5" -> isExiting = true;
                default -> System.out.println("Вы путаетесь в мыслях и не знаете куда пойти...");
            }
        }

        System.out.println("До скорых встреч!");
    }
}