package com.example.repasorecyclerview

class SuperHeroProvider {
    companion object {
        val superHeroList = mutableListOf(
            SuperHero("Iron Man", "Marvel", "Tony Stark", "https://i.pinimg.com/736x/b3/9b/34/b39b34240da7b3fe68953ad476459e96.jpg"),
            SuperHero("Spider-Man", "Marvel", "Peter Parker", "https://example.com/spiderman.jpg"),
            SuperHero(
                "Captain America",
                "Marvel",
                "Steve Rogers",
                "https://cuadrosyretablos.com/wp-content/uploads/2022/08/cuadro-decorativo-universo-marvel-capitan-america.jpg"
            ),
            SuperHero("Thor", "Marvel", "Thor Odinson", "https://example.com/thor.jpg"),
            SuperHero(
                "Black Widow",
                "Marvel",
                "Natasha Romanoff",
                "https://example.com/blackwidow.jpg"
            ),
            SuperHero("Shrek", "DreamWorks", "Shrek", "https://www.panoramaaudiovisual.com/wp-content/uploads/2010/07/Shrek-4.jpg"),
            SuperHero("Donkey", "DreamWorks", "Donkey", "https://example.com/donkey.jpg"),
            SuperHero("Fiona", "DreamWorks", "Princess Fiona", "https://example.com/fiona.jpg"),
            SuperHero("Puss in Boots", "DreamWorks", "Puss", "https://example.com/pussinboots.jpg"),
            SuperHero("Lord Farquaad", "DreamWorks", "Farquaad", "https://example.com/farquaad.jpg")
        )
    }
}