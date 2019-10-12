package com.example.marketapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var mods = ArrayList<Mod>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        mods.clear();
        showList.setOnClickListener{
            requestToServerList();
        }
        modButton.setOnClickListener{
            val regex = """[a-z]+\s[a-z]+""".toRegex();

            if(regex.matches(nameText.text.toString())){
                requestToServerMod(nameText.text.toString());
            } else {
                Toast.makeText(getApplicationContext(),
                    "Please write the name correctly", Toast.LENGTH_SHORT).show();
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun requestToServerList(){
        val queue = Volley.newRequestQueue(this);

        val url = "http://192.168.1.34:40000/catalog"
        mods.clear();
        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->

                for(i in 0 until (response.length())){
                    mods.add(Mod(response.getJSONObject(i).getString("name"), response.getJSONObject(i).getInt("quantity")))
                }
                recyclerView.layoutManager = LinearLayoutManager(this)

                recyclerView.adapter = ModAdapter(mods, this)
            },
            Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )

        queue.add(jsonArrayRequest);
    }

    private fun requestToServerMod(name: String){

        val queue = Volley.newRequestQueue(this);
        val url = "http://192.168.1.34:40000/mod"

        val params = HashMap<String,String>()
        params.put("name", name)
        mods.clear();
        val parameters = JSONObject()

            parameters.put("name", name);

        val key = parameters.keys().next();

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url + "?"+ key +"=" + parameters.getString(key), parameters,
            Response.Listener { response ->
                    mods.add(Mod(response.getString("name"), response.getInt("quantity")))

                recyclerView.layoutManager = LinearLayoutManager(this)

                recyclerView.adapter = ModAdapter(mods, this)

            },
            Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )

        queue.add(jsonObjectRequest);
    }
}
