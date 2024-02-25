package com.example.myapplication.model

import com.example.myapplication.R

object PizzaDataSource {

    val pizzaList = arrayListOf<Pizza>(
        Pizza(
            name = "Баварская",
            shortDescription = "Острые колбаски чоризо, маринованные огурчики, красный лук, томаты, горчичный соус, моцарелла, фирменный томатный соус",
            sizeDescription = "25cm, ",
            testoDescription = "traditional",
            imageRes = R.drawable.bavarskaya,
            smallPrice = 2700,
            mediumPrice = 3000,
            bigPrice = 3500,
            combo = false
        ),
        Pizza(
            name = "Вау! Кебаб",
            shortDescription = "Мясо говядины, соус ранч, сыр моцарелла, сладкий перец, томаты, красный лук и фирменный томатный соус",
            sizeDescription = "25cm, ",
            testoDescription = "traditional",
            imageRes = R.drawable.wowkebab,
            smallPrice = 2900,
            mediumPrice = 3000,
            bigPrice = 3500,
            combo = false
        ),
        Pizza(
            name = "Комбо за 3900 ₸",
            shortDescription = "Кому-кому только одному. Маленькая пицца, закуска, напиток и соус. Цена комбо зависит от выбранных продуктов и может быть увеличена",
            sizeDescription = "25cm, ",
            testoDescription = "traditional",
            imageRes = R.drawable.kombo1,
            smallPrice = 3900,
            mediumPrice = 3900,
            bigPrice = 3900,
            combo = true
        ),
        Pizza(
            name = "Пепперони с грибами",
            shortDescription = "Пикантная пепперони, моцарелла, шампиньоны, соус альфредо",
            sizeDescription = "25cm, ",
            testoDescription = "traditional",
            imageRes = R.drawable.pepperonimushrooms,
            smallPrice = 2000,
            mediumPrice = 3000,
            bigPrice = 3500,
            combo = false
        ),
        Pizza(
            name = "Миксик",
            shortDescription = "Пицца четвертинками с ветчиной из цыпленка, томатами, брынзой, моцареллой, фирменным соусом альфредо. Набор юного садовода в подарок",
            sizeDescription = "25cm, ",
            testoDescription = "traditional",
            imageRes = R.drawable.miksik,
            smallPrice = 2200,
            mediumPrice = 3000,
            bigPrice = 3500,
            combo = false
        ),
        Pizza(
            name = "Пепперони фреш",
            shortDescription = "Пикантная пепперони, мно-о-ого моцареллы, томаты и томатный соус",
            sizeDescription = "25cm, ",
            testoDescription = "traditional",
            imageRes = R.drawable.pepperoni,
            smallPrice = 1900,
            mediumPrice = 3000,
            bigPrice = 3500,
            combo = false
        ),
        Pizza(
            name = "Комбо от Смешариков",
            shortDescription = "Одобрено героями мультфильма: маленькая пицца любого вкуса и набор юного садовода. Цена комбо зависит от выбранных пицц и может быть увеличена",
            sizeDescription = "25cm, ",
            testoDescription = "traditional",
            imageRes = R.drawable.kombosmeshariki,
            smallPrice = 2300,
            mediumPrice = 2300,
            bigPrice = 2300,
            combo = true
        ),
        Pizza(
            name = "Песто",
            shortDescription = "Сочный цыпленок с пикантным соусом песто, кубики брынзы, томаты, моцарелла и соус альфредо",
            sizeDescription = "25cm, ",
            testoDescription = "traditional",
            imageRes = R.drawable.pesto,
            smallPrice = 2700,
            mediumPrice = 3000,
            bigPrice = 3500,
            combo = false
        ),
        Pizza(
            name = "Додо",
            shortDescription = "Ветчина из цыпленка, сочные митболы, пепперони из цыпленка, томаты, шампиньоны, сладкий перец, красный лук, моцарелла, томатный соус и чеснок",
            sizeDescription = "25cm, ",
            testoDescription = "traditional",
            imageRes = R.drawable.dodo,
            smallPrice = 2900,
            mediumPrice = 3000,
            bigPrice = 3500,
            combo = false
        ),
    )

}