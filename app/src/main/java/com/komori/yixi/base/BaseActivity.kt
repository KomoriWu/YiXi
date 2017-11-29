package com.komori.yixi.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.KeyEvent
import android.widget.Toast
import butterknife.ButterKnife
import com.komori.yixi.R
import com.komori.yixi.application.MyApplication
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


abstract class BaseActivity : AppCompatActivity() {
    var toolBar: Toolbar? = null;
    var isBack = true
    private var mExitTime: Long = 0
    private var mApplication: MyApplication? = null
    abstract val layoutId: Int

    var onMenuItemClick: Toolbar.OnMenuItemClickListener = Toolbar.OnMenuItemClickListener { menuItem ->
        OnMenuItemClick(menuItem.itemId)
        true
    }

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
//        ButterKnife.bind(this)
        mApplication = MyApplication.getInstance()
        addActivity()
        onCreateView()
        init()
    }

    open fun onCreateView() {

    }


    fun initToolbar() {
        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar)
        title = ""
        toolBar?.setOnMenuItemClickListener(onMenuItemClick)

        if (isBack) {
            toolBar?.setNavigationOnClickListener { onBackPressed() }
        }

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    fun OnMenuItemClick(itemId: Int) {

    }

    fun onExitActivity(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - mExitTime > 2000) {
                Toast.makeText(this, R.string.exit_program_hint,
                        Toast.LENGTH_SHORT).show()
                mExitTime = System.currentTimeMillis()
            } else {
                removeAllActivity()
            }
            true
        } else {
            super.onKeyDown(keyCode, event)
        }
    }

    public override fun onDestroy() {
        super.onDestroy()
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }

    fun addActivity() {
        mApplication!!.addActivity(this)
    }


    fun removeAllActivity() {
        mApplication!!.removeAllActivity()
    }

    @Subscribe
    fun onEventMainThread(flags: String) {
    }
}
