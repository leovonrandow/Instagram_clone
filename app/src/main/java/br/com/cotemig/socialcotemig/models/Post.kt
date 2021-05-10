package br.com.cotemig.socialcotemig.models

class Post {
    var date: String = ""
    var image: String = ""
    var description: String = ""
    var id: String = ""
    var avatar: String = ""
    var user: String = ""
    var local: String = ""
    var likes: List<String> = emptyList()
    var gallery: List<PostImage> = emptyList()
}