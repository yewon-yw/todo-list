package com.example.todolist.view

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.R
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.databinding.DialogTodoDetailBinding
import com.example.todolist.model.TodoModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var todoListAdapter: TodoListAdapter
    private val todoList: ArrayList<TodoModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initRV()
        initClickListener()
        setContentView(binding.root)
    }

    private fun initRV(){
        todoList.apply {
            add(TodoModel(false, "hello"))
            add(TodoModel(false, "hello"))
            add(TodoModel(false, "hi"))
        }
//        Log.d("확인용","$todoList")
        todoListAdapter = TodoListAdapter(todoList)

        binding.todoListRv.apply {
            adapter = todoListAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initClickListener() {
        binding.addBtn.setOnClickListener {
            setDialog()
        }
    }

    private fun setDialog() {
        val dialogBinding = DialogTodoDetailBinding.inflate(layoutInflater)
//        val dialogView = layoutInflater.inflate(R.layout.dialog_todo_detail, null)
        val dialog = AlertDialog.Builder(this)
            .setTitle("할 일 추가하기")
            .setView(dialogBinding.root)
            .setPositiveButton("확인") { _, i ->
                val content = dialogBinding.todoContentEt.text.toString()
                val todoModel = TodoModel(false, content)
                todoListAdapter.addItem(todoModel)
            }
            .setNegativeButton("취소",null)
            .create()
        dialog.show()
    }

}