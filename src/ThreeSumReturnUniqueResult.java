import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumReturnUniqueResult {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		//Take a number. Do 2Sum for remaining number.
		for (int i = 0; i < nums.length; i++) {
			int c = nums[i];
			int j = i + 1;
			int k = nums.length - 1;
			// skip same result
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			while (j < k) {
				if (c + nums[j] + nums[k] < 0) {
					j++;
				} else if (c + nums[j] + nums[k] > 0) {
					k--;
				} else {
					List<Integer> resultItem = new ArrayList<>();
					resultItem.add(c);
					resultItem.add(nums[j]);
					resultItem.add(nums[k]);
					result.add(resultItem);
					j++;
					k--;
					// skip same result
					while (j < k && nums[j] == nums[j - 1])
						j++;
					// skip same result
					while (j < k && nums[k] == nums[k + 1])
						k--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ThreeSumReturnUniqueResult t = new ThreeSumReturnUniqueResult();
		int[] i = new int[] { -1, 0, 1, 2, -1, -4 };
		int[] sortedI = new int[] { -4, -1, -1, 0, 1, 2 };
		System.out.println(t.threeSum(sortedI));
	}

}
