package com.example.myapplication

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        val redColor = Color.parseColor("#FF0000")
        listView.setBackgroundColor(redColor)

        listView.adapter = MyCustomAdapter(this) //adapter per dire cosa renderizzare
    }

    private class MyCustomAdapter(context:Context): BaseAdapter() { //HO creato un adapter custom

        private val mContext: Context
        private val names = arrayListOf<String>(
            "Donald Trump","Steve Jobs", "Tim Cook"
        )
        init{
            mContext = context
        }

        override fun getCount(): Int { // deve avere il numero di righe da rappresentare
            return names.size
        }

        override fun getItem(position: Int): Any {
            return "Test String"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            //devo costruire una view
            //il Layout Inflator ci pemette di tradurre i layout
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)
            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textView)
            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
            nameTextView.text = names.get(position)
            positionTextView.text = "Row number: $position"
            return rowMain
        }
    }
}
