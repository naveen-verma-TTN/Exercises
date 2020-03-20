/*
    Create Kotlin classes having suitable attributes for Library management system.
    Use OOPs concepts in your design.Also try to use interfaces and abstract classes.
*/

abstract class Library{
    abstract var libraryId : Int
    abstract fun libraryDetails()
}

interface Book {
    var bookId : Int
    fun bookDetails()
}

class Author: Library(), Book {
    // Abstraction
    private var authorId : Int
    private var name : String

    override var libraryId : Int = 10001
    override var bookId : Int = 2002

    init{
        authorId = 0
        name = ""
    }

    // overriding (Polymorphism)
    fun setAuthorsDetails(authorId : Int , name : String) {
        this.authorId = authorId;
        this.name = name;
    }

    fun setAuthorsDetails(name : String, authorId : Int) {
        this.authorId = authorId;
        this.name = name;
    }

     // abstract class and overriding (Polymorphism)
    override fun libraryDetails() {
        System.out.println("Library id: " +libraryId);
    }

     // interface and overriding
    override fun bookDetails() {
        System.out.println("Book id: " +bookId);
    }

      fun authorDetails() {
        System.out.println("Author id: " +authorId);
        System.out.println("Author name: " +name);
    }
}

fun main(args: Array<String>) {
     // Encapsulation
    var author = Author()
    author.setAuthorsDetails(15434," J K rollings")
    author.setAuthorsDetails(" J K rollings", 23134)
    author.authorDetails()

    var library = Author()
    library.libraryDetails()
    var book = Author()
    book.bookDetails();
}