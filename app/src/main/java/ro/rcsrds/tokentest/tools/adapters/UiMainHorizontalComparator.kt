package ro.rcsrds.tokentest.tools.adapters

import androidx.recyclerview.widget.DiffUtil
import ro.rcsrds.tokentest.model.UiProduct

class UiMainHorizontalComparator: DiffUtil.ItemCallback<UiProduct>() {
    override fun areItemsTheSame(oldItem: UiProduct, newItem: UiProduct): Boolean {
        return oldItem.mTitle == newItem.mTitle
    }

    override fun areContentsTheSame(oldItem: UiProduct, newItem: UiProduct): Boolean {
        return oldItem == newItem
    }


}