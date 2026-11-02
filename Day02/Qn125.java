class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n-1;
        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while(left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if(Character.toLowerCase(s.charAt(left)) != 
                Character.toLowerCase(s.charAt(right)))
                return false;
            left++; right--;
        }
        return true;
    }
}




class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for (int j=1; j <nums.length; j++){
            if (nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
        
    }
}










