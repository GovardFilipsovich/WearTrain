import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.wear.widget.WearableRecyclerView
import com.example.myapplication.DishDescription
import com.example.myapplication.R
import com.squareup.picasso.Picasso

class MenuAdapter(private val menu: List<MenuItem>) :
    RecyclerView.Adapter<MenuAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text1: TextView? = null
        var img: ImageView? = null

        init {
            text1 = itemView.findViewById(R.id.MealName)
            img = itemView.findViewById(R.id.MealImage)
        }

        fun bind(item : MenuItem){
            itemView.setOnClickListener(
                View.OnClickListener {
                    var intent = Intent(itemView.context, DishDescription::class.java)
                    startActivity(itemView.context, intent, null)
                }
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.menu_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        try {
            holder.text1?.text = menu[position].name
            holder.img?.setImageBitmap(menu[position].image)

        }catch (e: IllegalArgumentException){}

        var cont = holder.itemView.context
        holder.bind(menu[position])
    }

    override fun getItemCount() = menu.size
}