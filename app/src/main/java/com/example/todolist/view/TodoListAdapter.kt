package com.example.todolist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTodoBinding
import com.example.todolist.model.TodoModel

class TodoListAdapter(private val todoItemList: ArrayList<TodoModel>): RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemTodoBinding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoListAdapter.ViewHolder, position: Int) {
        holder.bind(todoItemList[position])
    }

    override fun getItemCount(): Int = todoItemList.size

    inner class ViewHolder(private val binding: ItemTodoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(todoModel: TodoModel) {
            binding.todoTv.text = todoModel.content
        }
    }

    fun addItem(todoModel: TodoModel){
        todoItemList.add(todoModel)
        notifyDataSetChanged()
    }
}