package ro.rcsrds.tokentest.tools.bindings

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["setPrice"])
fun setUpPriceTextView(nTextView: TextView?, nPriceInt: Int?) {
    if (nTextView != null && nPriceInt != null) {
        nTextView.setText(nPriceInt.toString())
    }
}