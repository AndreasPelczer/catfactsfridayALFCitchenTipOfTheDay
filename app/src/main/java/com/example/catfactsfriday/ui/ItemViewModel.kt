package com.example.catfactsfriday.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.catfactsfriday.data.AppRepository
import com.example.catfactsfriday.data.database.getItemDatabase
import com.example.catfactsfriday.data.datamodels.FactsItem
import com.example.catfactsfriday.data.remote.ItemApi
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application) {

    private val itemDatabase = getItemDatabase(application)
    private val repository = AppRepository(ItemApi, itemDatabase)

    val items = repository.items

    fun loadData() {
        viewModelScope.launch {
            repository.getItems()
            repository.getAll()
        }
    }
    fun insertDataFromApi(itemData: FactsItem) {
        viewModelScope.launch {
            repository.insertFactsFromApi(itemData)
        }
    }
}
