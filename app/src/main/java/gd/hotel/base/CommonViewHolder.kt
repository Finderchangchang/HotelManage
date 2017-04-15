package gd.hotel.base

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView

/**
 * Created by liuliu on 2015/11/16   16:29

 * @author 柳伟杰
 * *
 * @Email 1031066280@qq.com
 */
class CommonViewHolder private constructor(private val mContext: Context, parent: ViewGroup, layoutId: Int,
                                           val position: Int) {
    private val mViews: SparseArray<View>
    val convertView: View

    init {
        this.mViews = SparseArray<View>()
        convertView = LayoutInflater.from(mContext).inflate(layoutId, parent,
                false)
        convertView.tag = this
    }

    fun setHeight(viewId: Int, height: Int): CommonViewHolder {
        val view = getView<LinearLayout>(viewId)
        val lp = view.layoutParams
        lp.height = height
        view.layoutParams = lp
        return this
    }

    fun setMargin(viewId: Int, left: Int, right: Int, top: Int, bottom: Int): CommonViewHolder {
        val ll = getView<LinearLayout>(viewId)
        val layoutParams = ll.layoutParams as LinearLayout.LayoutParams
        layoutParams.setMargins(left, right, top, bottom)//4个参数按顺序分别是左上右下
        ll.layoutParams = layoutParams
        return this
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views

     * @param viewId
     * *
     * @return
     */
    fun <T : View> getView(viewId: Int): T {
        var view: View? = mViews.get(viewId)
        if (view == null) {
            view = convertView.findViewById(viewId)
            mViews.put(viewId, view)
        }
        return view as T
    }

    /**
     * 为TextView设置字符串

     * @param viewId
     * *
     * @param text
     * *
     * @return
     */
    fun setText(viewId: Int, text: String): CommonViewHolder {
        val view = getView<TextView>(viewId)
        view.text = text + ""
        return this
    }

    fun setBGText(viewId: Int, text: String): CommonViewHolder {
        val view = getView<Button>(viewId)
        view.text = text + ""
        return this
    }

    fun setBG(viewId: Int, text: Int): CommonViewHolder {
        val view = getView<View>(viewId)
        view.setBackgroundResource(text)
        return this
    }

    fun setTextColor(viewId: Int, text: Int): CommonViewHolder {
        val view = getView<TextView>(viewId)
        view.setTextColor(mContext.resources.getColor(text))
        return this
    }

    fun setStar(viewId: Int, num: String): CommonViewHolder {
        val rb = getView<RatingBar>(viewId)
        rb.numStars = Integer.parseInt(num)
        return this
    }


    //获取知道textview的值
    fun getText(viewId: Int): String {
        val view = getView<TextView>(viewId)
        return view.text.toString().trim { it <= ' ' }
    }

    /**
     * 设置监听时间

     * @param viewId
     * *
     * @param listener
     * *
     * @return
     */
    fun setOnClickListener(viewId: Int, listener: View.OnClickListener): CommonViewHolder {
        val view = getView<View>(viewId)
        view.setOnClickListener(listener)
        return this
    }


    /**
     * 为ImageView设置图片

     * @param viewId
     * *
     * @param drawableId
     * *
     * @return
     */
    fun setImageResource(viewId: Int, drawableId: Int): CommonViewHolder {
        val view = getView<ImageView>(viewId)
        view.setImageResource(drawableId)
        return this
    }

    /**
     * 为ImageView设置图片

     * @param viewId
     * *
     * @param bm
     * *
     * @return
     */
    fun setImageBitmap(viewId: Int, bm: Bitmap): CommonViewHolder {
        val view = getView<ImageView>(viewId)
        view.setImageBitmap(bm)
        return this
    }

    fun setImageDrawable(viewId: Int, bm: Drawable): CommonViewHolder {
        val view = getView<ImageView>(viewId)
        view.setImageDrawable(bm)
        return this
    }

    private fun setImageTag(viewId: Int, url: String): ImageView {
        val view = getView<ImageView>(viewId)
        view.tag = url
        return view
    }

    /**
     * 设置控件显示隐藏

     * @param viewId（控件id）
     * *
     * @param result(控件显示隐藏)
     */
    fun setVisible(viewId: Int, result: Boolean): CommonViewHolder {
        val view = getView<View>(viewId)
        if (result) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
        return this
    }

    companion object {

        /**
         * 拿到一个ViewHolder对象

         * @param context
         * *
         * @param convertView
         * *
         * @param parent
         * *
         * @param layoutId
         * *
         * @param position
         * *
         * @return
         */
        operator fun get(context: Context, convertView: View?,
                         parent: ViewGroup, layoutId: Int, position: Int): CommonViewHolder {
            if (convertView == null) {
                return CommonViewHolder(context, parent, layoutId, position)
            }
            return convertView.tag as CommonViewHolder
        }
    }
}
