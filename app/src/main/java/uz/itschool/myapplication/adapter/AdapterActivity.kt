package uz.itschool.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import coil.load
import uz.itschool.myapplication.MainActivity
import uz.itschool.myapplication.R
import uz.itschool.myapplication.User
import uz.itschool.myapplication.databinding.ActivityMainBinding

class AdapterActivity(context: Context,var users:MutableList<User>):ArrayAdapter<User>(context, R.layout.activity_main,users) {

    override fun getCount(): Int {
        return users.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ActivityMainBinding

        if (convertView == null){
            binding = ActivityMainBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        }else{
            binding = ActivityMainBinding.bind(convertView)
        }
        val user = users.get(position)
        binding.movieName.text = user.name

        binding.poster.load(user.img)

        return binding.root

    }
}