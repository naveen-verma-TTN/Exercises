package com.example.exercise_13_android_introduction_to_jetpack_component_part_1.DataBindingExample

import com.example.exercise_13_android_introduction_to_jetpack_component_part_1.Person

class FakeList {
    val person: ArrayList<Person> = ArrayList<Person>()

    init {
        repeat(2) {
            person.add(
                Person(
                    "https://image.flaticon.com/icons/png/512/149/149074.png",
                    "Rahul",
                    32,
                    "rahul@gmail.com",
                    "9876453256"
                )
            )
            person.add(
                Person(
                    "https://image.flaticon.com/icons/png/512/149/149074.png",
                    "Gyan",
                    23,
                    "gyan@gmail.com",
                    "9844353256"
                )
            )
            person.add(
                Person(
                    "https://image.flaticon.com/icons/png/512/149/149074.png",
                    "Ram",
                    45,
                    "ram@gmail.com",
                    "9844353256"
                )
            )
            person.add(
                Person(
                    "https://image.flaticon.com/icons/png/512/149/149074.png",
                    "Tarun",
                    37,
                    "tarun@gmail.com",
                    "9844353256"
                )
            )
        }
    }
}