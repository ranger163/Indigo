package me.inassar.indigo.views.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.profile_messaegs_item_row.view.*
import me.inassar.indigo.*
import me.inassar.indigo.utils.DateUtils
import me.inassar.indigo.utils.ThemeHelper
import me.inassar.indigo.utils.Utils


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeStatusBarTransparent()
        setContentView(R.layout.activity_home)

        interactions()
        dataSet()
    }

    /**
     * This function is used to handle user interactions
     * */
    private fun interactions() {

        homeNotificationsBtn.setOnClickListener { toast("Notifications") }

        homeProfileBtn.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ProfileActivity::class.java
                )
            )
        }

        themeSwitchBtn.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                ThemeHelper.applyTheme("dark")
            } else {
                ThemeHelper.applyTheme("light")
            }
        }

        homeShareBtn.setOnClickListener {
            Utils.shareMessage(this, homeMessageCard)
        }

        navigateToTimeLineBtn.setOnClickListener {
            toast(navigateToTimeLineBtn.text.toString())
        }

        homeLikeBtn.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                buttonView.like()
                notificationDot.show()
            } else {
                buttonView.dislike()
                notificationDot.hide()
            }
        }
    }

    /**
     * This function is used to bind data to views
     * */
    @SuppressLint("SetTextI18n")
    private fun dataSet() {
        container.animateBackground()
        homeDateTv.text = DateUtils.arabicDate
    }
}
