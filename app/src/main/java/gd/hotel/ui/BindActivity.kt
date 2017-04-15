package gd.hotel.ui

import android.content.Intent

import gd.hotel.R
import gd.hotel.base.BaseActivity
import kotlinx.android.synthetic.main.activity_bind.*

/**
 * 生成旅馆代码，并进行旅馆绑定
 * */
class BindActivity : BaseActivity() {
    override fun initViews() {

    }

    override fun initEvents() {
        download_btn.setOnClickListener {
            if (login().check_pwd(manage_pwd_et.text.toString().trim())) {
                if (login().loadHotel(hotel_code_et.text.toString().trim(), this)) {//绑定成功，跳转到首页
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    toast("绑定失败，请重试")
                }
            } else {
                toast("管理密码不正确，请重新输入")
            }
        }
    }

    override fun setLayout(): Int {
        return R.layout.activity_bind
    }
}
