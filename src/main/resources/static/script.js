let questions = [];

function loadQuestions() {
    fetch("/api/questions")
        .then(res => res.json())
        .then(data => {
            questions = data;
            let html = "";

            data.forEach((q, i) => {
                html += `<div class="question-box">`;
                html += `<p><b>${i + 1}. ${q.question}</b></p>`;
                html += `<label><input type="radio" name="q${i}" value="A"> ${q.optionA}</label><br>`;
                html += `<label><input type="radio" name="q${i}" value="B"> ${q.optionB}</label><br>`;
                html += `<label><input type="radio" name="q${i}" value="C"> ${q.optionC}</label><br>`;
                html += `<label><input type="radio" name="q${i}" value="D"> ${q.optionD}</label><br>`;
                html += `</div>`;
            });

            document.getElementById("questions").innerHTML = html;
        });
}

function submitExam() {
    let score = 0;

    questions.forEach((q, i) => {
        let ans = document.querySelector(`input[name="q${i}"]:checked`);
        if (ans && ans.value === q.answer) {
            score++;
        }
    });

    let resultDiv = document.getElementById("result");
    resultDiv.innerHTML = `
        <h3> Exam Completed</h3>
        <p><b>Your Score:</b> ${score} / ${questions.length}</p>
        <p>${score >= 5 ? " Congratulations! You passed." : " Better luck next time."}</p>
        <button onclick="location.href='index.html'">Go to Home</button>
    `;
}
