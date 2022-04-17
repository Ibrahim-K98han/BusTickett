package com.ibrahimssoft.busticket

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:setFavorite")
fun setFavorite(imageView: ImageView, favorite:Boolean){
    when(favorite){
        true -> imageView.setImageResource(R.drawable.favorit_red)
        false -> imageView.setImageResource(R.drawable.favorit_gray)
    }
}