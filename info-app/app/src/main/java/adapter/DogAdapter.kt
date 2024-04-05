package adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.info_app.databinding.ItemDogBinding
import com.example.info_app.details_dog
import model.Dog

class DogAdapter (private val onDogClick: (Dog) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    companion object {
        private const val DOG_ADAPTER_TAG = "DogAdapter"
    }

    private val dogList: MutableList<Dog> = mutableListOf()

    fun setData(dogs: List<Dog>){
        dogList.clear()
        dogList.addAll(dogs)

        notifyDataSetChanged()
    }

    fun getData(): MutableList<Dog> {
        return dogList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : DogViewHolder {
        Log.d(DOG_ADAPTER_TAG,"onCreateViewHolder")
        return DogViewHolder(
            ItemDogBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder) {
            is DogViewHolder -> holder.bind(dogList[position])
        }

    }

    inner class DogViewHolder(
        private val binding: ItemDogBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(dog: Dog) {
            with(binding) {

                Glide
                    .with(root.context)
                    .load(dog.imageUrl)
                    .into(dogImage)

                dogName.text = dog.name
                dogPlay.text = dog.playfulness.toString()
                dogEnergy.text = dog.energy.toString()
                dogWeight.text = dog.weight.toString()
                btn.setOnClickListener { onDogClick(dog) }
            }
        }
    }
}