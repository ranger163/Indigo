package me.inassar.indigo.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_profile.*
import me.inassar.indigo.R
import me.inassar.indigo.models.ProfileMessagesModel
import me.inassar.indigo.views.adapters.ProfileMessagesAdapter

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        init()
        interactions()
        dataSet()
    }

    private fun init() {
        profileMessageRecycler.apply {
            layoutManager = LinearLayoutManager(this@ProfileActivity)
            adapter = ProfileMessagesAdapter(this@ProfileActivity, dataSet())
            isNestedScrollingEnabled = true
        }
    }

    private fun interactions() {

    }

    private fun dataSet(): List<ProfileMessagesModel> {
        val itemsList = ArrayList<ProfileMessagesModel>()
        itemsList.add(
            ProfileMessagesModel(
                "23 4 2020",
                "slkfjsldkfjs wpoeirwpeori sepodif sdfsdmf sdfposdif",
                "~Carl Gross~",
                "@rangr163"
            )
        )
        itemsList.add(
            ProfileMessagesModel(
                "23 4 2020",
                "slkfjsldkfjs wpoeirwpeori sepodif sdfsdmf sdfposdif",
                "~Carl Gross~",
                "@rangr163"
            )
        )
        itemsList.add(
            ProfileMessagesModel(
                "23 4 2020",
                "slkfjsldkfjs wpoeirwpeori sepodif sdfsdmf sdfposdif",
                "~Carl Gross~",
                "@rangr163"
            )
        )
        itemsList.add(
            ProfileMessagesModel(
                "23 4 2020",
                "slkfjsldkfjs wpoeirwpeori sepodif sdfsdmf sdfposdif",
                "~Carl Gross~",
                "@rangr163"
            )
        )
        itemsList.add(
            ProfileMessagesModel(
                "23 4 2020",
                "slkfjsldkfjs wpoeirwpeori sepodif sdfsdmf sdfposdif",
                "~Carl Gross~",
                "@rangr163"
            )
        )
        itemsList.add(
            ProfileMessagesModel(
                "23 4 2020",
                "slkfjsldkfjs wpoeirwpeori sepodif sdfsdmf sdfposdif",
                "~Carl Gross~",
                "@rangr163"
            )
        )
        itemsList.add(
            ProfileMessagesModel(
                "23 4 2020",
                "slkfjsldkfjs wpoeirwpeori sepodif sdfsdmf sdfposdif",
                "~Carl Gross~",
                "@rangr163"
            )
        )
        return itemsList
    }
}
