package com.example.quizapp

class QuestionAnswer {

    companion object {
        val questions = arrayOf(
            "Quelle entreprise possédait Android ?",
            "Lequel n'est pas un langage de programmation ?",
            "Quelle balise HTML est utilisée pour insérer une image sur une page web ?",
            "Quelle balise HTML est utilisée pour créer un lien hypertexte ?",
            "Quel langage est principalement utilisé pour ajouter des styles à une page web ?"
        )

        val choices = arrayOf(
            arrayOf("Google", "Apple", "Nokia", "Samsung"),
            arrayOf("Java", "Kotlin", "Notepad", "Python"),
            arrayOf("<img>", "<image>", "<picture>", "<src>"),
            arrayOf("<a>", "<link>", "<button>", "<href>"),
            arrayOf("JavaScript", "HTML", "CSS", "SQL")
        )

        val correctAnswers = arrayOf(
            "Google",
            "Notepad",
            "<img>",
            "<a>",
            "CSS"
        )
    }
}
