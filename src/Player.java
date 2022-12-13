public class Player extends Entity {
    private int experience, gold;

    public Player(int fullHealth, int strength, int dexterity, String name) {
        super(fullHealth, fullHealth, strength, dexterity, name);
        this.experience = 0;
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
                "\nИгрок" +
                "\nОпыт " + experience +
                "\nЗолото " + gold +
                super.toString();
    }

    public void setExperience(Monster monster) {
        int gainedExperience = monster.fullHealth + monster.strength + monster.dexterity;
        this.experience += gainedExperience;
        System.out.println("Вы получили опыта - " + gainedExperience);
    }

    public void setGold(Monster monster) {
        this.gold += monster.bounty;
        System.out.println("Вы заработали золота - " + monster.bounty);
    }
}
