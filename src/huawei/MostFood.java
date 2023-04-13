package huawei;

import java.util.*;

public class MostFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer,Grid> map = new HashMap<>();
        //构建n个方格
        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            int parentId = scanner.nextInt();
            int value = scanner.nextInt();

            Grid grid = new Grid(id, parentId, value);
            //将方格放入map
            map.put(id,grid);
        }

        //二叉树，孩子节点  确定父子关系
        for (Grid grid : map.values()) {
            //不为叶子节点
            if (grid.parentId != -1){
                Grid parentGrid = map.get(grid.parentId);
                parentGrid.children.add(grid);
            }
        }

        int result = 0;
        for (Grid grid : map.values()) {
            if (grid.value > 0){
                //对每一个格子做搜索 确定当前格子能获得的最大值  再取所有格子的最大值
                int gridMostFood = getMostFood(grid);
                if (gridMostFood > result){
                    result = gridMostFood;
                }
            }
        }
        System.out.println(result);
    }

    /**
     * 深度优先搜索
     * @param grid
     * @return
     */
    private static int getMostFood(Grid grid) {
        int mostFood = 0;
        //用栈存储方格 每次弹出一个进行访问 并将其子节点入栈，并记录已经访问过的id，避免重复访问
        Deque<Grid> stack = new LinkedList<>(); //栈
        Set<Integer> visted = new HashSet<>(); //不重复几何记录访问过的id

        stack.push(grid);
        visted.add(grid.id);

        while (!stack.isEmpty()){
            Grid cur = stack.pop();
            int curFood = cur.value;
            for (Grid child : cur.children) {
                //未访问过
                if (!visted.contains(child.id)){
                    visted.add(child.id);
                    if (child.value > 0){
                        curFood += getMostFood(child);
                    }
                    stack.push(child);
                }
            }
            if (curFood > mostFood){
                mostFood = curFood;
            }
        }
        return mostFood;
    }

    /**
     * 方格类
     */
    private static class Grid {
        int id;
        int parentId;
        int value;
        //传送门：孩子节点
        List<Grid> children;
        public Grid(int id, int parentId, int value) {
            this.id = id;
            this.parentId = parentId;
            this.value = value;
            this.children = new ArrayList<>();
        }
    }
}
