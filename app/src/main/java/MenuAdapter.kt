import android.content.Intent
import android.graphics.BitmapFactory
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
                    intent.putExtra("describe", item.describe);
                    intent.putExtra("image", item.image);
                    intent.putExtra("name", item.name)
                    intent.putExtra("logo", item.logo)
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
            var bit = BitmapFactory.decodeByteArray(menu[position].logo, 0, menu[position].logo.size)
            holder.img?.setImageBitmap(bit)

        }catch (e: IllegalArgumentException){}

        var cont = holder.itemView.context
        holder.bind(menu[position])
    }

    override fun getItemCount() = menu.size
}