package com.mj.findfriend.ui

import android.annotation.TargetApi
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import butterknife.OnClick
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mj.core.util.L
import com.mj.findfriend.R
import com.mj.findfriend.net.entity.GirlFriend
import com.mj.findfriend.utils.TestUtils
import kotlinx.android.synthetic.main.activity_gril_friend.*
import java.util.*

/**
 * Created by huaqiang
 * on 2016-06-01.
 */
class GirlFriendActivity : Activity() {
    /*@InjectView(R.id.et_height)
    EditText etHeight;//身高
    @InjectView(R.id.et_weight)
    EditText etWeight;//体重*/
    /*@InjectView(R.id.sp_height)
    internal var spHeight: Spinner? = null
    @InjectView(R.id.sp_weight)
    internal var spWeight: Spinner? = null
    @InjectView(R.id.sp_age)
    internal var spAge: Spinner? = null//年龄
    @InjectView(R.id.sp_bust)
    internal var spBust: Spinner? = null//胸围
    @InjectView(R.id.sp_colour)
    internal var spColour: Spinner? = null//肤色
    @InjectView(R.id.sp_face_shape)
    internal var spFaceShape: Spinner? = null//脸型
    @InjectView(R.id.btn_ok)
    internal var btnOk: TextView? = null
    @InjectView(R.id.line1)
    internal var line1: LinearLayout? = null
    @InjectView(R.id.girl_friend_img)*/
    internal var girlFriendImg: ImageView? = null

    internal var girlFriends: List<GirlFriend> = ArrayList<GirlFriend>()

    private var gfPhoto: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gril_friend)
        initSpHeight()//设置身高下拉选项
        initSpWeight()//设置体重下拉选项
        initSpAge()//设置年龄下拉选项
        initSpBust()//设置胸围下拉选项
        initSpColour()//设置肤色下拉选项
        initSpFaceShape()//设置脸型下拉选项
        girlFriends = json

    }

    @OnClick(R.id.btn_ok)
    internal fun onClick(view: View) {
        when (view.id) {
            R.id.btn_ok -> getGirlFriend()
        }
    }

    fun getGirlFriend() {
        val age = sp_age!!.selectedItem.toString()//年龄
        val height = sp_height!!.selectedItem.toString()//身高
        val weight = sp_weight!!.selectedItem.toString()//体重
        val colour = sp_colour!!.selectedItem.toString()//肤色
        val faceShape = sp_face_shape!!.selectedItem.toString()//脸型
        val bust = sp_bust!!.selectedItem.toString()//胸围
        for (i in girlFriends.indices) {
            if (height == girlFriends[i].height
                    && weight == girlFriends[i].weight
                    && colour == girlFriends[i].colour
                    && faceShape == girlFriends[i].faceShape
                    && bust == girlFriends[i].bust
                    && age == girlFriends[i].age) {
                gfPhoto = girlFriends[i].photo
                L.e("whq --- gfPhone : " + gfPhoto!!)
                getImg(gfPhoto!!)
                break
            } else {
                Toast.makeText(this, "没有找到相应要求的姑娘！", Toast.LENGTH_LONG).show()
                girlFriendImg!!.setImageResource(R.mipmap.ic_launcher)
            }

        }

    }

    //获取女朋友图片
    fun getImg(gfImg: String) {
        if (gfImg == "photo_anjie") {
            girlFriendImg!!.setImageResource(R.mipmap.photo_anjie)
        } else if (gfImg == "photo_anran") {
            girlFriendImg!!.setImageResource(R.mipmap.photo_anran)
        } else if (gfImg == "photo_anna") {
            girlFriendImg!!.setImageResource(R.mipmap.photo_anna)
        } else if (gfImg == "photo_anni") {
            girlFriendImg!!.setImageResource(R.mipmap.photo_anli)
        } else if (gfImg == "photo_anyao") {
            girlFriendImg!!.setImageResource(R.mipmap.photo_anyao)
        }
    }

    //获取女朋友数据
    val json: List<GirlFriend>
        get() {
            val jsonStr = TestUtils.getJSONFromAsset(this@GirlFriendActivity, "GirlFriend.json")
            L.e("whq --- jsonStr : " + jsonStr)
            var list: List<GirlFriend> = ArrayList<GirlFriend>()
            list = Gson().fromJson(jsonStr, object : TypeToken<List<GirlFriend>>() {
            }.getType())
            L.e("whq --- data : " + list)
            return list
        }

    //获取身高下拉选项
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    fun initSpHeight() {
        val mSpinnerItem = resources.getStringArray(R.array.spHeight)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, mSpinnerItem)
        sp_height!!.adapter = adapter
        sp_height!!.setPopupBackgroundDrawable(resources.getDrawable(R.drawable.abc_switch_thumb_material))
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    fun initSpWeight() {
        val mSpinnerItem = resources.getStringArray(R.array.spWeight)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, mSpinnerItem)
        sp_weight!!.adapter = adapter
        sp_weight!!.setPopupBackgroundDrawable(resources.getDrawable(R.drawable.abc_switch_thumb_material))
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    fun initSpAge() {
        val mSpinnerItem = resources.getStringArray(R.array.spAge)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, mSpinnerItem)
        sp_age!!.adapter = adapter
        sp_age!!.setPopupBackgroundDrawable(resources.getDrawable(R.drawable.abc_switch_thumb_material))
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    fun initSpBust() {
        val mSpinnerItem = resources.getStringArray(R.array.spBust)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, mSpinnerItem)
        sp_bust!!.adapter = adapter
        sp_bust!!.setPopupBackgroundDrawable(resources.getDrawable(R.drawable.abc_switch_thumb_material))
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    fun initSpColour() {
        val mSpinnerItem = resources.getStringArray(R.array.spColour)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, mSpinnerItem)
        sp_colour!!.adapter = adapter
        sp_colour!!.setPopupBackgroundDrawable(resources.getDrawable(R.drawable.abc_switch_thumb_material))
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    fun initSpFaceShape() {
        val mSpinnerItem = resources.getStringArray(R.array.spFaceShape)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, mSpinnerItem)
        sp_face_shape!!.adapter = adapter
        sp_face_shape!!.setPopupBackgroundDrawable(resources.getDrawable(R.drawable.abc_switch_thumb_material))
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
