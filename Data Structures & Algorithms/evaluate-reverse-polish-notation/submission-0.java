class Solution {
    public int evalRPN(String[] tokens) {
        //just have a stack, if we encounter an operand, we have to pop two off the stack
        //issue arises when we encounter more than one operand at a time
        Deque<Integer> stack = new ArrayDeque<>();
        for(String c : tokens){
            if(c.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(c.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }else if(c.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(c.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }else{
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }

}
