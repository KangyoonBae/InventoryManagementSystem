package appforcivil.kb_adventofcode_day2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import appforcivil.kb_adventofcode_day2.utils.CalculateChecksum
import appforcivil.kb_adventofcode_day2.utils.FindCorrectID
import kotlinx.android.synthetic.main.activity_main.*



/**
 * MainActivity
 * This class is for implementation for MainActivity
 */
class MainActivity : AppCompatActivity() {

    //Static object for LOG_TAG
    companion object {
        private const val LOG_TAG = "MainActivity"
    }

    //Enum for UI Stages
    enum class UIStage {
        dataLoading, calculate, completed
    }



    /**
     * This Override function get called when activity is created.
     * @param savedInstanceState Bundle?
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Set the layout
        setContentView(R.layout.activity_main)

        //Set UIs
        setUIs()
    }

    /**
     * Main function for the calculation of checksum and correct IDs.
     * @param listOfInputString List<String> - List of String from the raw input
     */
    private fun calculateChecksumAndFindCorrectIDs(listOfInputString:List<String>){
        //Update UI
        updateUI(UIStage.calculate)

        //Create helper class CalculateChecksum
        val calculateChecksumHelper = CalculateChecksum(listOfInputString)
        //Call function calculateChecksumHelper to calculates
        val resultChecksum =  calculateChecksumHelper.calculateChecksum()

        //Create helper class FindCorrectID
        val findCorrectIDHelper = FindCorrectID(listOfInputString)
        //Call function findCorrectIDHelper to find correctID
        val resultCorrectID =  findCorrectIDHelper.findCorrectID()

        //Debug
        //Log.e(LOG_TAG, "calculateChecksumAndFindCorrectIDs - resultChecksum:$resultChecksum")

        //Update UI with Checksum and CorrectID result
        updateUI(UIStage.completed,resultChecksum = resultChecksum,resultCorrectID = resultCorrectID)
    }

    /**
     * function for loading a raw data into a list of String
     * @return List<String>
     */
    private fun loadData():List<String>{
        //Update UI
        updateUI(UIStage.dataLoading)

        //Loading Data - read file as inputStream, covert to string, and put each lines into List<String>
        //**Read raw input source path and file from R.string
        val inputStream = resources.openRawResource(
            resources.getIdentifier(resources.getString(R.string.data_input_name),
                resources.getString(R.string.data_input_path), packageName))
        val inputAsString = inputStream.reader().readText()
        return inputAsString.lines()
    }


    /**
     * function for setting up UI
     *
     */
    private fun setUIs(){
        //Hide progressBar
        pb.visibility = View.INVISIBLE

        //Set the Calculate button click event
        btnCalculate.setOnClickListener{
            //Call loadData and calculateChecksumAndFindCorrectIDs
            calculateChecksumAndFindCorrectIDs(loadData())
        }
    }



    /**
     * Function to update UIs
     * @param uiStage UIStage - Enum for UIS Stages
     * @param resultChecksum Int ***OPTIONAL - Checksum to display
     * @param resultCorrectID String ***OPTIONAL  - CorrectID to display
     */

    private fun updateUI(uiStage: UIStage, resultChecksum:Int = -1, resultCorrectID:String = "None"){
        //Switch
        when(uiStage) {
            //UIStage loading: show progress bar and update Message TextView
            UIStage.dataLoading ->{
                tvMessage.text = "Data Loading..."
                pb.visibility = View.VISIBLE
            }
            //UIStage calculate: update Message TextView (Delay for real-application effect)
            UIStage.calculate -> {
                Handler().postDelayed({
                    tvMessage.text = "Calculating..."
                }, 700)
            }
            //UIStage completed: hide progress bar and update Message TextView (Delay for real-application effect)
            UIStage.completed -> {
                //Update UIs
                Handler().postDelayed({
                    tvMessage.text = " Task Completed!"
                    pb.visibility = View.INVISIBLE
                    tvChecksum.text = "Checksum \n$resultChecksum"
                    tvCorrectID.text = "Correct Box ID \n$resultCorrectID"
                }, 1200)
            }
        }
    }


}
