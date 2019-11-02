import kotlin.system.measureTimeMillis

val SEQ_THRESHOLD = 50000
class ComputeSum {

    fun compute(array: IntArray, low: Int, high: Int): Long {
        return if (high - low <= SEQ_THRESHOLD) {
            (low until high)
                .map { array[it].toLong() }
                .sum()
        } else {
            val mid = low + (high - low) / 2
            val left = compute(array, low, mid)
            val right = compute(array, mid, high)

            return left + right

        }
    }
}
fun main() {
    val list = mutableListOf<Int>()
    var limit = 20_000_000
    while(limit>0){
        list.add(limit--)
    }

    var result = 0L
    val computeSum = ComputeSum()
    var time = measureTimeMillis {
        result = computeSum.compute(list.toIntArray(), 0 ,list.size)
    }


    result = 0L
    time = measureTimeMillis {
        result = computeSum.compute(list.toIntArray(), 0 ,list.size)
    }


    print("$result, time takes $time ms")

}