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


/**
 * Symmetric difference b/w arrays
 * */
fun <T> symmetricDifference(f: Array<T>, s: Array<T>): Set<T> = differenceOf(f, s) union differenceOf(s, f)

infix fun <T> Array<T>.symmetricDifferenceWith(s: Array<T>): Set<T> = symmetricDifference(this, s)

/**
 * Cardinality
 * */
fun <T> Array<T>.cardinality() = size

typealias Cardinality = Int


/**
 * Power set
 * */
fun <T> powerSet(set: Set<T>): Set<Set<T>> {

    return if (set.isEmpty()) setOf(emptySet())
    else {
        println("Current Set $set")
        val droppedSet = powerSet(set.drop(1).toSet())
        droppedSet + droppedSet.map { it + set.first() }
    }
}