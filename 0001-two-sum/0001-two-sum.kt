class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numStorage = HashMap<Int, Int>()
        
        nums.forEachIndexed { i, num ->
            val numberToAdd = numStorage[target - num]

            numberToAdd?.let {
                return intArrayOf(it, i)
            }
            numStorage[num] = i
        }
        
        return intArrayOf(-1, -1)
    }
}