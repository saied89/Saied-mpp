package com.hami.saied_mpp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.jetbrains.handson.mpp.mobile.createApplicationScreenMessage
import com.jetbrains.handson.mpp.mobile.getOnePersion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val name: String = withContext(Dispatchers.IO) {
                getOnePersion().name
            }
            findViewById<TextView>(R.id.helloTV).text = name
        }

        findViewById<TextView>(R.id.helloTV).text = createApplicationScreenMessage()
    }
}
