const music = new Audio('./audio/music.mp3');
const submit_btn = document.getElementById("submit");
const clock = document.getElementById('clock');
const timeGreeting = document.getElementById("timeEvent");
const updateMsg = document.getElementById("yourmsg");
const updateImg = document.getElementById("alarming");
const alarmTime = document.getElementById("input_time");
const alarmMsg = document.getElementById("input_msg");
const newImg = "imgs/thanos.gif";
const defaultImg = "imgs/ninja.jpg";

const [noon, evening] = [12, 18];
var [inputHr, inputMin, inputMsg] = [-1,-1,'']
var alarmSet = 0;

const showCurrentTime = (hours, minutes, seconds) => {
    let meridian = (hours >= noon) ? "PM" : "AM";
    (hours > noon) ? (hours -= noon) : ('');
    (minutes < 10) ? ( minutes = "0" + minutes) : ('');
    (seconds < 10) ? (seconds = "0" + seconds) : ('');
    clock.innerText = hours + ':' + minutes + ':' + seconds + " " + meridian + "!";
};    

const updateClock = (hours, minutes) => {
  if (alarmSet == 1 && hours == inputHr && minutes == inputMin){
      updateMsg.innerHTML= "   " + inputMsg;
      updateImg.src = newImg;
      music.play();
      alarmSet=2;
  }
  timeGreeting.innerText = (hours<noon)?("Good Morning"):((hours>=evening)?"Good Evening":"Good Afternoon");
};

const updateData = ()=>{
  let currentTime = new Date();
  [hours, minutes, seconds] = [currentTime.getHours(),currentTime.getMinutes(),currentTime.getSeconds()];
  updateClock(hours, minutes);
  showCurrentTime(hours, minutes, seconds);
};

const alarmEvent = ()=>{
  alarmSet=1;
  [inputHr, inputMin] = alarmTime.value.split(':');
  inputMsg = alarmMsg.value;
  alarmMsg.disabled=true;
  alarmTime.disabled=true;
  submit_btn.innerHTML = "Stop Alarm";
}

const alarmStop = () =>{ 
  alarmSet=0;
	music.pause();
  music.currentTime=0;
  submit_btn.innerHTML = "Set Alarm";
  updateImg.src = defaultImg;
  updateMsg.innerHTML = "";
  alarmMsg.disabled=false;
  alarmTime.disabled=false;
}

submit_btn.addEventListener("click",()=>{
  (submit_btn.innerHTML == "Set Alarm") ? alarmEvent() : alarmStop(); 
});

setInterval( updateData, 1000);