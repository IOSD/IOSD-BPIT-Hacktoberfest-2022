from flask import Flask, render_template, request, url_for
from flask_bootstrap import Bootstrap
from textblob import TextBlob

app = Flask(__name__)
Bootstrap(app)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/analyse', methods=['POST'])
def analyse():
    if request.method == 'POST':
        rawtext = request.form['rawtext']
        blob = TextBlob(rawtext)
        received_text=blob
        blob_polarity, blob_subjectivity = blob.sentiment.polarity, blob.sentiment.subjectivity
    if blob_polarity < -0.05:
        message = "Negative😔"
    elif blob_polarity > 0.05:
        message = "Positive😊"
    else:
        message = "Neutral😕"
    return render_template('index.html', received_text=received_text, blob_polarity=blob_polarity, blob_subjectivity=blob_subjectivity, message=message)

if __name__ == '__main__':
    app.run(debug=True)

# Negative😔
# Positive😊
# Neutral😕
