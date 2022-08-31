package com.example.dcalert


import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapterTwo(var context: Context, var data:ArrayList<UserTwo>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var mTxtName:TextView
        var mTxtCrimeDes:TextView
        var mTxtEmail:TextView
        var mTxtPlace:TextView
        var mTxtDate:TextView
        var mTxtTime:TextView
        init {
            this.mTxtName = row?.findViewById(R.id.MtVname) as TextView
            this.mTxtCrimeDes = row?.findViewById(R.id.MtvCrimeDescription) as TextView
            this.mTxtPlace = row?.findViewById(R.id.MtvCrimePlace) as TextView
            this.mTxtDate= row?.findViewById(R.id.MtvDate) as TextView
            this.mTxtTime= row?.findViewById(R.id.MtvTime) as TextView
            this.mTxtEmail = row?.findViewById(R.id.MtvEmaiL) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.item_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:UserTwo = getItem(position) as UserTwo
        viewHolder.mTxtName.text = item.name
        viewHolder.mTxtCrimeDes.text = item.CrimeDescription
        viewHolder.mTxtPlace.text = item.Place
        viewHolder.mTxtEmail.text = item.email
        viewHolder.mTxtTime.text = item.Time
        viewHolder.mTxtDate.text = item.Date

        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}
