package ro.rcsrds.tokentest.tools.adapters.viewHolders

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ro.rcsrds.tokentest.databinding.ItemProductBinding
import ro.rcsrds.tokentest.model.UiProduct
import ro.rcsrds.tokentest.tools.interfaces.ProductSelectInterface

class VHProduct(nItemView: View): RecyclerView.ViewHolder(nItemView) {

    fun bindUiData(nRow: UiProduct, nInterface: ProductSelectInterface) {
        DataBindingUtil.getBinding<ItemProductBinding>(itemView)?.let {
            it.vRow = nRow
            it.executePendingBindings()
        }
    }
}