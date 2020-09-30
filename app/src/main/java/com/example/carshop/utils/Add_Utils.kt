package com.example.carshop.utils

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Environment
import android.os.StatFs




object Add_Utils{

    fun electronicCar (intent : Intent, context : Context) : String {

        val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
            context.registerReceiver(null, ifilter)
        }

        val batteryPct: Float? = batteryStatus?.let { intent ->
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            level * 100 / scale.toFloat()
        }

        return "Batería disponible (%): " + batteryPct.toString()
    }

    fun truckCar () : String {
        val statFs = StatFs(Environment.getExternalStorageDirectory().getAbsolutePath())
        val Free = statFs.availableBlocks * statFs.blockSize / 1048576
        return "Memoria libre dispoible: " + Integer.toString(Free)
    }

    fun commercialCar () : String {

        val stat = StatFs(Environment.getExternalStorageDirectory().getPath())
        val bytesAvailable = stat.blockSize.toLong() * stat.blockCount.toLong()
        val megAvailable = bytesAvailable / 1048576

        return "Capacidad disponible (MB):  :$megAvailable"
    }


    fun memoriaOcupada(): String? {
        val statFs = StatFs(Environment.getExternalStorageDirectory().getAbsolutePath())
        val Total = statFs.blockCount * statFs.blockSize / 1048576
        val Free = statFs.availableBlocks * statFs.blockSize / 1048576
        val Busy = Total - Free
        return Integer.toString(Busy)
    }

}