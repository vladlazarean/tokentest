package ro.rcsrds.tokentest.tools.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ro.rcsrds.tokentest.model.UiProduct
import ro.rcsrds.tokentest.tools.adapters.AdapterMainHorizontal
import ro.rcsrds.tokentest.tools.extensions.setUpRecyclerView
import ro.rcsrds.tokentest.ui.MainActivity

@BindingAdapter(value = ["setActivity", "setProductsList"])
fun setUpProductsRecyclerView(nRecyclerView: RecyclerView?, nMainActivity: MainActivity?, nProductsList: ArrayList<UiProduct>?) {
    if (nRecyclerView != null && nMainActivity != null && nProductsList != null) {
        if (nProductsList.size > 0) {
            val nAdapter = AdapterMainHorizontal(nMainActivity)
            nAdapter.submitList(nProductsList)
            nRecyclerView.setUpRecyclerView(nAdapter = nAdapter, RecyclerView.HORIZONTAL)
        }
    }
}