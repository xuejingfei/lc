package array;

public class FindMedianSortedArrays {


    /**
     * 找到两个有序数组中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1,int[] nums2) {
        int aLength = nums1.length;
        int bLength =nums2.length;
        int maxLength = aLength + bLength;
        int aStart = 0;
        int bStart = 0;
        int left = 0; //存储前值
        int right = 0;
        for (int i = 0;i<=maxLength/2;i++) {
             left = right;
             if (aStart < aLength && (bStart >= bLength || nums1[aStart] < nums2[bStart])) {
                 right = nums1[aStart++];
             } else {
                 right = nums2[bStart++];
             }
        }
        if (maxLength %2 ==0) {
            return (left + right)/2.0f;
        }
        return right;
    }
}
