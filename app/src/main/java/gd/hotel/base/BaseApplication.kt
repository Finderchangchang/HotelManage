package gd.hotel.base

import android.app.Application
import android.content.Context

import com.lzy.okgo.OkGo
import com.lzy.okgo.cookie.store.PersistentCookieStore

import gd.hotel.R

/**
 * Created by Administrator on 2017/2/4.
 */

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        OkGo.init(this)//初始化OkGo---必须
        OkGo.getInstance()
                .setCookieStore(PersistentCookieStore())//cookie持久化存储，如果cookie不过期，则一直有效
                .setCertificates(resources.openRawResource(R.raw.cer))//加载证书
    }

    companion object {
        var context: Context? = null
    }
}
