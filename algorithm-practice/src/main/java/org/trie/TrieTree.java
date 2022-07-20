package org.trie;

import java.util.Arrays;

public class TrieTree {
    public static void main(String[] args) {
        String[] arr = {"abc", "abd", "bce", "abcd", "bcf"};
        Arrays.sort(arr);
    }

    /**
     * 前缀树节点
     */
    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new Node1[26];
        }
    }

    public static class Trie1 {
        private Node1 root;

        public Trie1() {
            this.root = new Node1();
        }

        public void insert(String str) {
            if (str == null) {
                return;
            }
            char[] chars = str.toCharArray();
            Node1 node = root;
            node.pass++;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                //计算要去的路径
                path = chars[i] - 'a';
                //找有没有到chars[i]字符的路径
                if (node.nexts[path] == null) {
                    node.nexts[path] = new Node1();

                }
                //路径存在
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }

        /**
         * word这个单词之前加入过几次
         *
         * @param word
         * @return
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }

            char[] strs = word.toCharArray();
            Node1 node = root;
            int path = 0;
            for (int i = 0; i < strs.length; i++) {
                path = strs[i] - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }

            return node.end;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] strs = word.toCharArray();
                Node1 node = root;
                node.pass--;

                int path = 0;
                for (int i = 0; i < strs.length; i++) {
                    path = strs[i] - 'a';
                    if (--node.nexts[path].pass == 0) {
                        node.nexts[path] = null;
                        return;

                    }
                    node = node.nexts[path];
                }
                node.end--;
            }
        }

        public int prefixNumber(String word) {
            if (word == null) {
                return 0;
            }

            char[] strs = word.toCharArray();
            Node1 node = root;
            int path = 0;
            for (int i = 0; i < strs.length; i++) {
                path = strs[i] - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }

            return node.pass;
        }
    }
}
