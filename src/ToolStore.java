public class ToolStore extends NormalLocation{

    public ToolStore(Player player) {
        super(player, "Store");
    }



    @Override
    public boolean onLocation(){
        System.out.println("Welcome to the store ! ");
        System.out.println("1 - Weapons");
        System.out.println("2 - Armor");
        System.out.println("3 - Exit");
        System.out.print("Your choice : ");
        int selectCase = Location.input.nextInt();
        while(selectCase < 1 || selectCase > 3){
            System.out.println("Invalid value, please choose again : ");
            selectCase = input.nextInt();
        }
        switch (selectCase)
        {
            case 1 :
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("See you soon ! ");
                return true;
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("----- Weapons -----");
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + " - " + w.getName() + " <Para : " + w.getPrice() + " , Hasar : " + w.getDamage()  + " >");
        }
    }

    public void buyWeapon(){
        System.out.print("Please choose a weapon : ");
        int selectWeaponID = input.nextInt();

        while(selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length){
            System.out.print("Invalid value, please choose again : ");
            selectWeaponID = input.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
        if(selectedWeapon!= null){
            if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Doesn't enough money ! ");
            }
            else{
                System.out.println(" You bought this weapon : " + selectedWeapon.getName());
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Remaining money : " + this.getPlayer().getMoney());
                System.out.println("Previous weapon : " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("New weapon : " + this.getPlayer().getInventory().getWeapon().getName());
            }
        }
    }

    public void printArmor(){
        System.out.println("----- Armors ------");
    }
}
