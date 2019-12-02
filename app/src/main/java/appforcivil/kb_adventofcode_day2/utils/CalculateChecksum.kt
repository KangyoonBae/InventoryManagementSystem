package appforcivil.kb_adventofcode_day2.utils

/**
 * CalculateChecksum
 * This class is a helper class to calculate the checksum
 * @constructor creates CalculateChecksum take List<String> as parameter
 */
class CalculateChecksum() {
    //Static object for LOG_TAG
    companion object {
        private const val LOG_TAG = "CalculateChecksum"
    }


    //Final Result Global variable
    private var totalTwo = 0
    private var totalThree = 0
    private var mlistOfInputString = mutableListOf<String>()

    //Constructor
    constructor(listOfInputString: List<String>) : this() {
        //Set Input
        this.mlistOfInputString = listOfInputString as MutableList<String>
    }


    /**
     * Function for calculation and tracking counter
     * @return Int (checksum)
     */
    fun calculateChecksum(): Int {
        //Loop through mlistOfInputString (List<String>)
        for (inputString in mlistOfInputString) {
            //Convert current line of String into a list of char
            val charList = inputString.toCharArray().toList()

            //Group charList by char
            var frequenciesByChar = charList.groupBy { it }

            //Debug
            //Log.e(LOG_TAG, "letters in frequenciesByChar")

            //Count 2
            if(frequenciesByChar.filterValues { it.size == 2 }.isNotEmpty()){
                //Debug
                //Log.e(LOG_TAG, "Adding Two to : $totalTwo")
                totalTwo++
            }
            //Count 3
            if(frequenciesByChar.filterValues { it.size == 3 }.isNotEmpty()){
                //Debug
                //Log.e(LOG_TAG, "Adding Three to : $totalTwo")
                totalThree++
            }
        }
        //Return Checksum
        return totalTwo * totalThree
    }
}
