package com.gk.nasapicturesapp.utilis

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import com.gk.nasapicturesapp.R
import java.util.*


object CommonMethods {


    private var mProgressDialog: ProgressDialog? = null

    @SuppressLint("ResourceAsColor")
    fun showProgress(mContext: Context) {
        if (mProgressDialog == null) {

            mProgressDialog = ProgressDialog(mContext, R.style.AppTheme)
            if (mProgressDialog?.window != null) mProgressDialog?.window!!
                .setBackgroundDrawable(
                    ColorDrawable(R.color.color_bg_progress_bar)
                )
            mProgressDialog?.window?.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
            mProgressDialog?.isIndeterminate = true
            mProgressDialog?.setCancelable(false)
            mProgressDialog?.setCanceledOnTouchOutside(false)
            mProgressDialog?.show()
            mProgressDialog?.setContentView(R.layout.layout_loader_progress_bar)

            mProgressDialog?.setOnDismissListener {
            }
        }

        if (!mProgressDialog!!.isShowing) {
            mProgressDialog?.show()
        }

    }

    fun hideProgress() {

        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog?.dismiss()
        }
        mProgressDialog = null
    }


}