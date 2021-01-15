package com.example.eseothomas.ui.activities

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.eseothomas.R
import com.example.eseothomas.data.local.LocalPreferences
import com.example.eseothomas.data.model.LedStatus
import com.example.eseothomas.utils.service.ApiService
import kotlinx.android.synthetic.main.activity_internet_remote.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InternetRemoteActivity : AppCompatActivity() {

    private var ledStatus = LedStatus()
    private val rotate = AnimationUtils.loadAnimation(this, R.anim.rotationfinite)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet_remote)
        if (LocalPreferences.getInstance(this).lastConnectedDeviceName() == null) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.no_id_last_co))
            builder.setMessage(getString(R.string.msg_dialog_last_device))
            builder.setPositiveButton(android.R.string.yes) { _, _ ->
                finish()
            }
            builder.show()

        } else {
            LocalPreferences.getInstance(this).lastConnectedDeviceName()
                ?.let { ledStatus.setIdentifier(it) }
        }
        getStatus()
        internet_remote_button.setOnClickListener {
            changerLed()
        }
        image_on_off.setOnClickListener {
            getStatus()
            image_on_off.startAnimation(rotate)
        }
    }

    // Récupération de l'état depuis le serveur
    private fun getStatus() {
        CoroutineScope(Dispatchers.IO).launch {
            runCatching {

                val readStatus = ApiService.instance.readStatus(ledStatus.identifier)
                ledStatus.setStatus(readStatus.status)
                setVisualState()
            }
        }
    }

    private fun changerLed() {
        ledStatus.reverseStatus()
        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                ApiService.instance.writeStatus(ledStatus)
                setVisualState()
            }
        }

    }

    private fun setVisualState() {
        if (ledStatus.status) {
            image_on_off.setImageResource(R.drawable.ic_baseline_wb_sunny_on_24)
        } else {
            image_on_off.setImageResource(R.drawable.ic_baseline_wb_sunny_24)
        }
    }

}