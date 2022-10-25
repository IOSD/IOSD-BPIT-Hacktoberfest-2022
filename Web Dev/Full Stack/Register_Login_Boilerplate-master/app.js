const express = require('express');
const expressLayouts = require('express-ejs-layouts');
const mongoose = require('mongoose');
const passport = require('passport');
const flash = require('connect-flash');
const session = require('express-session');

const app = express();

// Passport Config
require('./config/passport')(passport);

// DB Config
const db = require('./config/keys').MongoURI;

// Connect to MongoDB
mongoose
  .connect(
    db,
    { useNewUrlParser: true ,useUnifiedTopology: true}
  )
  .then(() => console.log('MongoDB Connected'))
  .catch(err => console.log(err));





//ADDING EJS MIDDLEWARE
//Remember use expresslayouts will be above set engine else it will not work
app.use(expressLayouts);//due to this line we are able to use designs like things in welcome(bootstrap)
app.set('view engine','ejs');


//BODYPARSER
app.use(express.urlencoded({extended:false}));


// Express session
app.use(
  session({
    secret: 'secret',
    resave: true,
    saveUninitialized: true
  })
);

//remember below session
// Passport middleware
app.use(passport.initialize());
app.use(passport.session());

// Connect flash
app.use(flash());

// Global variables fo colors for different flash messages
app.use(function(req, res, next) {
  res.locals.success_msg = req.flash('success_msg');
  res.locals.error_msg = req.flash('error_msg');
  res.locals.error = req.flash('error');
  next();
});


//ROUTES
app.use('/',require('./routes/index'));
app.use('/users',require('./routes/user'));







const PORT= process.env.PORT || 5000;
app.listen(PORT,console.log(`server started on port ${PORT}`));
