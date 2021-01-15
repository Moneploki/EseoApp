package com.example.eseothomas.ui.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.eseothomas.R
import kotlinx.android.synthetic.main.activity_loading.*


class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        val tv = findViewById<View>(R.id.loading_text) as TextView
        tv.isSelected = true
        rotateEseo()
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(MainActivity.getStartIntent(this))
            finish()
        }, 1000)
    }

    private fun rotateEseo() {
        val rotate = AnimationUtils.loadAnimation(this, R.anim.rotationinfinite)
        loading_logoeseo.animation = rotate
    }

}