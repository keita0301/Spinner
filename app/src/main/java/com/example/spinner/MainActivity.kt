package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preSpinner = findViewById<Spinner>(R.id.preSpinner)
        val adapter = ArrayAdapter.createFromResource(this, R.array.pre_name, R.layout.spinner_item)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        preSpinner.adapter = adapter

        val citySpinner = findViewById<Spinner>(R.id.citySpinner)

        val map: Map<String, String> = mapOf<String, String>(
            "北海道" to "hokkaido","青森県" to "aomori","岩手県" to "iwate", "宮城県" to "miyagi","秋田県" to "akita","山形県" to "yamagata","福島県" to "fukushima","茨城県" to "ibaraki","栃木県" to "tochigi","群馬県" to "gunma","埼玉県" to "saitama","千葉県" to "chiba","東京都" to "tokyo","神奈川県" to "kanagawa","新潟県" to "niigata","富山県" to "toyama","石川県" to "ishikawa","福井県" to "fukui","山梨県" to "yamanashi","長野県" to "nagano","岐阜県" to "gifu","静岡県" to "shizuoka","愛知県" to "aichi","三重県" to "mie","滋賀県" to "shiga","京都府" to "kyoto","大阪府" to "osaka","兵庫県" to "hyogo","奈良県" to "nara","和歌山県" to "wakayama","鳥取県" to "tottori","島根県" to "shimane","岡山県" to "okayama","広島県" to "hiroshima","山口県" to "yamaguchi","徳島県" to "tokushima","香川県" to "kagawa","愛媛県" to "ehime","高知県" to "kochi","福岡県" to "fukuoka","佐賀県" to "saga","長崎県" to "nagasaki","熊本県" to "kumamoto","大分県" to "oita","宮崎県" to "miyazaki","鹿児島県" to "kagoshima","沖縄県" to "okinawa"
        )

        // OnItemSelectedListenerの実装
        preSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            // 項目が選択された時に呼ばれる
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val text = parent?.selectedItem as String
                val preName = "spinner_" + map[text]
                val n = "array"

                val id = resources.getIdentifier(preName, n, packageName)
//                val array = resources.getStringArray(R.array.spinnerItems)
//                Toast.makeText(this@MainActivity, id, Toast.LENGTH_SHORT).show()
                val adapter2 = ArrayAdapter.createFromResource(this@MainActivity, id, android.R.layout.simple_spinner_item)
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                citySpinner.adapter = adapter2
            }

            // 基本的には呼ばれないが、何らかの理由で選択されることなく項目が閉じられたら呼ばれる
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}