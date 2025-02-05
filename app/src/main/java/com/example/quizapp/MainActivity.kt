package com.example.quizapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var totalQuestionText: TextView
    private lateinit var questionText: TextView
    private lateinit var ansA: Button
    private lateinit var ansB: Button
    private lateinit var ansC: Button
    private lateinit var ansD: Button
    private lateinit var submitButton: Button

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation des éléments de l'UI
        totalQuestionText = findViewById(R.id.total_question)
        questionText = findViewById(R.id.question)
        ansA = findViewById(R.id.ans_A)
        ansB = findViewById(R.id.ans_B)
        ansC = findViewById(R.id.ans_C)
        ansD = findViewById(R.id.ans_D)
        submitButton = findViewById(R.id.submit_btn)

        // Affichage du nombre total de questions
        totalQuestionText.text = "Total de Questions : ${QuestionAnswer.questions.size}"

        // Afficher la première question
        showQuestion(currentQuestionIndex)

        // Réagir au clic sur les boutons de réponse
        ansA.setOnClickListener { checkAnswer(ansA.text.toString()) }
        ansB.setOnClickListener { checkAnswer(ansB.text.toString()) }
        ansC.setOnClickListener { checkAnswer(ansC.text.toString()) }
        ansD.setOnClickListener { checkAnswer(ansD.text.toString()) }

        // Action du bouton "Submit"
        submitButton.setOnClickListener {
            if (currentQuestionIndex < QuestionAnswer.questions.size - 1) {
                currentQuestionIndex++
                showQuestion(currentQuestionIndex)
            } else {
                Toast.makeText(this, "Quiz terminé ! Votre score est $score/${QuestionAnswer.questions.size}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showQuestion(index: Int) {
        // Afficher la question et les choix de réponses
        questionText.text = QuestionAnswer.questions[index]
        ansA.text = QuestionAnswer.choices[index][0]
        ansB.text = QuestionAnswer.choices[index][1]
        ansC.text = QuestionAnswer.choices[index][2]
        ansD.text = QuestionAnswer.choices[index][3]
    }

    private fun checkAnswer(selectedAnswer: String) {
        // Vérifier si la réponse sélectionnée est correcte
        val correctAnswer = QuestionAnswer.correctAnswers[currentQuestionIndex]
        if (selectedAnswer == correctAnswer) {
            score++
            Toast.makeText(this, "Bonne réponse !", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Mauvaise réponse, la bonne réponse est $correctAnswer", Toast.LENGTH_SHORT).show()
        }
    }
}
