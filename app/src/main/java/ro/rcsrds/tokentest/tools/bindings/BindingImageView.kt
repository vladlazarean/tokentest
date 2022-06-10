package ro.rcsrds.tokentest.tools.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["setImageRes"])
fun setUpFromResImage(nImageView: ImageView?, nImageRes: Int?) {
    if (nImageView != null && nImageRes != null) {
        nImageView.setImageResource(nImageRes)
    }
}