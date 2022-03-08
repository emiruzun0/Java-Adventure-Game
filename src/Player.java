import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){
        GameChar[] charList =  {new Samurai(), new Archer(), new Knight()};
        System.out.println("------------------------------------------------------------------");
        System.out.println("--------------------------------CHARACTERS------------------------");
        for (GameChar gameChar : charList){
            System.out.println("ID : " + gameChar.getId() +
                    "\t Character: " + gameChar.getName() +
                    "\t Damage : " + gameChar.getDamage() +
                    "\t Health : " + gameChar.getHealth() +
                    "\t Money : " + gameChar.getMoney());
        }
        System.out.println("------------------------------------------------------------------");
        System.out.print("Please enter an ID to select character : ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai()); //default character
                break;
        }
        System.out.println("Character : " + this.getCharName() +
                "\t Damage : " + this.getDamage() +
                "\t Health : " + this.getHealth() +
                "\t Money : " + this.getMoney());


    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println(
                " Your weapon : " + this.getInventory().getWeapon().getName() +
                "\n Your armor : " + this.getInventory().getArmor().getName() +
                "\n Blocking : " + this.getInventory().getArmor().getBlock() +
                "\n Your Damage : " + this.getDamage() +
                "\n Your Health : " + this.getHealth() +
                "\n Your Money : " + this.getMoney());
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
