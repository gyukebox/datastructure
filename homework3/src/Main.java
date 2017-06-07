import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static int getAmountInput() {
        System.out.print("number of disk: ");
        return sc.nextInt();
    }

    public static void main(String[] args) {
        int n = getAmountInput();
        HanoiTower tower = new HanoiTower();
        tower.init(n);
        tower.move(n, 1, 2, 3);
        System.out.println("Number of movement : " + tower.getTotalMoves());
    }
}
