import org.junit.Test

class SetsTest {

    companion object {

        private val dummyArray1 = arrayOf(1, 3, 5, 7, 9, 11, 13)
        private val dummyArray2 = arrayOf(1, 2, 3, 4, 5, 6, 7)
        private val dummyArray3 = arrayOf(14, 51, 23, 32, 44)
    }

    @Test
    fun `Array Union`() = assertTrueBlock {

        dummyArray1 union dummyArray2 == setOf(1, 3, 5, 7, 9, 11, 13, 2, 4, 6)
    }

    @Test
    fun `Array Intersect`() = assertTrueBlock {

        dummyArray1.intersect(dummyArray2) == setOf(1, 3, 5, 7)
    }

    @Test
    fun `Is Disjoint`() = assertTrueBlock {

        isDisjoint(dummyArray1, dummyArray3)
    }

    @Test
    fun `Is not Disjoint`() = assertTrueBlock {

        !isDisjoint(dummyArray1, dummyArray2)
    }

    @Test
    fun `isDisjointWith Extension`() = assertTrueBlock {

        dummyArray1.isDisjointWith(dummyArray3)
    }
}

fun assertTrueBlock(block: () -> Boolean) {
    assert(block.invoke())
}