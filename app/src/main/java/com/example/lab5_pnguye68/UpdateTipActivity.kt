package com.example.lab5_pnguye68

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UpdateTipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_tip)

        val excellentInput = findViewById<EditText>(R.id.editTextExcellent)
        val averageInput = findViewById<EditText>(R.id.editTextAverage)
        val belowInput = findViewById<EditText>(R.id.editTextBelow)

        // Get incoming values and set as hints
        excellentInput.hint = intent.getIntExtra("EXCELLENT", 25).toString()
        averageInput.hint = intent.getIntExtra("AVERAGE", 20).toString()
        belowInput.hint = intent.getIntExtra("BELOW", 15).toString()

        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val buttonCancel = findViewById<Button>(R.id.buttonCancel)

        buttonSave.setOnClickListener {
            val resultIntent = Intent()
            if (excellentInput.text.isNotEmpty()) {
                resultIntent.putExtra("EXCELLENT", excellentInput.text.toString().toInt())
            }
            if (averageInput.text.isNotEmpty()) {
                resultIntent.putExtra("AVERAGE", averageInput.text.toString().toInt())
            }
            if (belowInput.text.isNotEmpty()) {
                resultIntent.putExtra("BELOW", belowInput.text.toString().toInt())
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        buttonCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}