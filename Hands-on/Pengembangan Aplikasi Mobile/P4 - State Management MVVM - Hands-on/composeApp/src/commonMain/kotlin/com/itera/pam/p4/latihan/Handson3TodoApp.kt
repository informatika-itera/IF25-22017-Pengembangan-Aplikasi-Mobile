package com.itera.pam.p4.latihan

import kotlinx.coroutines.flow.update
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkboximport androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Latihan 3: Todo App dengan ViewModel — implementasi MVVM pattern (slide P4 hal. 31)
//
// Checklist:
// [ ] Data class Todo
// [ ] TodoUiState dengan list
// [ ] TodoViewModel dengan StateFlow
// [ ] Add todo function
// [ ] Toggle done function
// [ ] TextField untuk input
// [ ] LazyColumn untuk list
// [ ] Checkbox untuk done

// 1. Data class
data class Todo(val id: Int, val text: String, val done: Boolean)

data class TodoUiState(
    val todos: List<Todo> = emptyList(),
    val input: String = ""
)

/**
 * Pengelola data tugas yang mengatur daftar dan interaksi pengguna.
 */
class TodoViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TodoUiState())
    val uiState: StateFlow<TodoUiState> = _uiState.asStateFlow()

    fun onInputChange(text: String) {
        _uiState.update { it.copy(input = text) }
    }

    fun addTodo() {
        if (_uiState.value.input.isNotBlank()) {
            val newTodo = Todo(id = _uiState.value.todos.size, text = _uiState.value.input, done = false)
            _uiState.update { it.copy(todos = it.todos + newTodo, input = "") }
        }
    }

    fun toggleTodo(id: Int) {
        _uiState.update { state ->
            val updatedTodos = state.todos.map {
                if (it.id == id) it.copy(done = !it.done) else it
            }
            state.copy(todos = updatedTodos)
        }
    }
}

/**
 * Tampilan daftar tugas yang datanya dikendalikan oleh TodoViewModel.
 */
@Composable
fun Handson3Screen(viewModel: TodoViewModel = viewModel { TodoViewModel() }) {
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Latihan 3: Todo App dengan ViewModel")

        OutlinedTextField(value = uiState.input, onValueChange = viewModel::onInputChange)
        Button(onClick = { viewModel.addTodo() }) { Text("Tambah") }
        LazyColumn {
            items(uiState.todos) { todo ->
                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    Checkbox(checked = todo.done, onCheckedChange = { viewModel.toggleTodo(todo.id) })
                    Text(todo.text)
                }
            }
        }
    }
}
