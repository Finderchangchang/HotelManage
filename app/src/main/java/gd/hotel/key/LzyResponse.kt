package gd.hotel.key

import java.io.Serializable

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：16/9/28
 * 描    述：
 * 修订历史：
 * ================================================
 */
class LzyResponse<T> : Serializable {
    var total: Int = 0
    var code: Int = 0
    var msg: String? = null
    var rows: List<T>? = null
    var randomNumber: String = ""
    var isSuccess: Boolean = false
    var message: String = ""
    var time: String = ""

    companion object {

        private const val serialVersionUID = 5213230387175987834L
    }
}