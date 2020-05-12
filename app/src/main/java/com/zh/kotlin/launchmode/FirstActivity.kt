package com.zh.kotlin.launchmode

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.zh.kotlin.R
import kotlinx.android.synthetic.main.activity_first.*

/**
 * 1：启动activity
 *  onCreate->onStart->onResume
 *  2:跳转second
 *  onPause-> onCreate（second）-onStart（second）-onResume（second）->onStop
 *  3:second返回
 *  onPause（second）->onRestart()->onStart->onResume->onStop（second）->onDestroy（second）
 *  4:跳转dialogactivity
 *  onPause
 *  5：dialog返回
 *  onResume
 * */
class FirstActivity : AppCompatActivity() {
    private val requestCode = 1001
    private val tag = "FirstActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        setContentView(R.layout.activity_first)
        btn_jump.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, requestCode)
        }
        btn_jump_dialog.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1001 -> {
                if (resultCode == Activity.RESULT_OK)
                    Toast.makeText(this, "返回成功了", Toast.LENGTH_LONG).show()
            }
        }
    }
}
