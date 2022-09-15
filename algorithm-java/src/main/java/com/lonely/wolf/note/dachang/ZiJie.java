package com.lonely.wolf.note.dachang;

import com.alibaba.fastjson.JSONObject;

public class ZiJie {


    public static void main(String[] args) {
        int[] nums = {4,0,0,3,2,0,6};
//        int[] result = test1(nums);
//        System.out.println(JSONObject.toJSONString(result));

        int[] result2 = test2(nums);
        System.out.println(JSONObject.toJSONString(result2));
    }


    /**
     * 一个数组，把小于0的数字移到前面，大于0的数字移到后面
     * 给定一个数组，如[4,0,0,3,2,0,6]，把所有的0移到数组的最后，保持其他的数据顺序不变，要求空间复杂度为O(1)
     *
     *  自己解法：不断后移
     * @return
     */
    public static int[] test1(int[] nums){
        if (null == nums || nums.length == 0){
            return nums;
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i] != 0){
                continue;
            }
            //nums[i] == 0
            for (int j=i;j<nums.length;j++){
                if(nums[j] != 0){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }
        return nums;
    }


    public static int[] test2(int[] nums){
        if (null == nums || nums.length == 0){
            return nums;
        }
        int n = nums.length;
        for(int i=n-1; i>=0; i--) {//[3,4,0]
            if(nums[i] == 0) {
                int last_not_zero = n-1;
                for(int k=n-1; k>0; k--) {
                    if(nums[k] != 0) {
                        last_not_zero = k;
                        break;
                    }
                }
                int j = i;
                for(; j<last_not_zero; j++) {
                    nums[j] = nums[j+1];
                }
                nums[j] = 0;
            }
        }
        return nums;
    }
}
