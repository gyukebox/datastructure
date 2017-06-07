import java.util.Stack;

public class HanoiTower {
    private Stack<Integer>[] pegs;
    private int totalMoves;

    public HanoiTower() {
        this.totalMoves = 0;
        this.pegs = new Stack[3];
        for (int i = 0; i < pegs.length; i++) {
            this.pegs[i] = new Stack<>();
        }
    }

    public void init(int n) {
        for (int i = n; i > 0; i--) {
            this.pegs[0].push(i);
        }
    }

    public void move(int n, int from, int by, int to) {
        if (n == 1) {
            int disk = pegs[from - 1].pop();
            this.pegs[to - 1].push(disk);
            this.printCurrentState();
        } else {
            this.move(n - 1, from, to, by);

            int disk = pegs[from - 1].pop();
            this.pegs[to - 1].push(disk);
            this.printCurrentState();

            this.move(n - 1, by, from, to);
        }
    }

    public void printCurrentState() {
        for (int i = 0; i < this.pegs.length; i++) {
            System.out.printf("stack %d : ", i + 1);
            if (this.pegs[i].size() == 0) {
                System.out.println("NULL");
            } else {
                for (int j = 0; j < this.pegs[i].size(); j++) {
                    System.out.printf("%d ", this.pegs[i].get(j));
                }
                System.out.println();
            }
        }
        System.out.println();
        this.totalMoves++;
    }

    public int getTotalMoves() {
        return this.totalMoves;
    }
}
