package classic.problem.三期.classic01;

public class P05_MakeNo {
    public static int[] makeNo(int size) {
        if (size == 1) {
            return new int[]{1};
        }

        int halfSize = (size + 1) / 2;
        int[] base = makeNo(halfSize);

        int[] ans = new int[size];
        int index = 0;
        for (int i = 0; i < halfSize; i++) {
            ans[index++] = base[i] * 2 - 1;
        }
        for (int i = 0; index < size; i++) {
            ans[index++] = base[i] * 2;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] ints = makeNo(10);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "\t");
        }
    }
}
