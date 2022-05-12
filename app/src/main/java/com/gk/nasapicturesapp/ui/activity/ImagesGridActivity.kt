package com.gk.nasapicturesapp.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.gk.nasapicturesapp.R
import com.gk.nasapicturesapp.databinding.ActivityImagesGridBinding
import com.gk.nasapicturesapp.model.ImagesData
import com.gk.nasapicturesapp.ui.`interface`.ImageClickInterface
import com.gk.nasapicturesapp.ui.adapter.ImagesAdapter
import com.gk.nasapicturesapp.utilis.AppConstants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class ImagesGridActivity : AppCompatActivity(), ImageClickInterface {

    private lateinit var binding: ActivityImagesGridBinding
    private var imagesList: ArrayList<ImagesData> = ArrayList()
    private lateinit var imagesAdapter: ImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_images_grid
        )
        initUI()
        fetchImageListFromAssets()
    }


    private fun initUI() {
        binding.rvImages.layoutManager =
            GridLayoutManager(this, 2)
    }

    private fun fetchImageListFromAssets() {
        val jsonFileString = getJsonDataAsStringFromAsset(applicationContext, "data.json")
        val gson = Gson()
        val listPersonType = object : TypeToken<List<ImagesData>>() {}.type
        imagesList = gson.fromJson(jsonFileString, listPersonType)
        setAdapter()
    }


    private fun getJsonDataAsStringFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    private fun setAdapter() {
        imagesAdapter = ImagesAdapter(imagesList, this)
        binding.rvImages.adapter = imagesAdapter
    }

    override fun imageClickEvent(position: Int) {
        val imageDetailsIntent = Intent(this, ImagesDetailsActivity::class.java)
        val mBundle = Bundle()
        mBundle.putInt(AppConstants.IMAGE_POSITION, position)
        mBundle.putSerializable(AppConstants.IMAGES_LIST, imagesList)
        imageDetailsIntent.putExtra(AppConstants.IMAGE_DETAIL_ARGS, mBundle)
        startActivity(imageDetailsIntent)
    }
}