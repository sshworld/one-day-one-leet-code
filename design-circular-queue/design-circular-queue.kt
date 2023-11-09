class MyCircularQueue(k: Int) {
    private val queue: HashMap<Int, Int> = hashMapOf()
    
    private val size: Int = k
    
    private var front: Int = 0
    
    private var rear: Int = -1

    fun enQueue(value: Int): Boolean {
        if (!isFull()) {
            rear += 1
            queue[rear] = value
            
            return true
        }
        
        return false
    }

    fun deQueue(): Boolean {
        if (!isEmpty()) {
            queue.remove(front)
            front += 1
            
            return true
        }
        
        return false
    }

    fun Front() = queue[front] ?: -1

    fun Rear() = queue[rear] ?: -1

    fun isEmpty() = queue.isEmpty()

    fun isFull() = queue.size == size

}