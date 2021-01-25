package com.example.books_shop2.adpter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.books_shop2.R
import com.example.books_shop2.books.details_book
import com.example.books_shop2.data_model.my_data_book_shop
import com.squareup.picasso.Picasso


class my_custom_adapter(var context: Context,var mydata:ArrayList<my_data_book_shop>):RecyclerView.Adapter<my_custom_adapter.my_view_holder>() {


    inner class my_view_holder(item:View):RecyclerView.ViewHolder(item){
        var txt_name_book=item.findViewById<TextView>(R.id.output_namebook)
        var txt_name_aurthor=item.findViewById<TextView>(R.id.output_name_author)
        var txt_price=item.findViewById<TextView>(R.id.output_price)
        var imageview_book=item.findViewById<ImageView>(R.id.image_view_book)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): my_view_holder {
       return my_view_holder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,null))
    }

    override fun onBindViewHolder(holder: my_view_holder, position: Int) {
        holder.txt_name_book.text=mydata[position].name
        holder.txt_name_aurthor.text=mydata[position].author
        holder.txt_price.text=mydata[position].price
        Picasso.get().load(mydata[position].link_img).into(holder.imageview_book)
        holder.imageview_book.setOnClickListener{
            Toast.makeText(context,"${mydata[position].id}",Toast.LENGTH_SHORT).show()
            var intent=Intent( context,details_book::class.java)
            intent.putExtra("name_of_book",mydata[position].name)
            intent.putExtra("name_of_author",mydata[position].author)
            intent.putExtra("name_description",mydata[position].description)
            intent.putExtra("published",mydata[position].published)
            intent.putExtra("price",mydata[position].price)
            intent.putExtra("link_img",mydata[position].link_img)
            intent.putExtra("gener",mydata[position].gener)
            context.startActivity(intent)

        }


    }

    override fun getItemCount(): Int =mydata.size
}