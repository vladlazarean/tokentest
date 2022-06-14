package ro.rcsrds.tokentest.tools.bindings

import android.widget.TextView
import androidx.databinding.BindingAdapter
import ro.rcsrds.tokentest.model.UiBasket

@BindingAdapter(value = ["setPrice"])
fun setUpPriceTextView(nTextView: TextView?, nPriceInt: Int?) {
    if (nTextView != null && nPriceInt != null) {
        nTextView.setText(nPriceInt.toString() + " EUR")
    }
}

@BindingAdapter(value = ["setProductsNumberFromBasket"])
fun setUpProductsNumberFromBasketTextView(nTextView: TextView?, nBasketList: ArrayList<UiBasket>?) {
    if (nTextView != null && nBasketList != null) {
        var mTempCounter = 0
        nBasketList.forEach { mBasket ->
            mTempCounter += mBasket.mQuantity
        }

        nTextView.setText(mTempCounter.toString())
    }
}

@BindingAdapter(value = ["setBasketItemNum"])
fun setUpBasketItemNumTextView(nTextView: TextView?, nBasketItemNum: Int?) {
    if (nTextView != null && nBasketItemNum != null) {
        nTextView.setText(nBasketItemNum.toString())
    }
}