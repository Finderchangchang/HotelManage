package gd.hotel.key

import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback

import okhttp3.Call
import okhttp3.Response

/**
 * Created by Administrator on 2017/4/1.
 */

class demo {
    internal fun load() {
        OkGo.post("http://s-352911.gotocdn.com/APP/shop/androidupload.ashx")//
                .tag(this)//
                .headers("type", "2")
                .headers("id", "5")
                .headers("ext", "jpg")
                .params("file1", "")    // 这里支持一个key传多个文件
                .execute(object : StringCallback() {
                    override fun onSuccess(s: String, call: Call, response: Response) {
                        //上传成功

                    }


                    override fun upProgress(currentSize: Long, totalSize: Long, progress: Float, networkSpeed: Long) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                })
    }
}
