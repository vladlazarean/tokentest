package ro.rcsrds.tokentest.tools.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ro.rcsrds.tokentest.model.UiBasket
import ro.rcsrds.tokentest.model.UiProduct
import ro.rcsrds.tokentest.tools.adapters.horizontal.AdapterMainHorizontal
import ro.rcsrds.tokentest.tools.adapters.vertical.AdapterPayVertical
import ro.rcsrds.tokentest.tools.extensions.setUpRecyclerView
import ro.rcsrds.tokentest.ui.main.MainActivity

@BindingAdapter(value = ["setActivity", "setProductsList"])
fun setUpProductsRecyclerView(nRecyclerView: RecyclerView?, nMainActivity: MainActivity?, nProductsList: ArrayList<UiProduct>?) {
    if (nRecyclerView != null && nMainActivity != null && nProductsList != null) {
        if (nProductsList.size > 0) {
            val nAdapter = AdapterMainHorizontal(nMainActivity)
            nAdapter.submitList(nProductsList)
            nRecyclerView.setUpRecyclerView(nAdapter, RecyclerView.HORIZONTAL)
        }
    }
}

@BindingAdapter(value = ["setBasketList"])
fun setUpBasketRecyclerView(nRecyclerView: RecyclerView?, nBasketList: ArrayList<UiBasket>?) {
    if (nRecyclerView != null && nBasketList != null) {
        if (nBasketList.size > 0) {
            val nAdapter = AdapterPayVertical()
            nAdapter.submitList(nBasketList)
            nRecyclerView.setUpRecyclerView(nAdapter, RecyclerView.VERTICAL)
        }
    }
}
