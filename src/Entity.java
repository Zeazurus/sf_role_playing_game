import java.util.Objects;

public abstract class Entity extends Evolution {
    String name;
    private int currentHealth, fullHealth, strength, dexterity;

    public Entity(int fullHealth, int currentHealth, int strength, int dexterity, String name) {
        this.currentHealth = currentHealth;
        this.fullHealth = fullHealth;
        this.strength = strength;
        this.dexterity = dexterity;
        this.name = name;
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        System.out.println("Вы получили:");
        setFullHealth(2, true);
        setStrength(1, true);
        setDexterity(1,true);
    }

    //Здоровье
    public int getFullHealth() {
        return fullHealth;
    }

    public void setFullHealth(int fullHealth, boolean isLevelUp) {
        this.fullHealth += fullHealth;
        if (isLevelUp) System.out.println("+2 здоровья");
        else setAbilityPoints(-1);
    }

    //Сила
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength, boolean isLevelUp) {
        this.strength += strength;
        if (isLevelUp) System.out.println("+1 силы");
        else setAbilityPoints(-1);
    }

    //Ловкость
    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity, boolean isLevelUp) {
        this.dexterity += dexterity;
        if (isLevelUp) System.out.println("+1 ловкости");
        else setAbilityPoints(-1);
    }

    public boolean setCurrentHealth(int currentHealth) {
        this.currentHealth += currentHealth;

        return this.currentHealth > 0;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public String toString() {
        return "\n========================================" +
                "\nХАРАКТЕРИСТИКИ" +
                "\nИмя=" + name +
                "\nТекущее здоровье=" + currentHealth +
                "\nПолное здоровье=" + fullHealth +
                "\nСила=" + strength +
                "\nЛовкость=" + dexterity +
                super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return currentHealth == entity.currentHealth && fullHealth == entity.fullHealth && strength == entity.strength && dexterity == entity.dexterity && name.equals(entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, currentHealth, fullHealth, strength, dexterity);
    }
}
