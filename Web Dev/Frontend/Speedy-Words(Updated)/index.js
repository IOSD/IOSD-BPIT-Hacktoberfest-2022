const wordList = ["Ishaan" , "Javascript" , "Racecar" , "Brawn" , "Redbull" , "Mercedes" , "Haas" , "Freemode" , "Recursion" , "Excuses" , "Tiktok" , "Metaverse" , "Mary" , "Procrastination" , "Gaming" , "Kennedy" , "Psychology" , "Czechoslovakia" , "Reverbration" , "Rasterization" , "Drums" , "Candy" , "Online" , "Himalayas" , "Foothills" , "Umbrella" , "Underground" , "Bluetooth" , "Charging" , "Cards" , "Target" , "Proximity" , "Kindly" , "Favourable" , "Performance" , "Steering" , "Percentage" , "Nest" , "Jailbreak" , "Heist" , "Panther" , "Drainage" , "Island" , "Disguise" , "Shoot" , "Escape" , "Money" , "Glass" , "Damn" , "F" , "Godzilla" , "Ironman" , "Hawkeye" , "Hulk" , "Black" , "Spider" , "Universe" , "Madness" , "Home" , "Far"];

// Initial Random Word
var randomNumber = Math.floor(Math.random() * wordList.length);
document.getElementById("word").innerText = wordList[randomNumber];

// Running the Time:
var timeSettings = setInterval(timer , 1000);
var isTimeRunning = true;

// Words and Scores
var word = document.getElementById("word").innerText;
var score = parseInt(document.getElementById("score").innerText);

// Word Changing Function
function wordChange(){
    var randomNumber = Math.floor(Math.random() * wordList.length);
    document.getElementById("word").innerText = wordList[randomNumber];
}

// Score Changing Function
function scoreChange(){
    score += 5;
    document.getElementById("score").innerText = score;
}

// Main Timing Function
function timer(){
    var x = parseInt(document.getElementById("time").innerHTML);
    console.log(x);
    document.querySelector(".finalPanel").classList.add("hidden");
    
    if(x > 0){ 
        var guessTillNow = document.getElementById("guess").value;
        
        if(guessTillNow == word){
            document.getElementById("guess").value = "";
            x += 3;
            scoreChange();
            wordChange();
            word = document.getElementById("word").innerText;
        }
        
        x -= 1;
        document.getElementById("time").innerText = x;
        
    } else {
        document.querySelector(".initialPanel").classList.add("hidden");
        document.querySelector(".finalPanel").classList.remove("hidden");

        document.getElementById("finalScore").innerText = score;

        isTimeRunning = false;
        clearInterval(timeSettings);
    }
}

// Refresh page after Game Over
function refreshPage() {
    window.location.reload();
}