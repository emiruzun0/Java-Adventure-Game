import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome To Adventure Game ! ");
        //System.out.println("Please enter a name : ");

        //String playerName = input.next();
        Player player = new Player("Emir");
        System.out.println("Welcome " + player.getName());
        System.out.println("Everything that happens here is real ! ");
        System.out.println("Please select a character : ");
        player.selectChar();
    }
}
