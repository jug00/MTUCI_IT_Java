package Tasks;

public class Task1 {
    public static int remainder(int dividend, int divider){
        return dividend % divider;
    }

    public static int triArea(int base, int height){
        return (base * height) / 2;
    }

    public static int animals(int num_chickens, int num_cow, int num_pigs){
        return (2 * num_chickens + 4 * (num_cow + num_pigs));
    }

    public static boolean profitableGamble(double prob, int prize, int pay){
        if (prob * prize > pay){
            return true;
        }
        return false;
    }

    public static String operation(int N, int a, int b){
        if (a + b == N){
            return "added";
        }
        else if (a - b == N){
            return "subtracted";
        }
        else return "none";
    }

    public static int ctoa(char symbol){
        return (int) symbol;
    }

    public static int addUpTo(int num){
        int sum = 0;
        for (int i = 1; i <= num ; i++) {
            sum += i;
        }
        return sum;
    }

    public static int nextEdge(int edge1, int edge2){
        return (edge1 + edge2 - 1);
    }

    public static int sumOfCubes(int[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Math.pow(numbers[i], 3);
        }
        return sum;
    }

    public static boolean abcmath(int a, int b, int c){
        if ((a + a * b) % c == 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println("1 - " + remainder(10,3));
        System.out.println("2 - " + triArea(7, 4));
        System.out.println("3 - " + animals(1, 2, 3));
        System.out.println("4 - " + profitableGamble(0.9, 1, 2));
        System.out.println("5 - " + operation(24,26,2));
        System.out.println("6 - " + ctoa('m'));
        System.out.println("7 - " + addUpTo(7));
        System.out.println("8 - " + nextEdge(8, 10));
        System.out.println("9 - " + sumOfCubes(new int[]{3, 4, 5}));
        System.out.println("10 - " + abcmath(5,2,1));
    }
}
