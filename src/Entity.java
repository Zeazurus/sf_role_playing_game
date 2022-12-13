public abstract class Entity {
    String name;
    private int currentHealth;
    int fullHealth, strength, dexterity;


    public Entity(int fullHealth, int currentHealth, int strength, int dexterity, String name) {
        this.currentHealth = currentHealth;
        this.fullHealth = fullHealth;
        this.strength = strength;
        this.dexterity = dexterity;
        this.name = name;
    }

    public boolean setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;

        return this.currentHealth > 0;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public String toString() {
        return "\nИмя=" + name +
                "\nТекущее здоровье=" + currentHealth +
                "\nПолное здоровье=" + fullHealth +
                "\nСила=" + strength +
                "\nЛовкость=" + dexterity
                + "\n========================================\n";
    }
}
