package appforcivil.kb_adventofcode_day2

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import appforcivil.kb_adventofcode_day2.utils.CalculateChecksum
import appforcivil.kb_adventofcode_day2.utils.FindCorrectID

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TestFindCorrectID {
    @Test
    fun checkTestResultWithExample() {
        //Test input
        val testArrayList:List<String> = listOf("abcde","fghij","klmno","pqrst","fguij","axcye","wvxyz")

        //Create helper class FindCorrectID
        val findCorrectIDHelper = FindCorrectID(testArrayList)

        //Call function findCorrectIDHelper to find correctID
        val result =  findCorrectIDHelper.findCorrectID()

        assertEquals(result,"fgij")
    }

}
