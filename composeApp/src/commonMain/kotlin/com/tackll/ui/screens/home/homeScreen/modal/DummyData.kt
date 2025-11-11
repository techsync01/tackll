package com.tackll.ui.screens.home.homeScreen.modal
//
//
//data class Story(val name: String, val image: String)
//data class Post(val user: String, val image: String, val title: String, val views: Int, val proViews: Int, val weeksAgo: Int)
//data class Flick(val image: String, val title: String)
//
//object DummyData {
//
//    val stories = listOf(
//        Story("Your Story", "story_1.jpg"),
//        Story("Learn_dancing", "story_2.jpg"),
//        Story("fitnessclub", "story_3.jpg"),
//        Story("_photography_", "story_4.jpg"),
//        Story("yogaclass", "story_5.jpg"),
//        Story("Learn_dancing", "story_2.jpg"),
//        Story("fitnessclub", "story_3.jpg"),
//        Story("_photography_", "story_4.jpg"),
//        Story("yogaclass", "story_5.jpg")
//    )
//
//    val posts = listOf(
//        Post("Learncoding", "post_1.jpg", "30-day fitness challenge: Works multiple...", 500, 130, 3),
//        Post("Thefitnessclub", "post_2.jpg", "Full-body HIIT workout for beginners", 400, 90, 2),
//        Post("Learncoding", "post_3.jpg", "Python binary visualizer", 800, 250, 1)
//    )
//
//    val flicks = listOf(
//        Flick("flick_1.jpg", "30-day fitness challenge"),
//        Flick("flick_2.jpg", "Crossfit strength"),
//        Flick("flick_3.jpg", "Yoga balance tips"),
//        Flick("flick_4.jpg", "Football training")
//    )
//}


//package com.tackll.ui.data


data class Story(
    val name: String,
    val imageUrl: String
)

data class Post(
    val userName: String,
    val profilePicture: String,
    val caption: String,
    val image: String,
    val timeAgo: String,
    val proViews: Int,
    val views: Int
)

data class Flick(
    val title: String,
    val videoUrl: String,
    val thumbnailUrl: String
)

object DummyData {
    val stories = listOf(
        Story("Your Story", "https://cdn-icons-png.flaticon.com/512/4140/4140048.png"),
        Story("Learn_dancing", "https://picsum.photos/203"),
        Story("fitnessclub", "https://picsum.photos/202"),
        Story("_photography_", "https://picsum.photos/203"),
        Story("artworld", "https://picsum.photos/204"),
        Story("Learn_dancing", "https://picsum.photos/201"),
        Story("fitnessclub", "https://picsum.photos/202"),
        Story("_photography_", "https://cdn-icons-png.flaticon.com/512/4140/4140048.png"),
        Story("artworld", "https://picsum.photos/204")
    )

    val posts = listOf(
        Post(
            userName = "Learncoding",
            profilePicture = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
            caption = "30-day fitness challenge: Works multiple muscle groups",
            image = "https://picsum.photos/400/200",
            timeAgo = "3 weeks ago",
            proViews = 130,
            views = 500
        ),
        Post(
            userName = "artworld",
            profilePicture = "https://picsum.photos/203",
            caption = "Digital painting session — mastering light & shade",
            image = "https://picsum.photos/401/200",
            timeAgo = "1 week ago",
            proViews = 85,
            views = 420
        ),
        Post(
            userName = "Home window",
            profilePicture = "https://picsum.photos/215",
            caption = "30-day fitness challenge: Works multiple muscle groups",
            image = "https://picsum.photos/212",
            timeAgo = "3 weeks ago",
            proViews = 130,
            views = 500
        ),
        Post(
            userName = "artworld",
            profilePicture = "https://picsum.photos/210",
            caption = "Digital painting session — mastering light & shade",
            image = "https://picsum.photos/401/200",
            timeAgo = "1 week ago",
            proViews = 85,
            views = 420
        ),
        Post(
            userName = "Learncoding",
            profilePicture = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
            caption = "30-day fitness challenge: Works multiple muscle groups",
            image = "https://picsum.photos/400/200",
            timeAgo = "3 weeks ago",
            proViews = 130,
            views = 500
        ),
        Post(
            userName = "artworld",
            profilePicture = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
            caption = "Digital painting session — mastering light & shade",
            image = "https://picsum.photos/401/200",
            timeAgo = "1 week ago",
            proViews = 85,
            views = 420
        ),
        Post(
            userName = "Learncoding",
            profilePicture = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
            caption = "30-day fitness challenge: Works multiple muscle groups",
            image = "https://picsum.photos/400/200",
            timeAgo = "3 weeks ago",
            proViews = 130,
            views = 500
        ),
        Post(
            userName = "artworld",
            profilePicture = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
            caption = "Digital painting session — mastering light & shade",
            image = "https://picsum.photos/401/200",
            timeAgo = "1 week ago",
            proViews = 85,
            views = 420
        ),
        Post(
            userName = "Learncoding",
            profilePicture = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
            caption = "30-day fitness challenge: Works multiple muscle groups",
            image = "https://picsum.photos/400/200",
            timeAgo = "3 weeks ago",
            proViews = 130,
            views = 500
        ),
        Post(
            userName = "artworld",
            profilePicture = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
            caption = "Digital painting session — mastering light & shade",
            image = "https://picsum.photos/401/200",
            timeAgo = "1 week ago",
            proViews = 85,
            views = 420
        ),
    )


//    val flicks = listOf(
//        Flick(
//            "30-day fitness challenge",
//            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
//        ),
//        Flick(
//            "Crossfit strength",
//            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
//        ),
//        Flick(
//            "Yoga balance tips",
//            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
//        ),
//        Flick(
//            "Football training",
//            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"
//        )
//    )
val flicks = listOf(
    Flick(
        "30-day fitness challenge",
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        "https://picsum.photos/seed/gym_thumbnail1/400/200"
    ),
    Flick(
        "Crossfit strength",
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
        "https://picsum.photos/seed/gym_thumbnail2/400/200"
    ),
    Flick(
        "Yoga balance tips",
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
        "https://picsum.photos/seed/gym_thumbnail3/400/200"
    ),
    Flick(
        "Football training",
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
        "https://picsum.photos/seed/gym_thumbnail4/400/200"
    )
)


}
