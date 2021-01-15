package com.example.eseothomas.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.eseothomas.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val BotAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        val TopAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val rotate = AnimationUtils.loadAnimation(this, R.anim.rotationfinite)
        val expand = AnimationUtils.loadAnimation(this, R.anim.disappear)
        expand.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                startActivity(ScanActivity.getStartIntent(this@MainActivity))
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })
        main_scan_BLE.animation = BotAnim
        main_command_internet.animation = BotAnim
        main_logoeseo.animation = TopAnim
        main_logoeseo.setOnClickListener {
            main_logoeseo.startAnimation(rotate)
        }
        main_scan_BLE.setOnClickListener {
            main_scan_BLE.startAnimation(expand)
        }

    }
}