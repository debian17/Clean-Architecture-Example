package kravchenko.ru.cleanarchitecture.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kravchenko.ru.cleanarchitecture.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = MainActivityPresenter()
        //commit for some f4

        presenter.getMedOrgs()

        //commit for some feature_one
        //commit for some feature_two
        //commit for some f3
        //commit for some f5
        //commit for some f5.1
    }
}
