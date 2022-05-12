package com.gk.nasapicturesapp.ui.adapter

import android.annotation.SuppressLint
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.gk.nasapicturesapp.R
import com.gk.nasapicturesapp.databinding.ItemImageDetailsBinding
import com.gk.nasapicturesapp.model.ImagesData
import com.gk.nasapicturesapp.ui.`interface`.ImageDetailsClickInterface

class ImageDetailsAdapter(imagesList: ArrayList<ImagesData>,imageDetailsClickInterface: ImageDetailsClickInterface) :
    GenericAdapter<ImagesData, ItemImageDetailsBinding>(imagesList) {
    private val clickInterface = imageDetailsClickInterface
    override fun getLayoutId(): Int {
        return R.layout.item_image_details
    }

    @SuppressLint("SetTextI18n")
    override fun onBindData(
        model: ImagesData,
        position: Int,
        dataBinding: ItemImageDetailsBinding
    ) {
        dataBinding.apply {
            val circularProgressDrawable = CircularProgressDrawable(dataBinding.ivImage.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()

            Glide.with(ivImage.context)
                .load(model.hdurl)
                .placeholder(circularProgressDrawable)
                .into(dataBinding.ivImage)

            tvDate.text = "Posted On: "+model.date
            tvImageTitle.text = model.title
            tvImageDescription.text = model.explanation
            tvTitle.text = model.title
            ivBack.setOnClickListener {
                clickInterface.imageDetailsClickEvent()
            }

        }

    }
}
