public class Monster extends Entity{
    int bounty;

    public Monster(int fullHealth, int currentHealth, int strength, int dexterity, String name, int bounty) {
        super(fullHealth, currentHealth, strength, dexterity, name);
        this.bounty = bounty;
    }

    @Override
    public boolean setCurrentHealth(int currentHealth) {
        if (currentHealth <= 0) {
            System.out.println("Монстр мертв.");
        }

        return super.setCurrentHealth(currentHealth);
    }

    @Override
    public String toString() {
        return "========================================" +
                "\nМонстр" + super.toString();
    }
}
