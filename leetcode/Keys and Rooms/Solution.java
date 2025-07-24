class Solution {
    private boolean[] check = new boolean[1001];
    private void DFS(int idx, List<List<Integer>> rooms) {
        if(check[idx])  return;
        check[idx] = true;
        for(int key : rooms.get(idx)) {
            DFS(key, rooms);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        DFS(0,rooms);
        for(int i=1; i<rooms.size(); i++){
            if(!check[i])   return false;
        }
        return true;
    }
}