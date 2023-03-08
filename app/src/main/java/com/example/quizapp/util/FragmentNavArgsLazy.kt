package com.example.quizapp

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.NavArgsLazy

/**
 * Returns a [Lazy] delegate to access the Fragment's arguments as an [Args] instance.
 *
 * It is strongly recommended that this method only be used when the Fragment is created
 * by [androidx.navigation.NavController.navigate] with the corresponding
 * [androidx.navigation.NavDirections] object, which ensures that the required
 * arguments are present.
 *
 * ```
 * class MyFragment : Fragment() {
 *     val args: MyFragmentArgs by navArgs()
 * }
 * ```
 *
 * This property can be accessed only after the Fragment's constructor.
 */
@MainThread
public inline fun <reified Args : NavArgs> Fragment.navArgs(): NavArgsLazy<Args> =
    NavArgsLazy(Args::class) {
        arguments ?: throw IllegalStateException("Fragment $this has null arguments")
    }
