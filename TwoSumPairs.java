import java.util.*;

public class TwoSumPairs {
    public static List<int[]> twoSum(int[] nums, int target) {
        List<int[]> indices = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices.add(new int[] { i, j });
                }
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int len = sc.nextInt();
        int[] nums = new int[len];

        System.out.println("Enter the array");
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the target: ");
        int target = sc.nextInt();

        List<int[]> indices = twoSum(nums, target);

        if (indices.isEmpty()) {
            System.out.println("no indices found");
        } else {
            for (int[] list : indices) {
                System.out.println(list[0] + " and " + list[1]);
            }
        }

    }
}