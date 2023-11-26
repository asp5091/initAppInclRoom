package com.personal_project.initproject.activity

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.personal_project.initproject.R
import com.personal_project.initproject.data.entity.User
import com.personal_project.initproject.databinding.ActivityMainBinding
import com.personal_project.initproject.databinding.FragmentSubBinding
import com.personal_project.initproject.fragment.SubFragment
import com.personal_project.initproject.utils.RoomBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

lateinit var binding : ActivityMainBinding
lateinit var db : RoomBuilder

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = RoomBuilder.getInstance(this)!!

        val fragment = supportFragmentManager.beginTransaction()
        fragment.add(R.id.fragment, SubFragment(), SubFragment::class.java.name)
        fragment.commit()

        //var newUser = User("Kim", "20", "010-1111-5555")

        CoroutineScope(Dispatchers.IO).launch {
            db.let{
                //println(it.userDao().getAll())
                //it.userDao().insert(newUser)
                it.userDao().getAll().forEach{
                    println("TestDB: "+ it)
                }
            }
        }




        //println("테스트:"+userList())

    }
}