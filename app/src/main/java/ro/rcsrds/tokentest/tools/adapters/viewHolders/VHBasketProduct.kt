package ro.rcsrds.tokentest.tools.adapters.viewHolders

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ro.rcsrds.tokentest.databinding.ItemBasketProductBinding
import ro.rcsrds.tokentest.model.UiBasket

class VHBasketProduct(nItemView: View): RecyclerView.ViewHolder(nItemView) {

    fun bindUiData(nRow: UiBasket) {
        DataBindingUtil.getBinding<ItemBasketProductBinding>(itemView)?.let {
            it.vRow = nRow
            it.executePendingBindings()
        }
    }
}