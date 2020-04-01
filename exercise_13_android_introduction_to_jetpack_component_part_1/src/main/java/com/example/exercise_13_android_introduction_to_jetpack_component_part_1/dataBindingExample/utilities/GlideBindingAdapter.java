package com.example.exercise_13_android_introduction_to_jetpack_component_part_1.dataBindingExample.utilities;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.exercise_13_android_introduction_to_jetpack_component_part_1.R;

/**
 * GlideBindingAdapter to set the image in the mylayout
 */
public class GlideBindingAdapter {
    @BindingAdapter("imageUrl")
    public static void setImageResource(ImageView view, String imageUrl){
        Context context = view.getContext();

        RequestOptions option = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .load(imageUrl.trim())
                .fitCenter()
                .placeholder(R.mipmap.ic_launcher)
                .into(view);
    }

}
