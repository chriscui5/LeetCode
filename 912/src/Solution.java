/**
 * @author:yixiaolan
 * @date:Created in 2020/3/31
 * @description:
 * @version:1.0
 */
public class Solution {

    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        heapify(nums);                                 // 新建一个最大堆
        for (int i = nums.length - 1; i >= 1; i--) {
            swap(nums, 0, i);                       // 弹出最大堆的堆顶放在最后
            rebuildHeap(nums, 0,i-1);          // 重建最大堆
        }
    }

    private void heapify(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int par = (i-1)>>1;                       // 找到父节点
            int child = i;                            // 定义子节点
            while (child>0&&nums[par]<nums[child]) {  // 从子节点到根节点构建最大堆
                swap(nums, par, child);
                child = par;
                par = (par-1) >> 1;
            }
        }
    }

    private void rebuildHeap(int[] nums, int par, int last) {
        int left = 2*par+1;                           // 左子节点
        int right = 2*par+2;                          // 右子节点
        int maxIndex = left;

        if (right<=last && nums[right]>nums[left]) {  // 找到最大子节点
            maxIndex = right;
        }

        if (left<=last && nums[par] < nums[maxIndex]) {// 和最大子节点比较
            swap(nums, par, maxIndex);                 // 互换到最大子节点
            rebuildHeap(nums, maxIndex, last);         // 重建最大子节点代表的子树
        }
    }

    private void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

}
