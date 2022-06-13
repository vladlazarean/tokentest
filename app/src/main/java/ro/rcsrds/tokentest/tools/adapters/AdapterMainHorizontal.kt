package ro.rcsrds.tokentest.tools.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ro.rcsrds.tokentest.R
import ro.rcsrds.tokentest.model.UiProduct
import ro.rcsrds.tokentest.tools.adapters.viewHolders.VHProduct
import ro.rcsrds.tokentest.tools.interfaces.ProductSelectInterface
import ro.rcsrds.tokentest.ui.main.MainActivity

class AdapterMainHorizontal(private val mActivity: MainActivity): ListAdapter<UiProduct, RecyclerView.ViewHolder>(UiMainHorizontalComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val mDataBindingView: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_product, parent, false)
        return VHProduct(mDataBindingView.root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as VHProduct).bindUiData(currentList[position], mActivity as ProductSelectInterface)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}