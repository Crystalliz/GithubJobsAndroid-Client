package me.cristalliz.ash.githubjobs.ui.activities

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import me.cristalliz.ash.githubjobs.R
import me.cristalliz.ash.githubjobs.ui.fragments.main.MainFragment

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
