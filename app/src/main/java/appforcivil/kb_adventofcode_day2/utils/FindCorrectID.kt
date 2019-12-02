package appforcivil.kb_adventofcode_day2.utils

/**
 * FindCorrectID
 * This class is a helper class to find the correctID
 * @constructor creates FindCorrectID take List<String> as parameter
 */
class FindCorrectID() {
    //Static object for LOG_TAG
    companion object {
        private const val LOG_TAG = "FindCorrectID"
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
     * Function for finding correctID
     * @return String (correctID)
     */
    fun findCorrectID(): String {

        //Create a secondList to compare
        var startFromSecondList = mlistOfInputString.toMutableList()
        startFromSecondList.removeAt(0)

        //Loop through mlistOfInputString (List<String>)
        for (inputString in mlistOfInputString) {
            //Loop through startFromSecondList (List<String>)
            for (inputString2 in startFromSecondList){
                //zip - Returns a list of pairs built from the elements of this array and the other array with the same index. The returned list has length of the shortest collection.
                //https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/zip.html
                //Get zip pair list
                val zipPairList = inputString zip inputString2
                //filter zip where a pair has different chars
                var zipPairListFilter  = zipPairList.filter { it.first != it.second } as MutableList<Pair<Char,Char>>
                //check filter zip list size is 1 => find inputString/inputString2 where char difference is only 1
                if(zipPairListFilter.toList().size == 1){

                    //Debug
                    //Log.e(LOG_TAG,"findCorrectID : two strings with 1 char different - $inputString vs $inputString2  diff $zipPairListFilter" )

                    //Debug
                    //Log.e(LOG_TAG,"findCorrectID :  found correct ID ! - $resultID" )

                    //return inputString without the char that is different
                    return inputString.replace(zipPairListFilter.first().first.toString(),"",false)
                }
            }
        }
        //ID not found
        return "ID not found!!"
    }
}
