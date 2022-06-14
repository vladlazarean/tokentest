package ro.rcsrds.tokentest.tools.bindings

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import ro.rcsrds.tokentest.model.UiBasket
import ro.rcsrds.tokentest.ui.other.CallableStates

@BindingAdapter(value = ["setPrice"])
fun setUpPriceTextView(nTextView: TextView?, nPriceInt: Int?) {
    if (nTextView != null && nPriceInt != null) {
        nTextView.setText(nPriceInt.toString() + " EUR")
    }
}

@BindingAdapter(value = ["setProductsNumberFromBasket", "setFlagUpdater"])
fun setUpProductsNumberFromBasketTextView(nTextView: TextView?, nBasketList: ArrayList<UiBasket>?, nFlagUpdater: CallableStates?) {
    if (nTextView != null && nBasketList != null && nFlagUpdater != null) {
        var mTempCounter = 0
        nBasketList.forEach { mBasket ->
            mTempCounter += mBasket.mQuantity
        }

        nTextView.setText(mTempCounter.toString())
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter(value = ["setBasketItemNum"])
fun setUpBasketItemNumTextView(nTextView: TextView?, nBasketItemNum: Int?) {
    if (nTextView != null && nBasketItemNum != null) {
        nTextView.setText("Items: $nBasketItemNum")
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter(value = ["setBasketItemsSum"])
fun setUpBasketItemsSumTextView(nTextView: TextView?, nBasketItems: List<UiBasket>?) {
    if (nTextView != null && nBasketItems != null) {
        var mTempSum = 0

        nBasketItems.forEach { mBasket ->
            mTempSum += mBasket.mQuantity
        }

        nTextView.setText("Total: $mTempSum")
    }
}