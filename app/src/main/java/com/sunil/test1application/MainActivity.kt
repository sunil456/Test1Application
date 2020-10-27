package com.sunil.test1application

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    var packageName: String? = "com.sunil.test2application"

    var firstValue: String = ""
    var secondValue: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        add_button.setOnClickListener {
            if(firstValue == null && secondValue == null)
            {
                Toast.makeText(this, "Please Enter Value", Toast.LENGTH_SHORT).show()
            }
            else
            {
                firstValue = editText_first_no.text.toString()
                secondValue = editText_second_no.text.toString()


//               val launchIntent = Intent("com.sunil.test2application")
//                launchIntent?.putExtra("FIRST_VALUE", firstValue.toLong())
//                launchIntent?.putExtra("SECOND_VALUE", secondValue.toLong())
//                applicationContext.sendBroadcast(launchIntent)

                val launchIntent = packageManager.getLaunchIntentForPackage("com.sunil.test2application")
                launchIntent?.putExtra("FIRST_VALUE", firstValue.toLong())
                launchIntent?.putExtra("SECOND_VALUE", secondValue.toLong())
                launchIntent?.let { startActivity(it) }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK)
        {
            Toast.makeText(this, data?.extras.toString(), Toast.LENGTH_SHORT).show()
        }

    }
}