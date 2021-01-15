package com.example.eseothomas.ui.activities

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.Toast
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

        main_scan_BLE.animation = BotAnim
        main_command_internet.animation = BotAnim
        main_logoeseo.animation = TopAnim
        main_logoeseo.setOnClickListener {
            main_logoeseo.startAnimation(rotate)
        }
        main_scan_BLE.setOnClickListener {
            main_scan_BLE.startAnimation(expand)
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(ScanActivity.getStartIntent(this))
            }, 450)

        }

        main_command_internet.setOnClickListener {
            if (isInternetConnection()) {
                main_command_internet.startAnimation(expand)
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(InternetRemoteActivity.getStartIntent(this))
                }, 450)
            } else {
                Toast.makeText(this, getString(R.string.noInternet), Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun isInternetConnection(): Boolean {
        val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}