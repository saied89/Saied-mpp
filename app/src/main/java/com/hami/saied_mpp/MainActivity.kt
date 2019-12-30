package com.hami.saied_mpp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.jetbrains.handson.mpp.mobile.ApplicationApi
import com.jetbrains.handson.mpp.mobile.createApplicationScreenMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            ApplicationApi().getOnePerson {
                findViewById<TextView>(R.id.helloTV).text = it.name
            }
        }

        findViewById<TextView>(R.id.helloTV).text = createApplicationScreenMessage()
    }
}
