package appforcivil.kb_adventofcode_day2

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import appforcivil.kb_adventofcode_day2.utils.CalculateChecksum

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TestCalculateChecksum {
    @Test
    fun checkTestResultWithExample() {
        //Test input
        val testArrayList:List<String> = listOf("abcdef","bababc","abbcde","abcccd","aabcdd","abcdee","ababab")

        //Create helper class CalculateChecksum
        val calculateChecksumHelper = CalculateChecksum(testArrayList)

        //Call function calculateChecksumHelper to calculates
        val result =  calculateChecksumHelper.calculateChecksum()

        assertEquals(result,12)
    }

}
