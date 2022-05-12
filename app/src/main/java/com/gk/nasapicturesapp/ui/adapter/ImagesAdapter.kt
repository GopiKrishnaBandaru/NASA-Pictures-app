package com.gk.nasapicturesapp.ui.adapter

import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.gk.nasapicturesapp.R
import com.gk.nasapicturesapp.databinding.ItemImagesBinding
import com.gk.nasapicturesapp.model.ImagesData
import com.gk.nasapicturesapp.ui.`interface`.ImageClickInterface

class ImagesAdapter(imagesList: ArrayList<ImagesData>, imageClickInterface: ImageClickInterface) :
    GenericAdapter<ImagesData, ItemImagesBinding>(imagesList) {
    private val clickInterface = imageClickInterface
    override fun getLayoutId(): Int {
        return R.layout.item_images
    }

    override fun onBindData(
        model: ImagesData,
        position: Int,
        dataBinding: ItemImagesBinding
    ) {
        dataBinding.apply {
            val circularProgressDrawable = CircularProgressDrawable(dataBinding.ivImage.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()

            Glide.with(ivImage.context)
                .load(model.url)
                .placeholder(circularProgressDrawable)
                .into(dataBinding.ivImage)

            tvImageTitle.text = model.title

            clMain.setOnClickListener {
                clickInterface.imageClickEvent(position)
            }
        }

    }
}
