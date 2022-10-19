This is a URLShortener made using Django.

Make sure you have python installed and added to PATH.
Open your Teminal, run command "pip install virtualenv"  (without "") if not already installed.
Then in the Parent folder "URLShortener" run command "virtualenv venv" and then run "venv\Scripts\activate" to activate the virtual environment.
Then cd into DjangoWorkshop folder using "cd DjangoWorkshop" and run "python manage.py runserver".
The URL Shorteneing page can be opened using the link provided in the terminal as "http://127.0.0.1:8000/" or something similar to that.
Then in the webpage u can enter the link you want to shorten and then enter an alias for that link and hit shorten.
If no error you will be redirected to a message.

To access the shortened link, while the django server is running, change the URL to "http://127.0.0.1:8000/redirect/<alias>" to access the longURL website.
