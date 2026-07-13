class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //target, 
        //target - position + speed * time = 0 is the calculation
        //a car can onlny catch up to another car and then drive at the same speed
        //lets say i sort the fleet in descending order, so i check if a fleet is formed, if my time is >+ the time of the next one
        int[][] positions = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            positions[i][0] = position[i];
            positions[i][1] = speed[i];
        }
        Arrays.sort(positions, (a, b) -> Integer.compare(b[0], a[0]));
        Deque<Double> stack = new ArrayDeque<>();
        for(int[] arr : positions){
            int pos = arr[0];
            int spd = arr[1];
            double currTime = (double) (target - pos) / spd;
            if(stack.isEmpty() || currTime > stack.peek()){
                stack.push(currTime);
            }

        }
        return stack.size();
    }
}
