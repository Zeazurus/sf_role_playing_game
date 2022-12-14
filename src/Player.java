import java.util.Objects;

public class Player extends Entity {
    private int gold = 0, healPotions = 0;

    public Player(int fullHealth, int strength, int dexterity, String name) {
        super(fullHealth, fullHealth, strength, dexterity, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return gold == player.gold && healPotions == player.healPotions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gold, healPotions);
    }

    @Override
    public String toString() {
        return "========================================" +
                "\nИГРОК" +
                "\nЗолото " + gold +
                "\nЗелья лечения " + healPotions +
                super.toString();
    }

    @Override
    public boolean setCurrentHealth(int currentHealth) {
        if (this.getCurrentHealth() + currentHealth <= 0) System.out.println("Вы умерли.");
        else if (currentHealth > 0) System.out.println("Востановлено " + currentHealth + " здоровья!");

        return super.setCurrentHealth(currentHealth);
    }

    //Прокачка
    public void gainExperience(Monster monster) {
        int gainedExperience = monster.getFullHealth() + monster.getStrength() + monster.getDexterity();
        System.out.println("Вы получили опыта - " + gainedExperience);
        this.setExperience(gainedExperience);
    }

    public void spendAbilityPoints(String stats) {
        switch (stats) {
            case "1" -> {
                setFullHealth(1, false);
                System.out.println("Вы улучшили свой запас жизни до " + getFullHealth() + " единиц!");
            }
            case "2" -> {
                setStrength(1, false);
                System.out.println("Вы улучшили свою силу до " + getStrength() + " единиц!");
            }
            case "3" -> {
                setDexterity(1, false);
                System.out.println("Вы улучшили свою ловкость до " + getDexterity() + " единиц!");
            }
            default -> System.out.println("Вы не можете совладать с разумом.");
        }
    }

    //Золото
    public void earnGold(Monster monster) {
        this.gold += monster.bounty;
        System.out.println("Вы заработали золота - " + monster.bounty);
    }

    public void spendGold(int gold) {
        this.gold -= gold;
        System.out.println("Вы потратили золота - " + gold);
    }

    public int getGold() {
        return gold;
    }

    //Зелья
    public int getHealPotions() {
        return healPotions;
    }

    public void setHealPotions(int healPotions) {
        if (healPotions > 0) System.out.println("Получено зелий здоровья - " + healPotions);
        else System.out.println("Потрачено зелий здоровья " + healPotions);
        this.healPotions += healPotions;

    }
}
