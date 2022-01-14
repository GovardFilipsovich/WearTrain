import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.wear.widget.WearableRecyclerView
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

        }catch (e: IllegalArgumentException){}
    }

    override fun getItemCount() = menu.size
}