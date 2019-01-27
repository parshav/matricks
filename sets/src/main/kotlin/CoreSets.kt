/**
 * Elements present in either a or b arrays,
 * */
infix fun <T> Array<T>.union(to: Array<T>): Set<T> {
    val returnList = mutableSetOf<T>()
    returnList.addAll(this)
    returnList.addAll(to)
    return returnList
}


/**
 * Elements in both arrays
 * */
infix fun <T> Array<T>.intersect(to: Array<T>): Set<T> = to.filter { this.contains(it) }.toSet()

/**
 * Is disjoint if no matching elements b/w arrays
 * */
fun <T> isDisjoint(firstArray: Array<T>, secondArray: Array<T>): Boolean = firstArray.intersect(secondArray).isEmpty()

infix fun <T> Array<T>.isDisjointWith(to: Array<T>) = isDisjoint(this, to)


/**
 * Difference with arrays
 * */
fun <T> differenceOf(f: Array<T>, s: Array<T>): Set<T> = f.filter { !s.contains(it) }.toSet()

infix fun <T> Array<T>.differenceWith(s: Array<T>): Set<T> = differenceOf(this, s)