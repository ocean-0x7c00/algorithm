package org.tree;

/**
 * 中序遍历
 */
public class Lesson12_05PaperFolding {
    /**
     * 当前你来了一个节点，脑海中想象的！
     * 这个节点在第i层，一共有N层，N固定不变的
     * 这个节点如果是凹的话，down = T
     * 这个节点如果是凸的话，down = F
     *
     * @param N
     * @param down
     */
    public static void process(int i, int N, boolean down) {
        if (i > N) {
            return;
        }

        process(i + 1, N, true);
        System.out.print(down ? "凹 " : "凸 ");
        process(i + 1, N, false);
    }

    public static void method(int N) {
        process(1, N, true);
    }

    public static void main(String[] args) {
        //凹 凹 凸 凹 凹 凸 凸 凹 凹 凹 凸 凸 凹 凸 凸
        //凹 凹 凸 凹 凹 凸 凸 凹 凹 凹 凸 凸 凹 凸 凸
        method(10);
    }
}
