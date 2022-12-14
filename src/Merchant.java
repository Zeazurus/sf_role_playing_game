public class Merchant implements Seller {
    private static final int cost = 10;
    @Override
    public boolean sell(Player player, int count) {
        int sum = count * cost;
        if (player.getGold() >= sum) {
            player.spendGold(sum);
            player.setHealPotions(count);
            System.out.println("У вас осталось зелий - " + player.getHealPotions());
            return true;
        } else return false;
    }
}