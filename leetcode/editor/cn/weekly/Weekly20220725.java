package leetcode.editor.cn.weekly;

import leetcode.editor.cn.LeetCodeDataStruct;

import java.util.*;

public class Weekly20220725 {
    static class Answer1 {
        public static void main(String[] args) {
            Solution solution = new Solution();
        }

        static class Solution {

        }
    }

    static class Answer2 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.equalPairs(LeetCodeDataStruct.parserTwoIntArray("[[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]"));
        }

        static class Solution {
            public int equalPairs(int[][] grid) {
                int n = grid.length;
                int res = 0;
                HashMap<Integer, Integer> map1 = new HashMap<>();
                HashMap<Integer, Integer> map2 = new HashMap<>();
                for (int[] i : grid) {
                    int hash = Arrays.hashCode(i);
                    map1.put(hash, map1.getOrDefault(hash, 0) + 1);
                }
                for (int i = 0; i < n; ++i) {
                    int[] t = new int[n];
                    for (int j = 0; j < n; ++j) {
                        t[j] = grid[j][i];
                    }
                    int hash = Arrays.hashCode(t);
                    map2.put(hash, map2.getOrDefault(hash, 0) + 1);
                }
                for (int i : map1.keySet()) {
                    if (map2.containsKey(i)) res += map1.get(i) * map2.get(i);
                }
                return res;
            }
        }
    }

    static class Answer3 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
            foodRatings.highestRated("korean");
            // "kimchi" 是分数最高的韩式料理，评分为 9 。
            foodRatings.highestRated("japanese"); // 返回 "ramen"
            // "ramen" 是分数最高的日式料理，评分为 14 。
            foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
            foodRatings.highestRated("japanese"); // 返回 "sushi"
            // "sushi" 是分数最高的日式料理，评分为 16 。
            foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
            foodRatings.highestRated("japanese");
        }

        static class Solution {

        }

        static class FoodRatings {
            // cuisines 到食物评分
            HashMap<String, PriorityQueue<Helper>> priMap = new HashMap<>();
            // 要删除了
            HashMap<String, PriorityQueue<Helper>> delMap = new HashMap<>();
            HashMap<String, String> foodMap = new HashMap<>();
            HashMap<String, Integer> ratMap = new HashMap<>();

            public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
                int n = foods.length;
                for (int i = 0; i < n; ++i) {
                    foodMap.put(foods[i], cuisines[i]);
                    ratMap.put(foods[i], ratings[i]);
                    if (!priMap.containsKey(cuisines[i])) {
                        priMap.put(cuisines[i], new PriorityQueue<>());
                        delMap.put(cuisines[i], new PriorityQueue<>());
                    }
                    priMap.get(cuisines[i]).add(new Helper(foods[i], ratings[i]));
                }
            }

            public void changeRating(String food, int newRating) {
                String cuisines = foodMap.get(food);
                priMap.get(cuisines).add(new Helper(food, newRating));
                delMap.get(cuisines).add(new Helper(food, ratMap.get(food)));
                ratMap.put(food, newRating);
            }

            public String highestRated(String cuisine) {
                PriorityQueue<Helper> delPQ = delMap.get(cuisine);
                PriorityQueue<Helper> pq = priMap.get(cuisine);
                while (!delPQ.isEmpty() && delPQ.peek().equals(pq.peek())) {
                    delPQ.poll();
                    pq.poll();
                }
                return pq.peek().food;
            }

            class Helper implements Comparable {
                String food;
                int rating;

                public Helper(String name, int rating) {
                    this.food = name;
                    this.rating = rating;
                }

                @Override
                public int compareTo(Object o) {
                    Helper helper = (Helper) o;
                    if (rating != helper.rating) return helper.rating - rating;
                    return food.compareTo(helper.food);
                }

                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (o == null || getClass() != o.getClass()) return false;
                    Helper helper = (Helper) o;
                    return rating == helper.rating && Objects.equals(food, helper.food);
                }

                @Override
                public int hashCode() {
                    return Objects.hash(food, rating);
                }
            }


        }
    }

    static class Answer4 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.countExcellentPairs(new int[]{1, 2, 3, 1, 536870911}, 3);
        }

        static class Solution {
            public long countExcellentPairs(int[] nums, int k) {
                long res = 0;
                int[] cnt = new int[80];
                HashSet<Integer> set = new HashSet<>();
                for (int i : nums) {
                    if (set.contains(i)) continue;
                    cnt[Integer.bitCount(i)]++;
                    set.add(i);
                }
                for (int i = 0; i <= 70; ++i) {
                    if (cnt[i] == 0) continue;
                    for (int r = Math.max(k - i, 0); r < 70; ++r) {
                        if (cnt[r] == 0) continue;
                        res += cnt[i] * cnt[r];
                    }
                }
                return res;
            }
        }
    }
}
