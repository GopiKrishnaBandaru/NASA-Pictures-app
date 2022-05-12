package com.gk.nasapicturesapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gk.nasapicturesapp.R
import com.gk.nasapicturesapp.databinding.ActivityImagesDisplayBinding
import com.gk.nasapicturesapp.model.ImagesData
import com.gk.nasapicturesapp.ui.`interface`.ImageDetailsClickInterface
import com.gk.nasapicturesapp.ui.adapter.ImageDetailsAdapter
import com.gk.nasapicturesapp.utilis.AppConstants


class ImagesDetailsActivity : AppCompatActivity(), ImageDetailsClickInterface {

    private lateinit var binding: ActivityImagesDisplayBinding
    private var imagesList: ArrayList<ImagesData> = ArrayList()
    private var imagePosition = 0
    private lateinit var imageDetailsAdapter: ImageDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_images_display
        )
        val mBundle = intent.getBundleExtra(AppConstants.IMAGE_DETAIL_ARGS)
        imagePosition = mBundle!!.getInt(AppConstants.IMAGE_POSITION)
        imagesList = mBundle.getSerializable(AppConstants.IMAGES_LIST) as ArrayList<ImagesData>
        initUI()
    }


    private fun initUI() {
        binding.tvTitle.text = imagesList[imagePosition].title
        imageDetailsAdapter = ImageDetailsAdapter(imagesList,this)
        binding.imagesViewPager.adapter = imageDetailsAdapter
        binding.imagesViewPager.setCurrentItem(imagePosition, true)
    }

    override fun imageDetailsClickEvent() {
        finish()
    }


}