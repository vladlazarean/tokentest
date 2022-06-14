package ro.rcsrds.tokentest.tools.adapters.vertical

import androidx.recyclerview.widget.DiffUtil
import ro.rcsrds.tokentest.model.UiBasket

class UiPayVerticalComparator: DiffUtil.ItemCallback<UiBasket>() {
    override fun areItemsTheSame(oldItem: UiBasket, newItem: UiBasket): Boolean {
        return oldItem.mUiProduct.mId == newItem.mUiProduct.mId
    }

    override fun areContentsTheSame(oldItem: UiBasket, newItem: UiBasket): Boolean {
        return oldItem == newItem
    }


}