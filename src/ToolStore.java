public class ToolStore extends NormalLocation{

    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation(){
        System.out.println("Welcome to the store");
        return true;
    }
}
