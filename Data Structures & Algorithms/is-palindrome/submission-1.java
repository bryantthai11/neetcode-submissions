class Solution {
    public boolean isPalindrome(String s) {
        //in order to solve this problem, i would utilize two pointers, one left and one right pointer.
        //i would then make the string all lowercase
        //i would have a boolean check if it is a valid char,
        //i would have a left check to increment, then a rightside check that would utilize the boolean check
        //return true if you are able to go outside the while loop, otherwise if we find two valid values in the palindrome we return false right away
        int right = s.length() - 1;
        int left = 0;
        while(left < right){
            char chLeft = s.charAt(left);
            char chRight = s.charAt(right);

            if(!Character.isLetterOrDigit(chLeft)){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(chRight)){
                right--;
                continue;
            }
            if(Character.toLowerCase(chLeft) != (Character.toLowerCase(chRight))){
                return false;
            }
            left++;
            right--;

            
        }
        return true;
    }

    
}
