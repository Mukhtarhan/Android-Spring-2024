package com.example.myapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemComboPizzaBinding
import com.example.myapplication.databinding.ItemPizzaBinding
import com.example.myapplication.model.Pizza

class PizzaAdapter(
    private val onPizzaClick: (Pizza) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val PIZZA_ADAPTER_TAG = "PizzaAdapter"
        private const val VIEW_TYPE_PIZZA = 0
        private const val VIEW_TYPE_COMBO_PIZZA = 1
    }

    private val pizzaList: ArrayList<Pizza> = ArrayList()

    fun setData(pizzas: ArrayList<Pizza>) {
        pizzaList.clear()
        pizzaList.addAll(pizzas)
        /**
         * метод для обновления списка элементов
         */
        notifyDataSetChanged()
    }

    /**
     * метод, который будет возвращать view type
     */
    override fun getItemViewType(position: Int): Int {
        return if (pizzaList[position].combo) {
            VIEW_TYPE_COMBO_PIZZA
        } else {
            VIEW_TYPE_PIZZA
        }
    }

    /**
     * метод, который будет создавать view для каждого объекта
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d(PIZZA_ADAPTER_TAG, "onCreateViewHolder")
        return if (viewType == VIEW_TYPE_PIZZA) {
            PizzaViewHolder(
                ItemPizzaBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
        else {
            ComboViewHolder(
                ItemComboPizzaBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    /**
     * метод, для определения количесвта элементов списка
     */
    override fun getItemCount() = pizzaList.size

    /**
     * для вызова метода из ViewHolder'a
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pizza = pizzaList[position]
        when (holder) {
            is PizzaViewHolder -> holder.bind(pizza)
            is ComboViewHolder -> holder.bind(pizza)
        }
    }


    inner class PizzaViewHolder(
        private val binding: ItemPizzaBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pizza: Pizza) {
            with(binding) {
                pizzaName.text = pizza.name
                pizzaImage.setImageResource(pizza.imageRes)
                pizzaDescription.text = pizza.shortDescription
                pizzaPrice.text = "От " + pizza.smallPrice.toString() + " KZT"
                root.setOnClickListener { onPizzaClick(pizza) }
            }
        }
    }

    inner class ComboViewHolder(
        private val binding: ItemComboPizzaBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pizza: Pizza) {
            with(binding) {
                pizzaName.text = pizza.name
                pizzaImage.setImageResource(pizza.imageRes)
                pizzaDescription.text = pizza.shortDescription
                pizzaPrice.text = pizza.smallPrice.toString() + " KZT"
                root.setOnClickListener { onPizzaClick(pizza) }
            }
        }
    }

}