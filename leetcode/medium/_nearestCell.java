class Node{
    int f;
    int s;
    int t;
    Node(int f,int s,int t){
        this.f=f;
        this.s=s;
        this.t=t;
    }
    }
class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        Queue<Node> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int[][]visited=new int[m][n];
        int[][]dist=new int[m][n];
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Node(i,j,0));
                    visited[i][j]=1;
                }
                else visited[i][j]=0;
            }
        }
        int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
        while(!q.isEmpty()){
            Node temp=q.remove();
            int r=temp.f;
            int c=temp.s;
            int step=temp.t;
            dist[r][c]=step;
            for(int[]d:dir){
                int row=r+d[0];
                int col=c+d[1];
                if(row>=0 && row<m && col>=0 && col<n && visited[row][col]==0){
                visited[row][col]=1;
                q.add(new Node(row,col,step+1));
            }
            }
        }
        for(int i=0;i<m;i++){
            ArrayList<Integer>a=new ArrayList<>();
            for(int j=0;j<n;j++){
                a.add(dist[i][j]);
            }
            arr.add(a);
        }
        return arr;
        
    }
}
