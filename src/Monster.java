import java.util.Objects;

public class Monster extends Entity{
    int bounty;

    public Monster(int fullHealth, int currentHealth, int strength, int dexterity, String name, int bounty) {
        super(fullHealth, currentHealth, strength, dexterity, name);
        this.bounty = bounty;
    }

    @Override
    public boolean setCurrentHealth(int currentHealth) {
        if (this.getCurrentHealth() + currentHealth <= 0) {
            System.out.println("Монстр мертв.");
        }

        return super.setCurrentHealth(currentHealth);
    }

    @Override
    public String toString() {
        return "========================================" +
                "\nМонстр" + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monster monster = (Monster) o;
        return bounty == monster.bounty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bounty);
    }
}
