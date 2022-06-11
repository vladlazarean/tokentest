package ro.rcsrds.tokentest.tools.adapters.viewHolders

import android.app.AlertDialog
import android.os.Build
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ro.rcsrds.tokentest.R
import ro.rcsrds.tokentest.databinding.ItemProductBinding
import ro.rcsrds.tokentest.model.UiBasket
import ro.rcsrds.tokentest.model.UiProduct
import ro.rcsrds.tokentest.tools.interfaces.ProductSelectInterface

class VHProduct(nItemView: View): RecyclerView.ViewHolder(nItemView) {
    lateinit var mInterface: ProductSelectInterface
    lateinit var mRow: UiProduct

    @RequiresApi(Build.VERSION_CODES.O)
    fun bindUiData(nRow: UiProduct, nInterface: ProductSelectInterface) {
        mInterface = nInterface
        mRow = nRow

        DataBindingUtil.getBinding<ItemProductBinding>(itemView)?.let {
            it.vRow = nRow
            it.addB.setOnClickListener { view ->
                setDialog(nRow.mTitle)
            }
            it.executePendingBindings()
        }
    }

    private fun setDialog(nTitle: String) {
        val mInput = EditText(itemView.context)
        mInput.hint = "Add ammount"
        mInput.inputType = InputType.TYPE_CLASS_NUMBER

        AlertDialog.Builder(itemView.context)
            .setTitle(nTitle)
            .setView(mInput)
            .setPositiveButton("OK") { dialog, which ->
                if (!mInput.text.toString().isEmpty()) { addProductQuantityToBasket(mInput.text.toString().toInt()) }
            }
            .setNegativeButton("Cancel") { dialog, which -> dialog.cancel() }
            .show()
    }

    private fun addProductQuantityToBasket(nQuantity: Int) {
        if (nQuantity == 0) {
            Toast.makeText(itemView.context, itemView.resources.getText(R.string.warning_ammount), Toast.LENGTH_LONG).show()
        } else {
            mInterface.onProductSelected(UiBasket().apply { mQuantity = nQuantity; mUiProduct = mRow })
            Toast.makeText(itemView.context, itemView.resources.getText(R.string.warning_added), Toast.LENGTH_LONG).show()
        }

    }
}