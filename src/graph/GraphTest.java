package graph;

import java.util.*;

/**
 * Created by GIOPPL
 * on 2021/8/15 15:20
 * TODO:
 */
public class GraphTest {
    private static int n = 0;

    public static void main(String[] args) {
        int[][][] graphList=InitGraph.g2();
        int[][] graph = graphList[0];
        int[][] graphPool = graphList[1];

        n = graph.length;
        if (isGraph(graph) || isGraph(graphPool)) {
            return;
        }
        int[] visited=new int[n];
        classify(graphPool,visited);
        int classificationCount=findClassification(visited);
        int[] classifies = sort(visited, classificationCount);
        System.out.println("end");
        connect(graph,graphPool,visited,classifies);
        printGraph(graphPool);
    }

    private static void connect(int[][] graph,int[][] graphPool,int[] visited,int[] classifies){
        int classCount=classifies.length;
        while (classCount>1){
            for (int j = 0; j < n; j++) {
                if(visited[j]==classifies[0]){
                    //j点时开始的点,connect是找到的联通的点
                    int connect = findVectorBFS(graph, visited, j);
                    if(connect==-1){
                        return;
                    }
                    System.out.println(":"+j+"获得的connect:"+connect);
                    addEdge(graphPool,visited,j,connect);
                    classCount=findClassification(visited);
                    classifies = sort(visited, classCount);
                }
            }
        }
    }

    private static void printGraph(int[][] graphPool){
        for (int i = 0; i < graphPool.length; i++) {
            for (int j = 0; j < graphPool[i].length; j++) {
                System.out.print(graphPool[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 添加一条边,从i连到j
     * @param i 开始的点
     * @param j 结束的点
     */
    private static void addEdge(int[][] graphPool,int[] visited,int i,int j){
        if((i<0||i>=n)||(j<0||j>=n)){
            return;
        }
        graphPool[i][j]=1;
        graphPool[j][i]=1;
        //将所有的visited中标志为i的节点换成标志为j的节点
        //表示两组节点联通
        int f1=visited[i];
        int f2=visited[j];
        for (int k = 0; k < n; k++) {
            if(visited[k]==f1){
                visited[k]=f2;
            }
        }
    }

    /**
     * 找到一个顶点到另一个非连通的顶点
     * @param x 从那个顶点开始
     * @return 找到的顶点编号
     */
    private static int findVectorBFS(int[][] graph, int[] visited, int x){
        Deque<Integer> queue=new LinkedList<>();
        boolean[] v=new boolean[n];
        v[x]=true;
        queue.offer(x);
        while (!queue.isEmpty()){
            int i=queue.poll();
            for (int j = 0; j < n; j++) {
                if(graph[i][j]==1&&!v[j]){
                    if(visited[j]!=-1&&visited[j]!=visited[x]){
//                        System.out.println();
                        return j;
                    }
                    v[j]=true;
//                    System.out.print(j+",");
                    queue.offer(j);
                }
            }
        }
//        System.out.println();
//        System.out.println("=====================");
        return -1;
    }

    //查看一共有多少个类别
    private static int findClassification(int[] visited){
        int x=0;
        int[] v=new int[n];
        for (int i = 0; i < n; i++) {
            v[i]=visited[i];
        }
        for (int i = 0; i < n; i++) {
            if(v[i]!=-1){
                int flag=v[i];
                x++;
                for (int j = 0; j < n; j++) {
                    if (v[j] == flag) {
                        v[j] = -1;

                    }
                }
            }
        }
        return x;
    }
    //排序
    public static int[] sort(int[] visited,int classification){
        int[] count=new int[classification];
        Entity[] entities=new Entity[classification];
        int[] v=new int[n];
        for (int i = 0; i < n; i++) {
            v[i]=visited[i];
        }
        int index=0;
        for (int i = 0; i < n; i++) {
            int c=0;
            int value=v[i];
            if(value!=-1){
                for (int j = 0; j < n; j++) {
                    if(value==v[j]){
                        c++;
                        v[j]=-1;
                    }
                }
                Entity entity=new Entity(c,value);
                entities[index++]=entity;
            }
        }
        for (int i = 0; i < classification; i++) {
            for (int j = i+1; j < classification; j++) {
                if(entities[i].key>entities[j].key){
                    Entity entity=entities[i];
                    entities[i]=entities[j];
                    entities[j]=entity;
                }
            }
        }
        for (int i = 0; i < classification; i++) {
            count[i]=entities[i].value;
        }
        return count;
    }

    /**
     * 最开始的分类,分类结果放在visited里面
     * 分类后visited[]会变成{1,-1,1,1,2,3}这样
     * @param visited 结果
     */
    public static void classify(int[][] graphPool,int[] visited){
        for (int i = 0; i < n; i++) {
            if(graphPool[i][i]==0){
                visited[i]=-1;
            }else {
                visited[i]=0;
            }
        }
        int flag=1;
        for (int i = 0; i < n; i++) {
            if(visited[i]==0){
                dfs(graphPool, i, visited, flag);
                flag++;
            }
        }

    }

    private static void dfs(int[][] graph, int v, int[] visited, int flag) {
        Stack<Integer> stack = new Stack<>();
        visited[v] = flag;
        System.out.print(v+",");
        stack.push(v);
        while (!stack.empty()) {
            int j = stack.pop();
            int i;
            for (i = 0; i < n; i++) {
                if (graph[j][i] != 0 && visited[i] != flag) {
                    System.out.print(i+",");
                    visited[i] = flag;
                    stack.push(i);
                    break;
                }
            }
            if (i == n&&!stack.empty()) {
                stack.pop();
            }
        }
    }

    public static boolean isGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] != graph[j][i]) {
                    System.out.println("i=" + i + "j=" + j);
                    return true;
                }
            }
        }
        System.out.println("图没有问题");
        return false;
    }

    static class Entity{
        int key;
        int value;

        public Entity(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
