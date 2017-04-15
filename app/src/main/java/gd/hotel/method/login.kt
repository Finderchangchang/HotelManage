package gd.hotel.ui

import com.lzy.okgo.OkGo
import gd.hotel.key.DialogCallback
import gd.hotel.key.LzyResponse
import gd.hotel.model.UserModel
import okhttp3.Call
import okhttp3.Response
import java.util.*

/**
 * 登录之前所有接口
 * 1.输入管理密码
 * 2.下载旅馆信息
 */
class login {

    /**
     * 根据用户名密码进行登录操作
     * */
    fun loadHotel(hotelId: String, context: BindActivity): Boolean {
        var result = true
        OkGo.get("")
                .execute(object : DialogCallback<LzyResponse<String>>(context) {
                    override fun onSuccess(model: LzyResponse<String>?, call: Call?, response: Response?) {
                        if (model != null) {
                            result = model.isSuccess
                        }
                    }

                    override fun onError(call: Call?, response: Response?, e: Exception?) {

                    }
                })
        return result
    }

    /**
     * 验证管理密码jcecc月加日
     * */
    fun check_pwd(pwd: String): Boolean {
        var c = Calendar.getInstance()
        var month = (c.get(Calendar.MONTH) + 1)
        var day = c.get(Calendar.DAY_OF_MONTH)
        var result = month + day
        if (day.toString().length == 2) {//天数是2位
            if (month.toString().length == 2) {
                var end_num = day.toString()[1].toInt() + month.toString()[1].toInt()
                if (end_num >= 10) {
                    result = result - 10
                }
            } else {
                var end_num = day.toString()[1].toInt() + month
                if (end_num >= 10) {
                    result = result - 10
                }
            }
        } else {//天数为1位
            if (month.toString().length == 2) {
                var end_num = day + month.toString()[1].toInt()
                if (end_num >= 10) {
                    result = result - 10
                }
            } else {
                if (result >= 10) {
                    result = result - 10
                }
            }
        }
        if (pwd.equals(result)) {
            return true
        } else {
            return false
        }
    }
}