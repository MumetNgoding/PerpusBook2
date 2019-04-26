package latihan.android.com.PerpusBook.view.view_detail

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import latihan.android.com.PerpusBook.StartApp
import latihan.android.com.PerpusBook.data.data_model.Book

class BookDetailViewModel(application: Application): AndroidViewModel(application){
    private val bookRepository = getApplication<StartApp>().getBookRepo()
    private val bookId = MutableLiveData<Int>()

    fun getBookDetails(id: Int): LiveData<Book>{
        bookId.value = id
        val bookDetail = Transformations.switchMap<Int, Book>(bookId){
            id->
            bookRepository.findBook(id)
        }
        return bookDetail
    }
}