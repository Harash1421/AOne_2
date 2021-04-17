package com.example.aone_activity_result

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            R.id.meGoogle -> {
                var g = Uri.parse("https://www.google.com")
                var i:Intent = Intent(Intent.ACTION_VIEW, g)
                startActivity(i)
            }
            R.id.meCamera -> {
                var Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(Intent,1)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1 && resultCode == RESULT_OK){
            var photo = data!!.extras!!.get("data") as Bitmap
            main_imgPhoto.setImageBitmap(photo)
        }
    }
}