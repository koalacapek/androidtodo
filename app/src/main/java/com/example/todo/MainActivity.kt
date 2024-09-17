package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

//    lateinit var = Promise to Kotlin we will initialize it later
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        binding.apply {
            rvTodoItems.adapter = todoAdapter
            rvTodoItems.layoutManager = LinearLayoutManager(this@MainActivity)

            btnAddTodo.setOnClickListener {
                val todoTitle = etTodoTitle.text.toString()

                if (todoTitle.isNotEmpty()) {
                    val todo = Todo(todoTitle, false)
                    todoAdapter.addTodo(todo)

                    // clear textinput
                    etTodoTitle.text.clear()
                }
            }

            btnDeleteDoneTodos.setOnClickListener {
                todoAdapter.deleteDoneTodos()
            }
        }
    }
}