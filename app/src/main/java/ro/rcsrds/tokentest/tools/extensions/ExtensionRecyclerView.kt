package ro.rcsrds.tokentest.tools.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setUpRecyclerView(nAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>, nOrientation: Int ): RecyclerView
{
    this.layoutManager = LinearLayoutManager(this.context, nOrientation, false)
    this.adapter = nAdapter

    return this
}
