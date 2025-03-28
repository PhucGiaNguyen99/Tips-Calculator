package com.example.lab5_pnguye68

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var excellentPercent = 25
    private var averagePercent = 20
    private var belowPercent = 15

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextBill = findViewById<EditText>(R.id.editTextBill)
        val editTextPeople = findViewById<EditText>(R.id.editTextPeople)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        val textTip = findViewById<TextView>(R.id.textViewTip)
        val textTotal = findViewById<TextView>(R.id.textViewTotal)
        val textPerPerson = findViewById<TextView>(R.id.textViewPerPerson)

        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val buttonUpdate = findViewById<Button>(R.id.buttonUpdate)

        radioGroup.setOnCheckedChangeListener{_, _ ->
            val bill = editTextBill.text.toString().toDoubleOrNull() ?: 0.0
            val tipPercent = when (radioGroup.checkedRadioButtonId) {
                R.id.radioExcellent -> excellentPercent
                R.id.radioAverage -> averagePercent
                R.id.radioBelow -> belowPercent
                else -> 0
            }
            val tipAmount = bill * tipPercent / 100
            val total = bill + tipAmount
            val people = editTextPeople.text.toString().toIntOrNull() ?: 1
            val perPerson = total / people

            textTip.text = "Tip total: $%.2f".format(tipAmount)
            textTotal.text = "Total: $%.2f".format(total)
            textPerPerson.text = "Total per: $%.2f".format(perPerson)
        }

        buttonClear.setOnClickListener {
            editTextBill.text.clear()
            editTextPeople.text.clear()
            radioGroup.clearCheck()
            textTip.text = "Tip total: $"
            textTotal.text = "Total: $"
            textPerPerson.text = "Total per: $"
        }

        buttonUpdate.setOnClickListener {
            val intent = Intent(this, UpdateTipActivity::class.java)
            intent.putExtra("EXCELLENT", excellentPercent)
            intent.putExtra("AVERAGE", averagePercent)
            intent.putExtra("BELOW", belowPercent)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            excellentPercent = data.getIntExtra("EXCELLENT", excellentPercent)
            averagePercent = data.getIntExtra("AVERAGE", averagePercent)
            belowPercent = data.getIntExtra("BELOW", belowPercent)

            findViewById<RadioButton>(R.id.radioExcellent).text = "EXCELLENT (${excellentPercent}%)"
            findViewById<RadioButton>(R.id.radioAverage).text = "Average (${averagePercent}%)"
            findViewById<RadioButton>(R.id.radioBelow).text = "Below Average (${belowPercent}%)"
        }
    }
}