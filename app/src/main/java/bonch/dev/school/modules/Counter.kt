package bonch.dev.school.modules

class Counter(startCount: Int = 0) {
    var value = startCount
        private set

    fun increment() {
        value++
    }
}