package com.zh.kotlin.imgsel

import android.Manifest
import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.media.MediaRecorder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import coil.Coil
import coil.api.load
import com.zh.kotlin.R
import com.zh.kotlin.utils.CoilUtils
import kotlinx.android.synthetic.main.activity_img_sel.*
import java.io.File
import java.net.URI
import java.security.Provider

class ImgSelActivity : AppCompatActivity() {

    companion object {

        fun launch(context: Context) {
            context.startActivity(Intent(context, ImgSelActivity::class.java))
        }
    }

    private val code1001 = 1001
    private val code1002 = 1002
    private val code1003 = 1003
    lateinit var file: File
    lateinit var uri: Uri
    private var arrayList =
        arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_img_sel)
        file =
            File(Environment.getExternalStorageDirectory().path + System.currentTimeMillis() + ".jpg")
        btn_go_album.setOnClickListener {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        code1001
                    )
                } else {
                    selAlbum()
                }
            }


        }
        btn_take_photo.setOnClickListener {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.CAMERA
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.CAMERA),
                        code1002
                    )
                } else {
                    takePhoto()
                }
            }
        }
    }


    private fun selAlbum() {
        val intent = Intent()
        intent.action = Intent.ACTION_PICK
        intent.type = "image/*"
        startActivityForResult(intent, code1001)
    }


    private fun takePhoto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(this, "com.zh.kotlin.Provider", file)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        } else {
            uri = Uri.fromFile(file)
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
        startActivityForResult(intent, code1002)

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            code1001 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    selAlbum()
                } else {
                    Toast.makeText(this, "您拒绝了读写权限", Toast.LENGTH_SHORT).show()
                }
            }
            code1002 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    takePhoto()
                } else {
                    Toast.makeText(this, "您拒绝了拍照权限", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                code1001 -> {
                    val slesctedImage = data!!.data

                    val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)

                    val cursor = contentResolver.query(
                        slesctedImage,

                        filePathColumn, null, null, null
                    )

                    cursor.moveToFirst()

                    val columnIndex = cursor.getColumnIndex(filePathColumn[0])

                    val picturePath = cursor.getString(columnIndex)

                    cursor.close()
                    Log.e("xxx", picturePath)
                    iv_result.load(Drawable.createFromPath(picturePath))

                }
                code1002 -> {
                    val imageUri = uri
                    iv_result.load(uri)
                }
                code1003 -> {
                    val imageUri = uri


                }
            }
        }
    }
}
