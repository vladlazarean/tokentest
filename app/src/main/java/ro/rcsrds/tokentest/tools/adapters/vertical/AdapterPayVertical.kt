package ro.rcsrds.tokentest.tools.adapters.vertical

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ro.rcsrds.tokentest.R
import ro.rcsrds.tokentest.model.UiBasket
import ro.rcsrds.tokentest.tools.adapters.viewHolders.VHBasketProduct

class AdapterPayVertical(): ListAdapter<UiBasket, RecyclerView.ViewHolder>(UiPayVerticalComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val mDataBindingView: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_basket_product, parent, false)
        return VHBasketProduct(mDataBindingView.root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as VHBasketProduct).bindUiData(currentList[position])
    }

}