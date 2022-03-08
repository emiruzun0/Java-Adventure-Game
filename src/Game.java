import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome To Adventure Game ! ");
        System.out.print("Please enter a name : ");

        String playerName = input.next();
        Player player = new Player(playerName);
        System.out.println("Welcome " + player.getName());
        System.out.println("Everything that happens here is real ! ");
        System.out.println("Please select a character : ");
        player.selectChar();

        Location location = null;
        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("------------------Locations--------------------");
            System.out.println();
            System.out.println("0 - Exit Game");
            System.out.println("1 - Safe House --> This is safe place for you, no enemy ! ");
            System.out.println("2 - Store --> You can buy weapon or armor");
            System.out.print("Please enter a number to go to this location  : ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if(location == null){
                System.out.println("You quickly gave up on this dark and foggy island ! ");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER ! ");
                break;
            }
        }
    }
}
