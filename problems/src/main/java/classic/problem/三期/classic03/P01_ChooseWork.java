package classic.problem.三期.classic03;

import java.util.Arrays;
import java.util.TreeMap;

public class P01_ChooseWork {
    public static int[] getMoneys(Job[] job, int[] ability) {
        Arrays.sort(job, (o1, o2) -> o1.hard != o2.hard ? (o1.hard - o2.hard) : (o2.money - o1.money));

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(job[0].hard, job[0].money);
        // pre 之前组的组长
        Job pre = job[0];
        for (int i = 1; i < job.length; i++) {
            if (job[i].hard != pre.hard && job[i].money > pre.money) {
                pre = job[i];
                map.put(job[i].hard, job[i].money);
            }
        }

        int[] ans = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            Integer key = map.floorKey(ability[i]);
            ans[i] = (key != null) ? map.get(key) : 0;
        }
        return ans;
    }


    public static class Job {
        public int money;
        public int hard;

        public Job(int money, int hard) {
            this.money = money;
            this.hard = hard;
        }
    }
}
