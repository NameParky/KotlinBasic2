package com.example.tmt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = getString(R.string.app_name)

        val talk = findViewById<TextView>(R.id.talk)

        var setLine = fun (int : Int?) {
            talk.ellipsize = null
            talk.maxLines = Int.MAX_VALUE
            if(int != null) {
                talk.maxLines = int
            }
            talk.setEllipsize(TextUtils.TruncateAt.END)
        }

        var settingEllipsize = fun (textUtils : TextUtils.TruncateAt) {
            talk.maxLines = 1
            talk.setEllipsize(textUtils)
        }

        // 이건 오류 (함수는 본문에서 처리해야하는 듯 싶다.)
        // val show10 = findViewById<Button>(R.id.show10).setOnClickListener(setLine(10))
        val show10 = findViewById<Button>(R.id.show10).setOnClickListener { setLine(10) }
        val show5 = findViewById<Button>(R.id.show5).setOnClickListener() { setLine(5) }
        val show3 = findViewById<Button>(R.id.show3).setOnClickListener() { setLine(3) }


        val removeStart = findViewById<Button>(R.id.remove_start).setOnClickListener{ settingEllipsize(TextUtils.TruncateAt.START) }
        val removeMiddle = findViewById<Button>(R.id.remove_middle).setOnClickListener { settingEllipsize(TextUtils.TruncateAt.MIDDLE) }
        val removeEnd = findViewById<Button>(R.id.remove_end).setOnClickListener { settingEllipsize(TextUtils.TruncateAt.END) }

        val showAll = findViewById<Button>(R.id.all_show).setOnClickListener { setLine(null) }

    }
}