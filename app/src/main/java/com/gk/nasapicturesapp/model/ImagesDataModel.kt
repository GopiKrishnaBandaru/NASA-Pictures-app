package com.gk.nasapicturesapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ImagesDataModel(

    var imagesList: ArrayList<ImagesData> = ArrayList()

) : Serializable


data class ImagesData(

    @SerializedName("copyright")
    var copyright: String = "",

    @SerializedName("date")
    var date: String = "",

    @SerializedName("explanation")
    var explanation: String = "",

    @SerializedName("hdurl")
    var hdurl: String = "",

    @SerializedName("media_type")
    var mediaType: String = "",

    @SerializedName("service_version")
    var serviceVersion: String = "",

    @SerializedName("title")
    var title: String = "",

    @SerializedName("url")
    var url: String = "",


    ) : Serializable

