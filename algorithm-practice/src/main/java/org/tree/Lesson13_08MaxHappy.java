package org.tree;

import java.util.List;

/**
 * 派对的最大快乐值
 * <p>
 * 员工信息的定义如下:
 * class Employee {
 * public int happy; // 这名员工可以带来的快乐值
 * List<Employee> subordinates; // 这名员工有哪些直接下级
 * }
 * <p>
 * 派对的最大快乐值
 * 公司的每个员工都符合 Employee 类的描述。整个公司的人员结构可以看作是一棵标准的、
 * 没有环的多叉树。树的头节点是公司唯一的老板。除老板之外的每个员工都有唯一的直接上级。
 * 叶节点是没有任何下属的基层员工(subordinates列表为空)，
 * 除基层员工外，每个员工都有一个或多个直接下级
 * <p>
 * <p>
 * 这个公司现在要办party，你可以决定哪些员工来，哪些员工不来，规则：
 * 1.如果某个员工来了，那么这个员工的所有直接下级都不能来
 * 2.派对的整体快乐值是所有到场员工快乐值的累加
 * 3.你的目标是让派对的整体快乐值尽量大
 * 给定一棵多叉树的头节点boss，请返回派对的最大快乐值。
 */
public class Lesson13_08MaxHappy {
    public static int maxHappy(Employee boss) {
        if (boss == null) {
            return 0;
        }
        Info allInfo = process(boss);

        return Math.max(allInfo.no, allInfo.yes);
    }

    /**
     * @param cur
     * @return
     */
    public static Info process(Employee cur) {
        if (cur == null) {
            return new Info(0, 0);
        }

        int yes = cur.happy;
        int no = 0;
        for (Employee subordinate : cur.subordinates) {
            Info info = process(subordinate);
            yes += info.no;
            //cur 不来，下级可以来也可以不来
            no += Math.max(info.no, info.yes);
        }


        return new Info(yes, no);
    }

    private static class Info {
        /**
         * 来，的最大收益
         */
        int yes;
        /**
         * 不来的最大收益
         */
        int no;

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }

    private static class Employee {
        public int happy; // 这名员工可以带来的快乐值
        List<Employee> subordinates; // 这名员工有哪些直接下级
    }
}
