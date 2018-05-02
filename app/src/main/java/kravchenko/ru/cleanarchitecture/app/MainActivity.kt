package kravchenko.ru.cleanarchitecture.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kravchenko.ru.cleanarchitecture.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = MainActivityPresenter()

        presenter.getMedOrgs()
    }
}
