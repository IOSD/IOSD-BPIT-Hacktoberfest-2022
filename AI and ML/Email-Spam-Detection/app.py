from flask import Flask, render_template, request, url_for
from flask_bootstrap import Bootstrap
# from textblob import TextBlob

import csv
import pandas as pd
import string
from nltk.corpus import stopwords
import sklearn
from sklearn.feature_extraction.text import CountVectorizer, TfidfTransformer, TfidfVectorizer
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix

app = Flask(__name__)
Bootstrap(app)

@app.route('/',methods=['POST','GET'])
def home():
    if request.method=='GET':
      return render_template('home.html')

    email_text = request.form['rawtext']

    data = pd.read_csv('spam.csv',encoding='latin-1')
    data.drop(['Unnamed: 2','Unnamed: 3','Unnamed: 4'],axis=1,inplace=True)

    def text_processing(text):
      text = text.translate(str.maketrans('','',string.punctuation))
      text = [word for word in text.split() if word.lower() not in stopwords.words('english')]
      return " ".join(text)
    data['text'] = data['text'].apply(text_processing)

    vectorizer = TfidfVectorizer()
    vectors = vectorizer.fit_transform(data['text'])
    features = vectors

    def categorize(category):
      if category == "ham":
        return 0
      else:
        return 1
    data['label'] = data['label'].apply(categorize)

    X_train, X_test, y_train, y_test = train_test_split(features, data['label'], test_size=0.15, random_state=111)

    lr = LogisticRegression(solver='liblinear', penalty='l1')
    lr.fit(X_train,y_train)

    email_text = email_text.translate(str.maketrans('','',string.punctuation))
    email_text = [word for word in email_text.split() if word.lower() not in stopwords.words('english')]
    email_text = " ".join(email_text)
    to_check =[]
    to_check.append(email_text)
    feature = vectorizer.transform(to_check)
    prediction = lr.predict(feature)
    if(prediction == 0.):
        message='Not Spam'
    else:
        message='Spam'
    return render_template('home.html',received_text=email_text,message=message)



if __name__ == '__main__':
    app.run(debug=True)
