import java.util.Random;

public class Battle {
    public static Entity fight(Entity attacker, Entity defender) {
        var lambdaContext = new Object() {
            Entity winner = null;
        };

        Entity[] entities = new Entity[] { attacker, defender };
        //getFightInfo(entities);

        System.out.println("БОЙ НАЧИНАЕТСЯ");
        Runnable runnable = () -> {
            for (int firstEntity = 0; ; firstEntity++) {
                firstEntity %= 2;
                int secondEntity = (firstEntity + 1) % 2;

                lambdaContext.winner = makeHit(entities[firstEntity], entities[secondEntity]);
                if (lambdaContext.winner != null) {
                    System.out.println("\nБОЙ ОКОНЧЕН!\n");
                    break;
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        /*while(attacker.getCurrentHealth() >= 0 || defender.getCurrentHealth() >= 0)
        {
            //Игрок нападает на Монстра
            System.out.println("Нападаем на Монстра");
            if (doDodge(defender.dexterity)) {
                //Пока не попадем по Монстру, мы не узнаем сколько у него здоровья
                System.out.println("Монстр уклонился!");
            }
            else {
                if (defender.setCurrentHealth(defender.getCurrentHealth() - attacker.strength))
                    System.out.println("У монстра осталось " + defender.getCurrentHealth() + " здоровья!");
                else {
                    winner = attacker;
                    break;
                }
            }

            //Монстр нападает на игрока
            System.out.println("Монстр атакует вас!");
            if (doDodge(attacker.dexterity)) {
                //Пока не попадем по Монстру, мы не узнаем сколько у него здоровья
                System.out.println("Вы уклонились!");
            }
            else {
                if (attacker.setCurrentHealth(attacker.getCurrentHealth() - defender.strength))
                    System.out.println("У вас осталось " + attacker.getCurrentHealth() + " здоровья!");
                else {
                    winner = defender;
                    break;
                }
            }
        }*/

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return lambdaContext.winner;
    }

    private static Entity makeHit(Entity attacker, Entity defender) {
        //Удар
        System.out.println(attacker.name + " нападает на " + defender.name);
        if (doDodge(defender.dexterity)) {
            //Пока не попадем по Монстру, мы не узнаем сколько у него здоровья
            System.out.println(defender.name + " уклонился!");
        }
        //Подведение итогов
        else {
            System.out.println("И наносит " + attacker.strength + " урона!");
            if (defender.setCurrentHealth(defender.getCurrentHealth() - attacker.strength)) {
                System.out.println("У " + defender.name + " осталось " + defender.getCurrentHealth() + " здоровья!");
            }
            else {
                return attacker;
            }
        }

        return null;
    }

    private static boolean doDodge(int dexterity) {
        Random random = new Random();
        return dexterity * 3 > random.nextInt(100);
    }

    /*private static void getFightInfo(Entity[] entities) {
        System.out.println("ИНФОРМАЦИЯ ПЕРЕД БОЕМ");
        for (Entity entity : entities) {
            getEntityInfo(entity);
        }
    }*/

    /*private static void getEntityInfo(Entity entity) {
        System.out.println(entity.toString());
    }*/
}
