package com.abnhl.notebook_movil.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import java.util.UUID

class NotebookViewModel : ViewModel() {
    private val _entries = mutableStateListOf<Entry>()
    val entries: List<Entry> get() = _entries

    sealed class Entry(
        open val id: String,
        open val content: String,
        open val isResultVisible: Boolean,
        open val result: String
    ) {
        data class TextEntry(
            override val id: String = UUID.randomUUID().toString(),
            override val content: String = "",
            override val isResultVisible: Boolean = false,
            override val result: String = ""
        ) : Entry(id, content, isResultVisible, result)

        data class CodeEntry(
            override val id: String = UUID.randomUUID().toString(),
            override val content: String = "",
            override val isResultVisible: Boolean = false,
            override val result: String = ""
        ) : Entry(id, content, isResultVisible, result)
    }

    fun addTextEntry() {
        _entries.add(Entry.TextEntry())
    }

    fun addCodeEntry() {
        _entries.add(Entry.CodeEntry())
    }

    fun updateContent(id: String, newContent: String) {
        val index = _entries.indexOfFirst { it.id == id }
        _entries[index] = when (val entry = _entries[index]) {
            is Entry.TextEntry -> entry.copy(content = newContent)
            is Entry.CodeEntry -> entry.copy(content = newContent)
        }
    }

    fun toggleResultVisibility(id: String) {
        val index = _entries.indexOfFirst { it.id == id }
        _entries[index] = when (val entry = _entries[index]) {
            is Entry.TextEntry -> entry.copy(isResultVisible = !entry.isResultVisible)
            is Entry.CodeEntry -> entry.copy(isResultVisible = !entry.isResultVisible)
        }
    }
}