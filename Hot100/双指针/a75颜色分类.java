package Hot100.双指针;

/**
 * @Author: ZJX
 * @Date: 2024/11/29
 * @Description:
 */
public class a75颜色分类 {
    class Solution1 {
        public void sortColors(int[] nums) {
            int[] cnt = new int[3];
            for (int v : nums) {
                cnt[v]++;
            }
            for (int i = 0; i < nums.length; i++) {
                if (cnt[0]-- > 0)
                    nums[i] = 0;
                else if (cnt[1]-- > 0)
                    nums[i] = 1;
                else
                    nums[i] = 2;

            }
        }
    }

    class Solution2 {
        //两次遍历，一个指针
        public void sortColors(int[] nums) {
            int n = nums.length;
            int ptr = 0; //ptr指向头部[0，ptr-1] ptr初始值为0，
            for (int i = 0; i < n; i++) {
                //0 0 2 1 1 2
                //第一次遍历，从左向右遍历整个数组，如果找到了 0，那么就需要将 0 与「头部」位置的元素进行交换，并将「头部」向后扩充
                // 在遍历结束之后，所有的 0 都被交换到「头部」的范围，并且「头部」只包含 0。
                if (nums[i] == 0) {
                    swap(nums, i, ptr++);
                }
            }
            //现在ptr已经遍了完了所有的0
            for (int i = ptr; i < n; i++) {
                if (nums[i] == 1) {
                    swap(nums, i, ptr++);
                }
            }
            //第二轮遍历结束,头部 已经全是 0和1，2的位置自然也固定了
        }

        private void swap(int[] nums, int l, int r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }

    class Solution3 {
        //一次遍历,两个指针
        public void sortColors(int[] nums) {
            int n = nums.length;
            int p0 = 0, p1 = 0; //用p0 来交换 0，p1 来交换1，初始都为0

            for (int i = 0; i < n; i++) {
                int v = nums[i];
                //如果找到了 1，那么将其与 nums[p1]进行交换，并将 p1,向后移动一个位置，这与方法一是相同的
                if (v == 1) {
                    swap(nums, p1, i);
                    p1++;
                } else if (v == 0) {
                    //如果找到了 0，那么将其与 nums[p0]交换  这里p0的位置是有可能为1的，所以有可能会将一个1交换出去
                    swap(nums, p0, i);
                    //判断如果 p0 在 p1之前，由于已经将一些1连续放在头部，所以会把一个1交换出去，导致1不连续。
                    //因此，将nums[i] 再与nums[p1]交换，将这个1放在p1表示的连续1的头部的尾部 然后p0，p1均++
                    if (p0 < p1) {
                        swap(nums, i, p1);
                    }
                    p0++;
                    p1++;
                }
            }
        }


        private void swap(int[] nums, int l, int r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }

    class Solution4 {
        //刷漆算法
        //思路：通过三个有包含关系的计数器，来分别动态算出0,1,2个数，并修改对应的值
        //遍历数组： i：代表目前为止(0 + 1 + 2) 的数量
        //n1: 代表目前为止 (0 + 1)的数量
        //n0: 代表目前为止 (0)的数量
        //一次判断当前数字属于哪一类，然后修改对应的nums[]（刷油漆)
        public void sortColors(int[] nums) {
            int n0 = 0, n1 = 0;
            for (int i = 0; i < nums.length; i++) {
                int v = nums[i];
                nums[i] = 2; //相当于把数组所有位置全部写2
                if (v <= 1)
                    nums[n1++] = 1; //相当于把前0和1的个数个位置写了1
                if (v == 0)
                    nums[n0++] = 0; //相当于只把数组前n0个位置写0
            }
        }
    }
}
