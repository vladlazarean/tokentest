package ro.rcsrds.tokentest.tools.adapters.horizontal

import androidx.recyclerview.widget.DiffUtil
import ro.rcsrds.tokentest.model.UiProduct

class UiMainHorizontalComparator: DiffUtil.ItemCallback<UiProduct>() {
    override fun areItemsTheSame(oldItem: UiProduct, newItem: UiProduct): Boolean {
        return oldItem.mId == newItem.mId
    }

    override fun areContentsTheSame(oldItem: UiProduct, newItem: UiProduct): Boolean {
        return oldItem == newItem
    }


}