package com.pk4u.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.pk4u.listview.databinding.ActivitySimpleAdapterBinding

class SimpleAdapterActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySimpleAdapterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleAdapterBinding.inflate(layoutInflater).also { setContentView(it.root) }


        setupListViewSimple()
//        setupListViewWithSimpleGenerationData()
    }

    private fun setupListViewSimple() {
        val data = listOf(
            mapOf((KEY_TITLE to "1 title"),
                    (KEY_DESCRIPTION to "The 1 some description")),
            mapOf((KEY_TITLE to "2 title"),
                (KEY_DESCRIPTION to "The 2 some description")),
            mapOf((KEY_TITLE to "3 title"),
                (KEY_DESCRIPTION to "The 3 some description")),
            mapOf((KEY_TITLE to "4 title"),
                (KEY_DESCRIPTION to "The 4 some description")),
            mapOf((KEY_TITLE to "5 title"),
                (KEY_DESCRIPTION to "The 5 some description")),
            mapOf((KEY_TITLE to "6 title"),
                (KEY_DESCRIPTION to "The 6 some description")),
            mapOf((KEY_TITLE to "7 title"),
                (KEY_DESCRIPTION to "The 7 some description")),
            mapOf((KEY_TITLE to "8 title"),
                (KEY_DESCRIPTION to "The 8 some description")),
            mapOf((KEY_TITLE to "9 title"),
                (KEY_DESCRIPTION to "The 9 some description")),
            mapOf((KEY_TITLE to "10 title"),
                (KEY_DESCRIPTION to "The 10 some description")),
            mapOf((KEY_TITLE to "11 title"),
                (KEY_DESCRIPTION to "The 11 some description")),
            mapOf((KEY_TITLE to "12 title"),
                (KEY_DESCRIPTION to "The 12 some description")),
            mapOf((KEY_TITLE to "13 title"),
                (KEY_DESCRIPTION to "The 13 some description")),
            mapOf((KEY_TITLE to "14 title"),
                (KEY_DESCRIPTION to "The 14 some description")),
            mapOf((KEY_TITLE to "15 title"),
                (KEY_DESCRIPTION to "The 15 some description")),
        )

        val adapter = SimpleAdapter(
            this,
            data,
            android.R.layout.simple_list_item_2,
            arrayOf(KEY_TITLE, KEY_DESCRIPTION),
            intArrayOf(android.R.id.text1,android.R.id.text2)
        )
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener{parent,view,position,id ->
            val selectedItemTitle = data[position][KEY_TITLE]
            val selectedItemDescription = data[position][KEY_DESCRIPTION]

            val dialog = AlertDialog.Builder(this)
                .setTitle(selectedItemTitle)
                .setMessage(getString(R.string.item_selected_massage,selectedItemDescription))
                .setPositiveButton("Ok"){dialog,which -> }
                .create()
            dialog.show()
        }
    }

//    private fun setupListViewWithSimpleGenerationData(){
//        val data = (1..100).map {
//            mapOf(
//                KEY_TITLE to "Item #$it",
//                KEY_DESCRIPTION to "Description #$it",
//            )
//        }
//
//        val adapter = SimpleAdapter(
//            this,
//            data,
//            R.layout.item_custom,
//            arrayOf(KEY_TITLE, KEY_DESCRIPTION),
//            intArrayOf(R.id.titleTextView,R.id.descriptionTextView)
//        )
//        binding.listView.adapter = adapter
//    }

    companion object{
        const val KEY_TITLE = "title"
        const val KEY_DESCRIPTION = "description"
    }
}