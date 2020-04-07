package me.inassar.indigo.utils

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.view.View
import androidx.core.content.FileProvider
import me.inassar.indigo.BuildConfig
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

object Utils {


    /**
     * This function is used to convert view into image
     * @param view
     * @return Bitmap
     * */
    private fun takeScreenshot(view: View): Bitmap? {
        return view.apply {
            isDrawingCacheEnabled = true
        }.drawingCache
    }

    /**
     * This function is used to save messages as png files
     * @param applicationContext
     * @param view
     * @return File
     */
    private fun saveImage(applicationContext: Context, view: View): File? {
        val wrapper = ContextWrapper(applicationContext)
        var file = wrapper.getDir("Images", Context.MODE_PRIVATE)
        val fileName = String.format("%s_%d.png", "Image", System.currentTimeMillis())
        file = File(file, fileName)
        try {
            var stream: OutputStream?
            stream = FileOutputStream(file)
            takeScreenshot(view)!!.compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: IOException) // Catch the exception
        {
            e.printStackTrace()
        }
        val savedImageURI = Uri.parse(file.absolutePath)
        return File(savedImageURI.toString())
    }

    /**
     * This function is used to share image
     * @param imagePath
     * */
    fun shareMessage(context: Context, view: View) {

        val imagePath = saveImage(context, view)

        val uri = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            FileProvider.getUriForFile(
                context,
                BuildConfig.APPLICATION_ID + ".provider",
                imagePath!!
            )
        } else {
            Uri.fromFile(imagePath!!)
        }
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "image/*"
        val shareBody = ""
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "My Tweecher score")
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        sharingIntent.putExtra(Intent.EXTRA_STREAM, uri)
        context.startActivity(Intent.createChooser(sharingIntent, "Share via"))
    }
}