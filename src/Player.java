public class Player extends Entity {
    private int gold;

    public Player(int fullHealth, int strength, int dexterity, String name) {
        super(fullHealth, fullHealth, strength, dexterity, name);
        this.gold = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public boolean setCurrentHealth(int currentHealth) {
        if (currentHealth <= 0) {
            System.out.println("Вы умерли.");
        }

        return super.setCurrentHealth(currentHealth);
    }

    @Override
    public String toString() {
        return "========================================" +
                "\nИГРОК" +
                "\nЗолото " + gold +
                super.toString();
    }

    public void gainExperience(Monster monster) {
        int gainedExperience = monster.getFullHealth() + monster.getStrength() + monster.getDexterity();
        System.out.println("Вы получили опыта - " + gainedExperience);
        this.setExperience(gainedExperience);
    }

    public void setGold(Monster monster) {
        this.gold += monster.bounty;
        System.out.println("Вы заработали золота - " + monster.bounty);
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
}
