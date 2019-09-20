package br.ufpe.cin.android.podcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun loadXML(RSSfeed: String){
        doAsync {
            val xml = URL(RSSfeed).readText()
            val itemsFeedList = Parser.parse(xml)

            uiThread {
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter = ItemFeedAdapter(itemsFeedList)
                recyclerView.addItemDecoration(DividerItemDecoration(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL))
            }
        }
    }
}
