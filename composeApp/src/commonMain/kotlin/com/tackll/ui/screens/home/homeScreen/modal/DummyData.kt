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
    val image: String
)

data class Post(
    val userName: String,
    val caption: String,
    val image: String,
    val timeAgo: String,
    val proViews: Int,
    val views: Int
)

data class Flick(
    val title: String,
    val videoUrl: String
)

object DummyData {
    val stories = listOf(
        Story("Your Story", "https://cdn-icons-png.flaticon.com/512/4140/4140048.png"),
        Story("Learn_dancing", "https://cdn-icons-png.flaticon.com/512/4140/4140048.png"),
        Story("fitnessclub", "https://picsum.photos/202"),
        Story("_photography_", "https://picsum.photos/203"),
        Story("artworld", "https://picsum.photos/204"),
        Story("Learn_dancing", "https://picsum.photos/201"),
        Story("fitnessclub", "https://picsum.photos/202"),
        Story("_photography_", "https://picsum.photos/203"),
        Story("artworld", "https://picsum.photos/204")
    )

    val posts = listOf(
        Post(
            userName = "Learncoding",
            caption = "30-day fitness challenge: Works multiple muscle groups",
            image = "https://picsum.photos/400/200",
            timeAgo = "3 weeks ago",
            proViews = 130,
            views = 500
        ),
        Post(
            userName = "artworld",
            caption = "Digital painting session — mastering light & shade",
            image = "https://picsum.photos/401/200",
            timeAgo = "1 week ago",
            proViews = 85,
            views = 420
        ),
        Post(
            userName = "Home window",
            caption = "30-day fitness challenge: Works multiple muscle groups",
            image = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
            timeAgo = "3 weeks ago",
            proViews = 130,
            views = 500
        ),
        Post(
            userName = "artworld",
            caption = "Digital painting session — mastering light & shade",
            image = "https://picsum.photos/401/200",
            timeAgo = "1 week ago",
            proViews = 85,
            views = 420
        ),
        Post(
            userName = "Learncoding",
            caption = "30-day fitness challenge: Works multiple muscle groups",
            image = "https://picsum.photos/400/200",
            timeAgo = "3 weeks ago",
            proViews = 130,
            views = 500
        ),
        Post(
            userName = "artworld",
            caption = "Digital painting session — mastering light & shade",
            image = "https://picsum.photos/401/200",
            timeAgo = "1 week ago",
            proViews = 85,
            views = 420
        ),
        Post(
            userName = "Learncoding",
            caption = "30-day fitness challenge: Works multiple muscle groups",
            image = "https://picsum.photos/400/200",
            timeAgo = "3 weeks ago",
            proViews = 130,
            views = 500
        ),
        Post(
            userName = "artworld",
            caption = "Digital painting session — mastering light & shade",
            image = "https://picsum.photos/401/200",
            timeAgo = "1 week ago",
            proViews = 85,
            views = 420
        ),
        Post(
            userName = "Learncoding",
            caption = "30-day fitness challenge: Works multiple muscle groups",
            image = "https://picsum.photos/400/200",
            timeAgo = "3 weeks ago",
            proViews = 130,
            views = 500
        ),
        Post(
            userName = "artworld",
            caption = "Digital painting session — mastering light & shade",
            image = "https://picsum.photos/401/200",
            timeAgo = "1 week ago",
            proViews = 85,
            views = 420
        ),
    )

//    val flicks = listOf(
//        Flick("30-day fitness challenge", "https://picsum.photos/500/300"),
//        Flick("Street photography reels", "https://picsum.photos/501/300"),
//        Flick("Dance flicks of the month", "https://picsum.photos/502/300"),
//        Flick("New Tech Hacks", "https://picsum.photos/503/300")
//    )
val flicks = listOf(
    Flick(
        "30-day fitness challenge",
        "https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_1mb.mp4"
    ),
    Flick(
        "Crossfit strength",
        "https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_2mb.mp4"
    ),
    Flick(
        "Yoga balance tips",
        "https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_5mb.mp4"
    ),
    Flick(
        "Football training",
        "https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_10mb.mp4"
    )
)
}
