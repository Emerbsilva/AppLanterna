package com.ebsindustrial.applanterna

import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebsindustrial.applanterna.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var estado = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.lanterna.setOnClickListener {
            if (!estado){
                binding.lanterna.setImageResource(R.drawable.ic_lanterna_on)
                estado = true
                luzLanterna(estado)
            }else{
                binding.lanterna.setImageResource(R.drawable.ic_lanterna_off)
                estado = false
                luzLanterna(estado)
            }
        }
    }

    private fun luzLanterna(estado: Boolean){
        // invoca um serviço de hardware da camera
        val cameraManager: CameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        // para identificar qual camera será usada
        val cameraId: String?

        try {
            // recebe da lista de id de cameras, o id da camera tr5aseira que é o 0
            cameraId = cameraManager.cameraIdList[0]
            cameraManager.setTorchMode(cameraId, estado)
        }catch (e: Exception){

        }
    }
}