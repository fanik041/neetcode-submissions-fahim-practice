class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies of each number
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        // Step 2: Use a min-heap to keep track of top k elements
        // Min-heap: smallest element at top (by frequency)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> frequency.get(a) - frequency.get(b)
        );
        // Step 3: Maintain heap of size k
        for (int num : frequency.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the least frequent
            }
        }
        // Step 4: Build result array
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }
        
        return result;
    }
}
