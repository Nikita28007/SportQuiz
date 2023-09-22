package com.example.sportquiz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


class QuizFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.quiz_fragment, container, false)
        view.visibility = View.VISIBLE
        val questions = addDataQuestions()
        val answers = addDataAnswers()
        val options = addDataOptions()
        val facts = addDataFacts()
        var titleCounter = 1
        var optionsCounter = 2
        var answerCounter = 0
        val answerText = view.findViewById<TextView>(R.id.answerText)
        val title = view.findViewById<TextView>(R.id.questionTitle)
        title.text = questions[0].toString()
        val option1 = view.findViewById<TextView>(R.id.radioButton1)
        val option2 = view.findViewById<TextView>(R.id.radioButton2)
        val option3 = view.findViewById<TextView>(R.id.radioButton3)
        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroupQuiz)
        option1.text = options[0].toString()
        option2.text = options[1].toString()
        option3.text = options[2].toString()
        view.findViewById<Button>(R.id.checkAnswerButton).setOnClickListener {

            when (radioGroup.checkedRadioButtonId) {
                option1.id -> {

                    if (answers[answerCounter].equals(option1.text.toString())) {
                        answerText.text = facts[answerCounter]
                    } else {
                        answerText.text = "Wrong"
                    }
                }

                option2.id -> {
                    if (answers[answerCounter].equals(option2.text.toString())) {
                        answerText.text = facts[answerCounter]
                    } else {
                        answerText.text = "Wrong"
                    }
                }

                option3.id -> {
                    if (titleCounter == 1) answerCounter=9
                    Log.d("title",titleCounter.toString()+" "+ answerCounter)
                    if (answers[answerCounter].equals(option3.text.toString())) {
                        answerText.text = facts[answerCounter]
                    } else {
                        answerText.text = "Wrong"
                    }
                }

            }


        }
        view.findViewById<Button>(R.id.nextButton).setOnClickListener {
            title.text = questions[titleCounter].toString()
            answerText.text = ""
            for (i in options.keys) {
                option1.text = options[optionsCounter + 1]
                option2.text = options[optionsCounter + 2]
                option3.text = options[optionsCounter + 3]
            }

            titleCounter++
            optionsCounter += 3
            answerCounter++
            if (titleCounter == 10 ) {
                titleCounter = 0
                optionsCounter = -1

            }
            if (answerCounter == 10)
                answerCounter=0
        }


        return view
    }
}

private fun addDataQuestions(): HashMap<Int, String> {
    val questionsArray = HashMap<Int, String>()

    questionsArray[0] =
        "What is the name of the Olympic sport that combines cross-country skiing with rifle shooting?"
    questionsArray[1] = "Which country is considered the birthplace of modern hockey?"
    questionsArray[2] = "A sport in which players run on ice and rub it with brushes?"
    questionsArray[3] = "In what year did figure skaters first take part in the Olympic Games?"
    questionsArray[4] =
        "Who is considered the inventor of the snowboard? He fastened two skis together for his daughter and got the so-called snurfer, which can actually be considered the first snowboard."
    questionsArray[5] = "In what year and in what country was the first hockey match held?"
    questionsArray[6] = "What does the machine called Resurfacer do?"
    questionsArray[7] = "Who is Vladislav Tretyak?"
    questionsArray[8] = "What is the name of the world's first single figure skater?"
    questionsArray[9] = "Who doesn't play hockey?"
    return questionsArray
}

private fun addDataAnswers(): HashMap<Int, String> {
    val answersArray = HashMap<Int, String>()

    answersArray[0] = "Biathlon"
    answersArray[1] = "Canada"
    answersArray[2] = "Curling"
    answersArray[3] = "In 1908"
    answersArray[4] = "Sherman Poppen"
    answersArray[5] = "In 1875 in Canada"
    answersArray[6] = "Restores ice surface"
    answersArray[7] = "Outstanding Soviet hockey player, goalkeeper and coach"
    answersArray[8] = "Irina Slutskaya"
    answersArray[9] = "Coward"
    return answersArray
}

private fun addDataFacts(): HashMap<Int, String> {
    val answersArray = HashMap<Int, String>()

    answersArray[0] =
        "International biathlon competition has been dominated by northern Europeans over the years," +
                " particularly by athletes from Russia, Finland, Germany, and Norway."
    answersArray[1] =
        "The longest game in NHL history was played on March 24, 1936, " +
                "between the Detroit Red Wings and the Montreal Maroons." +
                " It lasted six overtimes, totalling 116 minutes and 30 seconds of extra time."
    answersArray[2] =
        "Sweeping the ice in front of the stone is not just about cleaning the path. " +
                "The act of sweeping creates friction, which slightly melts the ice, " +
                "reducing the curl and increasing the stone’s speed and distance traveled."
    answersArray[3] =
        "Depending on paper readings, measurements show that a skater landing a triple or quadruple jump will have a landing force of 5 to 14 times the body weight on impact. " +
                "Therefore, a male skater weighing 150 pounds can land with a pressure of 1000 pounds!"
    answersArray[4] =
        "There are various styles of snowboarding, including freestyle, freeride, and alpine. Freestyle focuses on tricks, freeride emphasizes natural terrain, and alpine involves racing and carving turns. "
    answersArray[5] =
        "The coveted Stanley Cup outdates the NHL by a full 24 years. That is, " +
                "the Stanley Cup was created in 1893, while the NHL was officially established in 1917 on November 22"
    answersArray[6] =
        "The resurfacer after scraping the ice, puts a thin layer of water that is heated to 140 to 145 °F" +
                " (60 to 63°C). Actually, the hotter the water, the more even surface will get! " +
                "You would think you need cold water to make ice; But hot water contains less " +
                "oxygen which makes it easier for molecules to bind and freeze."
    answersArray[7] = "During each game, teams only get one 30-second timeout." +
            "Coaches and teams must use this timeout wisely as it is the only time they " +
            "get to huddle and make decisions during the game. Otherwise, they will have to wait " +
            "on intermission and other involuntary timeouts like commercial breaks."
    answersArray[8] =
        "Have you seen the top figure skaters spin on the ice and how their faces are smashed by the speed." +
                " Have you ever wondered how fast they spin?" +
                " The answer is that they can reach 6 revolutions per second which is over 300 revolutions per minute!"
    answersArray[9] =
        "The iconic black puck used in hockey is made of vulcanized rubber. Its dense and durable construction allows it to withstand the high-speed impacts and provides excellent glide on the ice."

    return answersArray
}

private fun addDataOptions(): HashMap<Int, String> {
    val optionsArray = HashMap<Int, String>()

    optionsArray[0] = "Biathlon"
    optionsArray[1] = "Bobsled"
    optionsArray[2] = "Freestyle"

    optionsArray[3] = "USA"
    optionsArray[4] = "Russia"
    optionsArray[5] = "Canada"

    optionsArray[6] = "Naturban"
    optionsArray[7] = "Curling"
    optionsArray[8] = "Broomball"

    optionsArray[9] = "In 1908"
    optionsArray[10] = "In 1922"
    optionsArray[11] = "In 1931"

    optionsArray[12] = "Darren Powell"
    optionsArray[13] = "Sherman Poppen"
    optionsArray[14] = "Jake Burton"

    optionsArray[15] = "In 1875 in Canada"
    optionsArray[16] = "In 1870 in France"
    optionsArray[17] = "In 1905 in Norway"

    optionsArray[18] = "Provides dynamic lighting in figure skating"
    optionsArray[19] = "Provides maintenance of the required temperature"
    optionsArray[20] = "Restores ice surface"

    optionsArray[21] = "Outstanding Soviet hockey player, goalkeeper and coach"
    optionsArray[22] = "Famous Russian figure skater, world champion"
    optionsArray[23] = "Famous alpine skier who won not a single gold medal at the Winter Olympics"

    optionsArray[24] = "Ekaterina Gordeeva"
    optionsArray[25] = "Irina Slutskaya"
    optionsArray[26] = "Elena Vodorezova"

    optionsArray[27] = "Fool"
    optionsArray[28] = "Lazy person"
    optionsArray[29] = "Coward"

    return optionsArray
}