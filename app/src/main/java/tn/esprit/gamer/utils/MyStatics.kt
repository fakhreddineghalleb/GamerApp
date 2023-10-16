package tn.esprit.gamer.utils

import android.content.Context
import android.content.res.Resources
import android.view.View
import android.view.inputmethod.InputMethodManager
import tn.esprit.gamer.R
import tn.esprit.gamer.model.News
import tn.esprit.gamer.model.Product

const val OTP_EMAIL = "OTP_EMAIL"
const val OTP_MOBILE = "OTP_MOBILE"

class MyStatics {

    companion object{
        fun hideKeyboard(context: Context, view: View) {
            val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

        fun getListNews(context: Context) : MutableList<News> {
            return mutableListOf<News>(
                News(1, R.drawable.ic_news1, context.getString(R.string.title1) , context.getString(R.string.description1)),
                News(2, R.drawable.ic_news2, context.getString(R.string.title2) , context.getString(R.string.description2)),
                News(3, R.drawable.ic_news3, context.getString(R.string.title3) , context.getString(R.string.description3)),
                News(4, R.drawable.ic_news4, context.getString(R.string.title4) , context.getString(R.string.description4)),
                News(5, R.drawable.ic_news5, context.getString(R.string.title5) , context.getString(R.string.description5))
            )
        }

        fun getListProducts(context: Context) : MutableList<Product> {
            return mutableListOf<Product>(
                Product(1, R.drawable.ic_product1, context.getString(R.string.product1) ,"PS4 Games",70.0f),
                Product(2, R.drawable.ic_product2, context.getString(R.string.product2) ,"PS4 Games",30.0f),
                Product(3, R.drawable.ic_product3, context.getString(R.string.product3) ,"Nintendo Switch",90.0f),
                Product(4, R.drawable.ic_product4, context.getString(R.string.product4) ,"PS4 Games",120.0f),
                Product(5, R.drawable.ic_product5, context.getString(R.string.product5) ,"PS4 Games",50.0f)
            )
        }
    }
}