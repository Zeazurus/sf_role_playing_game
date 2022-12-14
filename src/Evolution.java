public abstract class Evolution {
    private int experience = 0, level = 1, abilityPoints = 0;

    public int getAbilityPoints() {
        return abilityPoints;
    }

    public void setAbilityPoints(int abilityPoints) {
        this.abilityPoints += abilityPoints;
        if (abilityPoints > 0) System.out.println("Получены очки способностей - " + abilityPoints);
        else System.out.println("Потрачены очки способностей " + abilityPoints);
    }

    public void setLevel(int level) {
        this.level += level;
        System.out.println("Получен " + this.level + " уровень!");
        setAbilityPoints(1);

    }

    public void setExperience(int experience) {
        this.experience += experience;
        if (this.experience >= (100 * level)) {
            this.setLevel(1);
            this.experience = experience % (100 * level);
        }

    }

    @Override
    public String toString() {
        return "\n========================================" +
                "\nПРОКАЧКА" +
                "\nУровень=" + level +
                "\nОпыт=" + experience +
                "\nОчки способностей=" + abilityPoints +
                "\n========================================\n";
    }
}
