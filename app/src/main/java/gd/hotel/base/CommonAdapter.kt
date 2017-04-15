package gd.hotel.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

abstract class CommonAdapter<T>(protected var mContext: Context, protected var mDatas: List<T>?, private val layoutId: Int) : BaseAdapter() {
    protected var mInflater: LayoutInflater

    init {
        mInflater = LayoutInflater.from(mContext)
    }

    override fun getCount(): Int {
        if (mDatas != null) {
            return mDatas!!.size
        } else {
            return 0
        }
    }

    override fun getItem(position: Int): T {
        return mDatas!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        val holder = getViewHolder(position, convertView, parent)
        convert(holder, getItem(position), position)
        return holder.convertView
    }

    private fun getViewHolder(position: Int, convertView: View, parent: ViewGroup): CommonViewHolder {
        return CommonViewHolder.get(mContext, convertView, parent, layoutId, position)
    }

    abstract fun convert(holder: CommonViewHolder, t: T, position: Int)

    fun refresh(items: List<T>) {
        this.mDatas = items
        notifyDataSetChanged()
    }
}
