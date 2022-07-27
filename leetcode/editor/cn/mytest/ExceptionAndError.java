package leetcode.editor.cn.mytest;

import leetcode.editor.cn.ZhanDeYaRuDanChuXuLieLcof;

import java.util.ArrayList;

public class ExceptionAndError {
    public static void main(String[] args) {
        try {
            dfs();
            new ArrayList<>().add(1);
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    static void dfs() {
        Class<ZhanDeYaRuDanChuXuLieLcof> zhanDeYaRuDanChuXuLieLcofClass = ZhanDeYaRuDanChuXuLieLcof.class;
        dfs();
    }
}
