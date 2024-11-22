package problems.calendar.y22.d05;

import java.util.*

class CargoStack(val locationID: Int) : Stack<String>() {

    override fun push(item: String?): String {

        if (emptySign == item) {
            return ""
        }

        return super.push(item)
    }

    override fun toString(): String {
        return multiString(listOf(this))
    }

    companion object {

        val emptySign = "0"

        fun multiString(stackList : List<CargoStack>): String {

            val strBu = StringBuilder()
            val maxLevelSize = stackList.maxOf { it.size }

            for (i in (maxLevelSize - 1) downTo -1) {
                stackList.forEach {
                    if (i == -1) {
                        strBu.append("  ${it.locationID}  ")
                    } else {
                        strBu.append(it.getOrNull(i)?.let { " [${it}] " } ?: "     ")
                    }
                }
                strBu.append("\n")
            }

            return strBu.toString()
        }
    }
}
